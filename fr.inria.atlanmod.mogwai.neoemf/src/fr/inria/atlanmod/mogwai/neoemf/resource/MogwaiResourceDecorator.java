package fr.inria.atlanmod.mogwai.neoemf.resource;

import java.lang.reflect.Field;

import com.tinkerpop.blueprints.Graph;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFGremlinProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFOCLProcessor;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.processor.MogwaiGremlinProcessor;
import fr.inria.atlanmod.mogwai.processor.MogwaiOCLProcessor;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryException;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceDecorator;

public class MogwaiResourceDecorator extends PersistentResourceDecorator implements MogwaiResource {

	private static final ThreadLocal<NeoEMFOCLProcessor> oclProcessor = 
		new ThreadLocal<NeoEMFOCLProcessor>() {
			
			@Override
			protected NeoEMFOCLProcessor initialValue() {
				return new NeoEMFOCLProcessor();
			}
		};
		
	private static final ThreadLocal<NeoEMFGremlinProcessor> gremlinProcessor = 
		new ThreadLocal<NeoEMFGremlinProcessor>() {
			
			@Override
			protected NeoEMFGremlinProcessor initialValue() {
				return new NeoEMFGremlinProcessor();
			}
		};

	protected BlueprintsPersistenceBackend persistenceBackend;
	
	public MogwaiResourceDecorator(PersistentResource resource) throws MogwaiException {
		super(resource);
		if(resource == null) {
			throw new MogwaiException("Cannot construct a MogwaiResourceDecorator on a "
					+ "null PersistentResource");
		}
		if(!DefaultMogwaiResource.isMogwaiCompatible(resource)) {
			throw new MogwaiException("Cannot construct a MogwaiResourceDecorator: resource " 
					+ resource.toString() + " is not compatible with Mogwaï");
		}
		// Retrieve the PersistenceBackend defined in the base resource
		Field persistenceBackendField;
		try {
			persistenceBackendField = resource.getClass().getDeclaredField("backend");
			persistenceBackendField.setAccessible(true);
			persistenceBackend = (BlueprintsPersistenceBackend) persistenceBackendField.get(resource);
		} catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
			throw new MogwaiException(e.getMessage());
		}
	}
	
	@Override
	public NeoEMFQueryResult query(MogwaiQuery query) {
		return this.query(query, null);
	}

	@Override
	public NeoEMFQueryResult query(MogwaiQuery query, Object arg) {
		if(oclProcessor.get().accept(query)) {
			return (NeoEMFQueryResult)query.process(oclProcessor.get(), getBackend(), arg);
		} else if(gremlinProcessor.get().accept(query)) {
			return (NeoEMFQueryResult)query.process(gremlinProcessor.get(), getBackend(), arg);
		}
    	throw new MogwaiQueryException("Cannot find a processor for " + query);
	}
	
	@Override
	public BlueprintsPersistenceBackend getBackend() {
		return persistenceBackend;
	}
	
	@Override
	public void enableATLDebug() {
		oclProcessor.get().enableATLDebug();
	}
	
	@Override
	public void disableATLDebug() {
		oclProcessor.get().disableATLDebug();
	}
}
