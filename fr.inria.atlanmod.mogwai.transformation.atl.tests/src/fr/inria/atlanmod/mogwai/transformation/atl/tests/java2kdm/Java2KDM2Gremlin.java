package fr.inria.atlanmod.mogwai.transformation.atl.tests.java2kdm;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.JavaPackage;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.datastore.blueprints.AutocommitNeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResourceFactory;
import fr.inria.atlanmod.mogwai.processor.GremlinScriptRunner;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.builder.ATLQueryBuilder;
import fr.inria.atlanmod.mogwai.transformation.atl.tests.java2kdm.BaseJava2KDM.MemoryChecker;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class Java2KDM2Gremlin {

	public static String ATL_URI = "materials/java2kdm/java2kdm_simple.atl";

	public static int MEMORY_CHECK_INTERVAL = 5000;

	
	public static final String SET1 = "set1";
	public static final String SET2 = "set2";
	public static final String SET3 = "set3";
	public static final String SET4 = "set4";
	public static final String SET5 = "set5";
	
	public static String THE_SET = SET4;
	
	public static void main(String[] args) throws IOException {

		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());

		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		Resource targetMM = rs
				.getResource(
						URI.createFileURI("/home/gdaniel/Bureau/eclipse-mog/eclipse/workspace/org.eclipse.gmt.modisco.omg.kdm/model/kdm.ecore"),
						true);
		EPackage targetPackage = (EPackage) targetMM.getContents().get(0);
		EPackage.Registry.INSTANCE.put(targetPackage.getNsURI(), targetPackage);
		for (EPackage subPackage : targetPackage.getESubpackages()) {
			EPackage.Registry.INSTANCE.put(subPackage.getNsURI(), subPackage);
		}
		EPackage.Registry.INSTANCE.put(JavaPackage.eINSTANCE.getNsURI(), JavaPackage.eINSTANCE);

		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
				.put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());

		MogwaiQuery query = ATLQueryBuilder.newBuilder().fromURI(URI.createURI(ATL_URI))
				.sourcePackage(JavaPackage.eINSTANCE).targetPackage(targetPackage).build();

		Resource neoResource = rSet.createResource(BlueprintsURI.createFileURI(new File(
				"materials/java/neoemf/"+THE_SET+".graphdb")));
		Map<String, Object> neoOpts= BlueprintsNeo4jOptionsBuilder.newBuilder()
				.autocommit()
				.weakCache()
				.asMap();
		neoResource.load(neoOpts);
		
		MogwaiResource mogwaiResource = MogwaiResourceFactory.getInstance().decoratePersistentResource((PersistentResource)neoResource);
		
		Map<String, Object> options = new HashMap<>();
		options.put(GremlinScriptRunner.PRINT_SCRIPT_OPTION, true);
		/*
		 * Set this option when manipulating large graphs, this enable operation auto commit
		 * that reduces the memory consumption by committing changes every n operations
		 */
		options.put(MogwaiResource.NEOEMF_MODEL_DATASTORE, new AutocommitNeoEMFGraphDatastore(mogwaiResource
				.getBackend().getGraph(), 10000, JavaPackage.eINSTANCE));

		long beginMem = getMem();
		MogwaiLogger.info("Start Memory: {0}MB", beginMem);
//		MemoryChecker checker = new MemoryChecker();
//		checker.start();
		mogwaiResource.transform(query, options);
		
		
		long begin = System.currentTimeMillis();
//		checker.unwatch();
		mogwaiResource.save(neoOpts);
		long end = System.currentTimeMillis();
		long endMem = getMem();
		MogwaiLogger.info("Saving done in {0}ms", (end-begin));
		MogwaiLogger.info("End Memory: {0}MB", endMem);
		MogwaiLogger.info("Memory Consumption: {0}MB", (endMem - beginMem));
//		MogwaiLogger.info("[Checker] Max Memory Consumption: {0}MB", checker.highest - beginMem);
		
		mogwaiResource.close();

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
	
	public static class MemoryChecker extends Thread {
		
		private boolean running = true;
		
		public long highest = 0;
		
		@Override
		public void run() {
			MogwaiLogger.info("Memory Checker Started");
			while(running) {
				try {
					sleep(MEMORY_CHECK_INTERVAL);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long mem = getMem();
				if(mem > highest) {
					highest = mem;
				}
				MogwaiLogger.info("[Checker] Memory used: {0}", mem);
			}
		}
		
		public void unwatch() {
			this.running = false;
		}
	}

}
