package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.mogwai.gremlin.printers.DefaultGremlinPrinter;
import fr.inria.atlanmod.mogwai.transformation.atl.files.ATL2Gremlin;

public class TestATL2Gremlin {

	/***
	 * Compile Class2Relational into a Gremlin resource
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		ATL2Gremlin atl2gremlin = new ATL2Gremlin();
		
		Resource r = atl2gremlin.transform(URI
				.createURI("materials/ClassDiagram2Relational/ATLFiles/Class2Relational-simple.atl"));
		
		DefaultGremlinPrinter printer = new DefaultGremlinPrinter();
		System.out.println(printer.print(r.getContents().get(0)));
		
//		Resource r = atl2gremlin.transform(URI
//				.createURI("materials/ClassDiagram2Relational/ATLFiles/Class2Relational.atl"));
//		System.out.println(r.getContents().get(0));
	}

}
