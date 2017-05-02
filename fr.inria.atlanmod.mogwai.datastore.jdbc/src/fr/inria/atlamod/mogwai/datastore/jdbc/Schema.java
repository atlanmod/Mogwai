package fr.inria.atlamod.mogwai.datastore.jdbc;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Schema {

	public static Schema newSchema() {
		return new Schema();
	}

	protected Map<String, List<ColumnSpecification>> internalSchema;

	protected Schema() {
		internalSchema = new HashMap<>();
	}

	public Schema setTable(String tableName) {
		internalSchema.put(tableName, new ArrayList<ColumnSpecification>());
		return this;
	}

	public Schema setAttribute(String tableName, String attName, String attType) {
		getColumnsForTable(tableName).add(new ColumnSpecification(attName, attType));
		return this;
	}

	public Schema setReference(String sourceTable, String refName, String targetTable) {
		getColumnsForTable(sourceTable).add(new ColumnSpecification(refName, targetTable, targetTable));
		return this;
	}

	public Iterable<String> getAllTables() {
		return internalSchema.keySet();
	}

	public Iterable<String> getAttributeNamesFor(String table) {
		Stream<String> s = StreamSupport.stream(getColumnsForTable(table.toUpperCase()).spliterator(), false).map(cs -> cs.getColumnName());
		return s::iterator;
	}

	public Iterable<String> getAttributeTypesFor(String table) {
		Stream<String> s = StreamSupport.stream(getColumnsForTable(table).spliterator(), false).map(cs -> cs.getSQLType());
		return s::iterator;
	}

//	public Iterable<String> getReferenceNamesFor(String table) {
//		
//	}
//
//	public Iterable<String> getReferencedTypesFor(String table);

	private List<ColumnSpecification> getColumnsForTable(String tableName) {
		if (internalSchema.containsKey(tableName)) {
			return internalSchema.get(tableName);
		} else {
			throw new IllegalArgumentException(MessageFormat.format(
					"Cannot get the specification of {0}, the table doesn't exist", tableName));
		}
	}

	private class ColumnSpecification {

		private String name;

		private String sqlType;

		private String foreignKeyFor;

		public ColumnSpecification(String name, String sqlType) {
			this.name = name;
			this.sqlType = sqlType;
			this.foreignKeyFor = "";
		}

		public ColumnSpecification(String name, String sqlType, String foreignTypeFor) {
			this(name, sqlType);
			this.foreignKeyFor = foreignTypeFor;
		}

		public String getColumnName() {
			return name;
		}

		public String getSQLType() {
			return sqlType;
		}

		public String isForeignKeyFor() {
			return foreignKeyFor;
		}

	}

}
