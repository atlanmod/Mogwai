package fr.inria.atlanmod.mogwai.transformation.ocl.tests.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;

public class TestUtil {

	public static Resource createEmptyGremlinResource() {
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getPackageRegistry().put(GremlinPackage.eINSTANCE.getNsURI(), GremlinPackage.eINSTANCE);
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("gremlin", GremlinPackage.eINSTANCE);
		return createEmptyGremlinResource(rSet);
	}
	
	public static Resource createEmptyGremlinResource(ResourceSet rSet) {
		return rSet.createResource(URI.createURI("empty_resource.gremlin"));
	}
	
	
	
}
