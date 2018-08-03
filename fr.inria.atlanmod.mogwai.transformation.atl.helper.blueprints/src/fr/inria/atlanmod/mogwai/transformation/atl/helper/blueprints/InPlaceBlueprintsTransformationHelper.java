package fr.inria.atlanmod.mogwai.transformation.atl.helper.blueprints;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.Iterator;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.transformation.atl.helper.InPlaceATLTransformationHelper;

/**
 * A blueprints-based {@link InPlaceATLTransformationHelper} that computes model
 * transformations inside a blueprints database, storing the result aside the
 * input model.
 * <p>
 * Transformation-related elements, such as trace links and proxy links, are
 * stored within the database, reducing the memory footprint compared to
 * in-memory helpers.
 * 
 * @see InPlaceATLTransformationHelper
 * 
 * @author Gwendal DANIEL
 *
 */
public class InPlaceBlueprintsTransformationHelper extends InPlaceATLTransformationHelper<Vertex> {

	/**
	 * The label used to represent proxy links.
	 */
	private final static String PROXY_LABEL = "#atl2gremlinProxy";

	/**
	 * The label used to represent trace links.
	 */
	private final static String TRACE_LINK_LABEL = "#trace";

	/**
	 * The attribute key used to store the base label of a proxy link.
	 */
	private final static String BASE_LABEL_KEY = "baseLabel";

	/**
	 * The attribute key used to store trace link targets.
	 */
	private final static String TRACE_LINK_TARGET_KEY = "target";

	/**
	 * The attribute key used to store whether a reference is a containment.
	 */
	private final static String IS_CONTAINMENT_KEY = "isContainment";

	/**
	 * The attribute key used to store whether an element is in the target
	 * model.
	 */
	private final static String IS_TARGET_KEY = "is_target";
	
	// [Dev]
	public static long createTime = 0;
	public static long pLinkTime = 0;
	public static long linkTime = 0;
	public static long resolveProxyTime = 0;
	public static long isResolvableTime = 0;
	public static long resolveTime = 0;
	// /[Dev]

