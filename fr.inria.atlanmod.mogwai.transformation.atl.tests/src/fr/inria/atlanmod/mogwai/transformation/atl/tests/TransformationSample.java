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
import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

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
//		MogwaiResource mogResource = ModelUtil.getInstance().createSampleModel();
//		MogwaiResource mogResource = ModelUtil.getInstance().createLargeSampleModel();
		MogwaiResource mogResource = ModelUtil.getInstance().getResource(CreateModel.MODEL_LOCATION);
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
				.createURI(ATL_URI),
				ClassDiagramPackage.eINSTANCE,
				ClassDiagramPackage.eINSTANCE);
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
		
		NeoLogger.info("CreateElement time: {0}ms", TransformationHelper.createTime);
		NeoLogger.info("NewInstance time: {0}ms", NeoEMFMapping.newInstanceTime);
		NeoLogger.info("NewInstance setRef time: {0}ms", NeoEMFMapping.newInstanceSetRef);
		NeoLogger.info("NewInstance getResourceRoot: {0}ms", NeoEMFMapping.newInstanceGetResourceRoot);
		NeoLogger.info("NewInstance addVertex: {0}ms", NeoEMFMapping.newInstanceAddVertex);
		NeoLogger.info("NewInstance getMetaClass: {0}ms", NeoEMFMapping.newInstanceGetMetaclass);
		NeoLogger.info("IsResolvable time: {0}ms", TransformationHelper.isResolvableTime);
		NeoLogger.info("Resolve time: {0}ms", TransformationHelper.resolveTime);
		NeoLogger.info("Link time: {0}ms", TransformationHelper.linkTime);
		NeoLogger.info("Plink time: {0}ms", TransformationHelper.pLinkTime);
		NeoLogger.info("ResolveProxy time: {0}ms", TransformationHelper.resolveProxyTime);
		NeoLogger.info("UpdateContainment time: {0}ms", NeoEMFMapping.updateContainmentTime);
		NeoLogger.info("UpdateContainment loop1 time: {0}ms", NeoEMFMapping.updateContainment1);
		NeoLogger.info("UpdateContainment loop2 time: {0}ms", NeoEMFMapping.updateContainment2);

		long beginSave = System.currentTimeMillis();
		mogResource.save(Collections.emptyMap());	
		long endSave = System.currentTimeMillis();
		NeoLogger.info("Save time: {0}ms", (endSave-beginSave));
		
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
			for(Column key : t.getKey()) {
				NeoLogger.info("\tkey: {0} ( {1} )", key.getName(), key.getType() == null ? "null" : key.getType().getName());
			}
			for (Column c : t.getCol()) {
				NeoLogger.info("\tColumn: " + c.getName());
				NeoLogger.info("\t\tkeyOf: {0}", c.getKeyOf() == null ? "null" : c.getKeyOf().getName());
				NeoLogger.info("\t\ttype: {0}", c.getType() == null ? "null" : c.getType().getName());
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
