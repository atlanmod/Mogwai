/**
 */
package fr.inria.atlanmod.mogwai.gremlin;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinFactory
 * @model kind="package"
 * @generated
 */
public interface GremlinPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gremlin";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "fr.inria.atlanmod.ocl2query.gremlin";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gremlin";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GremlinPackage eINSTANCE = fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.GremlinScriptImpl <em>Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinScriptImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getGremlinScript()
	 * @generated
	 */
	int GREMLIN_SCRIPT = 0;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREMLIN_SCRIPT__INSTRUCTIONS = 0;

	/**
	 * The number of structural features of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREMLIN_SCRIPT_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREMLIN_SCRIPT___TO_STRING = 0;

	/**
	 * The number of operations of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREMLIN_SCRIPT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.InstructionImpl <em>Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.InstructionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getInstruction()
	 * @generated
	 */
	int INSTRUCTION = 1;

	/**
	 * The number of structural features of the '<em>Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTRUCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.VariableDeclarationImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__VALUE = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION___TO_STRING = INSTRUCTION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.VectorTypeImpl <em>Vector Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.VectorTypeImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getVectorType()
	 * @generated
	 */
	int VECTOR_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_TYPE__VALUES = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Vector Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_TYPE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_TYPE___TO_STRING = INSTRUCTION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Vector Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VECTOR_TYPE_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.TraversalElementImpl <em>Traversal Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.TraversalElementImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getTraversalElement()
	 * @generated
	 */
	int TRAVERSAL_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAVERSAL_ELEMENT__NEXT_ELEMENT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Traversal Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAVERSAL_ELEMENT_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Traversal Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRAVERSAL_ELEMENT_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ClosureImpl <em>Closure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ClosureImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getClosure()
	 * @generated
	 */
	int CLOSURE = 5;

	/**
	 * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSURE__INSTRUCTIONS = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Closure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSURE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSURE___TO_STRING = INSTRUCTION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Closure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSURE_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ClosureItImpl <em>Closure It</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ClosureItImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getClosureIt()
	 * @generated
	 */
	int CLOSURE_IT = 6;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSURE_IT__NEXT_ELEMENT = TRAVERSAL_ELEMENT__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Closure It</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSURE_IT_FEATURE_COUNT = TRAVERSAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSURE_IT___TO_STRING = TRAVERSAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Closure It</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSURE_IT_OPERATION_COUNT = TRAVERSAL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.VariableAccessImpl <em>Variable Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.VariableAccessImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getVariableAccess()
	 * @generated
	 */
	int VARIABLE_ACCESS = 7;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__NEXT_ELEMENT = TRAVERSAL_ELEMENT__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__NAME = TRAVERSAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS_FEATURE_COUNT = TRAVERSAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS___TO_STRING = TRAVERSAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Variable Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS_OPERATION_COUNT = TRAVERSAL_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.StepImpl <em>Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.StepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getStep()
	 * @generated
	 */
	int STEP = 8;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__NEXT_ELEMENT = TRAVERSAL_ELEMENT__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_FEATURE_COUNT = TRAVERSAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_OPERATION_COUNT = TRAVERSAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.IdentityStepImpl <em>Identity Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.IdentityStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getIdentityStep()
	 * @generated
	 */
	int IDENTITY_STEP = 9;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Identity Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_STEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Identity Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.FillStepImpl <em>Fill Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.FillStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getFillStep()
	 * @generated
	 */
	int FILL_STEP = 10;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Instruction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_STEP__INSTRUCTION = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fill Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_STEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Fill Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.StartStepImpl <em>Start Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.StartStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getStartStep()
	 * @generated
	 */
	int START_STEP = 11;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Start Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_STEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Start Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.VerticesStepImpl <em>Vertices Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.VerticesStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getVerticesStep()
	 * @generated
	 */
	int VERTICES_STEP = 12;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICES_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Vertex Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICES_STEP__VERTEX_ID = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Vertices Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICES_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICES_STEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Vertices Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICES_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.EdgesStepImpl <em>Edges Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.EdgesStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getEdgesStep()
	 * @generated
	 */
	int EDGES_STEP = 13;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGES_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Relationship Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGES_STEP__RELATIONSHIP_NAME = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edges Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGES_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Edges Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGES_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.PropertyStepImpl <em>Property Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.PropertyStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getPropertyStep()
	 * @generated
	 */
	int PROPERTY_STEP = 14;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STEP__NAME = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Property Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.OutEStepImpl <em>Out EStep</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.OutEStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getOutEStep()
	 * @generated
	 */
	int OUT_ESTEP = 15;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_ESTEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Relationship Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_ESTEP__RELATIONSHIP_NAME = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Out EStep</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_ESTEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_ESTEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Out EStep</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_ESTEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.InEStepImpl <em>In EStep</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.InEStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getInEStep()
	 * @generated
	 */
	int IN_ESTEP = 16;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_ESTEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Relationship Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_ESTEP__RELATIONSHIP_NAME = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>In EStep</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_ESTEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_ESTEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>In EStep</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_ESTEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.InVStepImpl <em>In VStep</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.InVStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getInVStep()
	 * @generated
	 */
	int IN_VSTEP = 17;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_VSTEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>In VStep</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_VSTEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_VSTEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>In VStep</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_VSTEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.OutVStepImpl <em>Out VStep</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.OutVStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getOutVStep()
	 * @generated
	 */
	int OUT_VSTEP = 18;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VSTEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Out VStep</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VSTEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VSTEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Out VStep</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_VSTEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.FilterStepImpl <em>Filter Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.FilterStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getFilterStep()
	 * @generated
	 */
	int FILTER_STEP = 19;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Closure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_STEP__CLOSURE = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Filter Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_STEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Filter Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.RetainStepImpl <em>Retain Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.RetainStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getRetainStep()
	 * @generated
	 */
	int RETAIN_STEP = 20;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETAIN_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETAIN_STEP__COLLECTION = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Retain Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETAIN_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETAIN_STEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Retain Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETAIN_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ExceptStepImpl <em>Except Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ExceptStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getExceptStep()
	 * @generated
	 */
	int EXCEPT_STEP = 21;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPT_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPT_STEP__COLLECTION = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Except Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPT_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPT_STEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Except Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCEPT_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.TransformStepImpl <em>Transform Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.TransformStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getTransformStep()
	 * @generated
	 */
	int TRANSFORM_STEP = 22;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Closure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_STEP__CLOSURE = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Transform Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_STEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Transform Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORM_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.GatherStepImpl <em>Gather Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GatherStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getGatherStep()
	 * @generated
	 */
	int GATHER_STEP = 23;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATHER_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Closure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATHER_STEP__CLOSURE = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gather Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATHER_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATHER_STEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Gather Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATHER_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ScatterStepImpl <em>Scatter Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ScatterStepImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getScatterStep()
	 * @generated
	 */
	int SCATTER_STEP = 24;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCATTER_STEP__NEXT_ELEMENT = STEP__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Scatter Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCATTER_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCATTER_STEP___TO_STRING = STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Scatter Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCATTER_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.MethodCallImpl <em>Method Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.MethodCallImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getMethodCall()
	 * @generated
	 */
	int METHOD_CALL = 25;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL__NEXT_ELEMENT = TRAVERSAL_ELEMENT__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Method Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_FEATURE_COUNT = TRAVERSAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Method Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_OPERATION_COUNT = TRAVERSAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.NextCallImpl <em>Next Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.NextCallImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getNextCall()
	 * @generated
	 */
	int NEXT_CALL = 26;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_CALL__NEXT_ELEMENT = METHOD_CALL__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Next Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_CALL_FEATURE_COUNT = METHOD_CALL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_CALL___TO_STRING = METHOD_CALL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Next Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_CALL_OPERATION_COUNT = METHOD_CALL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.HasNextCallImpl <em>Has Next Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.HasNextCallImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getHasNextCall()
	 * @generated
	 */
	int HAS_NEXT_CALL = 27;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NEXT_CALL__NEXT_ELEMENT = METHOD_CALL__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Has Next Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NEXT_CALL_FEATURE_COUNT = METHOD_CALL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NEXT_CALL___TO_STRING = METHOD_CALL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Has Next Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NEXT_CALL_OPERATION_COUNT = METHOD_CALL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.IndexCallImpl <em>Index Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.IndexCallImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getIndexCall()
	 * @generated
	 */
	int INDEX_CALL = 28;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CALL__NEXT_ELEMENT = METHOD_CALL__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Index Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CALL__INDEX_NAME = METHOD_CALL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CALL__INDEX_PROPERTY = METHOD_CALL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Index Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CALL__INDEX_QUERY = METHOD_CALL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Index Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CALL_FEATURE_COUNT = METHOD_CALL_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CALL___TO_STRING = METHOD_CALL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Index Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_CALL_OPERATION_COUNT = METHOD_CALL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.CountCallImpl <em>Count Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.CountCallImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getCountCall()
	 * @generated
	 */
	int COUNT_CALL = 29;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_CALL__NEXT_ELEMENT = METHOD_CALL__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Count Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_CALL_FEATURE_COUNT = METHOD_CALL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_CALL___TO_STRING = METHOD_CALL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Count Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNT_CALL_OPERATION_COUNT = METHOD_CALL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.FirstCallImpl <em>First Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.FirstCallImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getFirstCall()
	 * @generated
	 */
	int FIRST_CALL = 30;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRST_CALL__NEXT_ELEMENT = METHOD_CALL__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>First Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRST_CALL_FEATURE_COUNT = METHOD_CALL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRST_CALL___TO_STRING = METHOD_CALL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>First Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIRST_CALL_OPERATION_COUNT = METHOD_CALL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ToListCallImpl <em>To List Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ToListCallImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getToListCall()
	 * @generated
	 */
	int TO_LIST_CALL = 31;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_LIST_CALL__NEXT_ELEMENT = METHOD_CALL__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>To List Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_LIST_CALL_FEATURE_COUNT = METHOD_CALL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_LIST_CALL___TO_STRING = METHOD_CALL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>To List Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_LIST_CALL_OPERATION_COUNT = METHOD_CALL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.IsEmptyCallImpl <em>Is Empty Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.IsEmptyCallImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getIsEmptyCall()
	 * @generated
	 */
	int IS_EMPTY_CALL = 32;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_EMPTY_CALL__NEXT_ELEMENT = METHOD_CALL__NEXT_ELEMENT;

	/**
	 * The number of structural features of the '<em>Is Empty Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_EMPTY_CALL_FEATURE_COUNT = METHOD_CALL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_EMPTY_CALL___TO_STRING = METHOD_CALL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Empty Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_EMPTY_CALL_OPERATION_COUNT = METHOD_CALL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ContainsCallImpl <em>Contains Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ContainsCallImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getContainsCall()
	 * @generated
	 */
	int CONTAINS_CALL = 33;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CALL__NEXT_ELEMENT = METHOD_CALL__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CALL__VALUE = METHOD_CALL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Contains Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CALL_FEATURE_COUNT = METHOD_CALL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CALL___TO_STRING = METHOD_CALL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Contains Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_CALL_OPERATION_COUNT = METHOD_CALL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ContainsAllCallImpl <em>Contains All Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ContainsAllCallImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getContainsAllCall()
	 * @generated
	 */
	int CONTAINS_ALL_CALL = 34;

	/**
	 * The feature id for the '<em><b>Next Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_ALL_CALL__NEXT_ELEMENT = METHOD_CALL__NEXT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_ALL_CALL__VALUE = METHOD_CALL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Contains All Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_ALL_CALL_FEATURE_COUNT = METHOD_CALL_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_ALL_CALL___TO_STRING = METHOD_CALL_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Contains All Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINS_ALL_CALL_OPERATION_COUNT = METHOD_CALL_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 35;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.UnaryExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getUnaryExpression()
	 * @generated
	 */
	int UNARY_EXPRESSION = 36;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__EXP = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.NotExpressionImpl <em>Not Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.NotExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getNotExpression()
	 * @generated
	 */
	int NOT_EXPRESSION = 37;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION__EXP = UNARY_EXPRESSION__EXP;

	/**
	 * The number of structural features of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION___TO_STRING = UNARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXPRESSION_OPERATION_COUNT = UNARY_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.BinaryExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getBinaryExpression()
	 * @generated
	 */
	int BINARY_EXPRESSION = 38;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Binary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.EqualityExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getEqualityExpression()
	 * @generated
	 */
	int EQUALITY_EXPRESSION = 39;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_EXPRESSION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_EXPRESSION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Equality Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_EXPRESSION___TO_STRING = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Equality Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.DifferenceExpressionImpl <em>Difference Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.DifferenceExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getDifferenceExpression()
	 * @generated
	 */
	int DIFFERENCE_EXPRESSION = 40;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE_EXPRESSION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE_EXPRESSION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Difference Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE_EXPRESSION___TO_STRING = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Difference Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIFFERENCE_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.OrExpressionImpl <em>Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.OrExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getOrExpression()
	 * @generated
	 */
	int OR_EXPRESSION = 41;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION___TO_STRING = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.AndExpressionImpl <em>And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.AndExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getAndExpression()
	 * @generated
	 */
	int AND_EXPRESSION = 42;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION___TO_STRING = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.GreaterExpressionImpl <em>Greater Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GreaterExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getGreaterExpression()
	 * @generated
	 */
	int GREATER_EXPRESSION = 43;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EXPRESSION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EXPRESSION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Greater Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EXPRESSION___TO_STRING = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Greater Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.GreaterOrEqualExpressionImpl <em>Greater Or Equal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GreaterOrEqualExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getGreaterOrEqualExpression()
	 * @generated
	 */
	int GREATER_OR_EQUAL_EXPRESSION = 44;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL_EXPRESSION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL_EXPRESSION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Greater Or Equal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL_EXPRESSION___TO_STRING = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Greater Or Equal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GREATER_OR_EQUAL_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.LessExpressionImpl <em>Less Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.LessExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getLessExpression()
	 * @generated
	 */
	int LESS_EXPRESSION = 45;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EXPRESSION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EXPRESSION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Less Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EXPRESSION___TO_STRING = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Less Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.LessOrEqualExpressionImpl <em>Less Or Equal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.LessOrEqualExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getLessOrEqualExpression()
	 * @generated
	 */
	int LESS_OR_EQUAL_EXPRESSION = 46;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL_EXPRESSION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL_EXPRESSION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Less Or Equal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL_EXPRESSION___TO_STRING = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Less Or Equal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LESS_OR_EQUAL_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.AffectationExpressionImpl <em>Affectation Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.AffectationExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getAffectationExpression()
	 * @generated
	 */
	int AFFECTATION_EXPRESSION = 47;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFECTATION_EXPRESSION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFECTATION_EXPRESSION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Affectation Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFECTATION_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFECTATION_EXPRESSION___TO_STRING = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Affectation Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFFECTATION_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.LeftShiftExpressionImpl <em>Left Shift Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.LeftShiftExpressionImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getLeftShiftExpression()
	 * @generated
	 */
	int LEFT_SHIFT_EXPRESSION = 48;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_SHIFT_EXPRESSION__LEFT = BINARY_EXPRESSION__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_SHIFT_EXPRESSION__RIGHT = BINARY_EXPRESSION__RIGHT;

	/**
	 * The number of structural features of the '<em>Left Shift Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_SHIFT_EXPRESSION_FEATURE_COUNT = BINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_SHIFT_EXPRESSION___TO_STRING = BINARY_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Left Shift Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEFT_SHIFT_EXPRESSION_OPERATION_COUNT = BINARY_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.StringLiteralImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 49;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL___TO_STRING = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.IntegerLiteralImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 50;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL___TO_STRING = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.DoubleLiteralImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getDoubleLiteral()
	 * @generated
	 */
	int DOUBLE_LITERAL = 51;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL___TO_STRING = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.BooleanLiteralImpl
	 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getBooleanLiteral()
	 * @generated
	 */
	int BOOLEAN_LITERAL = 52;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>To String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL___TO_STRING = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.GremlinScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinScript
	 * @generated
	 */
	EClass getGremlinScript();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.atlanmod.mogwai.gremlin.GremlinScript#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instructions</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinScript#getInstructions()
	 * @see #getGremlinScript()
	 * @generated
	 */
	EReference getGremlinScript_Instructions();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.GremlinScript#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GremlinScript#toString()
	 * @generated
	 */
	EOperation getGremlinScript__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.Instruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instruction</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.Instruction
	 * @generated
	 */
	EClass getInstruction();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#getName()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EAttribute getVariableDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#getValue()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Value();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration#toString()
	 * @generated
	 */
	EOperation getVariableDeclaration__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.VectorType <em>Vector Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vector Type</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VectorType
	 * @generated
	 */
	EClass getVectorType();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.atlanmod.mogwai.gremlin.VectorType#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VectorType#getValues()
	 * @see #getVectorType()
	 * @generated
	 */
	EReference getVectorType_Values();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.VectorType#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VectorType#toString()
	 * @generated
	 */
	EOperation getVectorType__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.TraversalElement <em>Traversal Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traversal Element</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.TraversalElement
	 * @generated
	 */
	EClass getTraversalElement();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.TraversalElement#getNextElement <em>Next Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Next Element</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.TraversalElement#getNextElement()
	 * @see #getTraversalElement()
	 * @generated
	 */
	EReference getTraversalElement_NextElement();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.Closure <em>Closure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Closure</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.Closure
	 * @generated
	 */
	EClass getClosure();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.atlanmod.mogwai.gremlin.Closure#getInstructions <em>Instructions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instructions</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.Closure#getInstructions()
	 * @see #getClosure()
	 * @generated
	 */
	EReference getClosure_Instructions();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.Closure#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.Closure#toString()
	 * @generated
	 */
	EOperation getClosure__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.ClosureIt <em>Closure It</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Closure It</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ClosureIt
	 * @generated
	 */
	EClass getClosureIt();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.ClosureIt#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ClosureIt#toString()
	 * @generated
	 */
	EOperation getClosureIt__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.VariableAccess <em>Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Access</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VariableAccess
	 * @generated
	 */
	EClass getVariableAccess();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.VariableAccess#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VariableAccess#getName()
	 * @see #getVariableAccess()
	 * @generated
	 */
	EAttribute getVariableAccess_Name();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.VariableAccess#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VariableAccess#toString()
	 * @generated
	 */
	EOperation getVariableAccess__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.Step
	 * @generated
	 */
	EClass getStep();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.IdentityStep <em>Identity Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identity Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IdentityStep
	 * @generated
	 */
	EClass getIdentityStep();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.IdentityStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IdentityStep#toString()
	 * @generated
	 */
	EOperation getIdentityStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.FillStep <em>Fill Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fill Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.FillStep
	 * @generated
	 */
	EClass getFillStep();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.FillStep#getInstruction <em>Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Instruction</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.FillStep#getInstruction()
	 * @see #getFillStep()
	 * @generated
	 */
	EReference getFillStep_Instruction();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.FillStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.FillStep#toString()
	 * @generated
	 */
	EOperation getFillStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.StartStep <em>Start Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.StartStep
	 * @generated
	 */
	EClass getStartStep();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.StartStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.StartStep#toString()
	 * @generated
	 */
	EOperation getStartStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.VerticesStep <em>Vertices Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertices Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VerticesStep
	 * @generated
	 */
	EClass getVerticesStep();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.VerticesStep#getVertexId <em>Vertex Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vertex Id</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VerticesStep#getVertexId()
	 * @see #getVerticesStep()
	 * @generated
	 */
	EAttribute getVerticesStep_VertexId();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.VerticesStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.VerticesStep#toString()
	 * @generated
	 */
	EOperation getVerticesStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.EdgesStep <em>Edges Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edges Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.EdgesStep
	 * @generated
	 */
	EClass getEdgesStep();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.EdgesStep#getRelationshipName <em>Relationship Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relationship Name</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.EdgesStep#getRelationshipName()
	 * @see #getEdgesStep()
	 * @generated
	 */
	EAttribute getEdgesStep_RelationshipName();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.PropertyStep <em>Property Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.PropertyStep
	 * @generated
	 */
	EClass getPropertyStep();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.PropertyStep#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.PropertyStep#getName()
	 * @see #getPropertyStep()
	 * @generated
	 */
	EAttribute getPropertyStep_Name();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.PropertyStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.PropertyStep#toString()
	 * @generated
	 */
	EOperation getPropertyStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.OutEStep <em>Out EStep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out EStep</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.OutEStep
	 * @generated
	 */
	EClass getOutEStep();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.OutEStep#getRelationshipName <em>Relationship Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relationship Name</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.OutEStep#getRelationshipName()
	 * @see #getOutEStep()
	 * @generated
	 */
	EAttribute getOutEStep_RelationshipName();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.OutEStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.OutEStep#toString()
	 * @generated
	 */
	EOperation getOutEStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.InEStep <em>In EStep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In EStep</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.InEStep
	 * @generated
	 */
	EClass getInEStep();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.InEStep#getRelationshipName <em>Relationship Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relationship Name</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.InEStep#getRelationshipName()
	 * @see #getInEStep()
	 * @generated
	 */
	EAttribute getInEStep_RelationshipName();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.InEStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.InEStep#toString()
	 * @generated
	 */
	EOperation getInEStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.InVStep <em>In VStep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In VStep</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.InVStep
	 * @generated
	 */
	EClass getInVStep();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.InVStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.InVStep#toString()
	 * @generated
	 */
	EOperation getInVStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.OutVStep <em>Out VStep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out VStep</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.OutVStep
	 * @generated
	 */
	EClass getOutVStep();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.OutVStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.OutVStep#toString()
	 * @generated
	 */
	EOperation getOutVStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.FilterStep <em>Filter Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.FilterStep
	 * @generated
	 */
	EClass getFilterStep();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.FilterStep#getClosure <em>Closure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Closure</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.FilterStep#getClosure()
	 * @see #getFilterStep()
	 * @generated
	 */
	EReference getFilterStep_Closure();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.FilterStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.FilterStep#toString()
	 * @generated
	 */
	EOperation getFilterStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.RetainStep <em>Retain Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Retain Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.RetainStep
	 * @generated
	 */
	EClass getRetainStep();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.RetainStep#getCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.RetainStep#getCollection()
	 * @see #getRetainStep()
	 * @generated
	 */
	EReference getRetainStep_Collection();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.RetainStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.RetainStep#toString()
	 * @generated
	 */
	EOperation getRetainStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.ExceptStep <em>Except Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Except Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ExceptStep
	 * @generated
	 */
	EClass getExceptStep();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.ExceptStep#getCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ExceptStep#getCollection()
	 * @see #getExceptStep()
	 * @generated
	 */
	EReference getExceptStep_Collection();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.ExceptStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ExceptStep#toString()
	 * @generated
	 */
	EOperation getExceptStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.TransformStep <em>Transform Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transform Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.TransformStep
	 * @generated
	 */
	EClass getTransformStep();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.TransformStep#getClosure <em>Closure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Closure</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.TransformStep#getClosure()
	 * @see #getTransformStep()
	 * @generated
	 */
	EReference getTransformStep_Closure();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.TransformStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.TransformStep#toString()
	 * @generated
	 */
	EOperation getTransformStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.GatherStep <em>Gather Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gather Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GatherStep
	 * @generated
	 */
	EClass getGatherStep();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.GatherStep#getClosure <em>Closure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Closure</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GatherStep#getClosure()
	 * @see #getGatherStep()
	 * @generated
	 */
	EReference getGatherStep_Closure();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.GatherStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GatherStep#toString()
	 * @generated
	 */
	EOperation getGatherStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.ScatterStep <em>Scatter Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scatter Step</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ScatterStep
	 * @generated
	 */
	EClass getScatterStep();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.ScatterStep#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ScatterStep#toString()
	 * @generated
	 */
	EOperation getScatterStep__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.MethodCall <em>Method Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Call</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.MethodCall
	 * @generated
	 */
	EClass getMethodCall();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.NextCall <em>Next Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Next Call</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.NextCall
	 * @generated
	 */
	EClass getNextCall();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.NextCall#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.NextCall#toString()
	 * @generated
	 */
	EOperation getNextCall__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.HasNextCall <em>Has Next Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Next Call</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.HasNextCall
	 * @generated
	 */
	EClass getHasNextCall();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.HasNextCall#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.HasNextCall#toString()
	 * @generated
	 */
	EOperation getHasNextCall__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall <em>Index Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Call</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IndexCall
	 * @generated
	 */
	EClass getIndexCall();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexName <em>Index Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Name</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexName()
	 * @see #getIndexCall()
	 * @generated
	 */
	EAttribute getIndexCall_IndexName();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexProperty <em>Index Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Property</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexProperty()
	 * @see #getIndexCall()
	 * @generated
	 */
	EAttribute getIndexCall_IndexProperty();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexQuery <em>Index Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index Query</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IndexCall#getIndexQuery()
	 * @see #getIndexCall()
	 * @generated
	 */
	EAttribute getIndexCall_IndexQuery();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.IndexCall#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IndexCall#toString()
	 * @generated
	 */
	EOperation getIndexCall__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.CountCall <em>Count Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Count Call</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.CountCall
	 * @generated
	 */
	EClass getCountCall();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.CountCall#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.CountCall#toString()
	 * @generated
	 */
	EOperation getCountCall__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.FirstCall <em>First Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>First Call</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.FirstCall
	 * @generated
	 */
	EClass getFirstCall();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.FirstCall#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.FirstCall#toString()
	 * @generated
	 */
	EOperation getFirstCall__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.ToListCall <em>To List Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To List Call</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ToListCall
	 * @generated
	 */
	EClass getToListCall();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.ToListCall#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ToListCall#toString()
	 * @generated
	 */
	EOperation getToListCall__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall <em>Is Empty Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Empty Call</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall
	 * @generated
	 */
	EClass getIsEmptyCall();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall#toString()
	 * @generated
	 */
	EOperation getIsEmptyCall__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.ContainsCall <em>Contains Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contains Call</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ContainsCall
	 * @generated
	 */
	EClass getContainsCall();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.ContainsCall#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ContainsCall#getValue()
	 * @see #getContainsCall()
	 * @generated
	 */
	EReference getContainsCall_Value();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.ContainsCall#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ContainsCall#toString()
	 * @generated
	 */
	EOperation getContainsCall__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.ContainsAllCall <em>Contains All Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contains All Call</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ContainsAllCall
	 * @generated
	 */
	EClass getContainsAllCall();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.ContainsAllCall#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ContainsAllCall#getValue()
	 * @see #getContainsAllCall()
	 * @generated
	 */
	EReference getContainsAllCall_Value();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.ContainsAllCall#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.ContainsAllCall#toString()
	 * @generated
	 */
	EOperation getContainsAllCall__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.UnaryExpression
	 * @generated
	 */
	EClass getUnaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.UnaryExpression#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.UnaryExpression#getExp()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EReference getUnaryExpression_Exp();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.NotExpression <em>Not Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.NotExpression
	 * @generated
	 */
	EClass getNotExpression();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.NotExpression#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.NotExpression#toString()
	 * @generated
	 */
	EOperation getNotExpression__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.BinaryExpression
	 * @generated
	 */
	EClass getBinaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.BinaryExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.BinaryExpression#getLeft()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.atlanmod.mogwai.gremlin.BinaryExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.BinaryExpression#getRight()
	 * @see #getBinaryExpression()
	 * @generated
	 */
	EReference getBinaryExpression_Right();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.EqualityExpression <em>Equality Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equality Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.EqualityExpression
	 * @generated
	 */
	EClass getEqualityExpression();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.EqualityExpression#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.EqualityExpression#toString()
	 * @generated
	 */
	EOperation getEqualityExpression__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.DifferenceExpression <em>Difference Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Difference Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.DifferenceExpression
	 * @generated
	 */
	EClass getDifferenceExpression();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.DifferenceExpression#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.DifferenceExpression#toString()
	 * @generated
	 */
	EOperation getDifferenceExpression__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.OrExpression <em>Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.OrExpression
	 * @generated
	 */
	EClass getOrExpression();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.OrExpression#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.OrExpression#toString()
	 * @generated
	 */
	EOperation getOrExpression__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.AndExpression <em>And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.AndExpression
	 * @generated
	 */
	EClass getAndExpression();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.AndExpression#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.AndExpression#toString()
	 * @generated
	 */
	EOperation getAndExpression__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.GreaterExpression <em>Greater Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GreaterExpression
	 * @generated
	 */
	EClass getGreaterExpression();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.GreaterExpression#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GreaterExpression#toString()
	 * @generated
	 */
	EOperation getGreaterExpression__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.GreaterOrEqualExpression <em>Greater Or Equal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Greater Or Equal Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GreaterOrEqualExpression
	 * @generated
	 */
	EClass getGreaterOrEqualExpression();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.GreaterOrEqualExpression#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.GreaterOrEqualExpression#toString()
	 * @generated
	 */
	EOperation getGreaterOrEqualExpression__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.LessExpression <em>Less Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.LessExpression
	 * @generated
	 */
	EClass getLessExpression();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.LessExpression#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.LessExpression#toString()
	 * @generated
	 */
	EOperation getLessExpression__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.LessOrEqualExpression <em>Less Or Equal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Less Or Equal Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.LessOrEqualExpression
	 * @generated
	 */
	EClass getLessOrEqualExpression();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.LessOrEqualExpression#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.LessOrEqualExpression#toString()
	 * @generated
	 */
	EOperation getLessOrEqualExpression__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.AffectationExpression <em>Affectation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Affectation Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.AffectationExpression
	 * @generated
	 */
	EClass getAffectationExpression();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.AffectationExpression#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.AffectationExpression#toString()
	 * @generated
	 */
	EOperation getAffectationExpression__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.LeftShiftExpression <em>Left Shift Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Left Shift Expression</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.LeftShiftExpression
	 * @generated
	 */
	EClass getLeftShiftExpression();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.LeftShiftExpression#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.LeftShiftExpression#toString()
	 * @generated
	 */
	EOperation getLeftShiftExpression__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.StringLiteral#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.StringLiteral#toString()
	 * @generated
	 */
	EOperation getStringLiteral__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral#getValue()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Value();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral#toString()
	 * @generated
	 */
	EOperation getIntegerLiteral__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Literal</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.DoubleLiteral
	 * @generated
	 */
	EClass getDoubleLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.DoubleLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.DoubleLiteral#getValue()
	 * @see #getDoubleLiteral()
	 * @generated
	 */
	EAttribute getDoubleLiteral_Value();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.DoubleLiteral#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.DoubleLiteral#toString()
	 * @generated
	 */
	EOperation getDoubleLiteral__ToString();

	/**
	 * Returns the meta object for class '{@link fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral
	 * @generated
	 */
	EClass getBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral#isValue()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
	EAttribute getBooleanLiteral_Value();

	/**
	 * Returns the meta object for the '{@link fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral#toString() <em>To String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To String</em>' operation.
	 * @see fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral#toString()
	 * @generated
	 */
	EOperation getBooleanLiteral__ToString();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GremlinFactory getGremlinFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.GremlinScriptImpl <em>Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinScriptImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getGremlinScript()
		 * @generated
		 */
		EClass GREMLIN_SCRIPT = eINSTANCE.getGremlinScript();

		/**
		 * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GREMLIN_SCRIPT__INSTRUCTIONS = eINSTANCE.getGremlinScript_Instructions();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GREMLIN_SCRIPT___TO_STRING = eINSTANCE.getGremlinScript__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.InstructionImpl <em>Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.InstructionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getInstruction()
		 * @generated
		 */
		EClass INSTRUCTION = eINSTANCE.getInstruction();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.VariableDeclarationImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION__NAME = eINSTANCE.getVariableDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__VALUE = eINSTANCE.getVariableDeclaration_Value();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_DECLARATION___TO_STRING = eINSTANCE.getVariableDeclaration__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.VectorTypeImpl <em>Vector Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.VectorTypeImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getVectorType()
		 * @generated
		 */
		EClass VECTOR_TYPE = eINSTANCE.getVectorType();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VECTOR_TYPE__VALUES = eINSTANCE.getVectorType_Values();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VECTOR_TYPE___TO_STRING = eINSTANCE.getVectorType__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.TraversalElementImpl <em>Traversal Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.TraversalElementImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getTraversalElement()
		 * @generated
		 */
		EClass TRAVERSAL_ELEMENT = eINSTANCE.getTraversalElement();

		/**
		 * The meta object literal for the '<em><b>Next Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRAVERSAL_ELEMENT__NEXT_ELEMENT = eINSTANCE.getTraversalElement_NextElement();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ClosureImpl <em>Closure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ClosureImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getClosure()
		 * @generated
		 */
		EClass CLOSURE = eINSTANCE.getClosure();

		/**
		 * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOSURE__INSTRUCTIONS = eINSTANCE.getClosure_Instructions();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLOSURE___TO_STRING = eINSTANCE.getClosure__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ClosureItImpl <em>Closure It</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ClosureItImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getClosureIt()
		 * @generated
		 */
		EClass CLOSURE_IT = eINSTANCE.getClosureIt();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLOSURE_IT___TO_STRING = eINSTANCE.getClosureIt__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.VariableAccessImpl <em>Variable Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.VariableAccessImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getVariableAccess()
		 * @generated
		 */
		EClass VARIABLE_ACCESS = eINSTANCE.getVariableAccess();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_ACCESS__NAME = eINSTANCE.getVariableAccess_Name();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_ACCESS___TO_STRING = eINSTANCE.getVariableAccess__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.StepImpl <em>Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.StepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getStep()
		 * @generated
		 */
		EClass STEP = eINSTANCE.getStep();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.IdentityStepImpl <em>Identity Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.IdentityStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getIdentityStep()
		 * @generated
		 */
		EClass IDENTITY_STEP = eINSTANCE.getIdentityStep();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IDENTITY_STEP___TO_STRING = eINSTANCE.getIdentityStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.FillStepImpl <em>Fill Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.FillStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getFillStep()
		 * @generated
		 */
		EClass FILL_STEP = eINSTANCE.getFillStep();

		/**
		 * The meta object literal for the '<em><b>Instruction</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILL_STEP__INSTRUCTION = eINSTANCE.getFillStep_Instruction();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FILL_STEP___TO_STRING = eINSTANCE.getFillStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.StartStepImpl <em>Start Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.StartStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getStartStep()
		 * @generated
		 */
		EClass START_STEP = eINSTANCE.getStartStep();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation START_STEP___TO_STRING = eINSTANCE.getStartStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.VerticesStepImpl <em>Vertices Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.VerticesStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getVerticesStep()
		 * @generated
		 */
		EClass VERTICES_STEP = eINSTANCE.getVerticesStep();

		/**
		 * The meta object literal for the '<em><b>Vertex Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERTICES_STEP__VERTEX_ID = eINSTANCE.getVerticesStep_VertexId();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VERTICES_STEP___TO_STRING = eINSTANCE.getVerticesStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.EdgesStepImpl <em>Edges Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.EdgesStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getEdgesStep()
		 * @generated
		 */
		EClass EDGES_STEP = eINSTANCE.getEdgesStep();

		/**
		 * The meta object literal for the '<em><b>Relationship Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGES_STEP__RELATIONSHIP_NAME = eINSTANCE.getEdgesStep_RelationshipName();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.PropertyStepImpl <em>Property Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.PropertyStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getPropertyStep()
		 * @generated
		 */
		EClass PROPERTY_STEP = eINSTANCE.getPropertyStep();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_STEP__NAME = eINSTANCE.getPropertyStep_Name();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_STEP___TO_STRING = eINSTANCE.getPropertyStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.OutEStepImpl <em>Out EStep</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.OutEStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getOutEStep()
		 * @generated
		 */
		EClass OUT_ESTEP = eINSTANCE.getOutEStep();

		/**
		 * The meta object literal for the '<em><b>Relationship Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUT_ESTEP__RELATIONSHIP_NAME = eINSTANCE.getOutEStep_RelationshipName();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OUT_ESTEP___TO_STRING = eINSTANCE.getOutEStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.InEStepImpl <em>In EStep</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.InEStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getInEStep()
		 * @generated
		 */
		EClass IN_ESTEP = eINSTANCE.getInEStep();

		/**
		 * The meta object literal for the '<em><b>Relationship Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_ESTEP__RELATIONSHIP_NAME = eINSTANCE.getInEStep_RelationshipName();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IN_ESTEP___TO_STRING = eINSTANCE.getInEStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.InVStepImpl <em>In VStep</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.InVStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getInVStep()
		 * @generated
		 */
		EClass IN_VSTEP = eINSTANCE.getInVStep();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IN_VSTEP___TO_STRING = eINSTANCE.getInVStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.OutVStepImpl <em>Out VStep</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.OutVStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getOutVStep()
		 * @generated
		 */
		EClass OUT_VSTEP = eINSTANCE.getOutVStep();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OUT_VSTEP___TO_STRING = eINSTANCE.getOutVStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.FilterStepImpl <em>Filter Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.FilterStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getFilterStep()
		 * @generated
		 */
		EClass FILTER_STEP = eINSTANCE.getFilterStep();

		/**
		 * The meta object literal for the '<em><b>Closure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILTER_STEP__CLOSURE = eINSTANCE.getFilterStep_Closure();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FILTER_STEP___TO_STRING = eINSTANCE.getFilterStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.RetainStepImpl <em>Retain Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.RetainStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getRetainStep()
		 * @generated
		 */
		EClass RETAIN_STEP = eINSTANCE.getRetainStep();

		/**
		 * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETAIN_STEP__COLLECTION = eINSTANCE.getRetainStep_Collection();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RETAIN_STEP___TO_STRING = eINSTANCE.getRetainStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ExceptStepImpl <em>Except Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ExceptStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getExceptStep()
		 * @generated
		 */
		EClass EXCEPT_STEP = eINSTANCE.getExceptStep();

		/**
		 * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCEPT_STEP__COLLECTION = eINSTANCE.getExceptStep_Collection();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EXCEPT_STEP___TO_STRING = eINSTANCE.getExceptStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.TransformStepImpl <em>Transform Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.TransformStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getTransformStep()
		 * @generated
		 */
		EClass TRANSFORM_STEP = eINSTANCE.getTransformStep();

		/**
		 * The meta object literal for the '<em><b>Closure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORM_STEP__CLOSURE = eINSTANCE.getTransformStep_Closure();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORM_STEP___TO_STRING = eINSTANCE.getTransformStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.GatherStepImpl <em>Gather Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GatherStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getGatherStep()
		 * @generated
		 */
		EClass GATHER_STEP = eINSTANCE.getGatherStep();

		/**
		 * The meta object literal for the '<em><b>Closure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATHER_STEP__CLOSURE = eINSTANCE.getGatherStep_Closure();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GATHER_STEP___TO_STRING = eINSTANCE.getGatherStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ScatterStepImpl <em>Scatter Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ScatterStepImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getScatterStep()
		 * @generated
		 */
		EClass SCATTER_STEP = eINSTANCE.getScatterStep();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCATTER_STEP___TO_STRING = eINSTANCE.getScatterStep__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.MethodCallImpl <em>Method Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.MethodCallImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getMethodCall()
		 * @generated
		 */
		EClass METHOD_CALL = eINSTANCE.getMethodCall();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.NextCallImpl <em>Next Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.NextCallImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getNextCall()
		 * @generated
		 */
		EClass NEXT_CALL = eINSTANCE.getNextCall();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NEXT_CALL___TO_STRING = eINSTANCE.getNextCall__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.HasNextCallImpl <em>Has Next Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.HasNextCallImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getHasNextCall()
		 * @generated
		 */
		EClass HAS_NEXT_CALL = eINSTANCE.getHasNextCall();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HAS_NEXT_CALL___TO_STRING = eINSTANCE.getHasNextCall__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.IndexCallImpl <em>Index Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.IndexCallImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getIndexCall()
		 * @generated
		 */
		EClass INDEX_CALL = eINSTANCE.getIndexCall();

		/**
		 * The meta object literal for the '<em><b>Index Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_CALL__INDEX_NAME = eINSTANCE.getIndexCall_IndexName();

		/**
		 * The meta object literal for the '<em><b>Index Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_CALL__INDEX_PROPERTY = eINSTANCE.getIndexCall_IndexProperty();

		/**
		 * The meta object literal for the '<em><b>Index Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INDEX_CALL__INDEX_QUERY = eINSTANCE.getIndexCall_IndexQuery();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INDEX_CALL___TO_STRING = eINSTANCE.getIndexCall__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.CountCallImpl <em>Count Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.CountCallImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getCountCall()
		 * @generated
		 */
		EClass COUNT_CALL = eINSTANCE.getCountCall();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COUNT_CALL___TO_STRING = eINSTANCE.getCountCall__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.FirstCallImpl <em>First Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.FirstCallImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getFirstCall()
		 * @generated
		 */
		EClass FIRST_CALL = eINSTANCE.getFirstCall();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FIRST_CALL___TO_STRING = eINSTANCE.getFirstCall__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ToListCallImpl <em>To List Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ToListCallImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getToListCall()
		 * @generated
		 */
		EClass TO_LIST_CALL = eINSTANCE.getToListCall();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TO_LIST_CALL___TO_STRING = eINSTANCE.getToListCall__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.IsEmptyCallImpl <em>Is Empty Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.IsEmptyCallImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getIsEmptyCall()
		 * @generated
		 */
		EClass IS_EMPTY_CALL = eINSTANCE.getIsEmptyCall();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation IS_EMPTY_CALL___TO_STRING = eINSTANCE.getIsEmptyCall__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ContainsCallImpl <em>Contains Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ContainsCallImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getContainsCall()
		 * @generated
		 */
		EClass CONTAINS_CALL = eINSTANCE.getContainsCall();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINS_CALL__VALUE = eINSTANCE.getContainsCall_Value();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINS_CALL___TO_STRING = eINSTANCE.getContainsCall__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ContainsAllCallImpl <em>Contains All Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ContainsAllCallImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getContainsAllCall()
		 * @generated
		 */
		EClass CONTAINS_ALL_CALL = eINSTANCE.getContainsAllCall();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINS_ALL_CALL__VALUE = eINSTANCE.getContainsAllCall_Value();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINS_ALL_CALL___TO_STRING = eINSTANCE.getContainsAllCall__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.ExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.UnaryExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getUnaryExpression()
		 * @generated
		 */
		EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXPRESSION__EXP = eINSTANCE.getUnaryExpression_Exp();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.NotExpressionImpl <em>Not Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.NotExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getNotExpression()
		 * @generated
		 */
		EClass NOT_EXPRESSION = eINSTANCE.getNotExpression();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NOT_EXPRESSION___TO_STRING = eINSTANCE.getNotExpression__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.BinaryExpressionImpl <em>Binary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.BinaryExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getBinaryExpression()
		 * @generated
		 */
		EClass BINARY_EXPRESSION = eINSTANCE.getBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__LEFT = eINSTANCE.getBinaryExpression_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION__RIGHT = eINSTANCE.getBinaryExpression_Right();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.EqualityExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getEqualityExpression()
		 * @generated
		 */
		EClass EQUALITY_EXPRESSION = eINSTANCE.getEqualityExpression();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EQUALITY_EXPRESSION___TO_STRING = eINSTANCE.getEqualityExpression__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.DifferenceExpressionImpl <em>Difference Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.DifferenceExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getDifferenceExpression()
		 * @generated
		 */
		EClass DIFFERENCE_EXPRESSION = eINSTANCE.getDifferenceExpression();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIFFERENCE_EXPRESSION___TO_STRING = eINSTANCE.getDifferenceExpression__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.OrExpressionImpl <em>Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.OrExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getOrExpression()
		 * @generated
		 */
		EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OR_EXPRESSION___TO_STRING = eINSTANCE.getOrExpression__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.AndExpressionImpl <em>And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.AndExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getAndExpression()
		 * @generated
		 */
		EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation AND_EXPRESSION___TO_STRING = eINSTANCE.getAndExpression__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.GreaterExpressionImpl <em>Greater Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GreaterExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getGreaterExpression()
		 * @generated
		 */
		EClass GREATER_EXPRESSION = eINSTANCE.getGreaterExpression();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GREATER_EXPRESSION___TO_STRING = eINSTANCE.getGreaterExpression__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.GreaterOrEqualExpressionImpl <em>Greater Or Equal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GreaterOrEqualExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getGreaterOrEqualExpression()
		 * @generated
		 */
		EClass GREATER_OR_EQUAL_EXPRESSION = eINSTANCE.getGreaterOrEqualExpression();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GREATER_OR_EQUAL_EXPRESSION___TO_STRING = eINSTANCE.getGreaterOrEqualExpression__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.LessExpressionImpl <em>Less Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.LessExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getLessExpression()
		 * @generated
		 */
		EClass LESS_EXPRESSION = eINSTANCE.getLessExpression();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LESS_EXPRESSION___TO_STRING = eINSTANCE.getLessExpression__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.LessOrEqualExpressionImpl <em>Less Or Equal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.LessOrEqualExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getLessOrEqualExpression()
		 * @generated
		 */
		EClass LESS_OR_EQUAL_EXPRESSION = eINSTANCE.getLessOrEqualExpression();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LESS_OR_EQUAL_EXPRESSION___TO_STRING = eINSTANCE.getLessOrEqualExpression__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.AffectationExpressionImpl <em>Affectation Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.AffectationExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getAffectationExpression()
		 * @generated
		 */
		EClass AFFECTATION_EXPRESSION = eINSTANCE.getAffectationExpression();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation AFFECTATION_EXPRESSION___TO_STRING = eINSTANCE.getAffectationExpression__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.LeftShiftExpressionImpl <em>Left Shift Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.LeftShiftExpressionImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getLeftShiftExpression()
		 * @generated
		 */
		EClass LEFT_SHIFT_EXPRESSION = eINSTANCE.getLeftShiftExpression();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LEFT_SHIFT_EXPRESSION___TO_STRING = eINSTANCE.getLeftShiftExpression__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.StringLiteralImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getStringLiteral()
		 * @generated
		 */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STRING_LITERAL___TO_STRING = eINSTANCE.getStringLiteral__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.IntegerLiteralImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getIntegerLiteral()
		 * @generated
		 */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INTEGER_LITERAL___TO_STRING = eINSTANCE.getIntegerLiteral__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.DoubleLiteralImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getDoubleLiteral()
		 * @generated
		 */
		EClass DOUBLE_LITERAL = eINSTANCE.getDoubleLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_LITERAL__VALUE = eINSTANCE.getDoubleLiteral_Value();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOUBLE_LITERAL___TO_STRING = eINSTANCE.getDoubleLiteral__ToString();

		/**
		 * The meta object literal for the '{@link fr.inria.atlanmod.mogwai.gremlin.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.BooleanLiteralImpl
		 * @see fr.inria.atlanmod.mogwai.gremlin.impl.GremlinPackageImpl#getBooleanLiteral()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

		/**
		 * The meta object literal for the '<em><b>To String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOOLEAN_LITERAL___TO_STRING = eINSTANCE.getBooleanLiteral__ToString();

	}

} //GremlinPackage
