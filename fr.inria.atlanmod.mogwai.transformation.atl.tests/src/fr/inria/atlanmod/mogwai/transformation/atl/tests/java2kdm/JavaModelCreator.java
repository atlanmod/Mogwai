package fr.inria.atlanmod.mogwai.transformation.atl.tests.java2kdm;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.JavaPackage;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class JavaModelCreator {

	public static final String SET1 = "materials/java/set1.xmi";
	public static final String SET2 = "materials/java/set2.xmi";
	public static final String SET3 = "materials/java/set3.xmi";
	public static final String SET4 = "materials/java/set4.xmi";
	public static final String SET5 = "materials/java/set5.xmi";
	
	public static String THE_SET = SET1;
	
	public static void main(String[] args) throws IOException {
		createMogwaiResource(URI.createURI(THE_SET));
	}

	public static void createMogwaiResource(URI xmiURI) throws IOException {
		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());
		EPackage.Registry.INSTANCE.put(JavaPackage.eINSTANCE.getNsURI(), JavaPackage.eINSTANCE);
		String resourceName = xmiURI.segment(xmiURI.segmentCount() - 1);
		resourceName = resourceName.substring(0, resourceName.indexOf('.'));
		System.out.println(resourceName);
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
				.put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource xmiResource = rSet.createResource(xmiURI);
		xmiResource.load(Collections.emptyMap());

		MogwaiLogger.info("XMI size: {0}", size(xmiResource));

		Resource neoemfResource = rSet.createResource(BlueprintsURI.createFileURI(new File("materials/java/neoemf/" + resourceName
				+ ".graphdb")));
		Map<String, Object> options = BlueprintsNeo4jOptionsBuilder.newBuilder().autocommit().asMap();
		neoemfResource.save(options);
		neoemfResource.getContents().addAll(xmiResource.getContents());
		neoemfResource.save(options);

		MogwaiLogger.info("NeoEMF size: {0}", size(neoemfResource));
	}

	private static int size(Resource r) {
		int size = 0;
		Iterable<EObject> allContents = r::getAllContents;
		for (EObject e : allContents) {
			size++;
		}
		return size;
	}
}
