package fr.inria.atlanmod.mogwai.processor;

import java.util.Arrays;

import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.util.Pipeline;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.pipes.CustomGremlinGroovyPipeline;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesDatastore;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesUtils;
import groovy.lang.DelegatingMetaClass;
import groovy.lang.MetaClass;

/**
 * A Groovy {@link MetaClass} that wraps dynamic calls on model elements and
 * handles model-specific dynamic method and a dedicated implementation of the
 * Gremlin identity step {@code _()}.
 * <p>
 * Calling the identity step on an model element instance that uses this
 * metaclass creates a {@link CustomGremlinGroovyPipeline} instance starting
 * with the current model element and allowing to manipulate it in a Gremlin
 * traversal with extended modeling primitives. Note that {@link Iterable}
 * instances are supported and their content is added as the start elements of
 * the created pipeline.
 * <p>
 * This class relies on an internal {@link ModelDatastore} that is used to
 * access the underlying data-store and compute the captured model-specific
 * method calls. Supported methods retrieve:
 * <ul>
 * <li><b>getAtt:</b> see {@link ModelDatastore#getAtt(Object, String)}</li>
 * <li><b>getParent:</b> see {@link ModelDatastore#getParent(Object)}</li>
 * <li><b>getRef:</b> see
 * {@link ModelDatastore#getRef(Object, String, String, boolean)}</li>
 * <li><b>setAtt:</b> see {@link ModelDatastore#setAtt(Object, String, Object)}</li>
 * <li><b>setRef:</b> see
 * {@link ModelDatastore#setRef(Object, String, String, Object, boolean)}</li>
 * <li><b>removeRef:</b> see
 * {@link ModelDatastore#removeRef(Object, String, Object, boolean)}</li>
 * <li><b>getType:</b> see {@link ModelDatastore#getType(Object)}</li>
 * <li><b>isTypeOf:</b> see {@link ModelDatastore#isTypeOf(Object, String)}</li>
 * <li><b>isKindOf:</b> see {@link ModelDatastore#isKindOf(Object, String)}</li>
 * <li><b>_ (Identity Step):</b> creates a {@link CustomGremlinGroovyPipeline}
 * starting with the current model element</li>
 * </ul>
 * <p>
 * TODO: this class should be a subclass of {@link ObjectMetaClass} (see
 * https://github.com/atlanmod/Mogwai/issues/41)
 * 
 * @see ModelDatastore
 * 
 * @author Gwendal DANIEL
 *
 */
public class ModelElementMetaClass extends DelegatingMetaClass {

	/**
	 * The {@link ModelDatastore} used to compute model-specific method calls.
	 */
	private ModelDatastore datastore;

	/**
	 * Constructs a new {@link ModelElementMetaClass} for the instances of the
	 * provided {@code clazz} and using the given {@code datastore} to access
	 * the underlying data-store.
	 * <p>
	 * This metaclass wraps dynamic calls on the provided {@code clazz}
	 * instances representing model elements and provides model-specific dynamic
	 * method and a dedicated implementation of the Gremlin identity step
	 * {@code _()}.
	 * 
	 * @param clazz
	 *            the {@link Class} representing model elements to wrap with the
	 *            created metaclass
	 * @param datastore
	 *            the {@link ModelDatastore} used to access the underlying
	 *            data-store and perform model-level operations
	 */
	@SuppressWarnings("rawtypes")
	public ModelElementMetaClass(Class<?> clazz, ModelDatastore datastore) {
		super(clazz);
		MogwaiLogger.debug("Creating MetaClass instance for {0}", clazz.getName());
		this.datastore = datastore;
	}

