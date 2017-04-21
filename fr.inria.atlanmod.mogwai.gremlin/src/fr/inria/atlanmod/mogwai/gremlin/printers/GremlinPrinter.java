package fr.inria.atlanmod.mogwai.gremlin.printers;

import org.eclipse.emf.ecore.EObject;

public interface GremlinPrinter {

	public abstract String print(EObject eObject);

}
