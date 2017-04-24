package fr.inria.atlanmod.mogwai.datastore;

/**
 * Defines the methods that should be implemented to manipulate a
 * {@code data source} as a model.
 * <p>
 * The methods defined in this interface are called within the generated scripts
 * and are responsible of retrieving EMF-related information inside a
 * {@code data source}. They are inspired from the ones defined in the ATL API.
 * <p>
 * This mapping provides a low-level API to manipulate the model. It can be
 * combined with other mappings such as to provide a rich model navigation API
 * depending developer's needs.
 * <p>
 * A custom {@link ModelDatastore} can be provided to the Mogwai engine using
 * the following code:
 * 
 * <pre>
 * {@code
 * ModelMapping mapping = new // an implementation of this interface
 * 
 * MogwaiQuery query = Mogwai(ATL)QueryBuilder.newBuilder()
 * 	.fromFile(new File(<file containing the query to execute>))
 * 	.bind(ModelMapping.BINDING_NAME, mapping)
 * 	.build();
 * }
 * </pre>
 *
 * @param <D>
 *            the type of the {@code data source} to use
 * @param <E>
 *            the type representing {@code model elements}
 * @param <R>
 *            the type representing {@code references}
 * @param <A>
 *            the type representing {@code attributes' value}
 * 
 * @author Gwendal DANIEL
 * 
 */
public interface ModelDatastore<D, E, R, A> {
	/*
	 * TODO add option type parameters instead of complex method signatures This
	 * would ease future extension (for example to support transient EReference,
	 * proxies ...)
	 */

	/**
	 * The String literal used to bind a {@link ModelDatastore} implementation
	 * in the generated script.
	 */
	public static final String BINDING_NAME = "mappingHelper";

	/**
	 * Sets the {@code dataSource} to apply this mapping on.
	 * <p>
	 * <b>Note:</b> the previous datastore will not be accessible anymore.
	 * 
	 * @param dataSource
	 *            the {@code dataSource} to apply this mapping on
	 */
	void setDataSource(D dataSource);

	/**
	 * Returns the underlying {@code dataSource}.
	 * 
	 * @return the underlying {@code dataSource}
	 */
	D getDataSource();

	/**
	 * Returns an {@link Iterable} containing all the elements of the type
	 * {@code typeName}.
	 * <p>
	 * <b>Note:</b> result only contains strict instances of the given type. To
	 * get all the instances of {@code typeName} and its subclasses see
	 * {@link #allOfKind(String)}.
	 * 
	 * @param typeName
	 *            the name of the metaclass to get the instances of
	 * @return an {@link Iterable} containing all the instances of the type
	 *         {@code typeName}
	 */
	Iterable<E> allOfType(String typeName);

	/**
	 * Returns an {@link Iterable} containing all the elements of the type
	 * {@code typeName} and its subclasses.
	 * 
	 * @param typeName
	 *            the name of the metaclass to get the instances of
	 * @return an {@link Iterable} containing all the instances of the type
	 *         {@code typeName} and its subclasses
	 * 
	 */
	Iterable<E> allOfKind(String typeName);

	/**
	 * Creates a new element of the type {@code typeName} and add it to the
	 * resource {@code resourceName}.
	 * <p>
	 * {@code typePackageNsURI} can be provided for mappings that support
	 * metaclasses defined in multiple EPackages.
	 * <p>
	 * {@code resourceName} is optional and can be used by mapping
	 * implementation that supports multiple resource in a single database.
	 * 
	 * @param typeName
	 *            the name of the metaclass to create an instance of
	 * @param typePackageNsURI
	 *            the URI of the EPackage that defines the metaclass
	 *            {@code typeName}
	 * @param resourceName
	 *            the name of the resource where the new element is stored
	 * @return an {@link Object} representing the created instance of
	 *         {@code typeName}
	 * 
	 */
	E newInstance(String typeName, String typePackageNsURI, String resourceName);

