package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;

import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class NeoEMFModelFactory extends EMFModelFactory {

	public NeoEMFModelFactory() {
		super();
		this.getResourceSet().getResourceFactoryRegistry().getProtocolToFactoryMap()
				.put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());
	}

	public IModel newModel(IReferenceModel referenceModel, URI outputPath, Map<Object,Object> options) {
		return new NeoEMFModel((EMFReferenceModel) referenceModel, this, outputPath, options);
	}

}
