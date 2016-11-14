package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.ecore.OCLExpression;
import org.neo4j.kernel.impl.util.FileUtils;

import ClassDiagram.Attribute;
import ClassDiagram.ClassDiagramPackage;
import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.core.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.mogwai.resources.MogwaiResourceFactory;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;
import fr.inria.atlanmod.neoemf.datastore.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.graph.blueprints.neo4j.resources.BlueprintsNeo4jResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.resources.BlueprintsResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.util.NeoBlueprintsURI;
import fr.inria.atlanmod.neoemf.resources.PersistentResource;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceFactoryImpl;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceImpl;

public class StoreInputModel {

	public static void main(String[] args) throws IOException, MogwaiException {
		FileUtils.deleteRecursively(new File("materials/ClassDiagram2Relational/ClassDiagram/sample.graphdb"));
		
		PersistenceBackendFactoryRegistry.register(
				NeoBlueprintsURI.NEO_GRAPH_SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());
		
		
		
		ResourceSet rSet = new ResourceSetImpl();
		
		rSet.getResourceFactoryRegistry()
				.getProtocolToFactoryMap()
				.put(NeoBlueprintsURI.NEO_GRAPH_SCHEME,
						PersistentResourceFactoryImpl.getInstance());
		
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put("ecore", new XMIResourceFactoryImpl());
		
//		Resource mmResource = rSet.createResource(URI
//			.createURI("materials/ClassDiagram2Relational/ClassDiagram/ClassDiagram.ecore"));
		
//		mmResource.load(Collections.emptyMap());
		
//		EPackage mmPackage = (EPackage)mmResource.getContents().get(0);
		EPackage.Registry.INSTANCE.put(
				ClassDiagramPackage.eINSTANCE.getNsURI(),
				ClassDiagramPackage.eINSTANCE);
		
		Resource classModel = rSet.getResource(URI
				.createURI("materials/ClassDiagram2Relational/ClassDiagram/Sample-ClassDiagram.xmi"), true);
		
		Resource neoResource = rSet
				.createResource(NeoBlueprintsURI
						.createNeoGraphURI(new File(
								"materials/ClassDiagram2Relational/ClassDiagram/sample.graphdb")));
		
		Map<Object,Object> options = new HashMap<>();
		options.put(BlueprintsResourceOptions.OPTIONS_BLUEPRINTS_GRAPH_TYPE,
				BlueprintsNeo4jResourceOptions.OPTIONS_BLUEPRINTS_TYPE_NEO4J);
/*		// Loading existing resource
		neoResource.load(options);
/*/		// Creating new resource
		neoResource.save(options);

		neoResource.getContents().addAll(EcoreUtil.copyAll(classModel.getContents()));
		
		neoResource.save(Collections.emptyMap());
/**/		
		MogwaiResource mogResource = MogwaiResourceFactory.eINSTANCE.decoratePersistentResource((PersistentResource)neoResource);
//		mogResource.load(Collections.emptyMap());
		
		System.out.println(mogResource.getContents().get(0));
		
		OCLExpression oclExp = MogwaiUtil.parseInlineOCL("Class.allInstances()->any(true).attr->select(e | not e.multiValued)", ClassDiagramPackage.eINSTANCE.getClass_());
		MogwaiQueryResult mqr = mogResource.query(oclExp);
		showResult(mqr, mogResource);
		
		
		System.out.println(((ClassDiagram.Class) mogResource.getContents().get(1)).getAttr().get(1).getName());
		
		MogwaiQueryResult mqr2 = mogResource.gQuery("def metaClass = g.getIndex('metaclasses',Vertex.class)[[name:'Class']]; " + 
"def metaClassNode = (metaClass.hasNext() ? metaClass.next() : null); " +
"metaClassNode.inE('kyanosInstanceOf').outV.filter{def temp1 = it;true;}.first().outE('attr').inV.filter{def e = it; !( e.property('multiValued').transform{it == 'true';}.next());};");
		
		showResult(mqr2, mogResource);
		
		
		BufferedReader br = new BufferedReader(new FileReader("materials/ClassDiagram2Relational/ClassDiagram2Relational.gremlin"));
		showResult(mogResource.gQuery(br.lines().collect(Collectors.joining("\n"))), mogResource);

		
		neoResource.save(Collections.emptyMap());

		showResult(mogResource.query(MogwaiUtil.parseInlineOCL("Table.allInstances()", ClassDiagramPackage.eINSTANCE.getClass_())), mogResource);

		
		PersistentResourceImpl.shutdownWithoutUnload((PersistentResourceImpl)neoResource);
		

	}
	
	public static void showResult(MogwaiQueryResult mqr, MogwaiResource mogResource) throws MogwaiException {
		for(EObject e : mqr.reifyResults(mogResource)) {
			if(e instanceof Attribute) {
				Attribute att = (Attribute)e;
				System.out.println(att.getName());
			} else {
				System.out.println(e);
			}
		}
	}
	
}
