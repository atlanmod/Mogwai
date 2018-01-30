package fr.inria.atlanmod.mogwai.applications.panama;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import org.h2.jdbcx.JdbcDataSource;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class PanamaBase {

	public static void main(String[] args) throws Exception {
		
		long begin = System.currentTimeMillis();
		
		GraphDatabaseService graphdb = new GraphDatabaseFactory().newEmbeddedDatabase(new File("db/panama.graphdb"));
		registerShutdownHook(graphdb);
		
		JdbcDataSource ds = new JdbcDataSource();
		ds.setUrl("jdbc:h2:~/test");
		ds.setUser("sa");
//		ds.setPassword("test");
		Connection c = ds.getConnection();
		
		c.createStatement()
		.execute(
				"create table if not exists PanamaOfficers (id integer not null auto_increment, name varchar(500), company varchar(200), primary key (id));");
		
		c.commit();
		
		int count = 0;

		try (Transaction tx = graphdb.beginTx()) {

			try (ResourceIterator<Node> officers = graphdb.findNodes(Label.label("Officer"))) {
				while (officers.hasNext()) {
					Node off = officers.next();
					Iterable<Relationship> rels = off.getRelationships(Direction.OUTGOING, RelationshipType.withName("OFFICER_OF"));
					for (Relationship r : rels) {
						Node head = r.getEndNode();
							if(off.hasProperty("name") && head.hasProperty("name")) {
								String officerName = (String)off.getProperty("name");
								String companyName = (String)head.getProperty("name");
								count++;
								c.createStatement().execute("insert into PanamaOfficers values (NULL, '" + officerName.replace("'", "''") + "', '" + companyName.replace("'", "''") + "');");
								break;
							}
					}
				}
				officers.close();
			}
		}
		System.out.println("FOUND " + count + " little thieves ;)");
		c.commit();
		
		long end = System.currentTimeMillis();
		
		System.out.println(MessageFormat.format("Time to perform the query: {0}ms", (end-begin)));
		
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
	}

	private static void registerShutdownHook(final GraphDatabaseService graphDb) {
		// Registers a shutdown hook for the Neo4j instance so that it
		// shuts down nicely when the VM exits (even if you "Ctrl-C" the
		// running application).
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				graphDb.shutdown();
			}
		});
	}

}
