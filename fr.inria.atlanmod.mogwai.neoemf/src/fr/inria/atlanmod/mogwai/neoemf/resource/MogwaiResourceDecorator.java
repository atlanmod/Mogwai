package fr.inria.atlanmod.mogwai.neoemf.resource;

import static java.util.Objects.isNull;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.data.mapping.blueprints.NeoEMFMapping;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFGremlinProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFOCLProcessor;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryException;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceDecorator;

public class MogwaiResourceDecorator extends PersistentResourceDecorator implements MogwaiResource {

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

	protected BlueprintsPersistenceBackend persistenceBackend;

	public MogwaiResourceDecorator(PersistentResource resource) throws MogwaiException {
		super(resource);
		if (resource == null) {
			throw new MogwaiException("Cannot construct a MogwaiResourceDecorator on a " + "null PersistentResource");
		}
		if (!DefaultMogwaiResource.isMogwaiCompatible(resource)) {
			throw new MogwaiException("Cannot construct a MogwaiResourceDecorator: resource " + resource.toString()
					+ " is not compatible with Mogwaï");
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
	public NeoEMFQueryResult query(MogwaiQuery query, Map<String, Object> options) {
		return this.query(query, null, options);
	}

	@Override
	public NeoEMFQueryResult query(MogwaiQuery query, Object arg, Map<String, Object> options) {
		Map<String, Object> theOptions = options;
		if (isNull(theOptions)) {
			theOptions = Collections.emptyMap();
		}
		if (oclProcessor.get().accept(query)) {
			oclProcessor.get().setBackend(getBackend());
			return (NeoEMFQueryResult) query.process(oclProcessor.get(), getBackend().getGraph(), new NeoEMFMapping(),
					theOptions);
		} else if (gremlinProcessor.get().accept(query)) {
			gremlinProcessor.get().setBackend(getBackend());
			return (NeoEMFQueryResult) query.process(gremlinProcessor.get(), getBackend().getGraph(),
					new NeoEMFMapping(), theOptions);
		}
		throw new MogwaiQueryException("Cannot find a processor for " + query);
	}

	@Override
	public BlueprintsPersistenceBackend getBackend() {
		return persistenceBackend;
	}
}
