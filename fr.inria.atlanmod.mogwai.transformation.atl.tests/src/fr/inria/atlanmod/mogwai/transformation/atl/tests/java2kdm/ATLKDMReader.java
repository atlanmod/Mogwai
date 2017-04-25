package fr.inria.atlanmod.mogwai.transformation.atl.tests.java2kdm;

import java.io.IOException;
import java.util.Collections;

import kdm.action.ActionPackage;
import kdm.build.BuildPackage;
import kdm.code.CodePackage;
import kdm.conceptual.ConceptualPackage;
import kdm.core.CorePackage;
import kdm.data.DataPackage;
import kdm.event.EventPackage;
import kdm.kdm.KdmPackage;
import kdm.kdm.Segment;
import kdm.platform.PlatformPackage;
import kdm.source.SourcePackage;
import kdm.structure.StructurePackage;
import kdm.ui.UiPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.JavaPackage;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class ATLKDMReader {
	
	public static void main(String[] args) throws IOException {
		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());

		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		
		register(CorePackage.eINSTANCE);
		register(KdmPackage.eINSTANCE);
		register(SourcePackage.eINSTANCE);
		register(CodePackage.eINSTANCE);
		register(ActionPackage.eINSTANCE);
		register(PlatformPackage.eINSTANCE);
		register(BuildPackage.eINSTANCE);
		register(ConceptualPackage.eINSTANCE);
		register(DataPackage.eINSTANCE);
		register(EventPackage.eINSTANCE);
		register(StructurePackage.eINSTANCE);
		register(UiPackage.eINSTANCE);
		
		EPackage.Registry.INSTANCE.put(JavaPackage.eINSTANCE.getNsURI(), JavaPackage.eINSTANCE);

		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
				.put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());

		Resource r = rSet.createResource(URI.createURI("materials/kdm/set1.xmi"));
		r.load(Collections.emptyMap());
		
		EObject top = r.getContents().get(0);
		MogwaiLogger.info("Found {0}", top.eClass().getName());
		
		Segment s = (Segment)top;
		MogwaiLogger.info("Segment content size: {0}", s.eContents().size());
		for(EObject e : s.eContents()) {
			MogwaiLogger.info("\t{0}", e);
			MogwaiLogger.info("\teContents size: {0}", e.eContents().size());
			for(EObject ee : e.eContents()) {
				MogwaiLogger.info("\t\t{0}", ee);
			}
		}
		
	}
	
	private static void register(EPackage ePackage) {
		EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
	}
}
