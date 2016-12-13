package fr.inria.atlanmod.mogwai.resources;

import java.lang.reflect.Field;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.processor.MogwaiOCLProcessor;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryException;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceDecorator;

public class MogwaiResourceDecorator extends PersistentResourceDecorator implements MogwaiResource {

	private static final ThreadLocal<MogwaiOCLProcessor> oclProcessor = 
		new ThreadLocal<MogwaiOCLProcessor>() {
			
			@Override
			protected MogwaiOCLProcessor initialValue() {
				return new MogwaiOCLProcessor();
			}
		};

	protected BlueprintsPersistenceBackend persistenceBackend;
	
	public MogwaiResourceDecorator(PersistentResource resource) throws MogwaiException {
		super(resource);
		if(resource == null) {
			throw new MogwaiException("Cannot construct a MogwaiResourceDecorator on a "
					+ "null PersistentResource");
		}
		if(!MogwaiUtil.isMogwaiCompatible(resource)) {
			throw new MogwaiException("Cannot construct a MogwaiResourceDecorator: resource " 
					+ resource.toString() + " is not compatible with Mogwaï");
		}
		// Retrieve the PersistenceBackend defined in the base resource
		Field persistenceBackendField;
		try {
			persistenceBackendField = resource.getClass().getDeclaredField("persistenceBackend");
			persistenceBackendField.setAccessible(true);
			persistenceBackend = (BlueprintsPersistenceBackend) persistenceBackendField.get(base);
			oclProcessor.get().setGraphBackend(persistenceBackend);
		} catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
			throw new MogwaiException(e.getMessage());
		}
	}
	
	@Override
	public MogwaiQueryResult query(MogwaiQuery query) {
		return this.query(query, null);
	}

	@Override
	public MogwaiQueryResult query(MogwaiQuery query, Object arg) {
		if(oclProcessor.get().accept(query)) {
			return query.process(oclProcessor.get(), arg);
		}
    	throw new MogwaiQueryException("Cannot find a processor for " + query);
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
