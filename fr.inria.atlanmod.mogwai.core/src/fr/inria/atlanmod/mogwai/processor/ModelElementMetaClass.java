package fr.inria.atlanmod.mogwai.processor;

import java.util.Arrays;

import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.Pipeline;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesDatastore;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesUtils;
import groovy.lang.DelegatingMetaClass;

public class ModelElementMetaClass extends DelegatingMetaClass {
	
	private ModelDatastore datastore;
	
	public ModelElementMetaClass(Class<?> theClass, ModelDatastore datastore) {
		super(theClass);
		System.out.println("init for " + theClass.getName());
		this.datastore = datastore;
	}
	
	@Override
	public Object invokeMethod(Class sender, Object receiver, String methodName, Object[] arguments,
			boolean isCallToSuper, boolean fromInsideClass) {
		System.out.println("Invoke1");
		return super.invokeMethod(sender, receiver, methodName, arguments, isCallToSuper, fromInsideClass);
	}
	
	@Override
	public Object invokeMethod(Object object, String methodName, Object arguments) {
		System.out.println("Invoke2");
		return super.invokeMethod(object, methodName, arguments);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object invokeMethod(Object object, String methodName, Object[] arguments) {
		if(methodName.equals("getAtt")) {
			return datastore.getAtt(object, (String)arguments[0]);
		}
		else if(methodName.equals("getParent")) {
			return datastore.getParent(object);
		}
		else if(methodName.equals("getRef")) {
			return datastore.getRef(object, (String) arguments[0], (String) arguments[1], (boolean) arguments[2]);
		}
		else if(methodName.equals("setAtt")) {
			return datastore.setAtt(object, (String)arguments[0], arguments[1]);
		}
		else if(methodName.equals("setRef")) {
			return datastore.setRef(object, (String)arguments[0], (String)arguments[1], arguments[2], (boolean)arguments[3]);
		}
		else if(methodName.equals("removeRef")) {
			return datastore.removeRef(object, (String)arguments[0], arguments[1], (boolean)arguments[2]);
		}
		else if(methodName.equals("getType")) {
			return datastore.getType(object);
		}
		else if(methodName.equals("isTypeOf")) {
			return datastore.isTypeOf(object, (String) arguments[0]);
		}
		else if(methodName.equals("isKindOf")) {
			return datastore.isKindOf(object, (String) arguments[0]);
		}
		else if(methodName.equals("_")) {
			if(object instanceof Pipe || object instanceof Pipeline) {
//				System.out.println("_ on a Pipe object, not handled now");
				return super.invokeMethod(object, methodName, arguments);
			}
			else {
//				System.out.println("_ on an Object!");
				if(object instanceof Iterable) {
					return PipesUtils.pipelineOf((Iterable) object, (PipesDatastore)datastore);
				}
				else {
					return PipesUtils.pipelineOf(Arrays.asList(object), (PipesDatastore)datastore);
				}
			}
		}
		System.out.println("cannot find " + methodName + " on " + object);
		return super.invokeMethod(object, methodName, arguments);
	}
	
	@Override
	public Object invokeMethod(String arg0, Object arg1) {
		System.out.println("Invoke4");
		return super.invokeMethod(arg0, arg1);
	}

}
