package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.common.util.MogwaiQueryUtil;
import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.gremlin.impl.GremlinScriptImpl;
import fr.inria.atlanmod.mogwai.query.GremlinQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;
import fr.inria.atlanmod.mogwai.query.builder.GremlinQueryBuilder;
import fr.inria.atlanmod.mogwai.util.GremlinHelper;

/**
 * Provides an abstract API to process a {@link MogwaiQuery}.
 * <p>
 * This class defines the methods any processor has to implement in order to
 * compute a {@link MogwaiQuery}. Default implementation of some methods are
 * provided to ease integration.
 * <p>
 * <b>Note:</b> the current implementation supports only one
 * {@link ModelDatastore} used to access both source and target models. We plan
 * to separate them in the future in order to support model transformations
 * storing results in an external datasource.
 * 
 * @param <Q>
 *            the kind of {@link MogwaiQuery} this processor supports
 *            
 * @see MogwaiQuery
 * 
 * @author Gwendal DANIEL
 */
public abstract class AbstractQueryProcessor<Q extends MogwaiQuery> {

	/**
	 * The option key to specify query bindings.
	 */
	public static final String BINDINGS_KEY = "bindings";

	/**
	 * The binding key representing the source datastore.
	 * <p>
	 * <b>Note:</b> this binding should not be used, it is needed to support the
	 * previous version of the OCL2Gremlin transformation and will be removed in
	 * the future. TODO remove this binding after OCL2Gremlin update
	 */
	protected static final String DATASTORE_BINDING = "g";

	/**
	 * The binding key representing the source/target {@link ModelDatastore}.
	 * <p>
	 * <b>Note:</b> the current implementation only supports in-place
	 * queries/transformations (with a single {@link ModelDatastore} for the
	 * source and target models). It will be extended in the future to support
	 * two {@link ModelDatastore}s in order to compute model transformations and
	 * store results in an external datasource.
	 */
	protected static final String MODEL_MAPPING_BINDING = "mappingHelper";

	/**
	 * Returns the name of the processor.
	 * 
	 * @return the name of the processor
	 */
	public abstract String getName();

	/**
	 * The path of the initialization script used to define additional Gremlin
	 * operations and syntactic sugar used in the generated code.
	 */
	private static final String INIT_SCRIPT_FILE_NAME = "init.gremlin";

	/**
	 * The {@link File} containing the initialization script used to define
	 * additional Gremlin operations and syntactic sugar used in the generated
	 * code.
	 */
	private File initGremlinFile;

	/**
	 * Constructs a new {@link AbstractQueryProcessor} and loads the
	 * initialization Gremlin file used to setup the engine.
	 * 
	 * @throws IOException
	 *             if the initialization file cannot be found
	 */
	public AbstractQueryProcessor() {
		URL url;
		try {
			url = MogwaiQueryUtil.getFileURL(AbstractQueryProcessor.class, INIT_SCRIPT_FILE_NAME);
		} catch (IOException e) {
			throw new MogwaiCoreException("Cannot initialize MogwaiProcessor: {0} not found", INIT_SCRIPT_FILE_NAME);
		}
		try {
			initGremlinFile = new File(url.toURI());
		} catch (URISyntaxException e) {
			initGremlinFile = new File(url.getPath());
		}
	}

	/**
	 * Computes a {@code query} on the provided {@code datastore}.
	 * <p>
	 * This method is equivalent to
	 * {@code process(query, Arrays.asList(datastore), Collections.emptyMap())}.
	 * Override {@link #process(MogwaiQuery, List, Map)} to change its behavior.
	 * 
	 * @param query
	 *            the {@link MogwaiQuery} to compute
	 * @param datastore
	 *            the {@link ModelDatastore} to compute the {@code query} on
	 * @return a {@link QueryResult} representing the output of the executed
	 *         {@code query}
	 * 
	 * @see #process(MogwaiQuery, List, Map)
	 */
	@SuppressWarnings("rawtypes")
	public final QueryResult process(Q query, ModelDatastore datastore) {
		return process(query, datastore, new HashMap<String, Object>());
	}

	/**
	 * Computes a {@code query} on the provided {@code datastore} with the given
	 * {@code options}.
	 * <p>
	 * This method is equivalent to
	 * {@code process(query, Arrays.asList(datastore), options)}. Override
	 * {@link #process(MogwaiQuery, List, Map)} to change its behavior.
	 * 
	 * @param query
	 *            the {@link MogwaiQuery} to compute
	 * @param datastore
	 *            the {@link ModelDatastore} to compute the {@code query} on
	 * @param options
	 *            a {@link Map} containing {@code query} execution options
	 * @return a {@link QueryResult} representing the output of the executed
	 *         {@code query}
	 * 
	 * @see #process(MogwaiQuery, List, Map)
	 */
	@SuppressWarnings("rawtypes")
	public final QueryResult process(Q query, ModelDatastore datastore, Map<String, Object> options) {
		return process(query, Arrays.asList(datastore), options);
	}

