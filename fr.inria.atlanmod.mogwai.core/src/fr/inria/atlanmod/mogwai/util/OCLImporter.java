package fr.inria.atlanmod.mogwai.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;

import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;

/**
 * A utility class the provides methods to parse OCL expressions from different
 * source.
 * 
 * @author Gwendal DANIEL
 *
 */
public class OCLImporter {

	/**
	 * Parses the OCL file at the given {@code location} and returns the
	 * {@link Constraint} it contains.
	 * <p>
	 * This method will register the given {@code ePackage} before parsing the
	 * file in order to avoid parsing errors.
	 * <p>
	 * TODO Allow multiple constraints definition in a single OCL file
	 * 
	 * @param location
	 *            the {@link URI} of the OCL file to parse
	 * @param ePackage
	 *            the EPackage describing the meta-elements used in the
	 *            constraints
	 * @return the {@link Constraint} contained in the OCL file
	 * 
	 * @throws MogwaiCoreException
	 *             if {@code location} cannot be parsed to a valid OCL
	 *             {@link Constraint}
	 */
	public static Constraint parseOCL(URI location, EPackage ePackage) throws MogwaiCoreException {
		OCLParser parser = new OCLParser(ePackage);
		String cleanOCLQuery = removeImports(location);
		Constraint constraint = parser.parseTextualOCL(cleanOCLQuery);
		return constraint;
	}

	/**
	 * Parses the OCL file at the given {@code location} and returns the
	 * {@link Constraint} is contains.
	 * <p>
	 * This method assumes the {@link EPackage} accessed in the
	 * {@link Constraint} has been registered before.
	 * 
	 * @param location
	 *            the {@link URI} of the OCL file to parse
	 * @return the {@link Constraint} contained in the OCL file
	 * 
	 * @throws MogwaiCoreException
	 *             if {@code location} cannot be parsed to a valid OCL
	 *             {@link Constraint}
	 */
	public static Constraint parseOCL(URI location) throws MogwaiCoreException {
		OCLParser parser = new OCLParser();
		String cleanOCLQuery = removeImports(location);
		Constraint constraint = parser.parseTextualOCL(cleanOCLQuery);
		return constraint;
	}

	/**
	 * Parses the provided textual {@code oclExpression} and returns the
	 * {@link Constraint} it defines.
	 * 
	 * @param oclExpression
	 *            the textual OCL expression to parse
	 * @param context
	 *            the {@link EClassifier} representing the context of the OCL
	 *            expression to parse
	 * @return the {@link Constraint} parsed from the input
	 *         {@code oclExpression}
	 * @throws MogwaiCoreException
	 *             if the provided {@code oclExpression} cannot be parsed to a
	 *             valid OCL {@link Constraint}
	 */
	public static OCLExpression parseInlineOCL(String oclExpression, EClassifier context) throws MogwaiCoreException {
		OCLParser parser = new OCLParser(context.getEPackage());
		return parser.parseInlineOCL(oclExpression, context);
	}

	/**
	 * Remove the "import" statements in the OCL file at the oclFileURI location
	 * <p>
	 * <b>Note:</b> This method is called to fix parsing errors from unresolved
	 * imports
	 * 
	 * @param oclFileURI
	 *            the {@link URI} of the OCL file to process
	 * @return a {@link String} representation of the OCL document without
	 *         import statements
	 * 
	 * @throws MogwaiCoreException
	 *             if {@code oclFileURI} cannot be found
	 */
	private static String removeImports(URI oclFileURI) throws MogwaiCoreException {
		StringBuffer oclQuery = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(oclFileURI.toFileString()));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.contains("import")) {
					oclQuery.append(line);
					oclQuery.append("\n");
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			throw new MogwaiCoreException("Cannot find {0}", oclFileURI.toFileString());
		} catch (IOException e) {
			throw new MogwaiCoreException("Cannot read {0}", oclFileURI.toFileString());
		}
		return oclQuery.toString();
	}

}
