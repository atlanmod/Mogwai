package fr.inria.atlanmod.mogwai.processor;

import java.util.Arrays;

import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.Pipeline;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesDatastore;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesUtils;
import groovy.lang.DelegatingMetaClass;

public class ObjectMetaClass extends DelegatingMetaClass {
	
	public ObjectMetaClass(Class<?> theClass) {
		super(theClass);
		System.out.println("init for " + theClass.getName());
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
		if(methodName.equals("_")) {
			if(object instanceof Pipe || object instanceof Pipeline) {
				return super.invokeMethod(object, methodName, arguments);
			}
			else {
				if(object instanceof Iterable) {
					return PipesUtils.pipelineOf((Iterable) object);
				}
				else {
					return PipesUtils.pipelineOf(Arrays.asList(object));
				}
			}
		}
		return super.invokeMethod(object, methodName, arguments);
	}
	
	@Override
	public Object invokeMethod(String arg0, Object arg1) {
		System.out.println("Invoke4");
		return super.invokeMethod(arg0, arg1);
	}

}