	/**
	 * Computes a {@code query} on the provided {@code datastores}.
	 * <p>
	 * This method is equivalent to
	 * {@code process(query, datastores, Collections.emptyMap())}. Override
	 * {@link #process(MogwaiQuery, List, Map)} to change its behavior.
	 * 
	 * @param query
	 *            the {@link MogwaiQuery} to compute
	 * @param datastores
	 *            the {@link ModelDatastore}s to compute the {@code query} on
	 * @return a {@link QueryResult} representing the output of the executed
	 *         {@code query}
	 * 
	 * @see #process(MogwaiQuery, List, Map)
	 */
	@SuppressWarnings("rawtypes")
	public final QueryResult process(Q query, List<ModelDatastore> datastores) {
		return process(query, datastores, new HashMap<String, Object>());
	}

	/**
	 * Computes a {@code query} on the provided {@code datastores} with the
	 * given {@code options}.
	 * <p>
	 * This method is internally called by all the {@code process} methods.
	 * Override it to change the processing algorithm of the processor.
	 * 
	 * @param query
	 *            the {@link MogwaiQuery} to compute
	 * @param datastores
	 *            the {@link ModelDatastore}s to compute the {@code query} on
	 * @param options
	 *            a {@link Map} containing {@code query} execution options
	 * @return a {@link QueryResult} representing the output of the executed
	 *         {@code query}
	 */
	@SuppressWarnings("rawtypes")
	public QueryResult process(Q query, List<ModelDatastore> datastores, Map<String, Object> options) {
		checkNotNull(query, "Cannot process the query: {0}", query);
		checkArgument(datastores.size() >= 1, "Cannot process the query: expected at least 1 datastore, found {0}",
				datastores.size());
		adaptOptions(options);
		initGremlinScriptRunner(datastores);
		Map<String, Object> bindings = createBindings(datastores, options);
		GremlinScript gScript = createGremlinScript(query, options);
		Object result = runGremlinScript(gScript, bindings, options);
		return adaptResult(result, gScript, options);
	}

	/**
	 * Returns whether this processor accepts the provided {@code query}.
	 * 
	 * @param query
	 *            the {@link MogwaiQuery} to check
	 * @return {@code true} if this processor can handle the {@code query},
	 *         {@code false} otherwise
	 */
	public abstract boolean accept(MogwaiQuery query);

	/**
	 * Adapts the provided {@code options} for this processor.
	 * <p>
	 * This method can be overridden to automatically set additional options
	 * related to this processor. Default implementation doesn't add or remove
	 * any element from the {@code options} {@link Map}.
	 * 
	 * @param options
	 *            the {@link Map} containing the options to adapt
	 */
	protected void adaptOptions(Map<String, Object> options) {

	}

	/**
	 * Initializes the underlying Gremlin engine for the provided
	 * {@code datastores}.
	 * <p>
	 * This method uses the {@code initGremlinFile} to initialize the engine and
	 * binds its variables to the provided {@code datastores}. Once this
	 * initialization has been done, {@link ModelDatastore} operations can be
	 * accessed in a Gremlin-like way in the generated code.
	 * 
	 * @param datastores
	 *            the {@link ModelDatastore} used to initialize the engine
	 */
	@SuppressWarnings("rawtypes")
	protected void initGremlinScriptRunner(List<ModelDatastore> datastores) {
		checkArgument(datastores.size() >= 1,
				"Cannot init the script runner: expected at least 1 datastore, found {0}", datastores.size());
		GremlinQuery query = (GremlinQuery) GremlinQueryBuilder.newBuilder().fromFile(initGremlinFile).build();
		Map<String, Object> bindings = new HashMap<>();
		bindings.put(ModelDatastore.BINDING_NAME, datastores.get(0));
		bindings.put(GremlinHelper.BINDING_NAME, GremlinHelper.getInstance());
		GremlinScriptRunner.getInstance().runGremlinScript(new GremlinStringWrapper(query.getInput()),
				bindings, Collections.<String, Object> emptyMap());
	}