	/**
	 * Constructs a new instance of this class with the provided
	 * {@code datastore}
	 * <p>
	 * This helper performs in-place transformations inside a blueprints
	 * database, and stores transformation related objects inside the database
	 * reducing the memory footprint compared to in-memory helpers.
	 * 
	 * @param datastore
	 *            the {@link ModelDatastore} used to access the graph and store
	 *            the result
	 */
	public InPlaceBlueprintsTransformationHelper(ModelDatastore<?, Vertex, Edge, ?> datastore) {
		super(datastore);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isTargetElement(Vertex element) {
		Object isTargetProp = element.getProperty(IS_TARGET_KEY);
		if (nonNull(isTargetProp)) {
			return (boolean) isTargetProp;
		}
		/*
		 * The property isn't set, this means that the object hasn't been
		 * created by the transformation.
		 */
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vertex createElement(Vertex source, String targetLabel, String metaclassType, String nsURI,
			String resourceName) {
		long begin = System.currentTimeMillis();
		checkNotNull(metaclassType, "Cannot create an element from a null metaclass");
		/*
		 * This is a quick fix, in place transformations does not create additional resources.
		 */
		Vertex v = (Vertex) this.sourceDatastore.newInstance(metaclassType, nsURI, "ROOT");
//		Vertex v = (Vertex) this.sourceDatastore.newInstance(metaclassType, nsURI, resourceName);
		/*
		 * Set the element as a target element to avoid not resolvable proxies
		 * for target-specific model elements
		 */
		v.setProperty(IS_TARGET_KEY, true);
		Edge traceLink = source.addEdge(TRACE_LINK_LABEL, v);
		traceLink.setProperty(TRACE_LINK_TARGET_KEY, targetLabel);
		long end = System.currentTimeMillis();
		createTime += (end - begin);
		return v;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createProxyLink(Vertex from, Vertex to, String label, String oppositeLabel, boolean isContainment) {
		long begin = System.currentTimeMillis();
		Edge pEdge = this.createEdge(from, to, PROXY_LABEL, null, false);
		/*
		 * Proxy links cannot be containment feature, this information is holden
		 * in the edge properties to avoid mapping side-effects resulting on
		 * containment handling
		 */
		pEdge.setProperty(BASE_LABEL_KEY, label);
		if (isContainment) {
			pEdge.setProperty(IS_CONTAINMENT_KEY, true);
		}
		long end = System.currentTimeMillis();
		pLinkTime += (end - begin);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createConcreteLink(Vertex from, Vertex to, String label, String oppositeLabel, boolean isContainment) {
		this.createEdge(from, to, label, oppositeLabel, isContainment);
	}

	/**
	 * A private implementation that creates an {@link Edge} to represent a
	 * reference and returns it.
	 * <p>
	 * This method is used by both
	 * {@link #createConcreteLink(Vertex, Vertex, String, String, boolean)} and
	 * {@link #createProxyLink(Vertex, Vertex, String, String, boolean)} to
	 * create links in the database and manipulate their properties.
	 * 
	 * @param from
	 *            the tail {@link Vertex} of the {@link Edge} to create
	 * @param to
	 *            the head {@link Vertex} of the {@link Edge} to create
	 * @param label
	 *            the label of the {@link Edge} to create
	 * @param oppositeLabel
	 *            the label of the opposite reference if it exists
	 * @param isContainment
	 *            {@code true} if the reference is a containment, {@code false}
	 *            otherwise
	 * @return the create {@link Edge}
	 * 
	 * @see #createConcreteLink(Vertex, Vertex, String, String, boolean)
	 * @see #createProxyLink(Vertex, Vertex, String, String, boolean)
	 */
	private Edge createEdge(Vertex from, Vertex to, String label, String oppositeLabel, boolean isContainment) {
		long begin = System.currentTimeMillis();
		checkNotNull(from, "Cannot create a link from null");
		checkNotNull(to, "Cannot create a link to null");
		checkNotNull(label, "Cannot create a link with null label");
		Edge result = (Edge)sourceDatastore.setRef(from, label, oppositeLabel, to, isContainment);
		long end = System.currentTimeMillis();
		linkTime += (end-begin);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resolveProxies(Vertex sourceProxy, Vertex targetElement) {
		long begin = System.currentTimeMillis();
		// Should be put in mapping
		Iterator<Edge> pEdges = sourceProxy.getEdges(Direction.IN, PROXY_LABEL).iterator();
		while (pEdges.hasNext()) {
			Edge pEdge = pEdges.next();
			Vertex outV = pEdge.getVertex(Direction.OUT);
			if (outV.getId().equals(sourceProxy.getId())) {
				throw new RuntimeException("[Debug] Invalid traversal: in = out");
			}
			String baseLabel = pEdge.getProperty(BASE_LABEL_KEY);
			Boolean isContainment = pEdge.getProperty(IS_CONTAINMENT_KEY);
			if(isNull(isContainment)) {
				/*
				 * False is not set in the database to reduce its size
				 */
				isContainment = false;
			}
			if (isNull(baseLabel)) {
				throw new RuntimeException("[Debug] A proxy link has null as its base label");
			}
			sourceDatastore.setRef(outV, baseLabel, null, targetElement, isContainment);
			// Delete the proxy, it is no longer needed
			sourceDatastore.removeRef(outV, PROXY_LABEL, sourceProxy, false);
		}
		long end = System.currentTimeMillis();
		resolveProxyTime += (end-begin);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isResolvable(Vertex sourceProxy) {
		long begin = System.currentTimeMillis();
		boolean result = sourceDatastore.getRef(sourceProxy, TRACE_LINK_LABEL, null, false).iterator().hasNext();
		long end = System.currentTimeMillis();
		isResolvableTime += (end-begin);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vertex resolve(Vertex sourceProxy) {
		long begin = System.currentTimeMillis();
		Vertex result = sourceDatastore.getRef(sourceProxy, TRACE_LINK_LABEL, null, false).iterator().next();
		long end = System.currentTimeMillis();
		resolveTime += (end - begin);
		return result;
	}
	
	@Override
	public void close() {
		sourceDatastore.close();
	}

}
