package fr.inria.atlanmod.mogwai.transformation.atl.helper;

import static com.google.common.base.Preconditions.checkNotNull;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;

/**
 * A specialized implementation of {@link AbstractATLTransformationHelper} that
 * performs in-place transformations.
 * 
 * @param <E>
 *            the type representing source and target model elements
 * 
 * @author Gwendal DANIEL
 */
public abstract class InPlaceATLTransformationHelper<E> extends AbstractATLTransformationHelper<E, E> {

	/**
	 * Constructs a new {@link InPlaceATLTransformationHelper} that computes
	 * in-place transformations on {@code datastore}.
	 * 
	 * @param datastore
	 *            the {@link ModelDatastore} used to access the model and store
	 *            the result
	 */
	public InPlaceATLTransformationHelper(ModelDatastore<?, E, ?, ?> datastore) {
		super(datastore, datastore);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Overrides the default implementation by using
	 * {@link #isSourceElement(Object)} and {@link #isTargetElement(Object)} to
	 * check if an element is in the source or the target model.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void linkReference(E from, Object to, String label, String oppositeLabel, boolean isContainment) {
		checkNotNull(from, "Cannot create a reference from the provided element {0}", from);
		checkNotNull(to, "Cannot create a reference to the provided element {0}", to);
		checkNotNull("Cannot create a reference with the provided label {0}", label);
		try {
			E toElement = (E) to;
			if (isSourceElement(toElement)) {
				if (isResolvable(toElement)) {
					createConcreteLink(from, resolve(toElement), label, oppositeLabel, isContainment);
				} else {
					createProxyLink(from, toElement, label, oppositeLabel, isContainment);
				}
			} else {
				createConcreteLink(from, toElement, label, oppositeLabel, isContainment);
			}
		} catch (ClassCastException e) {
			/*
			 * The to element is not in the source or target model, this should
			 * not happen.
			 */
			throw new IllegalArgumentException("Cannot create reference: " + to
					+ " is not contained in the source or target model");
		}
	}

	/**
	 * Checks if the provided {@code element} is in the target model.
	 * <p>
	 * This method is specific to {@link InPlaceATLTransformationHelper} that
	 * uses the same {@link ModelDatastore} for source and target models. The
	 * transformation has to check if an element is in the target model in order
	 * to create concrete/proxy links and resolve elements.
	 * 
	 * @param element
	 *            the element to check
	 * @return {@code true} if {@code element} is in the target model,
	 *         {@code false} otherwise
	 * 
	 * @see #createConcreteLink(Object, Object, String, String, boolean)
	 * @see #createProxyLink(Object, Object, String, String, boolean)
	 * @see #resolve(Object)
	 * @see #resolveProxies(Object, Object)
	 */
	protected abstract boolean isTargetElement(E element);

	/**
	 * Checks if the provided {@code element} is in the source model.
	 * <p>
	 * This method should return the opposite of
	 * {@link #isTargetElement(Object)}. It is specific to
	 * {@link InPlaceATLTransformationHelper} that uses the same
	 * {@link ModelDatastore} for source and target models. The transformation
	 * has to check if an element is in the source model in order to create
	 * concrete/proxy links and resolve elements.
	 * 
	 * @param element
	 *            the element to check
	 * @return {@code true} if the element is in the source model, {@code false}
	 *         otherwise
	 * 
	 * @see #createConcreteLink(Object, Object, String, String, boolean)
	 * @see #createProxyLink(Object, Object, String, String, boolean)
	 * @see #resolve(Object)
	 * @see #resolveProxies(Object, Object)
	 */
	protected boolean isSourceElement(E element) {
		return !isTargetElement(element);
	}

}
