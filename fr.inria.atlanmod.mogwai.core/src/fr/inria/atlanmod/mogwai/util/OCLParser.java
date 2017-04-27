package fr.inria.atlanmod.mogwai.util;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;

/**
 * A utility class that provides methods to parse textual OCL expressions.
 * <p>
 * TODO: this class should be merged with {@link OCLImporter}.
 * 
 * @author Gwendal DANIEL
 *
 */
class OCLParser {

	/**
	 * The {@link OCL} instance used to parse the textual OCL expressions.
	 */
	@SuppressWarnings("rawtypes")
	private OCL ocl;

	/**
	 * The {@link OCLHelper} instance used to create OCL {@link Constraint}s
	 * from the parsed OCL expressions.
	 */
	@SuppressWarnings("rawtypes")
	private OCLHelper oclHelper;

	/**
	 * Creates a new OCLParser and registers the given {@link EPackage} to avoid
	 * OCL parse errors.
	 * 
	 * @param ePackage
	 *            the {@link EPackage} to register
	 */
	public OCLParser(EPackage ePackage) {
		this();
		if (!EPackage.Registry.INSTANCE.containsKey(ePackage.getNsURI())) {
			EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
		}
	}

	/**
	 * Creates a new OCLParser assuming the {@link EPackage} accessed in the OCL
	 * expression has been previously registered.
	 */
	public OCLParser() {
		this.ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		this.oclHelper = ocl.createOCLHelper();
	}

	/**
	 * Parses {@code oclQuery} and returns the created OCL {@link Constraint}.
	 * 
	 * @param oclQuery
	 *            the textual OCL expression to parse
	 * @return the created OCL {@link Constraint}
	 * @throws MogwaiCoreException
	 *             if {@code oclQuery} cannot be parsed
	 */
	public Constraint parseTextualOCL(String oclQuery) throws MogwaiCoreException {
		OCLInput document = new OCLInput(oclQuery);
		try {
			@SuppressWarnings("unchecked")
			List<Constraint> constraints = ocl.parse(document);
			assert constraints.size() > 0;
			// TODO Handle multiple constraints at once
			return constraints.get(0);
		} catch (ParserException e) {
			throw new MogwaiCoreException("Cannot parse the provided OCL expression {0}: {1}", oclQuery, e.getMessage());
		}
	}

	/**
	 * Parses {@code oclExpression} and returns the created
	 * {@link OCLExpression}.
	 * 
	 * @param oclExpression
	 *            the textual OCL expression to parse
	 * @param context
	 *            the {@link EClassifier} representing the context of the OCL
	 *            expression to parse
	 * @return the created {@link OCLExpression}
	 * @throws MogwaiCoreException
	 *             if {@code oclExpression} cannot be parsed
	 */
	@SuppressWarnings("unchecked")
	public OCLExpression parseInlineOCL(String oclExpression, EClassifier context) throws MogwaiCoreException {
		oclHelper.setContext(context);
		try {
			return (OCLExpression) oclHelper.createQuery(oclExpression);
		} catch (ParserException e) {
			throw new MogwaiCoreException("Cannot parse the provided OCL expression {0}: {1}", oclExpression,
					e.getMessage());
		}
	}

}
