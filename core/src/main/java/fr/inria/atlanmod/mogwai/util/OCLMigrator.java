package fr.inria.atlanmod.mogwai.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;

/**
 * Parse a given ocl file into its XMI representation
 * 
 * @author AtlanMod - Inria
 *
 */
class OCLMigrator {

	/**
	 * Create the XMI model corresponding to the given ocl resource.
	 * The result is put in the output folder
	 * @param oclURI the URI of the ocl file to migrate
	 */
	public static void migrate(EPackage packageInOcl, URI oclURI) {
		OCLParser oclParser = new OCLParser(packageInOcl);
		System.out.println("Migrating " + oclURI.toString());
		URI cleanedFileURI = removeImports(oclURI);
		System.out.println("Created " + cleanedFileURI.toString() + " without import statements");
		String fileName = oclURI.lastSegment().substring(0,oclURI.lastSegment().length()-4);
		URI outputURI = URI.createURI("tmp/"+fileName+".xmi");
		if(new File(outputURI.toFileString()).exists()) {
			System.out.println("[Warning] File " + outputURI.toString() + " already exists");
		}
		else {
			oclParser.parseFile(cleanedFileURI, outputURI);
			System.out.println("Created " + outputURI.toString());
		}
		File cleanedFile = new File(cleanedFileURI.toString());
		cleanedFile.delete();
		System.out.println("Deleted " + cleanedFileURI.toString() + " (tmp file)");
	}
	
	public static void cleanTmpFiles() {
		File tmpFolder = new File("tmp");
		File[] tmpFiles = tmpFolder.listFiles();
		for(int i = 0 ; i < tmpFiles.length ; i++) {
			tmpFiles[i].delete();
		}
		tmpFolder.delete();
	}
	
	public static URI removeImports(URI oclFileURI) {
		String newFileName = oclFileURI.trimFileExtension().toFileString();
		newFileName = newFileName+"_tmp.ocl";
		PrintWriter newFileWriter = null;
		URI newURI = URI.createURI(newFileName);
		try {
			BufferedReader br = new BufferedReader(new FileReader(oclFileURI.toFileString()));
			newFileWriter = new PrintWriter(newFileName);
			String line;
			while ((line = br.readLine()) != null) {
			   if(!line.contains("import")) {
				   newFileWriter.println(line);
			   }
			}
			br.close();
		}catch(FileNotFoundException e) {
			System.out.println("Cannot open the file");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}finally {
			newFileWriter.close();
		}
		return newURI;
	}
	
}
