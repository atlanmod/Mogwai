package fr.inria.atlanmod.mogwai.benchmarks.emfquery.tests;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectContainmentFeatureCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.IteratorKind;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.gmt.modisco.java.BodyDeclaration;
import org.eclipse.gmt.modisco.java.ClassDeclaration;
import org.eclipse.gmt.modisco.java.MethodDeclaration;
import org.eclipse.gmt.modisco.java.TypeAccess;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThrownExceptionsQuery extends EMFQueryTest {

	public ThrownExceptionsQuery(String resourceName) {
		super(resourceName);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void test() {
		
		EObjectCondition condition = 
				new EObjectContainerValueCondition(
						new EObjectContainmentFeatureCondition(JavaPackage.eINSTANCE.getAbstractMethodDeclaration_ThrownExceptions()),
						new EObjectContainerValueCondition(
								new EObjectTypeRelationCondition(JavaPackage.eINSTANCE.getMethodDeclaration()),
								new EObjectTypeRelationCondition(JavaPackage.eINSTANCE.getClassDeclaration())
						)
				);
		
		SELECT selectBD = new SELECT(
				new FROM(this.resource.getContents().get(0), IteratorKind.HIERARCHICAL_LITERAL),
				new WHERE(condition)
		);
		startTimer();
		IQueryResult r = selectBD.execute();
		endTimer();
		System.out.println(r.size());
	}

}
