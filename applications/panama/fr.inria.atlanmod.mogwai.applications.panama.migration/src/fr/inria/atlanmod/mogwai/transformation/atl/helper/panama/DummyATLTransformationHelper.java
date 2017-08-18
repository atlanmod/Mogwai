package fr.inria.atlanmod.mogwai.transformation.atl.helper.panama;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.transformation.atl.helper.AbstractATLTransformationHelper;

/**
 * A dummy example implementation of {@link AbstractATLTransformationHelper}
 * that simply creates the target elements without managing trace links and
 * proxy references in the target data-store.
 * <p>
 * Using this transformation helper may produce unexpected results if both
 * source and target {@link ModelDatastore} wraps the same data-source, and if
 * the transformation tries to create a link between an element of the source
 * and target model.
 * <p>
 * <b>Note:</b> this transformation helper should not be used in production, and
 * has only been tested on the Mogwai Panama papers example.
 * 
 * @see AbstractATLTransformationHelper
 * 
 * @author Gwendal DANIEL
 *
 * @param <ES>
 *            the type representing the source model elements
 * @param <ET>
 *            the type representing the target model elements
 */
public class DummyATLTransformationHelper<ES, ET> extends AbstractATLTransformationHelper<ES, ET> {

	/**
	 * Constructs a new {@link DummyATLTransformationHelper} that transforms the
	 * model stored in {@code sourceDatastore} and store the resulting model in
	 * {@code targetDatastore}.
	 * <p>
	 * <b>Note:</b> this transformation helper simply creates the target
	 * elements without managing trace links and proxy references in the target
	 * data-store.
	 * 
	 * @param sourceDatastore
	 *            the {@link ModelDatastore} used to access the source model
	 * @param targetDatastore
	 *            the {@link ModelDatastore} used to store the transformed model
	 */
	public DummyATLTransformationHelper(ModelDatastore<?, ES, ?, ?> sourceDatastore,
			ModelDatastore<?, ET, ?, ?> targetDatastore) {
		super(sourceDatastore, targetDatastore);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ET createElement(ES source, String targetLabel, String metaclassType, String nsURI, String resourceName) {
		return targetDatastore.newInstance(metaclassType, nsURI, resourceName);
	}

	/**
	 * <b>This method is not implemented and does not create any proxy link.</b>
	 * <p>
	 * Using this transformation helper may produce unexpected results if both
	 * source and target {@link ModelDatastore} wraps the same data-source, and
	 * if the transformation tries to create a link between an element of the
	 * source and target model.
	 * <p>
	 * <b>Note:</b> this transformation helper should not be used in production,
	 * and has only been tested on the Mogwai Panama papers example.
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
	 */
	@Override
	protected void createProxyLink(ET from, ES to, String label, String oppositeLabel, boolean isContainment) {

	}

	/**
	 * <b>This method is not implemented and does not resolve any proxy.</b>
	 * <p>
	 * Using this transformation helper may produce unexpected results if both
	 * source and target {@link ModelDatastore} wraps the same data-source, and
	 * if the transformation tries to create a link between an element of the
	 * source and target model.
	 * <p>
	 * <b>Note:</b> this transformation helper should not be used in production,
	 * and has only been tested on the Mogwai Panama papers example.
	 * 
	 * @param sourceProxy
	 *            the element that is connected to proxy links
	 * 
	 * @param targetElement
	 *            the element that resolves the proxies
	 */
	@Override
	public void resolveProxies(ES sourceProxy, ET targetElement) {

	}

	/**
	 * A dummy implementation the always return {@code false}.
	 * <p>
	 * This transformation helper does not handle model element proxies and
	 * proxy links, therefore source elements are marked as non-resolvable.
	 * <p>
	 * Using this transformation helper may produce unexpected results if both
	 * source and target {@link ModelDatastore} wraps the same data-source, and
	 * if the transformation tries to create a link between an element of the
	 * source and target model.
	 * <p>
	 * <b>Note:</b> this transformation helper should not be used in production,
	 * and has only been tested on the Mogwai Panama papers example.
	 * 
	 * @param sourceProxy
	 *            the source element to check
	 * 
	 * @return {@code false}
	 */
	@Override
	public boolean isResolvable(ES sourceProxy) {
		return false;
	}

	/**
	 * A dummy implementation that always return {@code null}.
	 * <p>
	 * This transformation helper does not handle model element proxies and
	 * proxy links, therefore resolving a source element always returns
	 * {@code null}. Note that the used ATL algorithm should not call this
	 * method because it is first checked using {@link #isResolvable(Object)}.
	 * <p>
	 * Using this transformation helper may produce unexpected results if both
	 * source and target {@link ModelDatastore} wraps the same data-source, and
	 * if the transformation tries to create a link between an element of the
	 * source and target model.
	 * <p>
	 * <b>Note:</b> this transformation helper should not be used in production,
	 * and has only been tested on the Mogwai Panama papers example.
	 * 
	 * @param sourceProxy
	 *            the source element to resolve
	 * 
	 * @return {@code null}
	 */
	@Override
	public ET resolve(ES sourceProxy) {
		return null;
	}
}
