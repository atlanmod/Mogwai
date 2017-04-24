package fr.inria.atlanmod.mogwai.transformation.atl.tests.java2kdm;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmt.modisco.java.emf.JavaPackage;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage;

import fr.inria.atlanmod.mogwai.gremlin.printers.MogwaiATLGremlinPrinter;
import fr.inria.atlanmod.mogwai.transformation.atl.files.ATL2Gremlin;

public class Java2KDM2Gremlin {

	/***
	 * Compile Class2Relational into a Gremlin resource
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		ATL2Gremlin atl2gremlin = new ATL2Gremlin();
		atl2gremlin.enableATLDebug();

		ResourceSet rs = new ResourceSetImpl();
		Resource targetMM = rs.getResource(URI.createFileURI("/home/gdaniel/Bureau/eclipse-mog/eclipse/workspace/org.eclipse.gmt.modisco.omg.kdm/model/kdm.ecore"), true);
		EPackage targetPackage = (EPackage)targetMM.getContents().get(0);

		long start = System.currentTimeMillis();
		Resource r = atl2gremlin.transform(
				URI.createURI("materials/java2kdm/java2kdm_simple.atl"),
				"java",
				JavaPackage.eINSTANCE, 
				"kdm",
				targetPackage);
		// watch out: KDM contains multiple packages and I don't know how to deal with this
		long stop = System.currentTimeMillis();
		System.out.println("Transformation performed in " + (stop - start) + "ms");

		r.setURI(URI.createURI("materials/java2kdm/java2kdm_simple_gremlin.xmi"));
		r.save(Collections.emptyMap());

		MogwaiATLGremlinPrinter printer = new MogwaiATLGremlinPrinter();
		System.out.println(printer.print(r.getContents().get(0)));
	}

}
