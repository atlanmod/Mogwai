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

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.gremlin.impl.GremlinScriptImpl;
import fr.inria.atlanmod.mogwai.query.MogwaiGremlinQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.query.builder.MogwaiGremlinQueryBuilder;
import fr.inria.atlanmod.mogwai.util.GremlinHelper;

public abstract class AbstractMogwaiProcessor<Q extends MogwaiQuery> {

	public static final String BINDINGS_KEY = "bindings";

	protected static final String DATASTORE_BINDING = "g";

	protected static final String MODEL_MAPPING_BINDING = "mappingHelper";

	public abstract String getName();

	private static final String INIT_SCRIPT_FILE_NAME = "init.gremlin";

	private File initGremlinFile;

	public AbstractMogwaiProcessor() {
		URL url;
		try {
			url = getFileURL(INIT_SCRIPT_FILE_NAME);
		} catch (IOException e) {
			throw new MogwaiException("Cannot initialize MogwaiProcessor: {0} not found", INIT_SCRIPT_FILE_NAME);
		}
		try {
			initGremlinFile = new File(url.toURI());
		} catch (URISyntaxException e) {
			initGremlinFile = new File(url.getPath());
		}
	}

	@SuppressWarnings("rawtypes")
	public final MogwaiQueryResult process(Q query, ModelDatastore datastore) {
		return process(query, datastore, new HashMap<String, Object>());
	}

	@SuppressWarnings("rawtypes")
	public final MogwaiQueryResult process(Q query, ModelDatastore datastore, Map<String, Object> options) {
		return process(query, Arrays.asList(datastore), options);
	}

	@SuppressWarnings("rawtypes")
	public final MogwaiQueryResult process(Q query, List<ModelDatastore> datastores) {
		return process(query, datastores, new HashMap<String, Object>());
	}

	@SuppressWarnings("rawtypes")
	public MogwaiQueryResult process(Q query, List<ModelDatastore> datastores, Map<String, Object> options) {
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

	public abstract boolean accept(MogwaiQuery query);

	@SuppressWarnings("rawtypes")
	protected void initGremlinScriptRunner(List<ModelDatastore> datastores) {
		checkArgument(datastores.size() >= 1,
				"Cannot init the script runner: expected at least 1 datastore, found {0}", datastores.size());
		MogwaiGremlinQuery query = (MogwaiGremlinQuery) MogwaiGremlinQueryBuilder.newBuilder()
				.fromFile(initGremlinFile).bind(ModelDatastore.BINDING_NAME, datastores.get(0))
				.bind(GremlinHelper.BINDING_NAME, GremlinHelper.getInstance()).build();
		GremlinScriptRunner.getInstance().runGremlinScript(new GremlinStringWrapper(query.getGremlinScript()), query.getBindings(),
				Collections.<String, Object> emptyMap());
	}

	protected Object runGremlinScript(GremlinScript gScript, Map<String, Object> bindings, Map<String, Object> options) {
		return GremlinScriptRunner.getInstance().runGremlinScript(gScript, bindings, options);
	}
	
	protected void adaptOptions(Map<String, Object> options) {
		
	}

	protected abstract GremlinScript createGremlinScript(Q query, Map<String, Object> options);

	protected MogwaiQueryResult adaptResult(Object result, GremlinScript gremlinScript, Map<String, Object> options) {
		return new MogwaiQueryResult(result, gremlinScript);
	}

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

	@SuppressWarnings("rawtypes")
	protected Map<String, Object> createDefaultBindings(List<ModelDatastore> datastores) {
		checkArgument(!datastores.isEmpty(), "Cannot create default bindings: no datastore provided");
		Map<String, Object> bindings = new HashMap<>();
		if (datastores.size() == 1) {
			/*
			 * TODO:
			 * This should not be needed: we don't have to bind the real
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

	private static URL getFileURL(String fileName) throws IOException {
		URL fileURL;
		if (isEclipseRunning()) {
			URL resourceURL = AbstractMogwaiProcessor.class.getResource(fileName);
			if (resourceURL != null) {
				fileURL = FileLocator.toFileURL(resourceURL);
			} else {
				fileURL = null;
			}
		} else {
			fileURL = AbstractMogwaiProcessor.class.getResource(fileName);
		}
		if (fileURL == null) {
			throw new IOException("'" + fileName + "' not found");
		} else {
			return fileURL;
		}
	}

	private static boolean isEclipseRunning() {
		try {
			return Platform.isRunning();
		} catch (Throwable e) {

		}
		return false;
	}
	
	protected class GremlinStringWrapper extends GremlinScriptImpl {
		
		private String textualScript;
		
		public GremlinStringWrapper(String textualScript) {
			super();
			this.textualScript = textualScript;
		}
		
		@Override
		public String toString() {
			return textualScript;
		}
	}

}
