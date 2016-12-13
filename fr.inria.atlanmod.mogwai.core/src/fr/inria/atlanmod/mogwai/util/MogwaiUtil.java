package fr.inria.atlanmod.mogwai.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;

public class MogwaiUtil {

	/**
	 * Returns true if an EMF resource can be used by Mogwaï
	 * @param resource the resource to check
	 * @return true if the resource can be used by Mogwaï, false otherwise
	 */
	public static boolean isMogwaiCompatible(Resource resource) {
		return (resource instanceof MogwaiResource) || resource.getURI().scheme().equals(BlueprintsURI.SCHEME);
	}
	
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
	 * Parse the OCL file at the given URI and return the constraints it contains
	 * @param oclFileURI the URI of the OCL file to parse
	 * @param resource the Resource containing the model to compute the constraints on
	 * @return the Constraint contained in the OCL file
	 * 
	 * TODO Allow multiple constraints definition in a single OCL file
	 */
//	public static Constraint parseOCL(URI oclFileURI, Resource resource) {
//		return parseOCL(oclFileURI, resource.getContents().get(0).eClass().getEPackage());
//	}
	
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
			//newFileWriter = new PrintWriter(newFileName);
			String line;
			while ((line = br.readLine()) != null) {
			   if(!line.contains("import")) {
				   oclQuery.append(line);
				   oclQuery.append("\n");
			   }
			}
			br.close();
		}catch(FileNotFoundException e) {
			System.out.println("Can not find " + oclFileURI.toFileString());
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("Can not read " + oclFileURI.toFileString());
		}
		return oclQuery.toString();
	}
	
}
