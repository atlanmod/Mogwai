package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.data.mapping.ModelMapping;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;

public abstract class MogwaiProcessor<Q extends MogwaiQuery, D> {

	public static final String BINDINGS_KEY = "bindings";

	protected static final String DATASTORE_BINDING = "g";

	protected static final String MODEL_MAPPING_BINDING = "mappingHelper";

	public abstract String getName();

	@SuppressWarnings("rawtypes")
	public final MogwaiQueryResult process(Q query, D datastore, ModelMapping mapping) {
		return process(query, datastore, mapping, new HashMap<String, Object>());
	}

	@SuppressWarnings("rawtypes")
	public final MogwaiQueryResult process(Q query, D datastore, ModelMapping mapping, Map<String, Object> options) {
		return process(query, Arrays.asList(datastore), Arrays.asList(mapping), options);
	}

	@SuppressWarnings("rawtypes")
	public final MogwaiQueryResult process(Q query, List<D> datastores, List<ModelMapping> mappings) {
		return process(query, datastores, mappings, new HashMap<String, Object>());
	}

	@SuppressWarnings("rawtypes")
	public MogwaiQueryResult process(Q query, List<D> datastores, List<ModelMapping> mappings,
			Map<String, Object> options) {
		checkNotNull(query, "Cannot process the query: {0}", query);
		linkMappings(datastores, mappings);
		Map<String, Object> bindings = createBindings(datastores, mappings, options);
		String gScript = createGremlinScript(query, options);
		Object result = runGremlinScript(gScript, bindings, options);
		return adaptResult(result, gScript, options);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void linkMappings(List<D> datastores, List<ModelMapping> mappings) {
		checkArgument(datastores.size() == mappings.size(),
				"Cannot link mappings to the datastores: found {0} datastores for {1} mappings", datastores.size(),
				mappings.size());
		for(int i = 0; i < datastores.size(); i++) {
			mappings.get(i).setDataSource(datastores.get(i));
		}

	}

	public abstract boolean accept(MogwaiQuery query);

	protected Object runGremlinScript(String gScript, Map<String, Object> bindings, Map<String, Object> options) {
		return GremlinScriptRunner.getInstance().runGremlinScript(gScript, bindings);
	}

	protected abstract String createGremlinScript(Q query, Map<String, Object> options);

	protected MogwaiQueryResult adaptResult(Object result, String gremlinScript, Map<String, Object> options) {
		return new MogwaiQueryResult(result, gremlinScript);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Map<String, Object> createBindings(List<D> datastores, List<ModelMapping> mappings,
			Map<String, Object> options) {
		Map<String, Object> bindings;
		if (options.containsKey(BINDINGS_KEY)) {
			bindings = (Map<String, Object>) options.get(BINDINGS_KEY);
		} else {
			bindings = createDefaultBindings(datastores, mappings);
		}
		return bindings;
	}

	@SuppressWarnings("rawtypes")
	protected Map<String, Object> createDefaultBindings(List<D> datastores, List<ModelMapping> mappings) {
		checkArgument(!datastores.isEmpty(), "Cannot create default bindings: no datastore provided");
		checkArgument(!mappings.isEmpty(), "Cannot create default bindings: no mapping provided");
		Map<String, Object> bindings = new HashMap<>();
		if (datastores.size() == 1) {
			bindings.put(DATASTORE_BINDING, datastores.get(0));
		} else {
			// Multiple datastores
			throw new UnsupportedOperationException("Multiple datastores are not supported for now");
		}
		if (mappings.size() == 1) {
			bindings.put(MODEL_MAPPING_BINDING, mappings.get(0));
		} else {
			// Multiple mappings
			throw new UnsupportedOperationException("Multiple mappings are not supported for now");
		}
		return bindings;
	}

}
