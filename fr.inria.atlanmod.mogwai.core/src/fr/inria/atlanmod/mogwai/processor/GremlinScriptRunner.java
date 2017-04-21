package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;

/**
 * Utility class that runs a Gremlin script on a given database. This feature is
 * in a dedicated class because it is used by several {@link MogwaiProcessor}.
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
	 * Run the provided query on the given backend using a dedicated Gremlin
	 * script engine.
	 * 
	 * @param literalQuery
	 *            the query to execute
	 * @param arg
	 *            an argument representing the current element if relevant (can
	 *            be null for global queries)
	 * @param graphBackend
	 *            the database to compute the query against
	 * @param customBindings
	 *            additional bindings needed by the query (usually provided by
	 *            the calling {@link MogwaiProcessor}
	 * @return a raw object representing the query result
	 */
	public Object runGremlinScript(String literalQuery, Map<String, Object> bindings, Map<String, Object> options) {
		// checkNotNull(datastore, "Cannot compute a query without a graph");
		checkNotNull(literalQuery, "{0} is not a valid query", literalQuery);
		boolean print = getPrintOption(options);
		if (print) {
			MogwaiLogger.info("Computing Gremlin Script \n{0}", literalQuery);
		}
		if (bindings != null) {
			this.bindings.putAll(bindings);
		}
		Object result = null;
		try {
			long beginCompil = System.currentTimeMillis();
			CompiledScript compiled = ((GremlinGroovyScriptEngine) engine).compile(literalQuery);
			long endCompil = System.currentTimeMillis();
			if (print) {
				MogwaiLogger.info("Script compiled in {0}ms", (endCompil - beginCompil));
			}
			result = compiled.eval(this.bindings);
			long endEval = System.currentTimeMillis();
			if (print) {
				MogwaiLogger.info("Query computed in {0}ms", (endEval - endCompil));
			}
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		this.bindings.clear();
		return result;
	}

	public Object runGremlinScript(GremlinScript gScript, Map<String, Object> bindings, Map<String, Object> options) {
		checkNotNull(gScript, "Null is not a valid query");
		return runGremlinScript(gScript.toString(), bindings, options);
	}

	private boolean getPrintOption(Map<String, Object> options) {
		boolean print = false;
		if (options.containsKey(PRINT_SCRIPT_OPTION)) {
			print = (boolean) options.get(PRINT_SCRIPT_OPTION);
		}
		return print;
	}

	private static class Holder {

		private static final GremlinScriptRunner INSTANCE = new GremlinScriptRunner();

	}

}
