package fr.inria.atlanmod.mogwai.query;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.java.GremlinPipeline;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.neoemf.core.PersistentEObject;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.logging.NeoLogger;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;

public class MogwaiQueryResult {
	
	private boolean isReifiable = false;
	@SuppressWarnings("rawtypes")
	private Collection collectionResult = null;
	private Object singleResult = null;
	private BlueprintsPersistenceBackend graph;
	private String gremlinScript;
	
	@SuppressWarnings("unchecked")
	public MogwaiQueryResult(Object engineResult, BlueprintsPersistenceBackend graph, String gremlinQuery) {
		this.graph = graph;
		this.gremlinScript = gremlinQuery;
		long begin = System.currentTimeMillis();
		if(engineResult instanceof GremlinPipeline<?,?>) {
			collectionResult = new BasicEList<Object>();
			Iterator<Object> it = ((GremlinPipeline<?,Object>) engineResult).iterator();

			// isReifiable is true only if all results were Vertex instances
			isReifiable = true;
			while(it.hasNext()) {
				final Object next = it.next();
				isReifiable = isReifiable && next instanceof Vertex;
				collectionResult.add(next);
			}
		}
		else {
			if(engineResult instanceof Collection<?>) {
				collectionResult = (Collection<Object>)engineResult;
			}
			else {
				singleResult = engineResult;
			}
		}
		long end = System.currentTimeMillis();
		NeoLogger.info("Result Creation Time: {0}ms", (end-begin));
	}
	
	public MogwaiQueryResult(Object engineResult, BlueprintsPersistenceBackend graph, GremlinScript gremlinScript) {
		this(engineResult, graph, gremlinScript.toString());
	}
	
	/**
	 * 
	 * @return the number of objects returned by the query
	 */
	public int resultSize() {
		if (collectionResult != null) {
			return collectionResult.size();
		}
		else {
			return 1;
		}
	}

	/**
	 * 
	 * @return true if the query result is a single value
	 */
	public boolean isSingleResult() {
		return singleResult != null;
	}
	
	/**
	 * 
	 * @return true if the query result is reifiable to EObjects
	 */
	public boolean isReifiable() {
		return isReifiable;
	}
	
	/**
	 * Reifies result vertices and attach them to the given resource
	 * @param resource the resource to attach the reified EObjects to
	 * @return an EList containing the reified EObjects
	 * @throws MogwaiException if there is no vertex to reify
	 */
	@SuppressWarnings("unchecked")
	public EList<EObject> reifyResults(PersistentResource resource) throws MogwaiException {
		if(!isReifiable()) {
			throw new MogwaiException();
		}
		EList<EObject> eObjects = new BasicEList<EObject>();
		for(Vertex vv : (Collection<Vertex>)collectionResult) {
			PersistentEObject reifiedEObject = graph.reifyVertex(vv);
			if(reifiedEObject.resource() != resource) {
				reifiedEObject.resource(resource);
			}
			eObjects.add(reifiedEObject);
		}
		return eObjects;
	}
	
	/**
	 * @return the result of the Mogwai query wrapped in a Collection
	 * @throws MogwaiException if the result is reifiable (reifiable results should not be accessed directly)
	 */
	@SuppressWarnings("unchecked")
	public Collection<Object> getResults() throws MogwaiException {
		if(collectionResult == null) {
			throw new MogwaiException();
		}
		return collectionResult;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getResult() throws MogwaiException {
		if(singleResult == null) {
			throw new MogwaiException();
		}
		return (T)singleResult;
	}
	
	public String getExecutedQuery() {
		return gremlinScript;
	}
	
}
