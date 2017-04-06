package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;

import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

public class NeoEMFModel extends EMFModel {

	public NeoEMFModel(EMFReferenceModel referenceModel, EMFModelFactory factory, URI uri, Map<Object,Object> options) {
		super(referenceModel, factory);
		Resource neoResource = factory.getResourceSet().createResource(uri);
		NeoLogger.info("Created NeoEMFModel " + neoResource.getURI());
		try {
			neoResource.load(options);
		} catch (IOException e) {
			NeoLogger.info("Cannot load NeoEMFModel");
		}
		setResource(factory.getResourceSet().createResource(uri));
	}
	
}
