package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.sun.istack.internal.Nullable;
import com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine;

import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

/**
 * Utility class that runs a Gremlin script on a given database. This feature is in a dedicated class because it
 * is used by several {@link MogwaiProcessor}.
 *
 * @author Gwendal DANIEL
 */
public class GremlinScriptRunner<D> {

	private final ScriptEngine engine;
	private final Bindings bindings;
	
	public static <D>GremlinScriptRunner<D> getInstance() {
		return Holder.INSTANCE;
	}
	
	private GremlinScriptRunner() {
		ScriptEngineManager scriptManager = new ScriptEngineManager();
		scriptManager.registerEngineName("gremlin-groovy",
				new com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngineFactory());
		engine = scriptManager.getEngineByName("gremlin-groovy");
		bindings = engine.createBindings();
	}
	
	/**
	 * 
	 * Run the provided query on the given backend using a dedicated Gremlin script engine.
	 * 
	 * @param literalQuery the query to execute
	 * @param arg an argument representing the current element if relevant (can be null for global queries)
	 * @param graphBackend the database to compute the query against
	 * @param customBindings additional bindings needed by the query (usually provided by the calling {@link MogwaiProcessor}
	 * @return a raw object representing the query result
	 */
	public Object runGremlinScript(String literalQuery, @Nullable Object arg, D datastore, @Nullable Map<String, Object> customBindings) {
		checkNotNull(datastore, "Cannot compute a query without a graph");
		checkNotNull(literalQuery, "Null is not a valid query");
		long begin = System.currentTimeMillis();
		NeoLogger.info("Computing Gremlin Script \n{0}", literalQuery);
//		bindings.put("g", graphBackend.getGraph());
		bindings.put("g", datastore);
		// This should not be set here, it depends on the implementation (and if we are computing OCL / ATL etc)
//		if(!Objects.isNull(arg)) {
//			// TODO handle other variables than self
//			if(arg instanceof PersistentEObject) {
//				bindings.put("self", graphBackend.getVertex(((PersistentEObject) arg).id()));
//			}
//			else if(arg instanceof List) {
//				List<Vertex> selfVertices = new ArrayList<Vertex>();
//			    for(Object a : (List<?>)arg) {
//			        if(a instanceof PersistentEObject) {
//			            selfVertices.add(graphBackend.getVertex(((PersistentEObject) a).id()));
//			        }
//			    }
//			    bindings.put("self", selfVertices);
//			}
//		}
		if(customBindings != null) {
			bindings.putAll(customBindings);
		}
		Object result = null;
		try {
			long beginCompil = System.currentTimeMillis();
			CompiledScript compiled = ((GremlinGroovyScriptEngine) engine).compile(literalQuery);
			long endCompil = System.currentTimeMillis();
			NeoLogger.info("Script Compilation Time: {0}ms", (endCompil - beginCompil));
			result = compiled.eval(bindings);
			long endEval = System.currentTimeMillis();
			NeoLogger.info("Script Evaluation Time: {0}ms", (endEval - endCompil));
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		bindings.clear();
		long end = System.currentTimeMillis();
		NeoLogger.info("Query Computation Time: {0}ms", (end-begin));
		return result;
	}
	
	public Object runGremlinScript(GremlinScript gScript, @Nullable Object arg, D datastore, @Nullable Map<String, Object> customBindings) {
		checkNotNull(gScript, "Null is not a valid query");
		return runGremlinScript(gScript.toString(), arg, datastore, customBindings);
	}
	
	private static class Holder {
		
		private static final GremlinScriptRunner INSTANCE = new GremlinScriptRunner();
		
	}
	
}
