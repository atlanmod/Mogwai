package fr.inria.atlanmod.mogwai.data.mapping;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.text.MessageFormat;
import java.util.Arrays;

import com.google.common.collect.Iterables;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Index;
import com.tinkerpop.blueprints.KeyIndexableGraph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.util.wrappers.id.IdGraph;

import fr.inria.atlanmod.mogwai.data.mapping.pipes.PipeMapping;

/**
 * An implementation of {@link EMFtoGraphMapping} representing how NeoEMF maps
 * EMF models into Blueprints databases.
 * <p>
 * This mapping is based on the one implicitly defined in
 * {@link BlueprintsPersistenceBackend} and {@link DirectWriteBlueprintsStore}.
 * It will be externalized in a future version of <a
 * href="www.neoemf.com">NeoEMF</a> to provide more flexibility on the EMF to
 * Blueprints mapping.
 * <p>
 * The current version of NeoEMF (1.0.1) doesn't contain class hierarchy within
 * the database. This lack of metaclass-level information avoid the definition
 * of {@link #allOfKind(String)} and {@link #isKindOf(Vertex, String)} that
 * throw {@link UnsupportedOperationException}. This will be fixed in a future
 * version of NeoEMF.
 * 
 * @see BlueprintsPersistenceBackend
 * @see DirectWriteBlueprintsStore
 * @see AbstractMapping
 * @see EMFtoGraphMapping
 * 
 * @author Gwendal DANIEL
 *
 */
public final class NeoEMFMapping implements PipeMapping<Graph, Vertex, Edge, Object> {

    private static final String KEY_NAME = "name";
	
    private static final String KEY_INSTANCE_OF = "kyanosInstanceOf";
    
    private static final String KEY_METACLASSES = "metaclasses";
    
    private static final String KEY_ECLASS_NAME = "name";
    
    private static final String KEY_EPACKAGE_NSURI = "nsURI";
    
	private static final String POSITION_KEY = "position";

	private static final String SEPARATOR = ":";

	private static final String SIZE_LITERAL = "size";

	private static final String CONTAINER_LABEL = "eContainer";

	private static final String CONTENTS_LABEL = "eContents";

	private static final String CONTAINING_FEATURE_KEY = "containingFeature";

	private IdGraph<KeyIndexableGraph> graph;

	private Index<Vertex> metaclassIndex;

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method also checks the provided graph defines a metaclass index, and
	 * make it available for other methods.
	 * 
	 * @throws IllegalArgumentException
	 *             if the provided {@code graph} is not an instance of
	 *             {@link IdGraph}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setDataSource(final Graph graph) throws IllegalArgumentException {
		checkNotNull(graph, "No graph provided");
		checkArgument(graph instanceof IdGraph, "NeoEMFMapping required a KeyIndexableGraph");
		this.graph = (IdGraph<KeyIndexableGraph>) graph;
		this.metaclassIndex = this.graph.getIndex(KEY_METACLASSES, Vertex.class);
	}

