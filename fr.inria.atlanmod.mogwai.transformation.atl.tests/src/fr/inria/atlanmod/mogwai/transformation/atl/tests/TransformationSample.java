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
import fr.inria.atlanmod.mogwai.mapping.EMFtoGraphMapping;
import fr.inria.atlanmod.mogwai.mapping.NeoEMFMapping;
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

public class TransformationSample {

	public static void main(String[] args) throws IOException, MogwaiException {
		MogwaiResource mogResource = ModelUtil.getInstance().createSampleModel();
		
		EMFtoGraphMapping mapping = new NeoEMFMapping();
		mapping.setGraph(mogResource.getBackend().getGraph());
		
		MogwaiQuery initQuery = MogwaiGremlinQueryBuilder.newBuilder()
				.fromFile(new File("materials/init.gremlin"))
				.bind(EMFtoGraphMapping.BINDING_NAME, mapping)
				.build();
		
		mogResource.query(initQuery);
		System.out.println("Initialization performed");
		
		GraphHelper helper = new GraphHelper(mogResource.getBackend().getGraph(), mapping);
		
		// Create Tables from Classes
		MogwaiQuery gremlinQuery2 = MogwaiGremlinQueryBuilder.newBuilder()
//				.fromFile(new File("materials/ClassDiagram2Relational/ClassDiagram2Relational.gremlin"))
				.fromFile(new File("materials/ClassDiagram2Relational/cd2rel.gremlin"))
				.bind("graphHelper", helper)
				.bind(EMFtoGraphMapping.BINDING_NAME, mapping)
				.build();
		
		// Print the created Tables since they are returned by the script
		// Note: returning the updated/created objects is not mandatory
		showResult(mogResource.query(gremlinQuery2), mogResource);

		
		mogResource.save(Collections.emptyMap());

		System.out.println("Table count: "+ mogResource.getAllInstances(ClassDiagramPackage.eINSTANCE.getTable()).size());
		System.out.println("Column count: "+ mogResource.getAllInstances(ClassDiagramPackage.eINSTANCE.getColumn()).size());
		
		// Print Tables
		MogwaiQuery outQuery = MogwaiOCLQueryBuilder.newBuilder().fromString("Table.allInstances()").context(ClassDiagramPackage.eINSTANCE.getClass_()).build();
		showResult(mogResource.query(outQuery), mogResource);
		
		MogwaiQuery attQuery = MogwaiOCLQueryBuilder.newBuilder()
				.fromString("Column.allInstances().name")
				.context(ClassDiagramPackage.eINSTANCE.getColumn())
				.build();
		
		showResult(mogResource.query(attQuery), mogResource);

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
			try {
				if(mqr.isSingleResult()) {
					System.out.println(mqr.getResult());
				}
				else {
					for(Object o : mqr.getResults()) {
						System.out.println(o);
					}
				}
			} catch(MogwaiException e) {
				// Need a fix, Mogwai-ATL can return null
				NeoLogger.info("The query didn't return any object");
			}
		}
	}
	
}
