package fr.inria.atlanmod.mogwai.benchmarks.emfquery.tests;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;

public class EObjectContainerValueCondition extends
		EObjectCondition {
	
	EObjectCondition contextCondition;
	EObjectCondition valueCondition;
	
	public EObjectContainerValueCondition(EObjectCondition contextCondition, EObjectCondition valueCondition) {
		super(contextCondition.getPruneHandler());
		this.contextCondition = contextCondition;
		this.valueCondition = valueCondition;
	}

	@Override
	public boolean isSatisfied(EObject eObject) {
		return  contextCondition.isSatisfied(eObject) 
				&& valueCondition.isSatisfied(eObject.eContainer());
	}
}
