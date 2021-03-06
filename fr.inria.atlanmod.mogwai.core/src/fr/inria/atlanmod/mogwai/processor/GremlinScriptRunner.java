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
import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.gremlin.printers.GremlinPrinter;
import fr.inria.atlanmod.mogwai.gremlin.printers.GremlinPrinterFactory;
import groovy.lang.MissingPropertyException;

/**
 * Utility class that computes a Gremlin script and returns the raw results.
 * <p>
 * This class is used to compute any script generated by Mogwai
 * {@code transformations}, as well as regular Gremlin queries.
 * <p>
 * Script execution can be parameterized with specific {@code bindings} and
 * {@code options}, allowing to tune the query computation and log execution
 * informations if necessary.
 *
 * @author Gwendal DANIEL
 */
public class GremlinScriptRunner {

	/**
	 * The underlying {@link ScriptEngine} used to compute the script.
	 */
	private final ScriptEngine engine;

	/**
	 * The script engine's {@link Bindings} used to set the value of free variables.
	 */
	private final Bindings bindings;

	/**
	 * The option key to set if the script is printed before execution.
	 */
	public static final String PRINT_SCRIPT_OPTION = "print.script";

	/**
	 * The option key to specify which {@link GremlinPrinter} to use to print the
	 * script.
	 * <p>
	 * <b>Note:</b> this option is not parsed if {@link #PRINT_SCRIPT_OPTION} is set
	 * to {@code false}.
	 */
	public static final String PRINTER_OPTION = "printer";

	/**
	 * Returns the singleton instance of this class.
	 * 
	 * @return the singleton instance of this class
	 */
	public static GremlinScriptRunner getInstance() {
		return Holder.INSTANCE;
	}

	/**
	 * Constructs a new {@link GremlinScriptRunner} and initialize its
	 * {@link ScriptEngine}.
	 * <p>
	 * <b>Note:</b> this method is private to avoid multiple instance of
	 * {@link GremlinScriptRunner} that could create concurrency issues on the
	 * underlying datastores.
	 */
	private GremlinScriptRunner() {
		ScriptEngineManager scriptManager = new ScriptEngineManager();
		scriptManager.registerEngineName("gremlin-groovy",
				new com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngineFactory());
		engine = scriptManager.getEngineByName("gremlin-groovy");
		bindings = engine.createBindings();
	}

	/**
	 * 
	 * Run the provided script using the internal Gremlin script engine.
	 * <p>
	 * <b>Note:</b> the {@link ModelDatastore}s involved in the script computation
	 * are not provided as parameters, they are set in the bindings and linked to
	 * their corresponding variables in the script.
	 * 
	 * @param script
	 *            the {@link GremlinScript} to execute
	 * @param bindings
	 *            the variables to bind in the executed query
	 * @param options
	 *            a {@link Map} containing execution options
	 * @return a raw {@link Object} representing the query result
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
			if (print) {
				MogwaiLogger.info("Script compiled in {0}ms", (endCompil - beginCompil));
			}
			result = compiled.eval(this.bindings);
			long endEval = System.currentTimeMillis();
			if (print) {
				MogwaiLogger.info("Query computed in {0}ms", (endEval - endCompil));
			}
		} catch (ScriptException e) {
			if (e.getCause() instanceof MissingPropertyException) {
				if (e.getMessage().contains("self")) {
					MogwaiLogger.error(
							"The self value is not defined for the processed query, make sure you added a context element when building the query");
				}
			}
			throw new RuntimeException(e);
		}
		this.bindings.clear();
		return result;
	}

	/**
	 * Prints the provided Gremlin {@code script}.
	 * <p>
	 * The provided {@code options} {@link Map} can be used to set the
	 * {@link GremlinPrinter} instance to use to print the {@code script} (see
	 * {@link #PRINTER_OPTION}. If no {@link GremlinPrinter} is specified the
	 * default one is used {@link GremlinPrinterFactory#getDefaultPrinter()}.
	 * 
	 * @param script
	 *            the {@link GremlinScript} to print
	 * @param options
	 *            the map containing options to customize the script printing
	 * 
	 * @see #PRINTER_OPTION
	 */
	private void printGremlinScript(GremlinScript script, Map<String, Object> options) {
		GremlinPrinter printer;
		if (nonNull(getPrinterOption(options))) {
			printer = GremlinPrinterFactory.getPrinter(getPrinterOption(options));
		} else {
			printer = GremlinPrinterFactory.getDefaultPrinter();
		}
		MogwaiLogger.info("Computing Gremlin Script \n{0}", printer.print(script));
	}

	/**
	 * Retrieves the {@link #PRINT_SCRIPT_OPTION} value from the {@code options}
	 * {@link Map}.
	 * <p>
	 * This method returns {@code false} if the {@code options} doesn't contain a
	 * {@link #PRINT_SCRIPT_OPTION} value.
	 * 
	 * @param options
	 *            the map containing the options to customize script printing
	 * @return the {@link #PRINT_SCRIPT_OPTION} value from {@code options} if it
	 *         exists, {@code false} otherwise
	 * 
	 * @see #PRINT_SCRIPT_OPTION
	 */
	private boolean getPrintOption(Map<String, Object> options) {
		boolean print = false;
		if (options.containsKey(PRINT_SCRIPT_OPTION)) {
			print = (boolean) options.get(PRINT_SCRIPT_OPTION);
		}
		return print;
	}

	/**
	 * Retrieves the {@link #PRINTER_OPTION} value from the {@code options}
	 * {@link Map}.
	 * <p>
	 * This method returns {@code null} if the {@code options} doesn't contain a
	 * {@link #PRINTER_OPTION} value.
	 * 
	 * @param options
	 *            the map containing the options to customize script printing
	 * @return the identifier of the {@link GremlinPrinter} associated to
	 *         {@link #PRINTER_OPTION} if it exists, {@code null} otherwise
	 * 
	 * @see #PRINTER_OPTION
	 * @see GremlinPrinter
	 */
	private String getPrinterOption(Map<String, Object> options) {
		String printerId = null;
		if (options.containsKey(PRINTER_OPTION)) {
			printerId = (String) options.get(PRINTER_OPTION);
		}
		return printerId;
	}

	/**
	 * A lazy holder maintaiing a singleton instance of {@link GremlinScriptRunner}.
	 */
	private static class Holder {

		/**
		 * The singleton instance of {@link GremlinScriptRunner}.
		 */
		private static final GremlinScriptRunner INSTANCE = new GremlinScriptRunner();

	}

}
