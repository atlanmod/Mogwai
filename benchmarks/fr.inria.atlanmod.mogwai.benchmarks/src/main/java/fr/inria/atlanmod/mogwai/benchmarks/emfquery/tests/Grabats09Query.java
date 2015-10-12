package fr.inria.atlanmod.mogwai.benchmarks.emfquery.tests;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.booleans.BooleanCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectInstanceCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectTypeRelationCondition;
import org.eclipse.emf.query.conditions.eobjects.TypeRelation;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.IteratorKind;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.gmt.modisco.java.BodyDeclaration;
import org.eclipse.gmt.modisco.java.MethodDeclaration;
import org.eclipse.gmt.modisco.java.TypeDeclaration;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Grabats09Query extends EMFQueryTest {

	public Grabats09Query(String resourceName) {
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
				new EObjectReferenceValueCondition(
						new EObjectTypeRelationCondition(JavaPackage.eINSTANCE.getTypeDeclaration(),TypeRelation.SAMETYPE_OR_SUBTYPE_LITERAL),
						JavaPackage.eINSTANCE.getAbstractTypeDeclaration_BodyDeclarations(),
						new EObjectReferenceValueCondition(
								new EObjectTypeRelationCondition(JavaPackage.eINSTANCE.getMethodDeclaration()),
								JavaPackage.eINSTANCE.getBodyDeclaration_Modifier(),
								new EObjectAttributeValueCondition(
										JavaPackage.eINSTANCE.getModifier_Static(),
										new BooleanCondition(true)
								)
						)
						.AND(
								// Cannot express equality
							new EObjectReferenceValueCondition(
									new EObjectTypeRelationCondition(JavaPackage.eINSTANCE.getMethodDeclaration()),
									JavaPackage.eINSTANCE.getMethodDeclaration_ReturnType(),
									new EObjectReferenceValueCondition(
											JavaPackage.eINSTANCE.getTypeAccess_Type(),
											new EObjectTypeRelationCondition(JavaPackage.eINSTANCE.getTypeDeclaration(),TypeRelation.SAMETYPE_OR_DIRECT_SUBTYPE_LITERAL)
									)
							)
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
