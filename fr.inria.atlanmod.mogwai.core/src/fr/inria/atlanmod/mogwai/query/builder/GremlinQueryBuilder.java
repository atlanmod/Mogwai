package fr.inria.atlanmod.mogwai.query.builder;

import java.util.HashMap;
import java.util.Map;

import fr.inria.atlanmod.mogwai.query.GremlinQuery;

public class GremlinQueryBuilder extends AbstractMogwaiQueryBuilder<GremlinQueryBuilder> {
	
	private Map<String, Object> bindings;
	
	protected GremlinQueryBuilder() {
		bindings = new HashMap<>();
	}
	
	public static GremlinQueryBuilder newBuilder() {
		return new GremlinQueryBuilder();
	}
	
	public GremlinQueryBuilder bind(String key, Object value) {
		bindings.put(key, value);
		return me();
	}
	
	public GremlinQueryBuilder bindAll(Map<String, Object> bindings) {
		this.bindings.putAll(bindings);
		return me();
	}
	
	@Override
	protected GremlinQuery buildQuery() {
		return new GremlinQuery(input, bindings);
	}
	
}
