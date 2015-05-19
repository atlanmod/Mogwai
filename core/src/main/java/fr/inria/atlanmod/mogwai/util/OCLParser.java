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
	
	@SuppressWarnings("unchecked")
	public void parseFile(URI input, URI output) {
	    throw new Error("Not implemented");
//		try {
		//	URIHandler uriHandler = new FileURIHandlerImpl();
		//	InputStream in = uriHandler.createInputStream(input, Collections.EMPTY_MAP);
		//	OCLInput document = new OCLInput(in);
		//	ResourceSet resSet = new ResourceSetImpl();
		//	resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		//	Resource res = resSet.createResource(output);
		//	res.getContents().addAll(ocl.parse(document));
		//	res.save(Collections.EMPTY_MAP);
//		} catch(IOException e) {
//			System.out.println("IOException, please verify input and output file path.");
//			e.printStackTrace();
//			// parser exception
//		} catch(Exception e) {
//			System.out.println("Parser exception");
//			e.printStackTrace();
//		}
	}
}
