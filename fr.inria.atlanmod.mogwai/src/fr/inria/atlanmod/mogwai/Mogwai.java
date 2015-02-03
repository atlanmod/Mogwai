package fr.inria.atlanmod.mogwai;

import java.io.File;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.Constraint;

import com.tinkerpop.blueprints.Graph;

import fr.inria.atlanmod.mogwai.transformation.OCL2GremlinTransformer;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;

public class Mogwai {
	
	private OCL2GremlinTransformer transformer;
	
	public Mogwai() {
		transformer = new OCL2GremlinTransformer();
	}
	
	public MogwaiQueryResult performQuery(Constraint exp, Object obj, EPackage pack, File dbDirectory) throws MogwaiException {
		Graph graph = MogwaiUtil.openBlueprintsGraph(dbDirectory);
		EObject gremlinScript = transformer.transform(pack, exp);
		return new MogwaiQueryResult(runQuery(gremlinScript.toString(), obj, graph),graph);
	}
	
	private Object runQuery(String gremlinScript, Object obj, Graph graph) {
		ScriptEngineManager manager = new ScriptEngineManager();
		manager.registerEngineName("gremlin-groovy", new com.tinkerpop.gremlin.groovy.jsr223.GremlinGroovyScriptEngineFactory()); 
		ScriptEngine engine = manager.getEngineByName("gremlin-groovy");
		Bindings bindings = engine.createBindings();
		bindings.put("g", graph);
		if(obj != null) {
				bindings.put("self_value",obj);
		}
		Object result = null;
		try {
				result = engine.eval(
						gremlinScript
						, bindings);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		graph.shutdown();
		return result;
	}
}
