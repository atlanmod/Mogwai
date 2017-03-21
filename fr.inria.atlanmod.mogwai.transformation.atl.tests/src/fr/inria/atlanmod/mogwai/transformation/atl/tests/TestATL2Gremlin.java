package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.mogwai.gremlin.printers.DefaultGremlinPrinter;
import fr.inria.atlanmod.mogwai.gremlin.printers.MogwaiATLGremlinPrinter;
import fr.inria.atlanmod.mogwai.transformation.atl.files.ATL2Gremlin;
import fr.inria.atlanmod.neoemf.logging.NeoLogger;

public class TestATL2Gremlin {

	/***
	 * Compile Class2Relational into a Gremlin resource
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		ATL2Gremlin atl2gremlin = new ATL2Gremlin();
		atl2gremlin.enableATLDebug();
		
		long start = System.currentTimeMillis();
		Resource r = atl2gremlin.transform(URI
				.createURI("materials/ClassDiagram2Relational/ATLFiles/Class2Relational-simple.atl"));
		long stop = System.currentTimeMillis();
		System.out.println("Transformation performed in " + (stop - start) + "ms");
		
		r.setURI(URI.createURI("materials/ClassDiagram2Relational/ATLFiles/Class2Relational-simple-gremlin.xmi"));
		r.save(Collections.emptyMap());
		
		MogwaiATLGremlinPrinter printer = new MogwaiATLGremlinPrinter();
		System.out.println(printer.print(r.getContents().get(0)));
		
//		Resource r = atl2gremlin.transform(URI
//				.createURI("materials/ClassDiagram2Relational/ATLFiles/Class2Relational.atl"));
//		System.out.println(r.getContents().get(0));
	}

}
