package fr.inria.atlanmod.mogwai.transformation.atl.helper;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;

/**
 * Defines the ATL primitives that should be implemented to support ATL
 * execution in generated Gremlin code.
 * <p>
 * This helper is used in the Gremlin code generated from the ATL transformation
 * plugin. Provided methods are called within the generated code to avoid
 * complex (and inefficient) Gremlin instructions.
 * <p>
 * This helper is independent of the implicit schema used to represent the
 * model, and delegates all the database accesses to its embedded
 * {@link ModelDatastore}s.
 * 
 * @see ModelDatastore
 *
 * @param <ES>
 *            the type representing source elements
 * @param <ET>
 *            the type representing target elements
 * 
 * @author Gwendal DANIEL
 */
public abstract class AbstractATLTransformationHelper<ES, ET> {

	/**
	 * The String literal used to bind a {@link AbstractATLTransformationHelper}
	 * implementation in the generated script.
	 */
	public static final String BINDING_NAME = "tHelper";

	/**
	 * The {@link ModelDatastore} used to access source elements.
	 */
	protected ModelDatastore<?, ES, ?, ?> sourceDatastore;

	/**
	 * The {@link ModelDatastore} used to access target elements.
	 */
	protected ModelDatastore<?, ET, ?, ?> targetDatastore;

	/**
	 * Constructs a new {@link AbstractATLTransformationHelper} that computes
	 * transformations from {@code sourceDatastore} and stores the result in
	 * {@code targetDatastore}.
	 * 
	 * @param sourceDatastore
	 *            the {@link ModelDatastore} used to access the source model
	 * @param targetDatastore
	 *            the {@link ModelDatastore} used to access the target model
	 */
	public AbstractATLTransformationHelper(ModelDatastore<?, ES, ?, ?> sourceDatastore,
			ModelDatastore<?, ET, ?, ?> targetDatastore) {
		this.sourceDatastore = sourceDatastore;
		this.targetDatastore = targetDatastore;
	}

	/**
	 * Creates a new target element mapped from the provided {@code source}
	 * element.
	 * <p>
	 * The created element can be manipulated by the target
	 * {@link ModelDatastore}, allowing model-based manipulation of the
	 * transformation output.
	 * 
	 * @param source
	 *            the element mapped by the transformation
	 * @param targetLabel
	 *            the label used in the transformation for the created element
	 * @param metaclassType
	 *            the type of the element to create
	 * @param nsURI
	 *            the {@code uri} of the EPackage containing the metaclass to
	 *            instantiate
	 * @param resourceName
	 *            the name of the resource where the new element is stored
	 * @return the created target element
	 */
	public abstract ET createElement(ES source, String targetLabel, String metaclassType, String nsURI,
			String resourceName);

	/**
	 * Links {@code from} and {@code to} by creating a mapped reference.
	 * <p>
	 * Note that {@code to} can be an element of the source model that has to be
	 * resolved (declarative binding), or an element of the target model that
	 * has been created by the rule (multi-binding rule). If {@code to} is in
	 * the source model and cannot be resolved (because the corresponding target
	 * element has not been created yet) a proxy link (see
	 * {@link #createProxyLink(Object, Object, String, String, boolean)}) is
	 * created that will be resolved later (see
	 * {@link #resolveProxies(Object, Object)}).
	 * 
	 * @param from
	 *            the tail (in the target model) of the link to create
	 * @param to
	 *            the head of the link to create (from the source or the target
	 *            model)
	 * @param label
	 *            the label of the link to create
	 * @param oppositeLabel
	 *            the label of the opposite reference if it exists
	 * @param isContainment
	 *            {@code true} if the reference is a containment, {@code false}
	 *            otherwise
	 * 
	 * @see #linkReference(Object, Iterable, String, String, boolean)
	 */
	public abstract void linkReference(ET from, Object to, String label, String oppositeLabel, boolean isContainment);

	/**
	 * Links {@code from} to all the elements in {@code to} by creating mapped
	 * references.
	 * <p>
	 * Note that {@code to} can contain elements of the source model that have
	 * to be resolved (declarative binding), or elements of the target model
	 * that have been created by the rule (multi-binding rule). If an element in
	 * {@code to} is in the source model and cannot be resolved (because the
	 * corresponding target element has not been created yet) a proxy link (see
	 * {@link #createProxyLink(Object, Object, String, String, boolean)}) is
	 * created that will be resolved later (see
	 * {@link #resolveProxies(Object, Object)}).
	 * 
	 * @param from
	 *            the tail (in the target model) of the links to create
	 * @param to
	 *            the heads of the links to create (from the source and/or the
	 *            target model)
	 * @param label
	 *            the label of the links to create
	 * @param oppositeLabel
	 *            the label of the opposite reference if it exists
	 * @param isContainment
	 *            {@code true} if the reference is a containment, {@code false}
	 *            otherwise
	 * 
	 * @see #linkReference(Object, Object, String, String, boolean)
	 */
	public abstract void linkReference(ET from, Iterable<Object> to, String label, String oppositeLabel,
			boolean isContainment);

