package fr.inria.atlanmod.mogwai.transformation.ocl.tests.execution;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmt.modisco.java.JavaPackage;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResourceFactory;
import fr.inria.atlanmod.mogwai.neoemf.util.MogwaiURI;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.builder.OCLQueryBuilder;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;

public class RunMogwaiQueryTest {

	@Test
	public void test() throws IOException {
		JavaPackage.eINSTANCE.eClass();
		EPackage.Registry.INSTANCE.put(JavaPackage.eNS_URI, JavaPackage.eINSTANCE);
		PersistenceBackendFactoryRegistry.register(MogwaiURI.MOGWAI_SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
				.put(MogwaiURI.MOGWAI_SCHEME, MogwaiResourceFactory.getInstance());
		MogwaiResource resource = (MogwaiResource) rSet.createResource(MogwaiURI.createMogwaiURI(new File(
				"resources/db/set1.graphdb")));
		resource.load(Collections.emptyMap());

		MogwaiQuery query = OCLQueryBuilder.newBuilder().fromString("ClassDeclaration.allInstances()")
				.context(JavaPackage.eINSTANCE.getClassDeclaration()).build();

		NeoEMFQueryResult result = resource.query(query);

		MogwaiLogger.info("Found {0} result(s)", result.getResults().size());

		if (result.isReifiable()) {
			List<EObject> reifiedResult = result.reifyResults(resource);
			for (EObject r : reifiedResult) {
				MogwaiLogger.info("\t{0}", r.toString());
			}
		} else {
			MogwaiLogger.error("Cannot reify query results");
		}

	}

}
