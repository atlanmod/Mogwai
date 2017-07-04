package fr.inria.atlanmod.mogwai.transformation.ocl.tests.util;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResourceFactory;
import fr.inria.atlanmod.mogwai.neoemf.util.MogwaiURI;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;

/**
 * Imports an existing XMI model into a NeoEMF/Graph resource.
 * <p>
 * TODO this method should be moved in a common package, this is something used
 * in all the benchmarks and useful for client applications too.
 * 
 * @author Gwendal DANIEL
 *
 */
public class ModelImporter {

	public static MogwaiResource createNeoMogwaiResourceFromXMI(URI xmiLocation, URI neoemfLocation) throws IOException {
		PersistenceBackendFactoryRegistry.register(MogwaiURI.MOGWAI_SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
				.put(MogwaiURI.MOGWAI_SCHEME, MogwaiResourceFactory.getInstance());
		
		Resource xmiResource = rSet.createResource(xmiLocation);
		xmiResource.load(Collections.emptyMap());
		
		Resource neoEMFResource = rSet.createResource(neoemfLocation);
		Map<String, Object> options = BlueprintsNeo4jOptionsBuilder.newBuilder().autocommit().asMap();

		/*
		 * Save to enable autocommit
		 */
		neoEMFResource.save(options);
		neoEMFResource.getContents().addAll(EcoreUtil.copyAll(xmiResource.getContents()));
		/*
		 * Save the resource containing the migrated model
		 */
		neoEMFResource.save(options);
		
		MogwaiLogger.info("Root element {0}", neoEMFResource.getContents().get(0));
		
		return (MogwaiResource) neoEMFResource;
	}

	public static String getResourceName(Resource resource) {
		String uri = resource.getURI().toString();
		return uri.substring(uri.lastIndexOf('/') + 1, uri.lastIndexOf('.'));
	}

}
