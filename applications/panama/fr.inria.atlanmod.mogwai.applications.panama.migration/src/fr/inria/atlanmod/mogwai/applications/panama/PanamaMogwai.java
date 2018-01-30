package fr.inria.atlanmod.mogwai.applications.panama;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.h2.jdbcx.JdbcDataSource;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import fr.inria.atlanmod.mogwai.applications.panama.panamaNeo4j.PanamaNeo4jPackage;
import fr.inria.atlanmod.mogwai.applications.panama.panamaRelational.PanamaRelationalPackage;
import fr.inria.atlanmod.mogwai.datastore.jdbc.DefaultJdbcDatastore;
import fr.inria.atlanmod.mogwai.datastore.jdbc.JdbcElement;
import fr.inria.atlanmod.mogwai.datastore.neo4j3.DefaultEmbeddedNeo4j3Datastore;
import fr.inria.atlanmod.mogwai.processor.ATLQueryProcessor;
import fr.inria.atlanmod.mogwai.processor.AbstractATLProcessor;
import fr.inria.atlanmod.mogwai.processor.GremlinScriptRunner;
import fr.inria.atlanmod.mogwai.query.ATLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.builder.ATLQueryBuilder;
import fr.inria.atlanmod.mogwai.transformation.atl.helper.panama.DummyATLTransformationHelper;

public class PanamaMogwai {

	public static void main(String[] args) throws Exception {
//		Thread.sleep(10000);
		
		MogwaiQuery query = ATLQueryBuilder.newBuilder().fromURI(URI.createURI("transformation/panama.atl"))
				.sourcePackage(PanamaNeo4jPackage.eINSTANCE).targetPackage(PanamaRelationalPackage.eINSTANCE).build();
		
		GraphDatabaseService graphdb = new GraphDatabaseFactory().newEmbeddedDatabase(new File("db/panama.graphdb"));
		JdbcDataSource ds = new JdbcDataSource();
		ds.setUrl("jdbc:h2:~/testH2");
		ds.setUser("test");
		ds.setPassword("test");
		Connection c = ds.getConnection();
		c.createStatement()
		.execute(
				"create table if not exists PanamaOfficers (id integer not null auto_increment, name varchar(500), company varchar(200), primary key (id));");

		long begin = System.currentTimeMillis();

		DefaultEmbeddedNeo4j3Datastore graphMapping = new DefaultEmbeddedNeo4j3Datastore(graphdb);
		DefaultJdbcDatastore jdbcMapping = new DefaultJdbcDatastore(c);
		
		Map<String, Object> options = new HashMap<>();
		options.put(GremlinScriptRunner.PRINT_SCRIPT_OPTION, true);
		options.put(ATLQueryProcessor.TRANSFORMATION_HELPER_KEY, new DummyATLTransformationHelper<Node, JdbcElement>(graphMapping, jdbcMapping));
		options.put(AbstractATLProcessor.ATL_DEBUG_KEY, true);
		
		ATLQueryProcessor processor = new ATLQueryProcessor();
		processor.process((ATLQuery)query, Arrays.asList(graphMapping, jdbcMapping), options);
	
		c.commit();
		
		long end = System.currentTimeMillis();
		
		System.out.println(MessageFormat.format("Time to compute the query: {0}", (end - begin)));
		
		
		Statement result = c.createStatement();
		result.execute("select * from PanamaOfficers;");
		ResultSet rSet = result.getResultSet();
		int c2 = 0;
		while(rSet.next()) {
			c2++;
		}
		System.out.println("H2 contains " + c2 + " lines");
		c.close();
		
		graphdb.shutdown();
		
//		Thread.sleep(500000);
		
	}
	
}
