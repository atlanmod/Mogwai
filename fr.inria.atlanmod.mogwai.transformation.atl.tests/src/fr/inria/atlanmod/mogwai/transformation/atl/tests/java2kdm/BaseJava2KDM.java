package fr.inria.atlanmod.mogwai.transformation.atl.tests.java2kdm;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import kdm.action.ActionPackage;
import kdm.build.BuildPackage;
import kdm.code.CodePackage;
import kdm.conceptual.ConceptualPackage;
import kdm.core.CorePackage;
import kdm.data.DataPackage;
import kdm.event.EventPackage;
import kdm.kdm.KdmPackage;
import kdm.platform.PlatformPackage;
import kdm.source.SourcePackage;
import kdm.structure.StructurePackage;
import kdm.ui.UiPackage;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.JavaPackage;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class BaseJava2KDM {

	public static final String SET1 = "set1";
	public static final String SET2 = "set2";
	public static final String SET3 = "set3";
	public static final String SET4 = "set4";
	public static final String SET5 = "set5";
	
	public static String THE_SET = SET4;
	
	public static void main(String[] args) throws IOException {
		Java2KDMRunner runner = new Java2KDMRunner();
		runner.enableATLDebug();
		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());

		ResourceSet rs = new ResourceSetImpl();
//		Resource targetMM = rs
//				.getResource(
//						URI.createFileURI("/home/gdaniel/Bureau/eclipse-mog/eclipse/workspace/org.eclipse.gmt.modisco.omg.kdm/model/kdm.ecore"),
//						true);
//		EPackage targetPackage = (EPackage) targetMM.getContents().get(0);
//		EPackage.Registry.INSTANCE.put(targetPackage.getNsURI(), targetPackage);
//		for (EPackage subPackage : targetPackage.getESubpackages()) {
//			EPackage.Registry.INSTANCE.put(subPackage.getNsURI(), subPackage);
//		}
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
//		Resource input = rSet.createResource(URI.createURI("materials/java/set1.xmi"));
//		input.load(Collections.emptyMap());
		Resource input = rSet.createResource(BlueprintsURI.createFileURI(new File("materials/java/neoemf/"+THE_SET+".graphdb")));
		Map<String, Object> options = BlueprintsNeo4jOptionsBuilder.newBuilder()
				/*
				 *  Having a high autocommit chunk makes the VM crash if we have a big
				 *  output model.
				 */
				.autocommit(100)
//				.autocommit()
				.asMap();
		input.load(options);
		
		Resource neoOutput = rSet.createResource(BlueprintsURI.createFileURI(new File("materials/kdm/neoemf/"+THE_SET+".graphdb")));
		neoOutput.save(options);
		
		runner.disableATLDebug();
		long beginMem = getMem();
		MogwaiLogger.info("Memory used: {0}MB", beginMem);
		long begin = System.currentTimeMillis();
		Resource out = runner.transform(input);
//		out.setURI(URI.createURI("materials/kdm/set1.xmi"));
//		out.save(Collections.emptyMap());
		MogwaiLogger.info("Closing input");
		((PersistentResource)input).close();
		MogwaiLogger.info("Moving output");
		long beginSave = System.currentTimeMillis();
//		long midMem = getMem();
		neoOutput.getContents().addAll(out.getContents());
		MogwaiLogger.info("Saving output");
		neoOutput.save(options);
		long end = System.currentTimeMillis();
		long endMem = getMem();
		MogwaiLogger.info("Input size: {0}", size(input));
		MogwaiLogger.info("Output size: {0}", size(neoOutput));
		MogwaiLogger.info("Execution time: {0}ms", (end-begin));
		MogwaiLogger.info("Save() time: {0}ms", (end-beginSave));
		MogwaiLogger.info("Memory used: {0}MB", endMem);
		MogwaiLogger.info("Memory Consumption: {0}MB", endMem - beginMem);
//		MogwaiLogger.info("Memory Consumption (middle): {0}MB", midMem - beginMem);
	}

	private static void register(EPackage ePackage) {
		EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
	}
	
	private static int size(Resource r) {
		int size = 0;
		Iterable<EObject> allContents = r::getAllContents;
		for (EObject e : allContents) {
			size++;
		}
		return size;
	}
	
	private static final int MB = 1024*1024;
	
	private static long getMem() {
		for(int i = 0; i < 5; i++) {
			System.gc();
		}
		try {
			Object[] t = new Object[200000000];
		} catch(Throwable e) {
			MogwaiLogger.info("Memory cleaned");
		}
		for(int i = 0; i < 5; i++) {
			System.gc();
		}
		return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / MB;
	}

}
