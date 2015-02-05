package fr.inria.atlanmod.mogwai;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.tinkerpop.blueprints.Graph;

public class MogwaiQueryResult implements Iterable<Object>{
	
	private Iterable<Object> queryResult = null;
	
	MogwaiQueryResult(Object engineResult, Graph graph) {
		if(engineResult instanceof Iterable){
			queryResult = (Iterable<Object>)engineResult;
		}
		else {
			// Wrap the result in an iterable collection
			queryResult = new ArrayList<Object>();
			((Collection<Object>)queryResult).add(engineResult);
		}
	}

	@Override
	public Iterator<Object> iterator() {
		return queryResult.iterator();
	}
	
	
}
