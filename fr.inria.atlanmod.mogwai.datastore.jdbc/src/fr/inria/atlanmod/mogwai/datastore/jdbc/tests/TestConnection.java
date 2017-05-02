package fr.inria.atlanmod.mogwai.datastore.jdbc.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.h2.jdbcx.JdbcDataSource;

import fr.inria.atlamod.mogwai.datastore.jdbc.DefaultJdbcDatastore;
import fr.inria.atlamod.mogwai.datastore.jdbc.JdbcElement;

public class TestConnection {

	// We need an intermediate object that wraps element and contains the
	// element type (this is required to create the attTables for example)
	// How can we represent references to any type ?
	// 1 table with all the elements ?
	// N tables for attributes / references ?

	public static void main(String[] args) throws Exception {
		JdbcDataSource ds = new JdbcDataSource();
		ds.setUrl("jdbc:h2:/tmp/testH2");
		ds.setUser("test");
		ds.setPassword("test");
		Connection c = ds.getConnection();
		
		System.out.println("Metadatas");
		ResultSet mrs = c.getMetaData().getCatalogs();
		while(mrs.next()) {
			System.out.println(mrs.toString());
			System.out.println(mrs.getString(1));
		}
		System.out.println("done");
		System.out.println("Schemas");
		
		ResultSet srs = c.getMetaData().getSchemas();
		while(srs.next()) {
			System.out.println(srs.toString());
			System.out.println(srs.getString(1));
			System.out.println(srs.getString(2));
			System.out.println(srs.getString(3));
		}
		
		System.out.println("done");
		
		System.out.println("get tables");
		String[] tableType = {"TABLE"};
		ResultSet trs = c.getMetaData().getTables(null, "PUBLIC", null, null);
		
		while(trs.next()) {
			System.out.println(trs.toString());
			String tableName = trs.getString(3);
			System.out.println(tableName);
			ResultSet columns = c.getMetaData().getColumns(null, null, tableName, null);
			
			while(columns.next()) {
				System.out.println(columns);
				for(int i = 1; i < 24; i++) {
					System.out.println(i + ": " + columns.getObject(i));
				}
				System.out.println(columns.getString(4));
			}
		}
		System.out.println("done");
		
		c.createStatement()
				.execute(
						"create table if not exists MyTable (id integer not null auto_increment, el_name varchar(40), primary key (id));");
		c.commit();
//		c.createStatement().execute("insert into MyTable values (null, 'test')");
//		Statement mStatement = c.createStatement();
//		mStatement.execute("insert into MyTable values (null, 'test3')");
//		
//		System.out.println("EL CREATED");
//		ResultSet mResultSet = mStatement.getGeneratedKeys();
//		int key = -1;
//		while(mResultSet.next()) {
//			System.out.println(mResultSet);
//			key = mResultSet.getInt(1);
//			System.out.println(mResultSet.getInt(1));
//		}
//		
//		System.out.println("DONE");
//		
//		System.out.println("UPDATING");
//		
//		c.createStatement().execute("update MyTable set el_name = 'pouetpouet' where el_id = " + key + ";");
//		
//		System.out.println("DONE");
//		
		Statement s = c.createStatement();
		s.execute("select * from MyTable;");
		ResultSet rs = s.getResultSet();
		System.out.println(rs);
		while (rs.next()) {
			System.out.println(rs.getString(2));
		}

		// System.out.println("PS");
		// PreparedStatement ps = c.prepareStatement(ALL_INSTANCES_SQL);
		// ps.setString(1, "el_id");
		// ps.setString(2, "MyTable");
		// ResultSet rs2 = ps.executeQuery();
		// while(rs2.next()) {
		// System.out.println(rs2.getString(2));
		// }
		
		System.out.println("Creating mapping");
		
		DefaultJdbcDatastore mapping = new DefaultJdbcDatastore(c);
		JdbcElement el = mapping.newInstance("MyTable", "", "");
		mapping.setAtt(el, "el_name", "pouetpouet");
		
		Statement s2 = c.createStatement();
		s2.execute("select * from MyTable;");
		ResultSet rs2 = s2.getResultSet();
		System.out.println(rs2);
		while (rs2.next()) {
			System.out.println(rs2.getString(2));
		}
		
		c.close();

		/*
		 * create table SUPPLIERS (SUP_ID integer NOT NULL, SUP_NAME varchar(40)
		 * NOT NULL, STREET varchar(40) NOT NULL, CITY varchar(20) NOT NULL,
		 * STATE char(2) NOT NULL, ZIP char(5), PRIMARY KEY (SUP_ID));
		 */
	}
	
}
