package fr.inria.atlanmod.mogwai.neoemf.query;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.tinkerpop.blueprints.Vertex;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.processor.AbstractMogwaiProcessor;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.neoemf.core.PersistentEObject;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;

/**
 * A NeoEMF-based implementation of {@link MogwaiQueryResult} that provides
 * utility methods to reify datastore query result and return {@link EObject}s
 * that can be used within a NeoEMF-based application.
 * <p>
 * This class is used by the dedicated NeoEMF {@link AbstractMogwaiProcessor}s to ease
 * the integration of Mogwai in existing EMF-based applications. Note that
 * NeoEMF {@link AbstractMogwaiProcessor}s only support a {@code graph} backend that
 * stores model elements according to the {@code NeoEMFMapping}.
 * 
 * @see MogwaiQueryResult
 * 
 * @author Gwendal DANIEL
 *
 */
public class NeoEMFQueryResult extends MogwaiQueryResult {

	/**
	 * The {@link BlueprintsPersistenceBackend} used to reify results.
	 */
	private BlueprintsPersistenceBackend graph;

	/**
	 * {@code true} if the query result can be reified as {@link EObject}s.
	 */
	private boolean isReifiable;

	/**
	 * Constructs a new {@link NeoEMFQueryResult} from the given
	 * {@code engineResult}, {@code graph}, and literal {@code gremlinScript}.
	 * <p>
	 * <b>Note:<b> if {@code engineResult} is an instance of {@link Iterable}
	 * this constructor iterates it to wrap the results. In case of
	 * Gremlin-based queries this can be costly because {@code GremlinPipeline}
	 * content is computed when iterated.
	 * 
	 * @param engineResult
	 *            the result of the query computation
	 * @param graph
	 *            the {@link BlueprintsPersistenceBackend} used to reify results
	 *            as {@link EObject}s
	 * @param gremlinScript
	 *            the textual representation of the computed query
	 */
	public NeoEMFQueryResult(Object engineResult, BlueprintsPersistenceBackend graph, String gremlinScript) {
		super(engineResult, gremlinScript);
		this.graph = graph;
		/*
		 * Checks whether the query result is reifiable. A collection can be
		 * reified iff all its elements are vertices.
		 */
		isReifiable = true;
		for (Object o : result) {
			isReifiable &= o instanceof Vertex;
		}
	}

	/**
	 * Constructs a new {@link NeoEMFQueryResult} from the given
	 * {@code engineResult}, {@code graph}, and {@code gremlinScript}.
	 * <p>
	 * <b>Note:<b> if {@code engineResult} is an instance of {@link Iterable}
	 * this constructor iterates it to wrap the results. In case of
	 * Gremlin-based queries this can be costly because {@link GremlinPipeline}
	 * content is computed when iterated.
	 * 
	 * @param engineResult
	 *            the result of the query computation
	 * @param graph
	 *            the {@link BlueprintsPersistenceBackend} used to reify results
	 *            as {@link EObject}s
	 * @param gremlinScript
	 *            the {@link GremlinScript} element representing the root of the
	 *            computed query
	 */
	public NeoEMFQueryResult(Object engineResult, BlueprintsPersistenceBackend graph, GremlinScript gremlinScript) {
		this(engineResult, graph, gremlinScript.toString());
	}

	/**
	 * Returns whether the query result can be reified as {@link EObject}s.
	 * 
	 * @return {@code true} if the query result can be reified as
	 *         {@link EObject}s.
	 */
	public boolean isReifiable() {
		return isReifiable;
	}

	/**
	 * Reifies the query result as {@link EObject}s and attach them to the
	 * provided {@code resource}.
	 * <p>
	 * This method is specific to {@link NeoEMFQueryResult}, that can use
	 * NeoEMF {@link BlueprintsPersistenceBackend} to create {@link EObject}s
	 * from graph vertices. Reified elements can be used as standard
	 * {@link EObject}s stored in NeoEMF.
	 * 
	 * @param resource
	 *            the {@link Resource} to attach the reified {@link EObject}s to
	 * 
	 * @return a {@link List} containing the reified {@link EObject}s
	 * @throws MogwaiException
	 *             if the query result cannot be reified by the backend
	 */
	public List<EObject> reifyResults(PersistentResource resource) throws MogwaiException {
		if (!isReifiable()) {
			throw new MogwaiException("Query result is not reifiable");
		}
		List<EObject> eObjects = new BasicEList<EObject>();
		for (Object o : result) {
			if (!(o instanceof Vertex)) {
				throw new MogwaiException("Cannot reify {0}, expected an instance of Vertex, found {1}", o, o
						.getClass().getName());
			}
			PersistentEObject reifiedEObject = graph.reifyVertex((Vertex) o);
			if (reifiedEObject.resource() != resource) {
				reifiedEObject.resource(resource);
			}
			eObjects.add(reifiedEObject);
		}
		return eObjects;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * <b>Note: </b> the returned {@link Iterator} doesn't reify the result,
	 * even if it is possible. To access reified result see
	 * {@link #reifyResults(PersistentResource)}.
	 */
	@Override
	public Iterator<Object> iterator() {
		return super.iterator();
	}

}
