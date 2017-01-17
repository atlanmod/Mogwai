package fr.inria.atlanmod.mogwai.transformation.atl.tests;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.neo4j.kernel.impl.util.FileUtils;

import ClassDiagram.ClassDiagramPackage;
import ClassDiagram.Named;
import ClassDiagram.NamedElement;
import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.query.builder.MogwaiGremlinQueryBuilder;
import fr.inria.atlanmod.mogwai.query.builder.MogwaiOCLQueryBuilder;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.mogwai.resources.MogwaiResourceFactory;
import fr.inria.atlanmod.mogwai.util.GraphHelper;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.logging.NeoLogger;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class LargeTransformationSample {

	public static void main(String[] args) throws IOException, MogwaiException {
		long begin = System.currentTimeMillis();
		MogwaiResource mogResource = ModelUtil.getInstance().createLargeSampleModel();
		long end = System.currentTimeMillis();
		NeoLogger.info("Created large instance in {0}ms", (end-begin));
//		NeoLogger.info(mogResource.getContents().get(0).toString());
		
		// Sample queries
//		MogwaiQuery query = MogwaiOCLQueryBuilder.newBuilder()
//				.fromString("Class.allInstances()->any(true).attr->select(e | not e.multiValued)")
//				.context(ClassDiagramPackage.eINSTANCE.getClass_()).build();
//		MogwaiQueryResult mqr = mogResource.query(query);
//		showResult(mqr, mogResource);
//		
//		MogwaiQuery gremlinQuery = MogwaiGremlinQueryBuilder.newBuilder().fromString("def metaClass = g.getIndex('metaclasses',Vertex.class)[[name:'Class']]; " + 
//"def metaClassNode = (metaClass.hasNext() ? metaClass.next() : null); " +
//"metaClassNode.inE('kyanosInstanceOf').outV.filter{def temp1 = it;true;}.first().outE('attr').inV.filter{def e = it; !( e.property('multiValued').transform{it == 'true';}.next());};").build();
//		
//		MogwaiQueryResult mqr2 = mogResource.query(gremlinQuery);
//		
//		showResult(mqr2, mogResource);
		
		GraphHelper helper = new GraphHelper(mogResource.getBackend().getGraph());
		
		// Create Tables from Classes
		MogwaiQuery gremlinQuery2 = MogwaiGremlinQueryBuilder.newBuilder()
				.fromFile(new File("materials/ClassDiagram2Relational/ClassDiagram2Relational.gremlin"))
				.bind("graphHelper", helper)
				.build();
		
		// Print the created Tables since they are returned by the script
		// Note: returning the updated/created objects is not mandatory
		showResult(mogResource.query(gremlinQuery2), mogResource);

		
		mogResource.save(Collections.emptyMap());

		System.out.println("Table count: "+ mogResource.getAllInstances(ClassDiagramPackage.eINSTANCE.getTable()).size());
		System.out.println("Column count: "+ mogResource.getAllInstances(ClassDiagramPackage.eINSTANCE.getColumn()).size());
		
		// Print Tables
//		MogwaiQuery outQuery = MogwaiOCLQueryBuilder.newBuilder().fromString("Table.allInstances()").context(ClassDiagramPackage.eINSTANCE.getClass_()).build();
//		showResult(mogResource.query(outQuery), mogResource);

		mogResource.close();

	}
	
	public static void showResult(MogwaiQueryResult mqr, MogwaiResource mogResource) throws MogwaiException {
		if(mqr.isReifiable()) {
			for(EObject e : mqr.reifyResults(mogResource)) {
				if(e instanceof NamedElement) {
					NamedElement n = (NamedElement)e;
					NeoLogger.info("({0}): {1}", e.eClass().getName(), n.getName());
				} else if(e instanceof Named){
					Named n = (Named)e;
					NeoLogger.info("({0}): {1}", e.eClass().getName(), n.getName());
				} else {
					NeoLogger.info("({0}): {1}", e.eClass().getName(), e.toString());
				}
			}
		} else {
			NeoLogger.info("Query Result is not reifiable");
		}
	}
	
}
