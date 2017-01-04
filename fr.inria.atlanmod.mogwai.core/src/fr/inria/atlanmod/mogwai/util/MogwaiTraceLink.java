package fr.inria.atlanmod.mogwai.util;

import java.util.Map;

import org.eclipse.m2m.atl.emftvm.trace.TraceLink;

import com.tinkerpop.blueprints.Vertex;

import fr.inria.atlanmod.mogwai.processor.MogwaiATLProcessor;

/**
 * A lightweight implementation of ATL {@link TraceLink} used by {@link MogwaiATLProcessor}
 * to store links between created {@link Vertex}
 * 
 * @author Gwendal DANIEL
 *
 */
public class MogwaiTraceLink {

	// Convenient field, used to debug / toString trace links
	private Vertex sourceElement;
	private Map<String, Vertex> bindings;
	
	// Derived, it is basically the first one in the bindings Map
	private Vertex defaultTargetElement;
	
	/**
	 * Creates a new {@link MogwaiTraceLink} with the given source {@link Vertex}
	 * @param source the source {@link Vertex}
	 */
	public MogwaiTraceLink(Vertex source) {
		this.sourceElement = source;
	}
	
	/**
	 * Add a binding to a new target {@link Vertex} using the given pattern
	 * @param pattern the pattern to bind the target {@link Vertex} to
	 * @param target the element to bind
	 */
	public void addBinding(String pattern, Vertex target) {
		bindings.put(pattern, target);
		// Naive implementation, need to be tested
		if(defaultTargetElement == null) {
			defaultTargetElement = target;
		}
	}
	
	/**
	 * @return the default target {@link Vertex} of the trace link
	 */
	public Vertex getDefaultTarget() {
		return defaultTargetElement;
	}
	
	/**
	 * 
	 * @param pattern the pattern binding the target {@link Vertex}
	 * @return the linked element if it exists, {@code null} otherwise
	 */
	public Vertex getBindedTarget(String pattern) {
		return bindings.get(pattern);
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(sourceElement.getId())
			.append(" -> {");
		String delim = "";
		for(String pat : bindings.keySet()) {
			buffer.append(delim)
				.append(pat)
				.append("=")
				.append(bindings.get(pat).getId());
			delim = ",";
		}
		buffer.append("}");
		return buffer.toString();
	}
}
