package fr.inria.atlanmod.mogwai.datastore.jdbc;

import static java.util.Objects.nonNull;
import static java.util.Objects.isNull;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesDatastore;

// There is no EPackage, tables are used to represent elements, attributes, and references
// This is clearly not the best mapping if we have informations on the schema
// This is work in progress, a full working implementation of this mapping is planned for a future release
// Only supports auto-increment ID fields for elements, and varchar attributes
public class DefaultJdbcDatastore implements ModelDatastore<Connection, JdbcElement, Object, Object>,
		PipesDatastore<Connection, JdbcElement, Object, Object> {

	/**
	 * The {@link Connection} instance containing the model to manipulate.
	 */
	private Connection connection;

	/**
	 * The {@link Schema} instance used to represent the underlying database schema.
	 * 
	 * @see Schema
	 */
	private Schema schema;
	
	private String elementToCreate;
	
	private Map<String, String> valuesToSet;

	public DefaultJdbcDatastore(Connection connection) {
		setDataSource(connection);
	}

	private static final String ALL_INSTANCES_SQL = "select ID from {0};";

	private static final String INSERT_ELEMENT_SQL = "insert into {0} values ({1});";
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * If a {@link Connection} is already set the pending {@link Statement}s are
	 * committed and closed. Note that this implementation doesn't provide an
	 * autocommit feature, and will perform all the requested operations within
	 * a single transaction.
	 * <p>
	 * TODO handle autocommit feature in a dedicated subclass.
	 * 
	 * @see DefaultJdbcDatastore#DefaultJdbcDatastore(Connection)
	 */
	@Override
	public void setDataSource(Connection dataSource) {
		try {
			if(nonNull(this.connection)) {
				this.connection.commit();
				this.connection.close();
			}
			this.elementToCreate = "";
			this.valuesToSet = new HashMap<>();
			this.connection = dataSource;
			this.schema = Schema.newSchema();
			DatabaseMetaData metaData = connection.getMetaData();
			
			ResultSet tables = metaData.getTables(null, "PUBLIC", null, null);
			while(tables.next()) {
				String tableName = tables.getString(3);
				System.out.println("found table " + tableName);
				schema.setTable(tableName);
				ResultSet columns = metaData.getColumns(null, null, tableName, null);
				while(columns.next()) {
					String columnName = columns.getString(4);
					String columnType = columns.getString(6);
					System.out.println("found column " + columns.getString(4));
					System.out.println("column type " + columnType);
					schema.setAttribute(tableName, columnName, columnType);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Connection getDataSource() {
		return connection;
	}

	@Override
	public Iterable<JdbcElement> allOfType(String typeName) {
		Iterable<JdbcElement> result = null;
		try {
			Statement statement = connection.createStatement();
			statement.execute((createAllOfTypeStatement(typeName)));
			ResultSet resultSet = statement.getResultSet();
			result = elementIterableFrom(resultSet, typeName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Iterable<JdbcElement> allOfKind(String typeName) {
		return allOfType(typeName);
	}

	@Override
	public JdbcElement newInstance(String typeName, String typePackageNsURI, String resourceName) {
		createLastElement();
		this.elementToCreate = typeName;
		Iterable<String> attributes = schema.getAttributeNamesFor(typeName);
		for(String att : attributes) {
			valuesToSet.put(att, null);
		}
		// Place holder
		return new JdbcElement(-10, typeName);
	}

	@Override
	public JdbcElement getParent(JdbcElement from) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Iterable<JdbcElement> getRef(JdbcElement from, String refName, String oppositeName, boolean isContainer) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Object setRef(JdbcElement from, String refName, String oppositeName, JdbcElement to, boolean isContainment) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public JdbcElement removeRef(JdbcElement from, String refName, JdbcElement to, boolean isContainment) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Iterable<Object> getAtt(JdbcElement from, String attName) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public JdbcElement setAtt(JdbcElement from, String attName, Object attValue) {
		valuesToSet.put(attName.toUpperCase(), (String)attValue);
		return from;
	}

	@Override
	public String getType(JdbcElement from) {
		return from.getType();
	}

	@Override
	public boolean isTypeOf(JdbcElement from, String type) {
		return from.getType().equals(type);
	}

	@Override
	public boolean isKindOf(JdbcElement from, String type) {
		return from.getType().equals(type);
	}

	private static String createAllOfTypeStatement(String typeName) {
		return MessageFormat.format(ALL_INSTANCES_SQL, typeName);
	}

	private static Iterable<JdbcElement> elementIterableFrom(ResultSet resultSet, String typeName) throws SQLException {
		List<JdbcElement> result = new ArrayList<>();
		while (resultSet.next()) {
			result.add(new JdbcElement(resultSet.getInt(1), typeName));
		}
		return result;
	}
	
	private void createLastElement() {
		if(isNull(elementToCreate) || elementToCreate.isEmpty()) {
			return;
		}
		StringBuilder attBuilder = new StringBuilder();
		String delim = "";
		for(String att : valuesToSet.keySet()) {
			attBuilder.append(delim);
			if(isNull(valuesToSet.get(att))) {
				attBuilder.append("NULL");
			}
			else {
				attBuilder.append("'").append(valuesToSet.get(att).replace("'", "''")).append("'");
			}
			delim = ",";
		}
		try {
			Statement statement = connection.createStatement();
			statement.execute(MessageFormat.format(INSERT_ELEMENT_SQL, elementToCreate, attBuilder.toString()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
