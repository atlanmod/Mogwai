package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.File;
import java.io.IOException;

import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.query.builder.MogwaiGremlinQueryBuilder;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;

/**
 * This class shows how additional bindings can be set within the gremlin
 * script, and how an initialization script can be used to set these additional
 * bindings before the actual query computation.
 * <p>
 * <b>Note:</b> using an initialization script may not be the fastest way to
 * initialize the engine (it should be more efficient to use the gremlin Java
 * API that doesn't need to compile an external script).
 * 
 * @author Gwendal DANIEL
 */
public class TestGremlin {

	/**
	 * Runs the test that first loads an existing Mogwai resource, then
	 * initializes the gremlin engine with the script init.gremlin, and finally
	 * uses the initialized variables in a the query script test.gremlin.
	 * 
	 * @param args the optional command-line arguments
	 * @throws IOException if the Mogwai resource cannot be found
	 */
	public static void main(String[] args) throws IOException {
		MogwaiResource mogResource = ModelUtil.getInstance().createSampleModel();

		TransformationHelper helper = new TransformationHelper();

		MogwaiQuery gremlinInit = MogwaiGremlinQueryBuilder.newBuilder()
				.fromFile(new File("materials/init.gremlin"))
				.bind("transformationHelper", helper)
				.build();

		mogResource.query(gremlinInit);
		System.out.println("Init done");

		MogwaiQuery gremlinQuery = MogwaiGremlinQueryBuilder.newBuilder()
				.fromFile(new File("materials/test.gremlin"))
				.build();

		MogwaiQueryResult result = mogResource.query(gremlinQuery);
		System.out.println(result.getResult());
	}

	/**
	 * A mock class that is defined as an external binding in the gremlin
	 * script.
	 * 
	 * @author Gwendal DANIEL
	 */
	private static class TransformationHelper {

		@SuppressWarnings("unused")
		public void debug() {
			System.out.println("DEBUG");
		}

	}

}
