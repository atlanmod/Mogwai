package fr.inria.atlanmod.mogwai.datastore.pipes;

import java.util.Iterator;

import com.tinkerpop.gremlin.groovy.GremlinGroovyPipeline;

public class CustomGremlinGroovyPipeline<S, E> extends GremlinGroovyPipeline<S, E> {
	
	private PipesDatastore datastore;
	
	public CustomGremlinGroovyPipeline() {
		super();
	}
	
	public CustomGremlinGroovyPipeline(final Object starts) {
		super(starts);
	}
	
	public CustomGremlinGroovyPipeline(final Object starts, PipesDatastore datastore) {
		super(starts);
		this.datastore = datastore;
	}
	
	public CustomGremlinGroovyPipeline<S, E> getAtt(String attName) {
		return (CustomGremlinGroovyPipeline<S, E>) this.add(datastore.getAtt(attName));
	}
	
	public boolean undefined() {
		Iterator<E> content = iterator();
		boolean result = true;
		if(content.hasNext()) {
			result = (content.next() == null);
		}
		return result;
	}

}
