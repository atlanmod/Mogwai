package fr.inria.atlanmod.mogwai.transformation.atl.tests.allOfKind;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.JavaPackage;

import com.tinkerpop.blueprints.Vertex;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.datastore.blueprints.NeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResourceFactory;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class AllOfKind {

	private static final String THE_SET = "set1";

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

		Resource neoResource = rSet.createResource(BlueprintsURI.createFileURI(new File("materials/java/neoemf/"
				+ THE_SET + ".graphdb")));
		Map<String, Object> neoOpts = BlueprintsNeo4jOptionsBuilder.newBuilder().autocommit().weakCache().asMap();
		neoResource.load(neoOpts);

		MogwaiResource mogwaiResource = MogwaiResourceFactory.getInstance().decoratePersistentResource(
				(PersistentResource) neoResource);
		
		Iterable<EObject> allContents = mogwaiResource::getAllContents;
		MogwaiLogger.info("Resource contains {0} elements", StreamSupport.stream(allContents.spliterator(), false).count());

		EClass eClassToFind = JavaPackage.eINSTANCE.getAbstractTypeDeclaration();
		eClassToFind.getEPackage().getEClassifiers().stream().filter(EClass.class::isInstance).map(EClass.class::cast)
				.filter(c -> eClassToFind.isSuperTypeOf(c) && !c.isAbstract())
				.forEach(c -> System.out.println(c.getName()));

		NeoEMFGraphDatastore graphDatastore = new NeoEMFGraphDatastore(mogwaiResource.getBackend().getGraph(),
				JavaPackage.eINSTANCE);
		
		Iterable<Vertex> allOfKind = graphDatastore.allOfKind(eClassToFind.getName());
		int count = 0;
		for(Vertex v : allOfKind) {
			count++;
		}
		MogwaiLogger.info("Found {0} instances of {1}", count, eClassToFind.getName());

		Iterable<Vertex> allOfType = graphDatastore.allOfType(JavaPackage.eINSTANCE.getClassDeclaration().getName());
		count = 0;
		for(Vertex v : allOfType) {
			count++;
		}
		MogwaiLogger.info("Found {0} strict instances of {1}", count, JavaPackage.eINSTANCE.getClassDeclaration().getName());
		
		mogwaiResource.close();
	}

}
