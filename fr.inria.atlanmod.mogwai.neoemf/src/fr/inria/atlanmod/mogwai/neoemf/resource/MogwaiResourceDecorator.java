package fr.inria.atlanmod.mogwai.neoemf.resource;

import java.lang.reflect.Field;
import java.util.Map;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.neoemf.util.NeoEMFQueryHandler;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryException;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceDecorator;

public class MogwaiResourceDecorator extends PersistentResourceDecorator implements MogwaiResource {

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NeoEMFQueryResult query(MogwaiQuery query, Object arg, Map<String, Object> options) {
		return NeoEMFQueryHandler.getInstance().query(query, arg, getBackend(), options);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public NeoEMFQueryResult transform(MogwaiQuery transformation, Map<String, Object> options)
			throws MogwaiQueryException {
		return NeoEMFQueryHandler.getInstance().transform(transformation, getBackend(), options);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public <D> NeoEMFQueryResult transform(MogwaiQuery transformation, D datastore, ModelDatastore mapping,
			Map<String, Object> options) throws MogwaiQueryException {
		throw new MogwaiQueryException("Multi-backend transformations are not supported for the moment");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlueprintsPersistenceBackend getBackend() {
		return persistenceBackend;
	}
}