	@Override
	public Iterable<Vertex> allOfType(String typeName) {
		Vertex metaClassVertex = getMetaclassVertex(typeName);
		return metaClassVertex.getVertices(Direction.IN, KEY_INSTANCE_OF);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method is not implemented in NeoEMF mapping because class hierarchy
	 * is not stored at the database level. This will be fixed in a future
	 * release of <a href="www.neoemf.com">NeoEMF</a>.
	 * 
	 * @throws UnsupportedOperationException
	 *             when called, will be fixed in a future release of NeoEMF
	 */
	@Override
	public Iterable<Vertex> allOfKind(String typeName) {
		throw new UnsupportedOperationException(
				"NeoEMFMapping doesn't support allOfKind mapping, use multiple allOfType instead");
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * 
	 * @throws NullPointerException
	 *             if the provided {@code typePackageNsURI} is null (it is
	 *             required by NeoEMF to create a new instance of a given type)
	 */
	@Override
	public Vertex newInstance(final String typeName, final String typePackageNsURI, String resourceName)
			throws NullPointerException {
		long begin = System.currentTimeMillis();
		checkNotNull(graph, "Graph hasn't been initialized, call setGraph before starting graph manipulation");
		checkNotNull(typePackageNsURI, "NeoEMFMapping requires EPackage nsURI to create a new element");
		long beginGetR = System.currentTimeMillis();
		Vertex resourceRoot = getOrCreateResourceRoot(resourceName);
		long endGetR = System.currentTimeMillis();
		newInstanceGetResourceRoot += (endGetR-beginGetR);
//		Vertex vertex = graph.addVertex(StringId.generate().toString());
		Vertex vertex = graph.addVertex(null);
		long endNewVertex = System.currentTimeMillis();
		newInstanceAddVertex += (endNewVertex-endGetR);
		Vertex eClassVertex = getMetaclassVertex(typeName);
		if (isNull(eClassVertex)) {
			eClassVertex = createMetaclassVertex(typeName, typePackageNsURI);
			metaclassIndex.put(KEY_NAME, typeName, eClassVertex);
		}
		long endGetMetaclass = System.currentTimeMillis();
		newInstanceGetMetaclass += (endGetMetaclass-endNewVertex);
		/*
		 * Don't use setRef to set this edge, we don't need to add the property
		 * kyanosInstanceof:size in the database
		 */
		vertex.addEdge(KEY_INSTANCE_OF, eClassVertex);
		long begin2 = System.currentTimeMillis();
		setRef(resourceRoot, CONTENTS_LABEL, null, vertex, false);
		long end = System.currentTimeMillis();
		newInstanceTime += (end-begin);
		newInstanceSetRef += (end-begin2);
		return vertex;
	}
	
	public static long newInstanceTime = 0;
	public static long newInstanceSetRef = 0;
	public static long newInstanceGetResourceRoot = 0;
	public static long newInstanceAddVertex = 0;
	public static long newInstanceGetMetaclass = 0;

	@Override
	public Vertex getParent(Vertex from) {
		return Iterables.getOnlyElement(from.getVertices(Direction.OUT, CONTAINER_LABEL), null);
	}

	@Override
	public Iterable<Vertex> getRef(Vertex from, String refName, String oppositeName, boolean isContainer) {
		Iterable<Vertex> result = null;
		if(isContainer && nonNull(oppositeName) && !oppositeName.equals("")) {
			/*
			 * NeoEMF doesn't store containment features with an opposite as edges,
			 * so we need to navigate the opposite to find the container of from.
			 * We can also navigate the eContainer edge, but this implies a property check to
			 * ensure the eContainer has the right type which is more expensive.
			 */
			result = from.getVertices(Direction.IN, oppositeName);
		}
		else {
			result = from.getVertices(Direction.OUT, refName);
		}
		return result;
	}

	@Override
	public Edge setRef(Vertex from, String refName, String oppositeName, Vertex to, boolean isContainment) {
		/*
		 * Note: this implementation only consider append behavior. If the
		 * transformation sets a reference at a specific position model
		 * consistency is not ensured.
		 */
		if (isContainment) {
			updateContainment(from, refName, to);
		}
		else {
			// NeoEMF stores opposites if they are not eContainers
			if(nonNull(oppositeName) && !oppositeName.equals("")) {
				/*
				 *  We don't give an opposite to setRef to avoid infinite recursion.
				 *  Note that the opposite reference cannot be a containment.
				 */
				setRef(to, oppositeName, null, from, false);
			}
		}
		Edge newEdge = from.addEdge(refName, to);
		Integer size = getSize(from, refName);
		int newSize = size + 1;
		newEdge.setProperty(POSITION_KEY, size);
		setSize(from, refName, newSize);
		return newEdge;
	}

	@Override
	public Vertex removeRef(Vertex from, String refName, Vertex to, boolean isContainment) {
		int size = getSize(from, refName);
		Iterable<Edge> refEdges = from.getEdges(Direction.OUT, refName);
		Vertex oldVertex = null;
		for (Edge refEdge : refEdges) {
			if (refEdge.getVertex(Direction.IN).equals(to)) {
				if (oldVertex != null) {
					// We have found the edge, update the position of the next
					// ones
					int position = refEdge.getProperty(POSITION_KEY);
					refEdge.setProperty(POSITION_KEY, position - 1);
				}
				oldVertex = refEdge.getVertex(Direction.IN);
				if (isContainment) {
					Edge containerEdge = Iterables.getFirst(oldVertex.getEdges(Direction.OUT, CONTAINER_LABEL), null);
					if (nonNull(containerEdge)) {
						containerEdge.remove();
					}
				}
				refEdge.remove();
			}
		}
		setSize(from, refName, size - 1);
		return oldVertex;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Object> getAtt(Vertex from, String attName) {
		Object property = from.getProperty(attName);
		if(property instanceof Iterable) {
			return (Iterable<Object>)property;
		}
		else {
			return Arrays.asList(property);
		}
	}

	@Override
	public Vertex setAtt(Vertex from, String attName, Object attValue) {
		from.setProperty(attName, attValue);
		return from;
	}

	@Override
	public String getType(Vertex from) {
		return getMetaclassVertexFor(from).getProperty(KEY_ECLASS_NAME);
	}

	@Override
	public boolean isTypeOf(Vertex from, String type) {
		return getMetaclassVertexFor(from).getProperty(KEY_ECLASS_NAME).equals(type);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method is not implemented in NeoEMF mapping because class hierarchy
	 * is not stored at the database level. This will be fixed in a future
	 * release of <a href="www.neoemf.com">NeoEMF</a>.
	 * 
	 * @throws UnsupportedOperationException
	 *             when called, will be fixed in a future release of NeoEMF
	 */
	@Override
	public boolean isKindOf(Vertex from, String type) {
//		NeoLogger.warn("NeoEMFMapping doesn't support isKindOf mapping, computing isTypeOf instead");
		return isTypeOf(from, type);
	}

	/**
	 * Get the {@link Vertex} corresponding to the root of the resource
	 * {@code resourceName}.
	 * <p>
	 * This method creates a new root {@link Vertex} if the database doesn't
	 * contain the requested one.
	 * 
	 * @param resourceName
	 *            the name of the resource to get the root of
	 * @return the {@link Vertex} corresponding to the root of the resource, or
	 *         a new {@link Vertex} if it doesn't exist
	 */
	private Vertex getOrCreateResourceRoot(String resourceName) {
		Vertex eObjectMetaclass = getMetaclassVertex("EObject");
		Iterable<Vertex> resourceRoots = eObjectMetaclass.getVertices(Direction.IN,
				KEY_INSTANCE_OF);
		for (Vertex rRoot : resourceRoots) {
			if (rRoot.getId().equals(resourceName)) {
				return rRoot;
			}
		}
		Vertex newResourceRoot = graph.addVertex(resourceName);
		newResourceRoot.addEdge(KEY_INSTANCE_OF, eObjectMetaclass);
		return newResourceRoot;
	}

	/**
	 * Returns the {@link Vertex} containing the metaclass information for
	 * {@code typeName}.
	 * 
	 * @param typeName
	 *            the name of the metaclass to search
	 * @return a {@link Vertex} corresponding to the metaclass, or {@code null}
	 *         if it doesn't exist in the graph
	 */
	private Vertex getMetaclassVertex(final String typeName) {
		checkNotNull(metaclassIndex,
				"Metaclass index cannot be found, call setGraph before starting graph manipulation");
		return Iterables.getOnlyElement(metaclassIndex.get(KEY_NAME, typeName), null);
	}

	/**
	 * Creates a new {@link Vertex} to store the metaclass {@code typeName}
	 * information.
	 * 
	 * @param typeName
	 *            the name of the metaclass to create
	 * @param typePackageNsURI
	 *            a string representation of the URI of the EPackage containing
	 *            the metaclass to store
	 * @return the created {@link Vertex}
	 */
	private Vertex createMetaclassVertex(final String typeName, final String typePackageNsURI) {
		Vertex vertex = graph.addVertex(new StringBuilder(typeName).append('@').append(typePackageNsURI).toString());
		vertex.setProperty(KEY_ECLASS_NAME, typeName);
		vertex.setProperty(KEY_EPACKAGE_NSURI, typePackageNsURI);
		return vertex;
	}

	/**
	 * Returns the {@link Vertex} containing the metaclass information for
	 * {@code instanceVertex}.
	 * 
	 * @param instanceVertex
	 *            the {@link Vertex} representing the instance to compute the
	 *            type from
	 * @return the {@link Vertex} containing the metclass information for
	 *         {@code instanceVertex}
	 * @throws IllegalStateException
	 *             if {@code instanceVertex} doesn't have an associated
	 *             metaclass
	 */
	private Vertex getMetaclassVertexFor(final Vertex instanceVertex) throws IllegalStateException {
		Vertex metaclassVertex = Iterables.getOnlyElement(
				instanceVertex.getVertices(Direction.OUT, KEY_INSTANCE_OF), null);
		if (nonNull(metaclassVertex)) {
			return metaclassVertex;
		} else {
			throw new IllegalStateException(MessageFormat.format("Cannot find the metaclass vertex of {0}",
					instanceVertex.getId()));
		}
	}

	/**
	 * Returns the size of the given {@code feature}.
	 * 
	 * @param vertex
	 *            the input {@link Vertex} of the {@code feature}
	 * @param feature
	 *            the name of the feature to compute the size of
	 * @return the size of the {@code feature} if it is multi-valued, {@code 0}
	 *         otherwise
	 */
	private Integer getSize(Vertex vertex, String feature) {
		Integer size = vertex.getProperty(feature + SEPARATOR + SIZE_LITERAL);
		return isNull(size) ? 0 : size;
	}

	/**
	 * Sets the size of the given {@code feature} to {@code size}.
	 * 
	 * @param vertex
	 *            the input {@link Vertex} of the {@code feature}
	 * @param feature
	 *            the name of the feature to set the size of
	 * @param size
	 *            the new size to set
	 */
	private void setSize(Vertex vertex, String feature, int size) {
		if (size == 0) {
			vertex.removeProperty(feature + SEPARATOR + SIZE_LITERAL);
		} else {
			vertex.setProperty(feature + SEPARATOR + SIZE_LITERAL, size);
		}
	}

	/**
	 * Updates the containment by creating a new container edge between
	 * {@code to} and {@code from}.
	 * <p>
	 * <b>Note:</b> this method removes all outgoing container edges from
	 * {@code to} before creating the new container edge.
	 * 
	 * @param from
	 *            the {@link Vertex} element representing the container
	 * @param refName
	 *            the name of the reference to set
	 * @param to
	 *            the {@link Vertex} representing the contained element
	 */
	private void updateContainment(Vertex from, String refName, Vertex to) {
		long begin = System.currentTimeMillis();
		// Find the old containment reference name and remove it
		long begin1 = System.currentTimeMillis();
		for (Edge edge : to.getEdges(Direction.OUT, CONTAINER_LABEL)) {
			removeRef(from, (String) edge.getProperty(CONTAINING_FEATURE_KEY), to, true);
			break;
		}
		long end1 = System.currentTimeMillis();
		
		// Remove eContents edges if the element is a top-level element
		long begin2 = System.currentTimeMillis();
		for (Edge edge : to.getEdges(Direction.IN, CONTENTS_LABEL)) {
			edge.remove();
			break;
		}
		long end2 = System.currentTimeMillis();
		Edge edge = to.addEdge(CONTAINER_LABEL, from);
		edge.setProperty(CONTAINING_FEATURE_KEY, refName);
		long end = System.currentTimeMillis();
		updateContainmentTime += (end-begin);
		updateContainment1 += (end1-begin1);
		updateContainment2 += (end2-begin2);
	}
	
	public static long updateContainmentTime = 0;
	public static long updateContainment1 = 0;
	public static long updateContainment2 = 0;
}
