package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.neoemf.logging.NeoLogger;

public class TestATL {

	public static void main(String[] args) throws IOException, MogwaiException {
		long begin = System.currentTimeMillis();
		MogwaiResource mogResource = ModelUtil.getInstance().createSampleModel();
		long end = System.currentTimeMillis();
		NeoLogger.info("Created large instance in {0}ms", (end-begin));
		
		ATLRunner runner = new ATLRunner();
		begin = System.currentTimeMillis();
		Resource output = runner.transform(mogResource);
		end = System.currentTimeMillis();
		NeoLogger.info("Created target model in {0}ms", (end-begin));
		
		output.setURI(URI.createURI("materials/ClassDiagram2Relational/ATLFiles/Class2Relational-simple-transformed.xmi"));
		output.save(Collections.emptyMap());

		mogResource.close();

	}	
}
