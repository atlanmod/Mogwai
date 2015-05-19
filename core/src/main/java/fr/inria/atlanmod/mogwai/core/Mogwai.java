package fr.inria.atlanmod.mogwai.core;

import java.util.ArrayList;
import java.util.List;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.Constraint;

import com.tinkerpop.blueprints.Vertex;

import fr.inria.atlanmod.mogwai.transformation.OCL2GremlinRunner;
import fr.inria.atlanmod.neoemf.core.PersistentEObject;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackend;

public class Mogwai {
	
	public MogwaiQueryResult performQuery(Constraint exp, Object obj, Resource resource, BlueprintsPersistenceBackend graph) {
		EPackage resourcePackage = resource.getContents().get(0).eClass().getEPackage();
		OCL2GremlinRunner runner = new OCL2GremlinRunner();
		EObject gremlinScript = runner.transform(resourcePackage, exp);
		return new MogwaiQueryResult(runQuery(gremlinScript.toString(), obj, graph),graph);
	}
	
	private Object runQuery(String gremlinScript, Object obj, BlueprintsPersistenceBackend graph) {
		System.out.println(gremlinScript);
	    ScriptEngineManager manager = new ScriptEngineManager();
		manager.registerEngineName("gremlin-groovy", new com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngineFactory()); 
		ScriptEngine engine = manager.getEngineByName("gremlin-groovy");
		Bindings bindings = engine.createBindings();
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
				result = engine.eval(
						gremlinScript
						, bindings);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return result;
	}
}
