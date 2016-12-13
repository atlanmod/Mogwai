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

import fr.inria.atlanmod.mogwai.util.MogwaiUtil;

public class MogwaiOCLQuery extends MogwaiQuery {

	private Constraint constraint;
	private EClassifier context;
	private EcoreFactory eFactory = EcoreFactory.eINSTANCE;
	
	/**
	 * Create a new MogwaiOCLQuery instance
	 * 
	 * @param input
	 *            the OCL query to compute. It can be represented using an URI,
	 *            a String, a {@link Constraint}, or an {@link OCLExpression}
	 * @param context
	 *            an optional parameter that specifies the context of the OCL
	 *            query.
	 */
	public MogwaiOCLQuery(Object input, EClassifier context) {
		super(input);
		if(Objects.isNull(this.context)) {
			// The context has not been set by a parent call
			this.context = context;
		}
		if(Objects.isNull(constraint)) {
			if(input instanceof Constraint) {
				fromConstraint((Constraint) input);
			} else if(input instanceof OCLExpression) {
				fromOCLExpression((OCLExpression) input);
			} else {
				throw new MogwaiQueryException("Unknown input type " + input);
			}
		}
	}
	
	/**
	 * @return the context of the query
	 */
	public EClassifier getContext() {
		return context;
	}
	
	/**
	 * @return the constraint embedded in the query
	 */
	public Constraint getConstraint() {
		return constraint;
	}

	@Override
	protected void fromString(String string) {
		checkNotNull(context, "Cannot build a String based MogwaiOCLQuery without explicit context");
		fromOCLExpression(MogwaiUtil.parseInlineOCL(string, context));
	}

	@Override
	protected void fromURI(URI uri) {
		fromConstraint(MogwaiUtil.parseOCL(uri));
	}
	
	private void fromConstraint(Constraint constraint) {
		this.constraint = (Constraint) constraint;
		EClassifier constraintContext = constraint.getSpecification().getContextVariable().getType();
		if(context != null && !Objects.equals(context, constraintContext)) {
			throw new MogwaiQueryException("Conflicting context types: " + context.getName() + " vs. " + constraintContext.getName());
		} else {
			this.context = constraintContext;
		}
	}
	
	private void fromOCLExpression(OCLExpression oclExpression) {
		checkNotNull(context, "Cannot build an OCLExpression based MogwaiOCLQuery without an explicit context");
		constraint = eFactory.createConstraint();
    	ExpressionInOCL mockExp = eFactory.createExpressionInOCL();
    	constraint.setSpecification(mockExp);
    	constraint.setName(UUID.randomUUID().toString());
    	mockExp.setBodyExpression((OCLExpression) oclExpression);
	}
	
	@Override
	public String getInput() {
		return constraint.toString();
	}
}
