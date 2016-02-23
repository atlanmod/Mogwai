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
import com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngine;

import fr.inria.atlanmod.mogwai.transformation.OCL2GremlinRunner;
import fr.inria.atlanmod.neoemf.core.PersistentEObject;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackend;

public class Mogwai {
	
	public MogwaiQueryResult performQuery(Constraint exp, Object obj, Resource resource, BlueprintsPersistenceBackend graph) {
		EPackage resourcePackage = resource.getContents().get(0).eClass().getEPackage();
		OCL2GremlinRunner runner = new OCL2GremlinRunner();
//		long begin = System.currentTimeMillis();
		EObject gremlinScript = runner.transform(resourcePackage, exp);
//		long end = System.currentTimeMillis();
//		System.out.println("Transformation time : " + (end-begin) + " ms");
//		begin = System.currentTimeMillis();
		MogwaiQueryResult qr = new MogwaiQueryResult(runQuery(gremlinScript.toString(), obj, graph),graph);
//		end = System.currentTimeMillis();
//		System.out.println("Query time : " + (end-begin) + " ms");
		return qr;
	}
	
	private Object runQuery(String gremlinScript, Object obj, BlueprintsPersistenceBackend graph) {
		System.out.println(gremlinScript);
//		long begin = System.currentTimeMillis();
	    ScriptEngineManager manager = new ScriptEngineManager();
		manager.registerEngineName("gremlin-groovy", new com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngineFactory()); 
		ScriptEngine engine = manager.getEngineByName("gremlin-groovy");
//		long end = System.currentTimeMillis();
//		System.out.println("Script Engine creation : " + (end-begin) + " ms");
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
//			begin = System.currentTimeMillis();
				result = ((GremlinGroovyScriptEngine)engine).compile(
						gremlinScript).eval(bindings);
//			end = System.currentTimeMillis();
//			System.out.println("Eval time " + (end-begin) + " ms");
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return result;
	}
}