	/**
	 * Returns the element corresponding to the parent of {@code from}.
	 * 
	 * @param from
	 *            the element to compute the parent of
	 * @return the element corresponding to the parent of {@code from}
	 */
	E getParent(E from);

	/**
	 * Returns an {@link Iterable} containing the elements connected to
	 * {@code from} with a reference labeled {@code refName}.
	 * 
	 * @param from
	 *            the element to get the reference from
	 * @param refName
	 *            the name of the reference to navigate
	 * @param oppositeName
	 *            the name of the reference's opposite if it exists
	 * @param isContainer
	 *            {@code true} if {@code refName} is a containment,
	 *            {@code false} otherwise
	 * @return an {@link Iterable} containing the elements connected to
	 *         {@code from}
	 */
	Iterable<E> getRef(E from, String refName, String oppositeName, boolean isContainer);

	/**
	 * Creates a reference link between {@code from} and {@code to} with the
	 * label {@code refName}.
	 * 
	 * @param from
	 *            the incoming element of the reference
	 * @param refName
	 *            the label of the reference
	 * @param oppositeName
	 *            the name of the reference's opposite if it exists
	 * @param to
	 *            the outgoing element of the reference
	 * @param isContainment
	 *            {@code true} if the reference is a containment, {@code false}
	 *            otherwise
	 * @return the created reference
	 */
	R setRef(E from, String refName, String oppositeName, E to, boolean isContainment);

	/**
	 * Removes the reference link between {@code from} and {@code to} with the
	 * label {@code refName}.
	 * 
	 * @param from
	 *            the incoming element of the reference
	 * @param refName
	 *            the label of the reference
	 * @param to
	 *            the outgoing element of the reference
	 * @param isContainment
	 *            {@code true} if the reference is a containment, {@code false}
	 *            otherwise
	 * @return the previously linked element
	 */
	E removeRef(E from, String refName, E to, boolean isContainment);

	/**
	 * Returns an {@link Iterable} containing the attribute(s) {@code attName}
	 * of {@code from}.
	 * 
	 * @param from
	 *            the element to get the attribute from
	 * @param attName
	 *            the name of the attribute to retrieve
	 * @return an instance of {@code A} representing the attribute(s)
	 *         {@code attName} of {@code from}
	 */
	Iterable<A> getAtt(E from, String attName);

	/**
	 * Sets the value of the attribute {@code attName} of {@code from} to
	 * {@code attValue}.
	 * 
	 * @param from
	 *            the element to set the attribute of
	 * @param attName
	 *            the name of the attribute to set
	 * @param attValue
	 *            the value of the attribute to set
	 * @return the updated element
	 */
	E setAtt(E from, String attName, A attValue);

	/**
	 * Returns the type of the {@code from} element.
	 * 
	 * @param from
	 *            the element to get the type of
	 * @return a String representation of the metaclass associated to
	 *         {@code from}
	 */
	String getType(E from);

	/**
	 * Returns whether {@code from} is an instance of {@code type}.
	 * <p>
	 * <b>Note:</b> this method only checks if {@code from} is a strict instance
	 * of the {@code type}. To check if {@code from} is an instance of
	 * {@code type} or any of its subclasses see {@link #isKindOf(Object, String)}.
	 * 
	 * @param from
	 *            the element to check the type of
	 * @param type
	 *            the type to check
	 * @return {@code true} if {@code from} is an instance of {@code type},
	 *         {@code false} otherwise
	 */
	boolean isTypeOf(E from, String type);

	/**
	 * Returns whether {@code from} is an instance of {@code type} or any of its
	 * subclasses.
	 * 
	 * @param from
	 *            the element to check the type of
	 * @param type
	 *            the type to check
	 * @return {@code true} if {@code from} is an instance of {@code type} or
	 *         any of its subclasses, {@code false} otherwise
	 */
	boolean isKindOf(E from, String type);

}