	/**
	 * Creates the Gremlin bindings from the provided {@code datastores} with
	 * the given {@code options}.
	 * <p>
	 * <b>Note:</b> this method creates default bindings (see
	 * {@link #createDefaultBindings(List)} if no custom bindings are specified
	 * in the {@code options} map.
	 * 
	 * @param datastores
	 *            the {@link ModelDatastore} to create the bindings from
	 * @param options
	 *            a {@link Map} containing the execution options and custom
	 *            bindings
	 * @return a {@link Map} containing the generated query bindings
	 * 
	 * @see #BINDINGS_KEY
	 * @see #createDefaultBindings(List)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Map<String, Object> createBindings(List<ModelDatastore> datastores, Map<String, Object> options) {
		Map<String, Object> bindings;
		if (options.containsKey(BINDINGS_KEY)) {
			bindings = (Map<String, Object>) options.get(BINDINGS_KEY);
		} else {
			bindings = createDefaultBindings(datastores);
		}
		return bindings;
	}

	/**
	 * Creates the default Gremlin bindings for the provided {@code datastores}.
	 * <p>
	 * <b>Note:</b> this method is called if no custom bindings are provided in
	 * the process {@code options} map. It binds the given {@code datastores}
	 * with default names that are used in the transformations.
	 * <p>
	 * This method only supports single {@link ModelDatastore} binding for now.
	 * It will be extended to support multiple datastore in the future. TODO
	 * Supports multiple datastores.
	 * 
	 * @param datastores
	 *            the {@link ModelDatastore}s to create the bindings from
	 * @return a {@link Map} containing the generated query bindings
	 * @throws UnsupportedOperationException
	 *             if more than one {@code datastore} is provided
	 */
	@SuppressWarnings("rawtypes")
	protected Map<String, Object> createDefaultBindings(List<ModelDatastore> datastores) {
		checkArgument(!datastores.isEmpty(), "Cannot create default bindings: no datastore provided");
		Map<String, Object> bindings = new HashMap<>();
		if (datastores.size() == 1) {
			/*
			 * TODO: This should not be needed: we don't have to bind the real
			 * datastore, but the current OCL implementation relies on the
			 * low-level graph API, and doesn't use the mapping. In addition,
			 * the init.gremlin script binds Pipes to Graph instead of a more
			 * generic ModelDatastore type.
			 */
			bindings.put(DATASTORE_BINDING, datastores.get(0).getDataSource());
		} else {
			// Multiple datastores
			throw new UnsupportedOperationException("Multiple datastores are not supported for now");
		}
		if (datastores.size() == 1) {
			bindings.put(MODEL_MAPPING_BINDING, datastores.get(0));
		} else {
			// Multiple mappings
			throw new UnsupportedOperationException("Multiple mappings are not supported for now");
		}
		return bindings;
	}

	/**
	 * Creates the {@link GremlinScript} corresponding to the provided
	 * {@code query}.
	 * 
	 * @param query
	 *            the input {@link MogwaiQuery} to generate the
	 *            {@link GremlinScript} from
	 * @param options
	 *            a {@link Map} containing query translation options
	 * @return the generated {@link GremlinScript}
	 */
	protected abstract GremlinScript createGremlinScript(Q query, Map<String, Object> options);

	/**
	 * Executes the provided {@code script} with the given {@code bindings} and
	 * execution {@code options}.
	 * <p>
	 * {@code bindings} are computed by the {@link #createBindings(List, Map)}
	 * methods that is responsible of creating the bindings from the input
	 * {@link ModelDatastore} and {@code options}.
	 * 
	 * @param script
	 *            the {@link GremlinScript} to execute
	 * @param bindings
	 *            the bindings used to set the query variable values
	 * @param options
	 *            a {@link Map} containing execution options
	 * @return a raw element representing the query result
	 * 
	 * @see #createBindings(List, Map)
	 */
	protected Object runGremlinScript(GremlinScript script, Map<String, Object> bindings, Map<String, Object> options) {
		return GremlinScriptRunner.getInstance().runGremlinScript(script, bindings, options);
	}

	/**
	 * Adapts the raw Gremlin engine result.
	 * 
	 * @param result
	 *            the {@link Object} representing the output of the Gremlin
	 *            engine
	 * @param script
	 *            the computed {@link GremlinScript}
	 * @param options
	 *            a {@link Map} containing execution options
	 * @return a {@link QueryResult} representing the output of the executed
	 *         {@code script}
	 */
	protected QueryResult adaptResult(Object result, GremlinScript script, Map<String, Object> options) {
		return new QueryResult(result, script);
	}

	/**
	 * A placeholder used to wrap textual Gremlin scripts in a
	 * {@link GremlinScript} object.
	 * <p>
	 * This class can be used by subclasses that don't generate a
	 * {@link GremlinScript} from their input query, or accept textual Gremlin
	 * queries as their input.
	 * <p>
	 * <b>Note:</b> this class only redefines {@code toString()} and may return
	 * unexpected results if base methods are called.
	 *
	 */
	protected class GremlinStringWrapper extends GremlinScriptImpl {

		/**
		 * The textual Gremlin script.
		 */
		private String textualScript;

		/**
		 * Constructs a new {@link GremlinStringWrapper} from the provided
		 * {@code textualScript}.
		 * 
		 * @param textualScript
		 *            the literal query to wrap
		 */
		public GremlinStringWrapper(String textualScript) {
			super();
			this.textualScript = textualScript;
		}

		/**
		 * Returns a {@link String} representation of this element.
		 */
		@Override
		public String toString() {
			return textualScript;
		}
	}

}
