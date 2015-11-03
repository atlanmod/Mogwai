package fr.inria.atlanmod.mogwai.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.Constraint;

public class MogwaiUtil {

	public static Constraint parseOCL(URI oclFileURI, EPackage ePackage) {
		OCLParser parser = new OCLParser(ePackage);
		System.out.println("Migrating " + oclFileURI.toString());
		String cleanOCLQuery = removeImports(oclFileURI);
		Constraint constraint = parser.parseTextualOCL(cleanOCLQuery);
		return constraint;
	}
	
	public static Constraint parseOCL(URI oclFileURI, Resource resource) {
		OCLParser oclParser = new OCLParser(resource.getContents().get(0).eClass().getEPackage());
		System.out.println("Migrating " + oclFileURI.toString());
		String cleanOCLQuery = removeImports(oclFileURI);
		//String fileName = oclURI.lastSegment().substring(0,oclURI.lastSegment().length()-4);
		//URI outputURI = URI.createURI("tmp/"+fileName+".xmi");
		//if(new File(outputURI.toFileString()).exists()) {
		//	System.out.println("[Warning] File " + outputURI.toString() + " already exists");
		//}
		//else {
		Constraint constraint= oclParser.parseTextualOCL(cleanOCLQuery);
		return constraint;
		//	System.out.println("Created " + outputURI.toString());
		//}
		//File cleanedFile = new File(cleanedFileURI.toString());
		//cleanedFile.delete();
		//System.out.println("Deleted " + cleanedFileURI.toString() + " (tmp file)");
	}
	
	private static String removeImports(URI oclFileURI) {
		/*String newFileName = oclFileURI.trimFileExtension().toFileString();
		newFileName = newFileName+"_tmp.ocl";
		PrintWriter newFileWriter = null;
		URI newURI = URI.createURI(newFileName);*/
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
