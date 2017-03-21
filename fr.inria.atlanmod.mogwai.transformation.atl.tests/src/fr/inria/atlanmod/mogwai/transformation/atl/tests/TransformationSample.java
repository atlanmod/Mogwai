package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import ClassDiagram.ClassDiagramPackage;
import ClassDiagram.Column;
import ClassDiagram.Named;
import ClassDiagram.NamedElement;
import ClassDiagram.Table;
import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.gremlin.printers.MogwaiATLGremlinPrinter;
import fr.inria.atlanmod.mogwai.mapping.EMFtoGraphMapping;
import fr.inria.atlanmod.mogwai.mapping.NeoEMFMapping;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.query.builder.MogwaiGremlinQueryBuilder;
import fr.inria.atlanmod.mogwai.query.builder.MogwaiOCLQueryBuilder;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.mogwai.transformation.atl.files.ATL2Gremlin;
import fr.inria.atlanmod.mogwai.util.TransformationHelper;
import fr.inria.atlanmod.neoemf.logging.NeoLogger;

/**
 * This class presents how a gremlin script corresponding to an ATL
 * transformation can be executed by the Mogwai framework.
 * <p>
 * This sample is used for development purpose, and does not represent the
 * standard way to use the Mogwai framework.
 * 
 * @author Gwendal DANIEL
 *
 */
public class TransformationSample {
	
	private static String ATL_URI = "materials/ClassDiagram2Relational/ATLFiles/Class2Relational-simple.atl";

	public static void main(String[] args) throws IOException, MogwaiException {
		
		NeoLogger.info("Creating sample model");
		MogwaiResource mogResource = ModelUtil.getInstance().createSampleModel();
		NeoLogger.info("Done");

		NeoLogger.info("Initializing mapping");
		EMFtoGraphMapping mapping = new NeoEMFMapping();
		mapping.setGraph(mogResource.getBackend().getGraph());
		TransformationHelper helper = new TransformationHelper(mapping);

		NeoLogger.info("Done");
		
		NeoLogger.info("Initializing the Gremlin engine");
		MogwaiQuery initQuery = MogwaiGremlinQueryBuilder.newBuilder()
				.fromFile(new File("materials/init.gremlin"))
				.bind(EMFtoGraphMapping.BINDING_NAME, mapping)
				.bind("graphHelper", helper)
				.build();

		mogResource.query(initQuery);
		NeoLogger.info("Gremlin engine initialized");
		
		NeoLogger.info("Translating ATL file (" + ATL_URI + ")");;
		ATL2Gremlin atl2gremlin = new ATL2Gremlin();
		atl2gremlin.enableATLDebug();
		Resource r = atl2gremlin.transform(URI
				.createURI(ATL_URI));
		MogwaiATLGremlinPrinter printer = new MogwaiATLGremlinPrinter();
		String textualQuery = printer.print(r.getContents().get(0));
		
		NeoLogger.info("Generated Gremlin Script: \n{0}", textualQuery);
		
		// Create Tables from Classes
		MogwaiQuery gremlinQuery2 = MogwaiGremlinQueryBuilder.newBuilder()
				.fromString(textualQuery)
				.bind("graphHelper", helper)
				.bind(EMFtoGraphMapping.BINDING_NAME, mapping)
				.build();
		
		mogResource.query(gremlinQuery2);
		
		NeoLogger.info("Model successfully transformed");
		// Print the created Tables since they are returned by the script
		// Note: returning the updated/created objects is not mandatory

		mogResource.save(Collections.emptyMap());

		
		MogwaiQuery outQuery = MogwaiOCLQueryBuilder.newBuilder()
				.fromString("Table.allInstances()")
				.context(ClassDiagramPackage.eINSTANCE.getClass_())
				.build();
		NeoLogger.info("AllInstances(Table): (OCL)");
		showResult(mogResource.query(outQuery), mogResource);

		MogwaiQuery attQuery = MogwaiOCLQueryBuilder.newBuilder()
				.fromString("Column.allInstances()")
				.context(ClassDiagramPackage.eINSTANCE.getColumn())
				.build();
		NeoLogger.info("AllInstances(Column): (OCL)");
		showResult(mogResource.query(attQuery), mogResource);

		NeoLogger.info("Table count: (NeoEMF)"
				+ mogResource.getAllInstances(ClassDiagramPackage.eINSTANCE.getTable()).size());
		NeoLogger.info("Column count: (NeoEMF)"
				+ mogResource.getAllInstances(ClassDiagramPackage.eINSTANCE.getColumn()).size());
		
		NeoLogger.info("Model navigation (NeoEMF)");
		List<EObject> allTables = mogResource.getAllInstances(ClassDiagramPackage.eINSTANCE.getTable());
		for (EObject e : allTables) {
			Table t = (Table) e;
			NeoLogger.info("Table: " + t.getName());
			for (Column c : t.getCol()) {
				NeoLogger.info("\tColumn: " + c.getName());
			}
		}
		mogResource.close();
	}

	public static void showResult(MogwaiQueryResult mqr, MogwaiResource mogResource) throws MogwaiException {
		if (mqr.isReifiable()) {
			for (EObject e : mqr.reifyResults(mogResource)) {
				if (e instanceof NamedElement) {
					NamedElement n = (NamedElement) e;
					NeoLogger.info("({0}): {1}", e.eClass().getName(), n.getName());
				} else if (e instanceof Named) {
					Named n = (Named) e;
					NeoLogger.info("({0}): {1}", e.eClass().getName(), n.getName());
				} else {
					NeoLogger.info("({0}): {1}", e.eClass().getName(), e.toString());
				}
			}
		} else {
			try {
				if (mqr.isSingleResult()) {
					NeoLogger.info(mqr.getResult().toString());
				} else {
					for (Object o : mqr.getResults()) {
						NeoLogger.info(o.toString());
					}
				}
			} catch (MogwaiException e) {
				// Need a fix, Mogwai-ATL can return null
				NeoLogger.info("The query didn't return any object");
			}
		}
	}

}
