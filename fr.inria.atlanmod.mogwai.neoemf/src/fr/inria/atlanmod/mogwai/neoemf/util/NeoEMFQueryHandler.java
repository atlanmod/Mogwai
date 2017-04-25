package fr.inria.atlanmod.mogwai.neoemf.util;

import static java.util.Objects.isNull;
import static com.google.common.base.Preconditions.checkArgument;

import java.util.HashMap;
import java.util.Map;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.blueprints.NeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFATLQueryProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFGremlinQueryProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFOCLQueryProcessor;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.QueryException;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class NeoEMFQueryHandler {

	public static NeoEMFQueryHandler getInstance() {
		return Holder.INSTANCE;
	}

	private static final ThreadLocal<NeoEMFOCLQueryProcessor> oclProcessor = new ThreadLocal<NeoEMFOCLQueryProcessor>() {

		@Override
		protected NeoEMFOCLQueryProcessor initialValue() {
			return new NeoEMFOCLQueryProcessor();
		}
	};

	private static final ThreadLocal<NeoEMFGremlinQueryProcessor> gremlinProcessor = new ThreadLocal<NeoEMFGremlinQueryProcessor>() {

		@Override
		protected NeoEMFGremlinQueryProcessor initialValue() {
			return new NeoEMFGremlinQueryProcessor();
		}
	};

	private static final ThreadLocal<NeoEMFATLQueryProcessor> atlProcessor = new ThreadLocal<NeoEMFATLQueryProcessor>() {

		protected NeoEMFATLQueryProcessor initialValue() {
			return new NeoEMFATLQueryProcessor();
		};
	};

	public NeoEMFQueryResult query(MogwaiQuery query, Object arg, BlueprintsPersistenceBackend datastore,
			Map<String, Object> options) throws QueryException {
		Map<String, Object> theOptions = options;
		if (isNull(theOptions)) {
			theOptions = new HashMap<>();
		}
		ModelDatastore<?, ?, ?, ?> modelDatastore = getModelDatastore(theOptions, datastore);
		if (oclProcessor.get().accept(query)) {
			oclProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) query.process(oclProcessor.get(),
					modelDatastore, theOptions);
		} else if (gremlinProcessor.get().accept(query)) {
			gremlinProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) query.process(gremlinProcessor.get(),
					modelDatastore, theOptions);
		}
		throw new QueryException("Cannot find a processor for " + query);
	}

	public NeoEMFQueryResult transform(MogwaiQuery transformation, BlueprintsPersistenceBackend datastore,
			Map<String, Object> options) throws QueryException {
		Map<String, Object> theOptions = options;
		if (isNull(theOptions)) {
			theOptions = new HashMap<>();
		}
		ModelDatastore<?, ?, ?, ?> modelDatastore = getModelDatastore(theOptions, datastore);
		if (atlProcessor.get().accept(transformation)) {
			atlProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) transformation.process(atlProcessor.get(), modelDatastore, theOptions);
		}
		throw new QueryException("Cannot find a processor for " + transformation);
	}
	
	private ModelDatastore<?, ?, ?, ?> getModelDatastore(Map<String, Object> options, BlueprintsPersistenceBackend datastore) {
		ModelDatastore<?, ?, ?, ?> modelDatastore = getDefaultModelDatastore(options, datastore);
		if (options.containsKey(MogwaiResource.NEOEMF_MODEL_DATASTORE)) {
			modelDatastore = (ModelDatastore<?, ?, ?, ?>) options.get(MogwaiResource.NEOEMF_MODEL_DATASTORE);
			checkArgument(modelDatastore instanceof NeoEMFGraphDatastore,
					"Cannot transform a resource, expected a {0} instance, found {1}",
					NeoEMFGraphDatastore.class.getName(), modelDatastore.getClass().getName());
		}
		return modelDatastore;
	}
	
	private ModelDatastore<?, ?, ?, ?> getDefaultModelDatastore(Map<String, Object> options, BlueprintsPersistenceBackend datastore) {
		return new NeoEMFGraphDatastore(datastore.getGraph());
	}

	private static class Holder {

		private static final NeoEMFQueryHandler INSTANCE = new NeoEMFQueryHandler();

	}

}
