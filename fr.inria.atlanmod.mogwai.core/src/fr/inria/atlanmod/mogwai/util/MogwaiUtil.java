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

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.core.MogwaiException;

public class MogwaiUtil {

	/**
	 * Parse the OCL file at the given location and return the {@link Constraint} it contains
	 * <p>
	 * This method will register the given {@link EPackage} before parsing the file in order
	 * to avoid parse errors.
	 * </p>
	 * @param location the URI of the OCL file to parse
	 * @param ePackage the EPackage describing the meta-elements used in the constraints
	 * @return the {@link Constraint} contained in the OCL file
	 * 
	 * TODO Allow multiple constraints definition in a single OCL file
	 */
	public static Constraint parseOCL(URI location, EPackage ePackage) {
		OCLParser parser = new OCLParser(ePackage);
		String cleanOCLQuery = removeImports(location);
		Constraint constraint = parser.parseTextualOCL(cleanOCLQuery);
		return constraint;
	}
	
	/**
	 * Parse the OCL file at the given location and return the {@link Constraint} is contains
	 * <p>
	 * This method assumes the accessed {@link EPackage} in the {@link Constraint} has been
	 * registered somehow before
	 * </p>
	 * @param location the URI of the OCL file to parse
	 * @return the {@link Constraint} contained in the OCL file
	 */
	public static Constraint parseOCL(URI location) {
		OCLParser parser = new OCLParser();
		String cleanOCLQuery = removeImports(location);
		Constraint constraint = parser.parseTextualOCL(cleanOCLQuery);
		return constraint;
	}
	
	public static OCLExpression parseInlineOCL(String oclExpression, EClassifier context) throws MogwaiException {
		OCLParser parser = new OCLParser(context.getEPackage());
		return parser.parseInlineOCL(oclExpression, context);
	}
	
	/**
	 * Remove the "import" statements in the OCL file at the oclFileURI location
	 * <p>
	 * This method is called to fix parsing errors from unresolved imports
	 * </p>
	 * @param oclFileURI the URI of the OCL file to process
	 * @return a String containing the OCL document without import statements
	 */
	private static String removeImports(URI oclFileURI) {
		StringBuffer oclQuery = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(oclFileURI.toFileString()));
			String line;
			while ((line = br.readLine()) != null) {
			   if(!line.contains("import")) {
				   oclQuery.append(line);
				   oclQuery.append("\n");
			   }
			}
			br.close();
		}catch(FileNotFoundException e) {
			MogwaiLogger.error("Cannot find {0}", oclFileURI.toFileString());
			e.printStackTrace();
		}catch(IOException e) {
			MogwaiLogger.error("Cannot read {0}", oclFileURI.toFileString());
		}
		return oclQuery.toString();
	}
	
}
