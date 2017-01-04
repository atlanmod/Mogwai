package fr.inria.atlanmod.mogwai.util;

import java.util.HashMap;
import java.util.Map;

import com.tinkerpop.blueprints.Vertex;

/**
 * Utility class that creates new {@link MogwaiTraceLink} and store them to
 * ease their access. Trace links configuration (binding creation) is delegated to client code
 * @author Gwendal DANIEL
 *
 */
public class MogwaiTraceLinkManager {
	
	private Map<Vertex, MogwaiTraceLink> traceLinks;
	
	/**
	 * Creates a new {@link MogwaiTraceLinkManager} with an empty {@link MogwaiTraceLink} registry
	 */
	public MogwaiTraceLinkManager() {
		this.traceLinks = new HashMap<>();
	}
	
	/**
	 * Creates a new {@link MogwaiTraceLink} and adds it to the registry
	 * @param sourceElement the element to create the trace link from
	 * @return the created {@link MogwaiTraceLink}
	 */
	public MogwaiTraceLink createTraceLink(Vertex sourceElement) {
		MogwaiTraceLink traceLink = new MogwaiTraceLink(sourceElement);
		traceLinks.put(sourceElement, traceLink);
		return traceLink;
	}
	
	/**
	 * @param sourceElement the source element of the {@link MogwaiTraceLink}
	 * @return the {@link MogwaiTraceLink} is it is registered, {@code null} otherwise
	 */
	public MogwaiTraceLink getTraceLink(Vertex sourceElement) {
		return traceLinks.get(sourceElement);
	}
	
}
