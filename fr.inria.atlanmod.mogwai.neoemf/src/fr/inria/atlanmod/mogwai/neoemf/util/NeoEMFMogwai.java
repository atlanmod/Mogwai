package fr.inria.atlanmod.mogwai.neoemf.util;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.Map;

import fr.inria.atlanmod.mogwai.data.mapping.blueprints.NeoEMFMapping;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFATLProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFGremlinProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFOCLProcessor;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryException;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class NeoEMFMogwai {

	public static NeoEMFMogwai getInstance() {
		return Holder.INSTANCE;
	}
	
	private static final ThreadLocal<NeoEMFOCLProcessor> oclProcessor = new ThreadLocal<NeoEMFOCLProcessor>() {

		@Override
		protected NeoEMFOCLProcessor initialValue() {
			return new NeoEMFOCLProcessor();
		}
	};

	private static final ThreadLocal<NeoEMFGremlinProcessor> gremlinProcessor = new ThreadLocal<NeoEMFGremlinProcessor>() {

		@Override
		protected NeoEMFGremlinProcessor initialValue() {
			return new NeoEMFGremlinProcessor();
		}
	};

	private static final ThreadLocal<NeoEMFATLProcessor> atlProcessor = new ThreadLocal<NeoEMFATLProcessor>() {

		protected NeoEMFATLProcessor initialValue() {
			return new NeoEMFATLProcessor();
		};
	};
	
	public NeoEMFQueryResult query(MogwaiQuery query, Object arg, BlueprintsPersistenceBackend datastore, Map<String, Object> options) throws MogwaiQueryException {
		Map<String, Object> theOptions = options;
		if (isNull(theOptions)) {
			theOptions = new HashMap<>();
		}
		if (oclProcessor.get().accept(query)) {
			oclProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) query.process(oclProcessor.get(), datastore.getGraph(), new NeoEMFMapping(),
					theOptions);
		} else if (gremlinProcessor.get().accept(query)) {
			gremlinProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) query.process(gremlinProcessor.get(), datastore.getGraph(),
					new NeoEMFMapping(), theOptions);
		}
		throw new MogwaiQueryException("Cannot find a processor for " + query);
	}
	
	public NeoEMFQueryResult transform(MogwaiQuery transformation, BlueprintsPersistenceBackend datastore, Map<String, Object> options) throws MogwaiQueryException {
		Map<String, Object> theOptions = options;
		if(isNull(theOptions)) {
			theOptions = new HashMap<>();
		}
		if(atlProcessor.get().accept(transformation)) {
			atlProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) transformation.process(atlProcessor.get(), datastore.getGraph(), new NeoEMFMapping(), theOptions);
		}
		throw new MogwaiQueryException("Cannot find a processor for " + transformation);
	}
	
	private static class Holder {
		
		private static final NeoEMFMogwai INSTANCE = new NeoEMFMogwai();
		
	}
	
}
