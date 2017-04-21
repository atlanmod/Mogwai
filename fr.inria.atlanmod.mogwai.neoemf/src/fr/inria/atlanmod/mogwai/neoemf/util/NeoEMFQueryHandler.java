package fr.inria.atlanmod.mogwai.neoemf.util;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.Map;

import fr.inria.atlanmod.mogwai.datastore.blueprints.NeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFATLQueryProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFGremlinQueryProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFOCLQueryProcessor;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
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
		if (oclProcessor.get().accept(query)) {
			oclProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) query.process(oclProcessor.get(),
					new NeoEMFGraphDatastore(datastore.getGraph()), theOptions);
		} else if (gremlinProcessor.get().accept(query)) {
			gremlinProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) query.process(gremlinProcessor.get(),
					new NeoEMFGraphDatastore(datastore.getGraph()), theOptions);
		}
		throw new QueryException("Cannot find a processor for " + query);
	}

	public NeoEMFQueryResult transform(MogwaiQuery transformation, BlueprintsPersistenceBackend datastore,
			Map<String, Object> options) throws QueryException {
		Map<String, Object> theOptions = options;
		if (isNull(theOptions)) {
			theOptions = new HashMap<>();
		}
		if (atlProcessor.get().accept(transformation)) {
			atlProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) transformation.process(atlProcessor.get(),
					new NeoEMFGraphDatastore(datastore.getGraph()), theOptions);
		}
		throw new QueryException("Cannot find a processor for " + transformation);
	}

	private static class Holder {

		private static final NeoEMFQueryHandler INSTANCE = new NeoEMFQueryHandler();

	}

}
