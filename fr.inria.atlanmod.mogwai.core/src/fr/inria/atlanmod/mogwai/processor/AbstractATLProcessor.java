package fr.inria.atlanmod.mogwai.processor;

import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;
import fr.inria.atlanmod.mogwai.transformation.Transformation;

/**
 * An ATL-based processor that uses an internal ATL transformation to create the
 * {@link GremlinScript} to compute.
 * <p>
 * This class defines methods ATL-based processors have to implement, and
 * default implementations integrating ATL options.
 *
 * @param <Q>
 *            the kind of {@link MogwaiQuery} this processor supports
 * 
 * @author Gwendal DANIEL
 */
public abstract class AbstractATLProcessor<Q extends MogwaiQuery> extends AbstractQueryProcessor<Q> {

	/**
	 * The option key to specify whether ATL debug is enabled.
	 */
	public static final String ATL_DEBUG_KEY = "atl.debug";

	/**
	 * The default ATL debug value.
	 */
	protected static final boolean ATL_DEBUG_DEFEAULT = false;

	/**
	 * The internal {@link Transformation} used to create the
	 * {@link GremlinScript} to compute.
	 * <p>
	 * <b>Note:</b> the {@link Transformation} interface should provide a
	 * unified {@code transform} method in the future. This has to be handled in
	 * the subclasses for now. TODO unify {@code transform} methods of
	 * {@link Transformation} implementations into a single one.
	 */
	protected Transformation transformation;

	/**
	 * Returns the internal {@link Transformation} used to create the
	 * {@link GremlinScript} to compute.
	 * 
	 * @return the internal {@link Transformation} used to create the
	 *         {@link GremlinScript} to comptue
	 */
	protected Transformation getTransformation() {
		return transformation;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Adds an initialization step in the {@code query} processing that handles
	 * ATL-specific {@code options}.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public QueryResult process(Q query, List<ModelDatastore> datastores, Map<String, Object> options) {
		handleATLOptions(options);
		return super.process(query, datastores, options);
	}

	/**
	 * Handles ATL-related options within the {@code options} map.
	 * 
	 * @param options
	 *            the {@link Map} containing the query options
	 */
	protected void handleATLOptions(Map<String, Object> options) {
		if (options.containsKey(ATL_DEBUG_KEY)) {
			transformation.setDebug((boolean) options.get(ATL_DEBUG_KEY));
		} else {
			transformation.setDebug(ATL_DEBUG_DEFEAULT);
		}
	}
}
