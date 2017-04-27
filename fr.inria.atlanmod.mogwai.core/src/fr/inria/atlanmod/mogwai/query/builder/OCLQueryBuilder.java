package fr.inria.atlanmod.mogwai.query.builder;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.processor.OCLQueryProcessor;
import fr.inria.atlanmod.mogwai.query.OCLQuery;

/**
 * An {@link AbstractMogwaiQueryBuilder} implementation that allows to create
 * {@link OCLQuery} instances.
 * <p>
 * This builder accepts all the input types of
 * {@link AbstractMogwaiQueryBuilder} (File, String, and URI), and provides
 * additional support to create {@link OCLQuery} instances from OCL
 * {@link Constraint}s and {@link OCLExpression}s.
 * <p>
 * The created {@link OCLQuery} can be processed by an {@link OCLQueryProcessor}
 * on top of any {@link ModelDatastore} implementation.
 * 
 * @see OCLQuery
 * @see OCLQueryProcessor
 * 
 * @author Gwendal DANIEL
 *
 */
public class OCLQueryBuilder extends AbstractMogwaiQueryBuilder<OCLQueryBuilder> {

	/**
	 * The context of the constraint to compute.
	 */
	private EClassifier context;

	/**
	 * Creates a new instance of this builder.
	 * <p>
	 * <b>Note:</b> this method is not public, use the static
	 * {@link #newBuilder()} that allows to chain build operations instead.
	 */
	protected OCLQueryBuilder() {

	}

	/**
	 * Creates a new instance of this builder that can be chained with build
	 * operations.
	 * 
	 * @return a new instance of this builder that can be chained with build
	 *         operations
	 */
	public static OCLQueryBuilder newBuilder() {
		return new OCLQueryBuilder();
	}

	/**
	 * Sets {@code constraints} as the input of the created {@link OCLQuery}.
	 * 
	 * @param constraint
	 *            the OCL {@link Constraint} used as the input of the
	 *            {@link OCLQuery} to create
	 * @return the instance of the builder
	 */
	public OCLQueryBuilder fromConstraint(Constraint constraint) {
		this.input = constraint;
		return me();
	}

	/**
	 * Sets {@code oclExpression} as the input of the created {@link OCLQuery}.
	 * 
	 * @param oclExpression
	 *            the {@link OCLExpression} used as the input of the
	 *            {@link OCLQuery} to create
	 * @return the instance of the builder
	 */
	public OCLQueryBuilder fromOCLExpression(OCLExpression oclExpression) {
		this.input = oclExpression;
		return me();
	}

	/**
	 * Sets the {@code context} of the OCL expression used to create the
	 * {@link OCLQuery}.
	 * <p>
	 * This parameter is required to create {@link OCLQuery} from String input
	 * and {@link OCLExpression}, where the context is not explicitly defined.
	 * 
	 * @param context
	 *            the {@link EClassifier} representing the context of the OCL
	 *            expression used to create the {@link OCLQuery}
	 * @return the instance of the builder
	 */
	public OCLQueryBuilder context(EClassifier context) {
		this.context = context;
		return me();
	}

	/**
	 * Constructs a new {@link OCLQuery} instance from the provided parameters.
	 * 
	 * @return the created {@link OCLQuery}
	 */
	@Override
	protected OCLQuery buildQuery() {
		return new OCLQuery(input, context);
	}

}
