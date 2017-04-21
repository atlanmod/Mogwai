package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.nonNull;

import java.util.Map;

import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.gremlin.printers.GremlinPrinter;
import fr.inria.atlanmod.mogwai.gremlin.printers.GremlinPrinterFactory;

/**
 * Utility class that runs a Gremlin script on a given database. This feature is
 * in a dedicated class because it is used by several {@link AbstractQueryProcessor}.
 *
 * @author Gwendal DANIEL
 */
public class GremlinScriptRunner {

	private final ScriptEngine engine;
	private final Bindings bindings;

	public static final String PRINT_SCRIPT_OPTION = "print.script";
	
	public static final String PRINTER_OPTION = "printer";

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
	 *            the calling {@link AbstractQueryProcessor}
	 * @return a raw object representing the query result
	 */
	public Object runGremlinScript(GremlinScript script, Map<String, Object> bindings, Map<String, Object> options) {
		checkNotNull(script, "{0} is not a valid query", script);
		boolean print = getPrintOption(options);
		if (print) {
			printGremlinScript(script, options);
		}
		if (bindings != null) {
			this.bindings.putAll(bindings);
		}
		String literalScript = script.toString();
		Object result = null;
		try {
			long beginCompil = System.currentTimeMillis();
			CompiledScript compiled = ((GremlinGroovyScriptEngine) engine).compile(literalScript);
			long endCompil = System.currentTimeMillis();
			if(print) {
				MogwaiLogger.info("Script compiled in {0}ms", (endCompil - beginCompil));
			}
			result = compiled.eval(this.bindings);
			long endEval = System.currentTimeMillis();
			if(print) {
				MogwaiLogger.info("Query computed in {0}ms", (endEval - endCompil));
			}
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		this.bindings.clear();
		return result;
	}

	public void printGremlinScript(GremlinScript script, Map<String, Object> options) {
		boolean print = getPrintOption(options);
		if(print) {
			GremlinPrinter printer;
			if(nonNull(getPrinterOption(options))) {
				printer = GremlinPrinterFactory.getPrinter(getPrinterOption(options));
			}
			else {
				printer = GremlinPrinterFactory.getDefaultPrinter();
			}
			MogwaiLogger.info("Computing Gremlin Script \n{0}", printer.print(script));
		}
	}

	private boolean getPrintOption(Map<String, Object> options) {
		boolean print = false;
		if (options.containsKey(PRINT_SCRIPT_OPTION)) {
			print = (boolean) options.get(PRINT_SCRIPT_OPTION);
		}
		return print;
	}
	
	private String getPrinterOption(Map<String, Object> options) {
		String printerId = null;
		if(options.containsKey(PRINTER_OPTION)) {
			printerId = (String) options.get(PRINTER_OPTION);
		}
		return printerId;
	}

	private static class Holder {

		private static final GremlinScriptRunner INSTANCE = new GremlinScriptRunner();

	}

}
