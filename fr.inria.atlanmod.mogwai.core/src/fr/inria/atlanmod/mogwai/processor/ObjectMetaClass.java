package fr.inria.atlanmod.mogwai.processor;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesUtils;
import groovy.lang.DelegatingMetaClass;

import java.util.Arrays;

import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.Pipeline;

public class ObjectMetaClass extends DelegatingMetaClass {
	
	public ObjectMetaClass(Class<?> theClass) {
		super(theClass);
		MogwaiLogger.debug("Creating MetaClass instance for {0}", theClass.getName());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	
}
