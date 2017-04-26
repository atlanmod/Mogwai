package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.neo4j.kernel.impl.util.FileUtils;

import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptions;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

public class CreateModel {
	
	public final static String MODEL_LOCATION = "materials/large-class.graphdb";

	public static void main(String[] args) throws IOException, MogwaiCoreException {
		long begin = System.currentTimeMillis();
		FileUtils.deleteRecursively(new File(MODEL_LOCATION));
		MogwaiResource mogResource = ModelUtil.getInstance().createLargeSampleModel(MODEL_LOCATION);
		mogResource.save(BlueprintsNeo4jOptionsBuilder.newBuilder().autocommit(1000).asMap());
		long end = System.currentTimeMillis();
		NeoLogger.info("Model created in {0}ms", (end-begin));
		mogResource.close();

	}	
}
