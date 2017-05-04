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
	
	public CustomGremlinGroovyPipeline<S, E> _() {
		return this;
	}
	
	public CustomGremlinGroovyPipeline<S, E> getAtt(String attName) {
		return (CustomGremlinGroovyPipeline<S, E>) this.add(datastore.getAtt(attName));
	}
	
	public CustomGremlinGroovyPipeline<S, E> getRef(String refName, String oppositeName, boolean isContainer) {
		return (CustomGremlinGroovyPipeline<S, E>) this.add(datastore.getRef(refName, oppositeName, isContainer));
	}
	
	public String getString() {
		Iterator<E> content = iterator();
		String value = content.next().toString();
		if(content.hasNext()) {
			throw new IllegalStateException("Calling toString on an Iterable that contain more than one element");
		}
		return value;
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
