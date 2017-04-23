package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import ClassDiagram.Attribute;
import ClassDiagram.ClassDiagramPackage;
import ClassDiagram.Column;
import ClassDiagram.Named;
import ClassDiagram.NamedElement;
import ClassDiagram.Table;
import fr.inria.atlanmod.mogwai.core.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.datastore.blueprints.NeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.processor.GremlinScriptRunner;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.builder.ATLQueryBuilder;
import fr.inria.atlanmod.mogwai.query.builder.OCLQueryBuilder;
import fr.inria.atlanmod.mogwai.transformation.atl.helper.blueprints.InPlaceBlueprintsTransformationHelper;
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

	public static void main(String[] args) throws IOException, MogwaiCoreException {
		
		NeoLogger.info("Creating sample model");
		MogwaiResource mogResource = ModelUtil.getInstance().createSampleModel();
//		MogwaiResource mogResource = ModelUtil.getInstance().createLargeSampleModel();
//		MogwaiResource mogResource = ModelUtil.getInstance().getResource(CreateModel.MODEL_LOCATION);
		NeoLogger.info("Done");
		
		// Monitoring
		int classCount = 0;
		int attributeCount = 0;
		int multivaluedCount = 0;
		int singleValuedCount = 0;
		int datatypeAttribute = 0;
		int classAttribute = 0;
		
		Iterable<EObject> allContents = mogResource::getAllContents;
		for(EObject e : allContents) {
			if(e instanceof ClassDiagram.Class) {
				classCount++;
			}
			if(e instanceof Attribute) {
				attributeCount++;
				Attribute a = (Attribute)e;
				if(a.getMultiValued()) {
					multivaluedCount++;
				}
				else {
					singleValuedCount++;
				}
				if(a.getType() instanceof ClassDiagram.Class) {
					classAttribute++;
				}
				else {
					datatypeAttribute++;
				}
			}
		}
		
		System.out.println("Class count: " + classCount);
		System.out.println("Attribute count: " + attributeCount);
		System.out.println("multivalued " + multivaluedCount);
		System.out.println("singlevalued " + singleValuedCount);
		System.out.println("datatype attribute " + datatypeAttribute);
		System.out.println("class attribute " + classAttribute);
		

		NeoLogger.info("Creating ATL query");
		
		MogwaiQuery query = ATLQueryBuilder.newBuilder()
			.fromURI(URI.createURI(ATL_URI))
			.sourcePackage(ClassDiagramPackage.eINSTANCE)
			.targetPackage(ClassDiagramPackage.eINSTANCE)
			.build();
		
		Map<String, Object> options = new HashMap<>();
		options.put(GremlinScriptRunner.PRINT_SCRIPT_OPTION, true);
		
		NeoLogger.info("Done");
		
		mogResource.transform(query, options);
		
		NeoLogger.info("Model successfully transformed");
		
		NeoLogger.info("CreateElement time: {0}ms", InPlaceBlueprintsTransformationHelper.createTime);
		NeoLogger.info("NewInstance time: {0}ms", NeoEMFGraphDatastore.newInstanceTime);
		NeoLogger.info("NewInstance setRef time: {0}ms", NeoEMFGraphDatastore.newInstanceSetRef);
		NeoLogger.info("NewInstance getResourceRoot: {0}ms", NeoEMFGraphDatastore.newInstanceGetResourceRoot);
		NeoLogger.info("NewInstance addVertex: {0}ms", NeoEMFGraphDatastore.newInstanceAddVertex);
		NeoLogger.info("NewInstance getMetaClass: {0}ms", NeoEMFGraphDatastore.newInstanceGetMetaclass);
		NeoLogger.info("IsResolvable time: {0}ms", InPlaceBlueprintsTransformationHelper.isResolvableTime);
		NeoLogger.info("Resolve time: {0}ms", InPlaceBlueprintsTransformationHelper.resolveTime);
		NeoLogger.info("Link time: {0}ms", InPlaceBlueprintsTransformationHelper.linkTime);
		NeoLogger.info("Plink time: {0}ms", InPlaceBlueprintsTransformationHelper.pLinkTime);
		NeoLogger.info("ResolveProxy time: {0}ms", InPlaceBlueprintsTransformationHelper.resolveProxyTime);
		NeoLogger.info("UpdateContainment time: {0}ms", NeoEMFGraphDatastore.updateContainmentTime);
		NeoLogger.info("UpdateContainment loop1 time: {0}ms", NeoEMFGraphDatastore.updateContainment1);
		NeoLogger.info("UpdateContainment loop2 time: {0}ms", NeoEMFGraphDatastore.updateContainment2);

		long beginSave = System.currentTimeMillis();
		mogResource.save(Collections.emptyMap());	
		long endSave = System.currentTimeMillis();
		NeoLogger.info("Save time: {0}ms", (endSave-beginSave));
		
		MogwaiQuery outQuery = OCLQueryBuilder.newBuilder()
				.fromString("Table.allInstances()")
				.context(ClassDiagramPackage.eINSTANCE.getClass_())
				.build();
		NeoLogger.info("AllInstances(Table): (OCL)");
		showResult(mogResource.query(outQuery), mogResource);

		MogwaiQuery attQuery = OCLQueryBuilder.newBuilder()
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

	public static void showResult(NeoEMFQueryResult mqr, MogwaiResource mogResource) throws MogwaiCoreException {
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
			} catch (MogwaiCoreException e) {
				// Need a fix, Mogwai-ATL can return null
				NeoLogger.info("The query didn't return any object");
			}
		}
	}

}
