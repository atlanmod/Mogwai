package fr.inria.atlanmod.mogwai.datastore.jdbc;

public class JdbcElement {

	private int id;
	private String type;

	public JdbcElement(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(id) + type.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof JdbcElement) {
			return this == obj || (((JdbcElement) obj).getId() == id && ((JdbcElement) obj).getType().equals(type));
		}
		return super.equals(obj);
	}

}
