package fr.inria.atlanmod.mogwai.transformation.atl.tests.java2kdm;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;

public class BaseJava2KDM {

	public static void main(String[] args) throws IOException {
		Java2KDMRunner runner = new Java2KDMRunner();
		runner.enableATLDebug();
		
		ResourceSet rs = new ResourceSetImpl();
		Resource targetMM = rs.getResource(URI.createFileURI("/home/gdaniel/Bureau/eclipse-mog/eclipse/workspace/org.eclipse.gmt.modisco.omg.kdm/model/kdm.ecore"), true);
		EPackage targetPackage = (EPackage)targetMM.getContents().get(0);
		EPackage.Registry.INSTANCE.put(targetPackage.getNsURI(), targetPackage);
		for(EPackage subPackage : targetPackage.getESubpackages()) {
			EPackage.Registry.INSTANCE.put(subPackage.getNsURI(), subPackage);
		}
		
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource xmi = rSet.createResource(URI.createURI("materials/java/set1.xmi"));
		xmi.load(Collections.emptyMap());
		MogwaiLogger.info("Input size: {0}", size(xmi));
		
		Resource out = runner.transform(xmi);
		out.setURI(URI.createURI("materials/kdm/set1.xmi"));
		out.save(Collections.emptyMap());
		MogwaiLogger.info("Output size: {0}", size(out));
	}
	
	private static int size(Resource r) {
		int size = 0;
		Iterable<EObject> allContents = r::getAllContents;
		for(EObject e : allContents) {
			size++;
		}
		return size;
	}
	
}
