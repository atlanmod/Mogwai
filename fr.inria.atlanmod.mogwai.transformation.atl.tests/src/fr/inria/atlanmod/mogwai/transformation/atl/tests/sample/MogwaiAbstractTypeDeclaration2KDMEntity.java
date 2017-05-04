package fr.inria.atlanmod.mogwai.transformation.atl.tests.sample;

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

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Index;
import com.tinkerpop.blueprints.Vertex;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.datastore.blueprints.AutocommitNeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResourceFactory;
import fr.inria.atlanmod.mogwai.processor.GremlinScriptRunner;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.builder.ATLQueryBuilder;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class MogwaiAbstractTypeDeclaration2KDMEntity {

	public static String ATL_URI = "materials/samples/abstractTypeDeclaration2kdmEntity.atl";

	public static final String SET1 = "set1";
	public static final String SET2 = "set2";
	public static final String SET3 = "set3";
	public static final String SET4 = "set4";
	public static final String SET5 = "set5";
	
	public static String THE_SET = SET5;
	
	public static void main(String[] args) throws IOException {

		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());

		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		Resource targetMM = rs
				.getResource(
						URI.createFileURI("/home/gdaniel/Bureau/eclipse-mog/eclipse/workspace/org.eclipse.gmt.modisco.omg.kdm/model/kdm.ecore"),
						true);
		EPackage codePackage = null;
		EPackage targetPackage = (EPackage) targetMM.getContents().get(0);
		EPackage.Registry.INSTANCE.put(targetPackage.getNsURI(), targetPackage);
		for (EPackage subPackage : targetPackage.getESubpackages()) {
			if(subPackage.getName().equals("code")) {
				codePackage = subPackage;
			}
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
//				.autocommit()
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
				.getBackend().getGraph(), 100000, JavaPackage.eINSTANCE));

		long beginMem = getMem();
		MogwaiLogger.info("Start Memory: {0}MB", beginMem);
		mogwaiResource.transform(query, options);
		
		
		long begin = System.currentTimeMillis();
		mogwaiResource.save(neoOpts);
		long end = System.currentTimeMillis();
		long endMem = getMem();
		MogwaiLogger.info("Saving done in {0}ms", (end-begin));
		MogwaiLogger.info("End Memory: {0}MB", endMem);
		MogwaiLogger.info("Memory Consumption: {0}MB", (endMem - beginMem));
		
		Index<Vertex> index = mogwaiResource.getBackend().getGraph().getIndex("metaclasses", Vertex.class);
		Iterable<Vertex> metaClassVertex = index.get("name", "Datatype");
		if(metaClassVertex.iterator().hasNext()) {
			for(Vertex mm : metaClassVertex) {
				System.out.println("meta vertex: " + mm.getId());
				Iterable<Vertex> instances = mm.getVertices(Direction.IN, "kyanosInstanceOf");
				int count = 0;
				for(Vertex ii : instances) {
					count++;
//					System.out.println(ii.getId());
				}
				System.out.println("found " + count + " instances");
			}
		}
		else {
			System.out.println("meta vertex: Datatype not found");
		}
		
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

}