	/**
	 * Creates a concrete link between {@code from} and {@code to}.
	 * <p>
	 * This method is similar to
	 * {@link #linkReference(Object, Object, String, String, boolean)} with a
	 * {@code to} element in the target model. It creates a concrete mapped
	 * reference in the target model between the two elements {@code from} and
	 * {@code to} by using the internal target {@link ModelDatastore}.
	 * 
	 * @param from
	 *            the tail (in the target model) of the link to create
	 * @param to
	 *            the head (in the target model) of the link to create
	 * @param label
	 *            the label of the link to create
	 * @param oppositeLabel
	 *            the label of the opposite reference if it exists
	 * @param isContainment
	 *            {@code true} if the reference is a containment, {@code false}
	 *            otherwise
	 * 
	 * @see #linkReference(Object, Object, String, String, boolean)
	 * @see #linkReference(Object, Iterable, String, String, boolean)
	 */
	protected abstract void createConcreteLink(ET from, ET to, String label, String oppositeLabel, boolean isContainment);

	/**
	 * Creates a proxy link between {@code from} and {@code to}.
	 * <p>
	 * This method is similar to
	 * {@link #linkReference(Object, Object, String, String, boolean)} with a
	 * {@code to} element in the source model. It creates an cross-model proxy
	 * link which is not defined in the source or target {@link ModelDatastore}
	 * that link the target element {@code from} to the source one {@code to}.
	 * 
	 * @param from
	 *            the tail (in the target model) of the proxy link to create
	 * @param to
	 *            the head (in the source model) of the link to create
	 * @param label
	 *            the label of the proxy link to create
	 * @param oppositeLabel
	 *            the label of the opposite reference if it exists
	 * @param isContainment
	 *            {@code true} if the reference is a containment, {@code false}
	 *            otherwise
	 * 
	 * @see #linkReference(Object, Object, String, String, boolean)
	 * @see #linkReference(Object, Iterable, String, String, boolean)
	 */
	protected abstract void createProxyLink(ET from, ES to, String label, String oppositeLabel, boolean isContainment);

	/**
	 * Resolves the proxy links connected to {@code sourceProxy} by setting
	 * their tail to {@code targetElement}.
	 * <p>
	 * {@code sourceProxy} is an element of the source model that has been
	 * transformed and is connected by proxy links to {@code targetElement}.
	 * Resolving a proxy removes the cross-model proxy links and replaces them
	 * by the corresponding link in the target model.
	 * 
	 * @param sourceProxy
	 *            the element that is connected to proxy links
	 * @param targetElement
	 *            the element that resolves the proxies
	 */
	public abstract void resolveProxies(ES sourceProxy, ET targetElement);

	/**
	 * Checks if the provided {@code sourceProxy} can be resolved.
	 * <p>
	 * {@code sourceProxy} is an element of the source model, that may be
	 * resolved if it is associated to an element in the target model.
	 * 
	 * @param sourceProxy
	 *            the source element to check
	 * @return {@code true} if {@code sourceProxy} can be resolved,
	 *         {@code false} otherwise
	 */
	public abstract boolean isResolvable(ES sourceProxy);

	/**
	 * Resolves the {@code sourceProxy} element by retrieving the corresponding
	 * target element.
	 * <p>
	 * This method returns an element of the target model that corresponds to
	 * the provided {@code sourceProxy}. Note that {@code sourceProxy} may not
	 * be resolvable if the corresponding target element hasn't been created yet
	 * (see {@link #isResolvable(Object)}).
	 * 
	 * @param sourceProxy
	 *            the source element to resolve
	 * @return the target element corresponding to {@code sourceProxy} if it
	 *         exists
	 */
	public abstract ET resolve(ES sourceProxy);

	/**
	 * Casts the provided {@code object} to a {@code boolean}.
	 * 
	 * @param object
	 *            the {@link Object} to cast
	 * @return the {@code boolean} value extracted from {@code object}
	 * @throws ClassCastException
	 *             if {@code object} cannot be cast to {@code boolean}
	 */
	public boolean booleanFrom(Object object) throws ClassCastException {
		if (object instanceof String) {
			return Boolean.parseBoolean((String) object);
		} else if (object instanceof Boolean) {
			return ((Boolean) object).booleanValue();
		} else {
			throw new ClassCastException(object + " cannot be cast to Boolean");
		}
	}

	/**
	 * Casts the provided {@code object} to an {@code int}.
	 * 
	 * @param object
	 *            the {@link Object} to cast
	 * @return the {@code int} value extracted from {@code object}
	 * @throws ClassCastException
	 *             if {@code object} cannot be cast to {@code int}
	 */
	public int integerFrom(Object object) throws ClassCastException {
		if (object instanceof String) {
			return Integer.parseInt((String) object);
		} else if (object instanceof Integer) {
			return ((Integer) object).intValue();
		} else {
			throw new ClassCastException(object + " cannot be cast to Integer");
		}
	}

	/**
	 * Casts the provided {@code object} to a {@code float}.
	 * 
	 * @param object
	 *            the {@link Object} to cast
	 * @return the {@code float} value extracted from {@code object}
	 * @throws ClassCastException
	 *             if {@code object} cannot be cast to {@code float}
	 */
	public float floadFrom(Object object) throws ClassCastException {
		if (object instanceof String) {
			return Float.parseFloat((String) object);
		} else if (object instanceof Float) {
			return ((Float) object).floatValue();
		} else {
			throw new ClassCastException(object + " cannot be cast to Float");
		}
	}
}
