package fr.inria.atlanmod.mogwai.query.builder;

import fr.inria.atlanmod.mogwai.query.MogwaiGremlinQuery;

public class MogwaiGremlinQueryBuilder extends AbstractMogwaiQueryBuilder<MogwaiGremlinQueryBuilder> {
	
	protected MogwaiGremlinQueryBuilder() {
		
	}
	
	public static MogwaiGremlinQueryBuilder newBuilder() {
		return new MogwaiGremlinQueryBuilder();
	}
	
	@Override
	protected MogwaiGremlinQuery buildQuery() {
		return new MogwaiGremlinQuery(input);
	}
	
}
