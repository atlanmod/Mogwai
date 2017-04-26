package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.File;
import java.io.IOException;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.blueprints.NeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;
import fr.inria.atlanmod.mogwai.query.builder.GremlinQueryBuilder;

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

		ModelDatastore mapping = new NeoEMFGraphDatastore(mogResource.getBackend().getGraph());

		MogwaiQuery gremlinInit = GremlinQueryBuilder.newBuilder()
				.fromFile(new File("materials/init.gremlin"))
//				.bind(ModelDatastore.BINDING_NAME, mapping)
				.build();

		mogResource.query(gremlinInit);
		System.out.println("Init done");

		MogwaiQuery gremlinQuery = GremlinQueryBuilder.newBuilder()
				.fromFile(new File("materials/test.gremlin"))
//				.bind(ModelDatastore.BINDING_NAME, mapping)
				.build();
		
		// Put bindings here if we need them
		QueryResult result = mogResource.query(gremlinQuery);
		System.out.println(result.getResults());
	}

}
