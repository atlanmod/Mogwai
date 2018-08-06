package fr.inria.atlanmod.mogwai.neoemf.query;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;

public class NeoEMFValidationResult  {

	private NeoEMFQueryResult rawResult;
	
	public NeoEMFValidationResult(NeoEMFQueryResult result) {
		rawResult = result;
	}
	
	public NeoEMFQueryResult getRawResult() {
		return rawResult;
	}
	
	public boolean isValidated() {
		return rawResult.getResults().isEmpty();
	}
	
	public List<EObject> getViolatingInstances(PersistentResource resource) {
		return rawResult.reifyResults(resource);
	}
	
}
