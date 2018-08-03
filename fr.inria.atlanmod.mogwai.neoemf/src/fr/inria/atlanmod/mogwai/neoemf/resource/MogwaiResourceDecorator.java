package fr.inria.atlanmod.mogwai.neoemf.resource;

import static java.util.Objects.isNull;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.blueprints.NeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesUtils;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.neoemf.util.NeoEMFQueryHandler;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.QueryException;
import fr.inria.atlanmod.neoemf.core.PersistentEObject;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceDecorator;

/**
 * A {@link PersistentResourceDecorator} that enables to wrap an existing
 * {@link PersistentResource} and query it with the Mogwai API.
 * <p>
 * This resource implementation can be used to add query capabilities on top of
 * an already opened NeoEMF {@link PersistentResource}. If the embedded database
 * used in NeoEMF graph is restricted to one connection this wrapper reuses the
 * existing connection to compute {@link MogwaiQuery}.
 * 
 * @author Gwendal DANIEL
 *
 */
public class MogwaiResourceDecorator extends PersistentResourceDecorator implements MogwaiResource {

	/**
	 * The base resource's {@link BlueprintsPersistenceBackend} used to access
	 * the graph database.
	 */
	protected BlueprintsPersistenceBackend persistenceBackend;

	/**
	 * Constructs a new {@link MogwaiResourceDecorator} from the provided
	 * {@code resource}.
	 * <p>
	 * The created resource reuses the underlying
	 * {@link BlueprintsPersistenceBackend} instance used to access the graph
	 * database to avoid multiple connection errors on embedded databases.
	 * 
	 * @param resource
	 *            the resource to wrap
	 * @throws MogwaiCoreException
	 *             if the provided {@code resource} is not compatible with
	 *             Mogwai
	 */
	public MogwaiResourceDecorator(PersistentResource resource) throws MogwaiCoreException {
		super(resource);
		if (isNull(resource)) {
			throw new MogwaiCoreException("Cannot construct a MogwaiResourceDecorator on a "
					+ "null PersistentResource");
		}
		if (!DefaultMogwaiResource.isMogwaiCompatible(resource)) {
			throw new MogwaiCoreException("Cannot construct a MogwaiResourceDecorator: resource " + resource.toString()
					+ " is not compatible with Mogwaï");
		}
		/*
		 * Retrieve the BlueprintsPersistenceBackend defined in the base
		 * resource using java reflection. This field is not public to avoid
		 * database corruption by client application, using reflection to access
		 * it is the safest way to limit bad practices.
		 */
		Field persistenceBackendField;
		try {
			persistenceBackendField = resource.getClass().getDeclaredField("backend");
			persistenceBackendField.setAccessible(true);
			persistenceBackend = (BlueprintsPersistenceBackend) persistenceBackendField.get(resource);
		} catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
			throw new MogwaiCoreException(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NeoEMFQueryResult query(MogwaiQuery query, Object arg, Map<String, Object> options) {
		Object theArgument = arg;
		if(arg instanceof PersistentEObject) {
			theArgument = this.getBackend().getVertex(((PersistentEObject) arg).id());
		}
		return NeoEMFQueryHandler.getInstance().query(query, PipesUtils.pipelineOf(Arrays.asList(theArgument), new NeoEMFGraphDatastore(this.getBackend().getGraph())), getBackend(), options);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NeoEMFQueryResult transform(MogwaiQuery transformation, Map<String, Object> options) throws QueryException {
		NeoEMFQueryResult result = NeoEMFQueryHandler.getInstance().transform(transformation, getBackend(), options);
		this.getBackend().getGraph().commit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public <D> NeoEMFQueryResult transform(MogwaiQuery transformation, D datastore, ModelDatastore mapping,
			Map<String, Object> options) throws QueryException {
		throw new QueryException("Multi-backend transformations are not supported for the moment");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BlueprintsPersistenceBackend getBackend() {
		return persistenceBackend;
	}
}
