package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import com.sun.istack.internal.Nullable;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.MogwaiOCLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.transformation.files.OCL2Gremlin;
import fr.inria.atlanmod.neoemf.core.PersistentEObject;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.logging.NeoLogger;

public class MogwaiOCLProcessor extends MogwaiProcessor<MogwaiOCLQuery> {

	private static final String NAME = "OCL Processor";

	private final OCL2Gremlin transformation;
	private final ScriptEngine engine;
	private final Bindings bindings;
	private BlueprintsPersistenceBackend graphBackend;

	public MogwaiOCLProcessor() {
		transformation = new OCL2Gremlin();
		ScriptEngineManager scriptManager = new ScriptEngineManager();
		scriptManager.registerEngineName("gremlin-groovy",
				new com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngineFactory());
		engine = scriptManager.getEngineByName("gremlin-groovy");
		bindings = engine.createBindings();
	}
	
	public MogwaiOCLProcessor(BlueprintsPersistenceBackend graphBackend) {
		this();
		checkNotNull(graphBackend, "Cannot instanciate a processor without a graph");
		this.graphBackend = graphBackend;
		
	}

	@Override
	public String getName() {
		return NAME;
	}
	
	public void setGraphBackend(BlueprintsPersistenceBackend graphBackend) {
		this.graphBackend = graphBackend;
	}
	
	public void enableATLDebug() {
		transformation.enableATLDebug();
	}
	
	public void disableATLDebug() {
		transformation.disableATLDebug();
	}

	@Override
	public MogwaiQueryResult internalProcess(MogwaiOCLQuery query, @Nullable Object arg) {
		checkNotNull(graphBackend, "Cannot compute a query without a graph");
		GremlinScript gScript = createGremlinScript(query);
		Object result = runGremlinScript(gScript, arg);
		return adaptResult(result, gScript);
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof MogwaiOCLQuery;
	}
	
	private GremlinScript createGremlinScript(MogwaiOCLQuery query) {
		EPackage ePackage = query.getContext().getEPackage();
		EObject transformedQuery = transformation.transform(ePackage, query.getConstraint());
		if (transformedQuery instanceof GremlinScript) {
			return (GremlinScript) transformedQuery;
		} else {
			throw new MogwaiException(
					"An error in the transformation occured, enable ATL debugging for further informations");
		}
	}
	
	private Object runGremlinScript(GremlinScript gScript, Object arg) {
		NeoLogger.info("Computing Gremlin Script");
		NeoLogger.info(gScript.toString());
		// Cannot be in the constructor, the backend may change between queries
		bindings.put("g", graphBackend.getGraph());
		if(!Objects.isNull(arg)) {
			// TODO handle other variables than self
			if(arg instanceof PersistentEObject) {
				bindings.put("self", graphBackend.getVertex(((PersistentEObject) arg).id()));
			}
			else if(arg instanceof List) {
				List<Vertex> selfVertices = new ArrayList<Vertex>();
			    for(Object a : (List)arg) {
			        if(a instanceof PersistentEObject) {
			            selfVertices.add(graphBackend.getVertex(((PersistentEObject) a).id()));
			        }
			    }
			    bindings.put("self", selfVertices);
			}
		}
		Object result = null;
		try {
			CompiledScript compiled = ((GremlinGroovyScriptEngine) engine).compile(gScript.toString());
			result = compiled.eval(bindings);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		bindings.clear();
		return result;
	}
	
	private MogwaiQueryResult adaptResult(Object result, GremlinScript gScript) {
		return new MogwaiQueryResult(result, graphBackend, gScript);
	}

}
