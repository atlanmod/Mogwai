package fr.inria.atlanmod.mogwai.query;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;
import java.util.UUID;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCLExpression;

import fr.inria.atlanmod.mogwai.query.builder.OCLQueryBuilder;
import fr.inria.atlanmod.mogwai.util.OCLImporter;

/**
 * A {@link MogwaiQuery} implementation that wraps an OCL query to compute.
 * <p>
 * Instances of this class can be created using the fluent
 * {@link OCLQueryBuilder} API.
 * 
 * @see MogwaiQuery
 * @see OCLQueryBuilder
 * 
 * @author Gwendal DANIEL
 *
 */
public class OCLQuery extends MogwaiQuery {

	/**
	 * The OCL {@link EcoreFactory} instance used to create constraint mocks.
	 * <p>
	 * This factory is used in {@link #fromOCLExpression(OCLExpression)} to wrap
	 * the provided expression within a {@link Constraint}.
	 * 
	 * @see #fromOCLExpression(OCLExpression)
	 */
	private static EcoreFactory eFactory = EcoreFactory.eINSTANCE;

	/**
	 * The OCL {@link Constraint} to compute.
	 */
	private Constraint constraint;

	/**
	 * The context of the constraint to compute.
	 */
	private EClassifier context;

	/**
	 * Constructs a new {@link OCLQuery} from the given {@code input}.
	 * <p>
	 * {@link OCLQuery} supports {@link String}, {@link URI}, {@link Constraint}
	 * , and {@link OCLExpression} inputs. If another {@code input} type is
	 * provided the constructor throws a {@link QueryException}.
	 * <p>
	 * Instances of {@link OCLQuery} can be created using the fluent
	 * {@link OCLQueryBuilder} API.
	 * 
	 * @param input
	 *            an {@link Object} containing the input query
	 * @param context
	 *            the {@link EClassifier} representing the context of the OCL
	 *            expression to compute
	 * 
	 * @throws QueryException
	 *             if {@code input} doesn't contain an OCL expression or if it
	 *             cannot be cast to a supported input type
	 *
	 * @see OCLQueryBuilder
	 */
	public OCLQuery(Object input, EClassifier context) throws QueryException {
		super(input);
		this.context = context;
		if (input instanceof String) {
			fromString((String) input);
		} else if (input instanceof URI) {
			fromURI((URI) input);
		} else if (input instanceof Constraint) {
			fromConstraint((Constraint) input);
		} else if (input instanceof OCLExpression) {
			fromOCLExpression((OCLExpression) input);
		} else {
			throw new QueryException("Cannot construct a {0} from the provided input ({1})", OCLQuery.class.getName(),
					input.getClass().getName());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInput() {
		return constraint.toString();
	}

	/**
	 * Returns the {@link EClassifier} representing the context of the query to
	 * compute.
	 * 
	 * @return the {@link EClassifier} representing the context of the query to
	 *         compute
	 */
	public EClassifier getContext() {
		return context;
	}

	/**
	 * Returns the {@link Constraint} representation of the query to compute.
	 * 
	 * @return the {@link Constraint} representation of the query to compute
	 */
	public Constraint getConstraint() {
		return constraint;
	}

	/**
	 * Sets the internal constraint representation from the provided
	 * {@code string}.
	 * 
	 * @param string
	 *            the {@link String} representation of the OCL expression
	 * 
	 * @see OCLQuery#OCLQuery(Object, EClassifier)
	 */
	protected void fromString(String string) {
		checkNotNull(context, "Cannot build a String based MogwaiOCLQuery without explicit context");
		fromOCLExpression(OCLImporter.parseInlineOCL(string, context));
	}

	/**
	 * Sets the internal constraint representation by parsing the content of
	 * {@code uri}.
	 * 
	 * @param uri
	 *            the {@link URI} containing the OCL expression
	 * 
	 * @see OCLQuery#OCLQuery(Object, EClassifier)
	 */
	protected void fromURI(URI uri) {
		fromConstraint(OCLImporter.parseOCL(uri));
	}

	/**
	 * Sets the internal constraint representation from the provided
	 * {@code constraint}.
	 * 
	 * @param constraint
	 *            the {@link Constraint} to compute
	 * 
	 * @throws QueryException
	 *             if the provided {@code constraint} defines a different
	 *             context as the one used to construct the {@link OCLQuery}
	 *
	 * @see OCLQuery#OCLQuery(Object, EClassifier)
	 */
	private void fromConstraint(Constraint constraint) throws QueryException {
		this.constraint = (Constraint) constraint;
		EClassifier constraintContext = constraint.getSpecification().getContextVariable().getType();
		if (context != null && !Objects.equals(context, constraintContext)) {
			throw new QueryException("Conflicting context types, found {0}, expected {1}", constraintContext.getName(),
					context.getName());
		} else {
			this.context = constraintContext;
		}
	}

	/**
	 * Sets the internal constraint representation from the provided
	 * {@code oclExpression}.
	 * 
	 * @param oclExpression
	 *            the {@link OCLExpression} to compute
	 *
	 * @see OCLQuery#OCLQuery(Object, EClassifier)
	 */
	private void fromOCLExpression(OCLExpression oclExpression) {
		checkNotNull(context, "Cannot build an OCLExpression based MogwaiOCLQuery without an explicit context");
		constraint = eFactory.createConstraint();
		ExpressionInOCL mockExp = eFactory.createExpressionInOCL();
		constraint.setSpecification(mockExp);
		constraint.setName(UUID.randomUUID().toString());
		mockExp.setBodyExpression((OCLExpression) oclExpression);
	}
}
