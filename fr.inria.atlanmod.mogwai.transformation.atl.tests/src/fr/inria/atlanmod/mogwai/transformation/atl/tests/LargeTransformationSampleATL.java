package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import ClassDiagram.Column;
import ClassDiagram.Named;
import ClassDiagram.NamedElement;
import ClassDiagram.Table;
import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

public class LargeTransformationSampleATL {

	public static void main(String[] args) throws IOException, MogwaiException {
		long begin = System.currentTimeMillis();
		MogwaiResource mogResource = ModelUtil.getInstance().createLargeSampleModel();
		long end = System.currentTimeMillis();
		NeoLogger.info("Created large instance in {0}ms", (end-begin));
		
		ATLRunner runner = new ATLRunner();
		begin = System.currentTimeMillis();
		Resource output = runner.transform(mogResource);
		end = System.currentTimeMillis();
		NeoLogger.info("Created target model in {0}ms", (end-begin));
		
//		output.save(Collections.emptyMap());

		int tCount = 0;
		int cCount = 0;
		Iterator<EObject> it = output.getAllContents();
		while(it.hasNext()) {
			EObject ee = it.next();
			if(ee instanceof Table) {
				tCount++;
			}
			if(ee instanceof Column) {
				cCount++;
			}
		}
		System.out.println("Table count: " + tCount);
		System.out.println("Column count: " + cCount);
		
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
