package fr.inria.atlanmod.mogwai.processor;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.datastore.pipes.CustomGremlinGroovyPipeline;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesUtils;
import groovy.lang.DelegatingMetaClass;
import groovy.lang.MetaClass;

import java.util.Arrays;

import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.Pipeline;

/**
 * A Groovy {@link MetaClass} that wraps dynamic calls on the provided
 * {@link Class} and provides a dedicated implementation of the Gremlin identity
 * step {@code _()}.
 * <p>
 * Calling the identity step on an object instance that uses this metaclass
 * creates a {@link CustomGremlinGroovyPipeline} instance containing the object
 * and allowing to manipulate it object in a Gremlin traversal with extended
 * modeling primitives. Note that {@link Iterable} instances are supported and
 * their content is added as the start elements of the created pipeline.
 * <p>
 * <b>Note:</b> using this metaclass for an instance of {@link Pipe} and
 * {@link Pipeline} will simply delegates the identity call to the parent
 * metaclass that will dispatch it to the regular Gremlin identity step
 * implementation.
 * 
 * @see CustomGremlinGroovyPipeline
 * 
 * @author Gwendal DANIEL
 *
 */
public class ObjectMetaClass extends DelegatingMetaClass {

	/**
	 * Constructs a new {@link ObjectMetaClass} for the instances of the
	 * provided {@code clazz}.
	 * <p>
	 * This metaclass wraps dynamic calls on the provided {@code clazz}
	 * instances and provides a dedicated implementation of the Gremlin identity
	 * step {@code _()} which returns a {@link CustomGremlinGroovyPipeline}.
	 * 
	 * TODO: check if the constructor parameter is needed or if it can be safely
	 * removed (see https://github.com/atlanmod/Mogwai/issues/40)
	 * 
	 * @param clazz
	 *            the {@link Class} to wrap with the created metaclass
	 */
	public ObjectMetaClass(Class<?> clazz) {
		super(clazz);
		MogwaiLogger.debug("Creating MetaClass instance for {0}", clazz.getName());
	}

	/**
	 * Captures dynamic method calls on the instances conforming to this
	 * metaclass and provides a specific implementation of the Gremlin identity
	 * step {@code _()} that returns a {@link CustomGremlinGroovyPipeline} using
	 * the current {@code object} as its start elements.
	 * <p>
	 * This method delegates the call to
	 * {@link DelegatingMetaClass#invokeMethod(Object, String, Object[])} if the
	 * dynamic call is not an identity step invocation, or if the current
	 * metaclass is used on {@link Pipe} or {@link Pipeline} instances.
	 * <p>
	 * <b>Note:</b> invoking this method on an {@link Iterable} instance is
	 * supported and its content is added as the start elements of the created
	 * pipeline.
	 * 
	 * @param object
	 *            the {@link Object} on which the dynamic method call is invoked
	 * @param methodName
	 *            the name of the method dynamically called
	 * @param arguments
	 *            the arguments of the method dynamically called
	 * 
	 * @return an {@link Object} corresponding to the dynamic method result
	 * 
	 * @see CustomGremlinGroovyPipeline
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object invokeMethod(Object object, String methodName, Object[] arguments) {
		if (methodName.equals("_")) {
			if (object instanceof Pipe || object instanceof Pipeline) {
				/*
				 * Identity step on an instance of Pipe / Pipeline is handled by
				 * the default Gremlin engine
				 */
				return super.invokeMethod(object, methodName, arguments);
			} else {
				if (object instanceof Iterable) {
					/*
					 * Use the Iterable content as the Pipeline start elements
					 */
					return PipesUtils.pipelineOf((Iterable) object);
				} else {
					/*
					 * Use the provided object as the Pipeline start element
					 */
					return PipesUtils.pipelineOf(Arrays.asList(object));
				}
			}
		}
		return super.invokeMethod(object, methodName, arguments);
	}

}
