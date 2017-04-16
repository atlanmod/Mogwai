package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;
import org.neo4j.kernel.impl.util.FileUtils;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

public class TestATL {

	public static void main(String[] args) throws IOException, MogwaiException {
		long begin = System.currentTimeMillis();
//		MogwaiResource mogResource = ModelUtil.getInstance().createSampleModel();
//		MogwaiResource mogResource = ModelUtil.getInstance().createLargeSampleModel();
		MogwaiResource mogResource = ModelUtil.getInstance().getResource(CreateModel.MODEL_LOCATION);
		FileUtils.deleteRecursively(new File(
						"materials/ClassDiagram2Relational/ATLFiles/Class2Relational-simple-transformed.graphdb"));
		PersistentResource outResource = (PersistentResource) mogResource.getResourceSet().createResource(
				BlueprintsURI.createFileURI(new File(
						"materials/ClassDiagram2Relational/ATLFiles/Class2Relational-simple-transformed.graphdb")));
		outResource.save(BlueprintsNeo4jOptionsBuilder.newBuilder().directWrite().autocommit(1000).asMap());
		long end = System.currentTimeMillis();
		NeoLogger.info("Created large instance in {0}ms", (end-begin));
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ATLRunner runner = new ATLRunner();
		begin = System.currentTimeMillis();
		Resource output = runner.transform(mogResource, outResource);
		System.out.println(output.getClass().getName());
		end = System.currentTimeMillis();
		NeoLogger.info("Created target model in {0}ms", (end-begin));
		begin = System.currentTimeMillis();
//		outputResource.getContents().addAll(output.getContents());
//		outputResource.save(Collections.emptyMap());
		outResource.save(Collections.emptyMap());
		end = System.currentTimeMillis();
		NeoLogger.info("Saved target model in {0}ms", (end-begin));
		
//		output.setURI(URI.createURI("materials/ClassDiagram2Relational/ATLFiles/Class2Relational-simple-transformed.xmi"));
//		output.save(Collections.emptyMap());

		mogResource.close();

	}	
}
