package fr.inria.atlanmod.mogwai.processor;

import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.transformation.Transformation;

public abstract class AbstractATLProcessor<Q extends MogwaiQuery, D> extends MogwaiProcessor<Q, D>{
	
	public static final String ATL_DEBUG_KEY = "atl.debug";
	
	protected static final boolean ATL_DEBUG_DEFEAULT = false;
	
	protected Transformation transformation;
	
	protected Transformation getTransformation() {
		return transformation;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public MogwaiQueryResult process(Q query, List<D> datastores, List<ModelDatastore> mappings,
			Map<String, Object> options) {
		handleATLOptions(options);
		return super.process(query, datastores, mappings, options);
	}
	
	protected void handleATLOptions(Map<String, Object> options) {
		if(options.containsKey(ATL_DEBUG_KEY)) {
			transformation.setDebug((boolean) options.get(ATL_DEBUG_KEY));
		}
		else {
			transformation.setDebug(ATL_DEBUG_DEFEAULT);
		}
	}
}
