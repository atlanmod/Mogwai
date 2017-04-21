package fr.inria.atlanmod.mogwai.query.builder;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;

import fr.inria.atlanmod.mogwai.query.OCLQuery;

public class OCLQueryBuilder extends AbstractMogwaiQueryBuilder<OCLQueryBuilder> {
	
	private EClassifier context;
	
	protected OCLQueryBuilder() {
		
	}
	
	public static OCLQueryBuilder newBuilder() {
		return new OCLQueryBuilder();
	}
	
	public OCLQueryBuilder fromConstraint(Constraint constraint) {
		this.input = constraint;
		return me();
	}
	
	public OCLQueryBuilder fromOCLExpression(OCLExpression oclExpression) {
		this.input = oclExpression;
		return me();
	}
	
	public OCLQueryBuilder context(EClassifier context) {
		this.context = context;
		return me();
	}
	
	@Override
	protected OCLQuery buildQuery() {
		return new OCLQuery(input, context);
	}
	
}