	/**
	 * Captures dynamic method calls on the instance conforming to this
	 * metaclass and provides model-specific dynamic method and a dedicated
	 * implementation of the Gremlin identity step {@code _()}.
	 * <p>
	 * This method allows to dynamically capture the following invocations:
	 * <ul>
	 * <li><b>getAtt:</b> see {@link ModelDatastore#getAtt(Object, String)}</li>
	 * <li><b>getParent:</b> see {@link ModelDatastore#getParent(Object)}</li>
	 * <li><b>getRef:</b> see
	 * {@link ModelDatastore#getRef(Object, String, String, boolean)}</li>
	 * <li><b>setAtt:</b> see
	 * {@link ModelDatastore#setAtt(Object, String, Object)}</li>
	 * <li><b>setRef:</b> see
	 * {@link ModelDatastore#setRef(Object, String, String, Object, boolean)}</li>
	 * <li><b>removeRef:</b> see
	 * {@link ModelDatastore#removeRef(Object, String, Object, boolean)}</li>
	 * <li><b>getType:</b> see {@link ModelDatastore#getType(Object)}</li>
	 * <li><b>isTypeOf:</b> see {@link ModelDatastore#isTypeOf(Object, String)}</li>
	 * <li><b>isKindOf:</b> see {@link ModelDatastore#isKindOf(Object, String)}</li>
	 * <li><b>_ (Identity Step):</b> creates a
	 * {@link CustomGremlinGroovyPipeline} starting with the current model
	 * element</li>
	 * </ul>
	 * Note that model-level operations are computed on the underlying
	 * data-store using the {@link ModelDatastore} embedded in the metaclass. If
	 * the invoked method is not handled by this metaclass, the call is
	 * delegated to
	 * {@link DelegatingMetaClass#invokeMethod(Object, String, Object[])}.
	 * <p>
	 * <b>Note:</b> this method can return a {@link CustomGremlinGroovyPipeline}
	 * for pipeline-based operations, or a raw result for meta-operations. Check
	 * the documentation of the corresponding operations in the
	 * {@link ModelDatastore} class.
	 * 
	 * @param object
	 *            the {@link Object} on which the dynamic method call is invoked
	 * @param methodName
	 *            the name of the method dynamicaly called
	 * @param arguments
	 *            the arguments of the method dynamically called
	 * 
	 * @return an {@link Object} corresponding to the dynamic method result
	 * 
	 * @see CustomGremlinGroovyPipeline
	 * @see ModelDatastore
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object invokeMethod(Object object, String methodName, Object[] arguments) {
		if (methodName.equals("getAtt")) {
			return datastore.getAtt(object, (String) arguments[0]);
		} else if (methodName.equals("getParent")) {
			return datastore.getParent(object);
		} else if (methodName.equals("getRef")) {
			return datastore.getRef(object, (String) arguments[0], (String) arguments[1], (boolean) arguments[2]);
		} else if (methodName.equals("setAtt")) {
			return datastore.setAtt(object, (String) arguments[0], arguments[1]);
		} else if (methodName.equals("setRef")) {
			return datastore.setRef(object, (String) arguments[0], (String) arguments[1], arguments[2],
					(boolean) arguments[3]);
		} else if (methodName.equals("removeRef")) {
			return datastore.removeRef(object, (String) arguments[0], arguments[1], (boolean) arguments[2]);
		} else if (methodName.equals("getType")) {
			return datastore.getType(object);
		} else if (methodName.equals("isTypeOf")) {
			return datastore.isTypeOf(object, (String) arguments[0]);
		} else if (methodName.equals("isKindOf")) {
			return datastore.isKindOf(object, (String) arguments[0]);
		} else if (methodName.equals("_")) {
			/*
			 * TODO: this is duplicated from ObjectMetaClass, this class should
			 * extend it and delegate to its parent in case an identity step is
			 * invoked (see https://github.com/atlanmod/Mogwai/issues/41).
			 */
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
					return PipesUtils.pipelineOf((Iterable) object, (PipesDatastore) datastore);
				} else {
					/*
					 * Use the provided object as the Pipeline start element
					 */
					return PipesUtils.pipelineOf(Arrays.asList(object), (PipesDatastore) datastore);
				}
			}
		}
		MogwaiLogger.debug("Cannot find {0} on {1}", methodName, object);
		return super.invokeMethod(object, methodName, arguments);
	}

}
