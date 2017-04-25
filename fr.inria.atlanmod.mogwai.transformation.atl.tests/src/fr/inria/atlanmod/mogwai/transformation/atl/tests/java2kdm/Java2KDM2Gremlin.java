package fr.inria.atlanmod.mogwai.transformation.atl.tests.java2kdm;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.JavaPackage;

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

public class Java2KDM2Gremlin {

	public static String ATL_URI = "materials/java2kdm/java2kdm_simple.atl";

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

		Map<String, Object> options = new HashMap<>();
		options.put(GremlinScriptRunner.PRINT_SCRIPT_OPTION, true);

		Resource neoResource = rSet.createResource(BlueprintsURI.createFileURI(new File(
				"materials/java/neoemf/set1.graphdb")));
		Map<String, Object> neoOpts= BlueprintsNeo4jOptionsBuilder.newBuilder().autocommit().asMap();
		neoResource.load(neoOpts);
		
		MogwaiResource mogwaiResource = MogwaiResourceFactory.getInstance().decoratePersistentResource((PersistentResource)neoResource);
		
		mogwaiResource.transform(query, options);
		
		mogwaiResource.save(neoOpts);
		
		mogwaiResource.close();

	}

}
