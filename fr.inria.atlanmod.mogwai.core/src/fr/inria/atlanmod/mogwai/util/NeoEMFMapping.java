package fr.inria.atlanmod.mogwai.util;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.text.MessageFormat;
import java.util.Collection;

import com.google.common.collect.Iterables;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Index;
import com.tinkerpop.blueprints.KeyIndexableGraph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.util.wrappers.id.IdGraph;

import fr.inria.atlanmod.neoemf.core.StringId;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.data.blueprints.store.DirectWriteBlueprintsStore;

/**
 * An implementation of {@link EMFtoGraphMapping} representing NeoEMF mapping.
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
 * @author Gwendal DANIEL
 *
 */
public final class NeoEMFMapping implements EMFtoGraphMapping {

	private IdGraph<KeyIndexableGraph> graph;
	private Index<Vertex> metaclassIndex;

	/**
	 * {@inheritDoc}
	 * <p>
	 * 
	 * @throws IllegalArgumentException
	 *             if the provided {@code graph} is not an instance of
	 *             {@link IdGraph}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setGraph(Graph graph) throws IllegalArgumentException {
		checkNotNull(graph, "No graph provided");
		checkArgument(graph instanceof IdGraph, "NeoEMFMapping required a KeyIndexableGraph");
		this.graph = (IdGraph<KeyIndexableGraph>) graph;
		this.metaclassIndex = this.graph.getIndex(BlueprintsPersistenceBackend.KEY_METACLASSES, Vertex.class);
	}

	@Override
	public Iterable<Vertex> allOfType(String typeName) {
		Vertex metaClassVertex = getMetaclassVertex(typeName);
		return metaClassVertex.getVertices(Direction.IN, BlueprintsPersistenceBackend.KEY_INSTANCE_OF);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method is not implemented in NeoEMF mapping because subclass
	 * information is not stored at the database level. This will be fixed in a
	 * future release of <a href="www.neoemf.com">NeoEMF</a>.
	 * 
	 * @throws UnsupportedOperationException
	 *             when called, will be fixed in a future release of NeoEMF
	 */
	@Override
	public Collection<Vertex> allOfKind(String typeName) throws UnsupportedOperationException {
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
	public Object newInstance(String typeName, String typePackageNsURI) throws NullPointerException {
		checkNotNull(graph, "Graph hasn't been initialized, call setGraph before starting graph manipulation");
		checkNotNull(typePackageNsURI, "NeoEMFMapping requires EPackage nsURI to create a new element");
		Vertex vertex = graph.addVertex(StringId.generate());
		Vertex eClassVertex = getMetaclassVertex(typeName);
		if (isNull(eClassVertex)) {
			eClassVertex = createMetaclassVertex(typeName, typePackageNsURI);
			metaclassIndex.put(BlueprintsPersistenceBackend.KEY_NAME, typeName, eClassVertex);
		}
		vertex.addEdge(BlueprintsPersistenceBackend.KEY_INSTANCE_OF, eClassVertex);
		return vertex;
	}

	@Override
	public Iterable<Vertex> getRef(Vertex from, String refName) {
		return from.getVertices(Direction.OUT, refName);
	}

	@Override
	public Object getAtt(Vertex from, String attName) {
		return from.getProperty(attName);
	}

	@Override
	public String getType(Vertex from) {
		Vertex metaclassVertex = getMetaclassVertexFor(from);
		return metaclassVertex.getProperty(BlueprintsPersistenceBackend.KEY_ECLASS_NAME);
	}

	@Override
	public boolean isTypeOf(Vertex from, String type) {
		Vertex metaclassVertex = getMetaclassVertexFor(from);
		return metaclassVertex.getProperty(BlueprintsPersistenceBackend.KEY_ECLASS_NAME).equals(type);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method is not implemented in NeoEMF mapping because subclass
	 * information is not stored at the database level. This will be fixed in a
	 * future release of <a href="www.neoemf.com">NeoEMF</a>.
	 * 
	 * @throws UnsupportedOperationException
	 *             when called, will be fixed in a future release of NeoEMF
	 */
	@Override
	public boolean isKindOf(Vertex from, String type) throws UnsupportedOperationException {
		throw new UnsupportedOperationException(
				"NeoEMFMapping doesn't support isKindOf mapping, use multiple isTypeOf instead");
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
	private Vertex getMetaclassVertex(String typeName) {
		checkNotNull(metaclassIndex,
				"Metaclass index cannot be found, call setGraph before starting graph manipulation");
		return Iterables.getOnlyElement(metaclassIndex.get(BlueprintsPersistenceBackend.KEY_NAME, typeName), null);
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
	private Vertex createMetaclassVertex(String typeName, String typePackageNsURI) {
		Vertex vertex = graph.addVertex(new StringId(typeName + '@' + typePackageNsURI));
		vertex.setProperty(BlueprintsPersistenceBackend.KEY_ECLASS_NAME, typeName);
		vertex.setProperty(BlueprintsPersistenceBackend.KEY_EPACKAGE_NSURI, typePackageNsURI);
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
	private Vertex getMetaclassVertexFor(Vertex instanceVertex) throws IllegalStateException {
		Vertex metaclassVertex = Iterables.getOnlyElement(
				instanceVertex.getVertices(Direction.OUT, BlueprintsPersistenceBackend.KEY_INSTANCE_OF), null);
		if (nonNull(metaclassVertex)) {
			return metaclassVertex;
		} else {
			throw new IllegalStateException(MessageFormat.format("Cannot find the metaclass vertex of {0}",
					instanceVertex.getId()));
		}
	}
}
