package fr.inria.atlanmod.mogwai.query.builder;

import fr.inria.atlanmod.mogwai.query.GremlinQuery;

public class GremlinQueryBuilder extends AbstractMogwaiQueryBuilder<GremlinQueryBuilder> {
	
	protected GremlinQueryBuilder() {

	}
	
	public static GremlinQueryBuilder newBuilder() {
		return new GremlinQueryBuilder();
	}
	
	@Override
	protected GremlinQuery buildQuery() {
		return new GremlinQuery(input);
	}
	
}
