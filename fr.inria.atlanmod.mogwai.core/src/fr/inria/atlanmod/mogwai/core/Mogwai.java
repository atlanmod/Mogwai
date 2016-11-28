package fr.inria.atlanmod.mogwai.core;

import java.util.ArrayList;
import java.util.List;

import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.Constraint;

import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine;

import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.transformation.files.OCL2Gremlin;
import fr.inria.atlanmod.neoemf.core.PersistentEObject;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackend;

public class Mogwai {
	
	private OCL2Gremlin runner;
	private ScriptEngine engine;
	private Bindings bindings;
	
	public Mogwai() {
		runner = new OCL2Gremlin();
		ScriptEngineManager manager = new ScriptEngineManager();
		manager.registerEngineName("gremlin-groovy", new com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngineFactory());
		engine = manager.getEngineByName("gremlin-groovy");
		bindings = engine.createBindings();
	}
	
	public MogwaiQueryResult gPerformQuery(String gScript, Resource resource, BlueprintsPersistenceBackend graph) {
		return this.gPerformQuery(gScript, null, resource, graph);
	}
	
	public MogwaiQueryResult gPerformQuery(String gScript, Object context, Resource resource, BlueprintsPersistenceBackend graph) {
		MogwaiQueryResult qr = new MogwaiQueryResult(runQuery(gScript, context, graph), graph, null);
		return qr;
	}
	
	public MogwaiQueryResult performQuery(Constraint exp, Object obj, Resource resource, BlueprintsPersistenceBackend graph) {
		EPackage resourcePackage = resource.getContents().get(0).eClass().getEPackage();
		EObject gremlinScript = runner.transform(resourcePackage, exp);
		assert gremlinScript instanceof GremlinScript : "OCL2Gremlin did not create a GremlinScript element";
		MogwaiQueryResult qr = new MogwaiQueryResult(runQuery(gremlinScript.toString(), obj, graph),graph,(GremlinScript)gremlinScript);
		return qr;
	}
	
	@SuppressWarnings("rawtypes")
	private Object runQuery(String gremlinScript, Object obj, BlueprintsPersistenceBackend graph) {
		System.out.println(gremlinScript.toString());
		bindings.put("g", graph);
		if(obj != null) {
			// TODO handle non object arguments
			if(obj instanceof PersistentEObject) {
				bindings.put("self",graph.getVertex((PersistentEObject)obj));
			}
			else if(obj instanceof List) {
			    List<Vertex> selfVertices = new ArrayList<Vertex>();
			    for(Object o : (List)obj) {
			        if(o instanceof PersistentEObject) {
			            selfVertices.add(graph.getVertex((PersistentEObject)o));
			        }
			    }
			    bindings.put("self", selfVertices);
			}
		}
		Object result = null;
		try {
			CompiledScript compiled = ((GremlinGroovyScriptEngine)engine).compile(
					gremlinScript);
			result = compiled.eval(bindings);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		bindings.clear();
		return result;
	}
	
	public void enableATLDebug() {
		runner.enableATLDebug();
	}
	
	public void disableATLDebug() {
		runner.disableATLDebug();
	}
}
