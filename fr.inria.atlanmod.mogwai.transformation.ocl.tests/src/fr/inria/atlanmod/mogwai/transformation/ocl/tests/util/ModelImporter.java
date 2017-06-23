package fr.inria.atlanmod.mogwai.transformation.ocl.tests.util;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.JavaPackage;

import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

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

	public static void main(String[] args) throws IOException {
		JavaPackage.eINSTANCE.eClass();
		EPackage.Registry.INSTANCE.put(JavaPackage.eNS_URI, JavaPackage.eINSTANCE);
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource xmiResource = rSet.createResource(URI.createURI("resources/models/set1.xmi"));
		xmiResource.load(Collections.emptyMap());
		createNeoEMFResourceFromXMI(xmiResource);
	}

	public static Resource createNeoEMFResourceFromXMI(Resource xmiResource) throws IOException {
		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
				.put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());
		Resource resource = rSet.createResource(BlueprintsURI.createFileURI(new File("resources/db/"
				+ getResourceName(xmiResource) + ".graphdb")));
		Map<String, Object> options = BlueprintsNeo4jOptionsBuilder.newBuilder().autocommit().asMap();

		/*
		 * Save to enable autocommit
		 */
		resource.save(options);
		resource.getContents().addAll(EcoreUtil.copyAll(xmiResource.getContents()));
		/*
		 * Save the resource containing the migrated model
		 */
		resource.save(options);
		return resource;
	}

	public static String getResourceName(Resource resource) {
		String uri = resource.getURI().toString();
		return uri.substring(uri.lastIndexOf('/') + 1, uri.lastIndexOf('.'));
	}

}
