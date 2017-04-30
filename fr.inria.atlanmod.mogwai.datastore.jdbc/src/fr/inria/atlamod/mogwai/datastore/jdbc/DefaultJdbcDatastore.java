package fr.inria.atlamod.mogwai.datastore.jdbc;

import java.sql.Connection;

public class DefaultJdbcDatastore {
	
	public static void main(String[] args) throws Exception {
//		JdbcDataSource ds = new JdbcDataSource();
//		ds.setUrl("jdbc:h2:/tmp/testH2");
//		ds.setUser("test");
//		ds.setPassword("test");
		Connection c = null; //= ds.getConnection();
		c.createStatement().execute("SELECT * from myTable");
		c.commit();
		c.close();
	}

}
