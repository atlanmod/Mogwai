package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import ClassDiagram.Attribute;
import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

public class LargeModelTraverser {

	public static void main(String[] args) throws IOException, MogwaiCoreException {
		long begin = System.currentTimeMillis();
		MogwaiResource mogResource = ModelUtil.getInstance().createLargeSampleModel();
		long end = System.currentTimeMillis();
		NeoLogger.info("Created large instance in {0}ms", (end-begin));
		
		List<ClassDiagram.Class> classes = new ArrayList<>();
		List<Attribute> cAtt = new ArrayList<>();
		List<Attribute> atts = new ArrayList<>();
		List<String> attNames = new ArrayList<>();
		begin = System.currentTimeMillis();
		Iterator<EObject> eContents = mogResource.getAllContents();
		while(eContents.hasNext()) {
			EObject ee = eContents.next();
			if(ee instanceof ClassDiagram.Class) {
				ClassDiagram.Class cc = (ClassDiagram.Class)ee;
				classes.add(cc);
				for(Attribute aa : cc.getAttr()) {
					cAtt.add(aa);
				}
				
			}
			if(ee instanceof Attribute) {
				Attribute aa = (Attribute)ee;
				atts.add(aa);
				attNames.add(aa.getName());
			}
		}
		end = System.currentTimeMillis();
		NeoLogger.info("Model traversed in {0}ms", (end-begin));
		
		mogResource.close();

	}
	
}
