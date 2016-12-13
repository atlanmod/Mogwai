package fr.inria.atlanmod.mogwai.query.builder;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;

import fr.inria.atlanmod.mogwai.query.MogwaiOCLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;

public class MogwaiOCLQueryBuilder extends AbstractMogwaiQueryBuilder<MogwaiOCLQueryBuilder> {
	
	private EClassifier context;
	
	protected MogwaiOCLQueryBuilder() {
		
	}
	
	public static MogwaiOCLQueryBuilder newBuilder() {
		return new MogwaiOCLQueryBuilder();
	}
	
	public MogwaiOCLQueryBuilder fromConstraint(Constraint constraint) {
		this.input = constraint;
		return me();
	}
	
	public MogwaiOCLQueryBuilder fromOCLExpression(OCLExpression oclExpression) {
		this.input = oclExpression;
		return me();
	}
	
	public MogwaiOCLQueryBuilder context(EClassifier context) {
		this.context = context;
		return me();
	}
	
	@Override
	protected MogwaiOCLQuery buildQuery() {
		return new MogwaiOCLQuery(input, context);
	}
	
}
