package fr.inria.atlanmod.mogwai.benchmarks.emfquery.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectContainmentFeatureCondition;

public class EObjectContainmentFeatureConditionNeo extends
		EObjectContainmentFeatureCondition {

	public EObjectContainmentFeatureConditionNeo(EReference containmentFeature) {
		super(containmentFeature);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSatisfied(EObject eObject) {
		eObject.eContainer();
		return super.isSatisfied(eObject);
	}

}
