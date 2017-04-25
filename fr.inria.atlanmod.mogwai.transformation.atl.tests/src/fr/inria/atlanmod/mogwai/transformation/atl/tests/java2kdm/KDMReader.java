package fr.inria.atlanmod.mogwai.transformation.atl.tests.java2kdm;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.JavaPackage;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResourceFactory;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class KDMReader {
	
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

		Resource neoResource = rSet.createResource(BlueprintsURI.createFileURI(new File(
				"materials/java/neoemf/set1.graphdb")));
		Map<String, Object> neoOpts= BlueprintsNeo4jOptionsBuilder.newBuilder().autocommit().asMap();
		neoResource.load(neoOpts);
		
		MogwaiResource mogwaiResource = MogwaiResourceFactory.getInstance().decoratePersistentResource((PersistentResource)neoResource);
		
		mogwaiResource.save(neoOpts);
		
		List<EObject> allSegments = mogwaiResource.getAllInstances(KdmPackage.eINSTANCE.getSegment());
		MogwaiLogger.info("Found {0} segments", allSegments.size());
		
		Segment s = (Segment)allSegments.get(0);
		MogwaiLogger.info("Found {0}", s.eClass().getName());
		MogwaiLogger.info("Segment Contents size: {0}", s.eContents().size());
		for(EObject e : s.eContents()) {
			MogwaiLogger.info("\t{0}", e);
			MogwaiLogger.info("\teContents size: {0}", e.eContents().size());
			for(EObject ee : e.eContents()) {
				MogwaiLogger.info("\t\t{0}", ee);
			}
		}
		
//		List<EObject> allCodeModels = mogwaiResource.getAllInstances(CodePackage.eINSTANCE.getCodeModel());
//		long cmSize = StreamSupport.stream(allCodeModels.spliterator(), false).filter(e -> e.eClass().getEPackage().getNsURI().contains("kdm")).count();
//		MogwaiLogger.info("#Model {0}", cmSize);
//		CodeModel cM = (CodeModel)allCodeModels.get(0);
//		MogwaiLogger.info("#CodeModel {0}", cM.getName());
//		for(AbstractCodeElement cE : cM.getCodeElement()) {
//			if(cE instanceof LanguageUnit) {
//				continue;
//			}
//			else {
//				MogwaiLogger.info("\t {0}", cE.eClass().getName());
//			}
//		}
//		
//		List<EObject> allPackages = mogwaiResource.getAllInstances(CodePackage.eINSTANCE.getPackage());
//		long pSize = StreamSupport.stream(allPackages.spliterator(), false).filter(e -> e.eClass().getEPackage().getNsURI().contains("kdm")).count();
//		MogwaiLogger.info("#Package {0}", pSize);
//		
//		List<EObject> allClassUnits = mogwaiResource.getAllInstances(CodePackage.eINSTANCE.getClassUnit());
//		long cSize = allClassUnits.size();
//		MogwaiLogger.info("#ClassUnit {0}", cSize);
//		
//		List<EObject> allAttributes = mogwaiResource.getAllInstances(KdmPackage.eINSTANCE.getAttribute());
//		long aSize = allAttributes.size();
//		MogwaiLogger.info("#Attributes {0}", aSize);
		
		mogwaiResource.close();
	}
	
	private static void register(EPackage ePackage) {
		EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
	}
}
