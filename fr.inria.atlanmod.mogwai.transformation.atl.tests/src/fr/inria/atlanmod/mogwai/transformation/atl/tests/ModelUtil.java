package fr.inria.atlanmod.mogwai.transformation.atl.tests;

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
import org.neo4j.kernel.impl.util.FileUtils;

import ClassDiagram.ClassDiagramPackage;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.mogwai.resources.MogwaiResourceFactory;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class ModelUtil {

	public static ModelUtil getInstance() {
		return Holder.INSTANCE;
	}
	
	public MogwaiResource createSampleModel() throws IOException {
		
		FileUtils.deleteRecursively(new File("materials/ClassDiagram2Relational/ClassDiagram/sample.graphdb"));
		
		PersistenceBackendFactoryRegistry.register(
				BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());
		
		
		
		ResourceSet rSet = new ResourceSetImpl();
		
		rSet.getResourceFactoryRegistry()
				.getProtocolToFactoryMap()
				.put(BlueprintsURI.SCHEME,
						PersistentResourceFactory.getInstance());
		
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put("ecore", new XMIResourceFactoryImpl());
		
		EPackage.Registry.INSTANCE.put(
				ClassDiagramPackage.eINSTANCE.getNsURI(),
				ClassDiagramPackage.eINSTANCE);
		
		Resource classModel = rSet.getResource(URI
				.createURI("materials/ClassDiagram2Relational/ClassDiagram/Sample-ClassDiagram.xmi"), true);
		
		Resource neoResource = rSet
				.createResource(BlueprintsURI
						.createFileURI(new File(
								"materials/ClassDiagram2Relational/ClassDiagram/sample.graphdb")));
		
		Map<String, Object> options = BlueprintsNeo4jOptionsBuilder.newBuilder().asMap();
		
		// Creating new resource
		neoResource.save(options);

		neoResource.getContents().addAll(EcoreUtil.copyAll(classModel.getContents()));
		
		neoResource.save(Collections.emptyMap());
		MogwaiResource mogResource = MogwaiResourceFactory.getInstance().decoratePersistentResource((PersistentResource)neoResource);
		
		return mogResource;
	}
	
	private static class Holder {
		
		public static final ModelUtil INSTANCE = new ModelUtil();
	}
	
}
