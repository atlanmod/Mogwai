package fr.inria.atlanmod.mogwai.core;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.java.GremlinPipeline;

import fr.inria.atlanmod.neoemf.datastore.InternalPersistentEObject;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resources.PersistentResource;

public class MogwaiQueryResult {
	
	private boolean isRefiable = false;
	@SuppressWarnings("rawtypes")
	private Collection collectionResult = null;
	private Object singleResult = null;
	private BlueprintsPersistenceBackend graph;
	
	@SuppressWarnings("unchecked")
	MogwaiQueryResult(Object engineResult, BlueprintsPersistenceBackend graph) {
		this.graph = graph;
		if(engineResult instanceof GremlinPipeline<?,?>) {
			collectionResult = new BasicEList<Vertex>();
			Iterator<Vertex> it = ((GremlinPipeline<?,Vertex>)engineResult).iterator();
			long begin = System.currentTimeMillis();
			while(it.hasNext()) {
				collectionResult.add(it.next());
			}
			long end = System.currentTimeMillis();
			System.out.println("Result computation time : " + (end-begin) + " ms");
			isRefiable = true;
		}
		else {
			if(engineResult instanceof Collection<?>) {
				collectionResult = (Collection<Object>)engineResult;
			}
			else {
				singleResult = engineResult;
			}
		}
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
		return isRefiable;
	}
	
	/**
	 * Reify result vertices and attach them to the given resource
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
			InternalPersistentEObject reifiedEObject = graph.reifyVertex(vv);
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
	
}
