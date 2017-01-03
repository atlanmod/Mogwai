package fr.inria.atlanmod.mogwai.query.builder;

import java.util.HashMap;
import java.util.Map;

import fr.inria.atlanmod.mogwai.query.MogwaiGremlinQuery;

public class MogwaiGremlinQueryBuilder extends AbstractMogwaiQueryBuilder<MogwaiGremlinQueryBuilder> {
	
	private Map<String, Object> bindings;
	
	protected MogwaiGremlinQueryBuilder() {
		bindings = new HashMap<>();
	}
	
	public static MogwaiGremlinQueryBuilder newBuilder() {
		return new MogwaiGremlinQueryBuilder();
	}
	
	public MogwaiGremlinQueryBuilder bind(String key, Object value) {
		bindings.put(key, value);
		return me();
	}
	
	public MogwaiGremlinQueryBuilder bindAll(Map<String, Object> bindings) {
		this.bindings.putAll(bindings);
		return me();
	}
	
	@Override
	protected MogwaiGremlinQuery buildQuery() {
		return new MogwaiGremlinQuery(input, bindings);
	}
	
}
