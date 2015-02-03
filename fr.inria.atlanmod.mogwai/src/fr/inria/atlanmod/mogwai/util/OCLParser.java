package fr.inria.atlanmod.mogwai.util;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;


class OCLParser {
	
	@SuppressWarnings("rawtypes")
	private OCL ocl;
	
	public OCLParser(EPackage ePackage) {
		EPackage.Registry registry = new EPackageRegistryImpl();
		registry.put(ePackage.getNsURI(), ePackage);
		this.ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
	}
	
	public Constraint parseTextualOCL(String oclQuery) {
		OCLInput document = new OCLInput(oclQuery);
		try {
			List<Constraint> constraints = ocl.parse(document);
			assert constraints.size() > 0;
			// TODO Handle multiple constraints at once
			return constraints.get(0);
		} catch (ParserException e) {
			System.out.println("Can not parse OCL Query");
			e.printStackTrace();
		}
		return null;
	}
}
