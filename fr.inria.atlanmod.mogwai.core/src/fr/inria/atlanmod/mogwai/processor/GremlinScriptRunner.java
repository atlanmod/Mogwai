package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.text.MessageFormat;
import java.util.Map;

import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine;

import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;

/**
 * Utility class that runs a Gremlin script on a given database. This feature is in a dedicated class because it
 * is used by several {@link MogwaiProcessor}.
 *
 * @author Gwendal DANIEL
 */
public class GremlinScriptRunner {

	private final ScriptEngine engine;
	private final Bindings bindings;
	
	public static final String PRINT_SCRIPT_OPTION = "print.script";
	
	public static GremlinScriptRunner getInstance() {
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
	public Object runGremlinScript(String literalQuery, Map<String, Object> bindings, Map<String, Object> options) {
//		checkNotNull(datastore, "Cannot compute a query without a graph");
		checkNotNull(literalQuery, "{0} is not a valid query", literalQuery);
		long begin = System.currentTimeMillis();
		if(options.containsKey(PRINT_SCRIPT_OPTION)) {
			boolean print = (boolean)options.get(PRINT_SCRIPT_OPTION);
			if(print) {
				System.out.println(MessageFormat.format("Computing Gremlin Script \n{0}", literalQuery));
			}
		}
//		bindings.put("g", graphBackend.getGraph());
//		bindings.put("g", datastore);
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
		if(bindings != null) {
			this.bindings.putAll(bindings);
		}
		Object result = null;
		try {
			long beginCompil = System.currentTimeMillis();
			CompiledScript compiled = ((GremlinGroovyScriptEngine) engine).compile(literalQuery);
			long endCompil = System.currentTimeMillis();
			System.out.println(MessageFormat.format("Script Compilation Time: {0}ms", (endCompil - beginCompil)));
			result = compiled.eval(this.bindings);
			long endEval = System.currentTimeMillis();
			System.out.println(MessageFormat.format("Script Evaluation Time: {0}ms", (endEval - endCompil)));
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		this.bindings.clear();
		long end = System.currentTimeMillis();
		System.out.println(MessageFormat.format("Query Computation Time: {0}ms", (end-begin)));
		return result;
	}
	
	public Object runGremlinScript(GremlinScript gScript, Map<String, Object> bindings, Map<String, Object> options) {
		checkNotNull(gScript, "Null is not a valid query");
		return runGremlinScript(gScript.toString(), bindings, options);
	}
	
	private static class Holder {
		
		private static final GremlinScriptRunner INSTANCE = new GremlinScriptRunner();
		
	}
	
}
