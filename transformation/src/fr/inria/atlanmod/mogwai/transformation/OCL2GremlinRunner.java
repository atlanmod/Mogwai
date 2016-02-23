package fr.inria.atlanmod.mogwai.transformation;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.osgi.framework.Bundle;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;

public class OCL2GremlinRunner {

	public EObject transform(EPackage packageInOcl, Constraint exp) {
		try {
			
			ATLLogger.getLogger().setLevel(Level.OFF);
			
			ILauncher transformationLauncher = new EMFVMLauncher();
			ModelFactory modelFactory = new EMFModelFactory();
			EMFInjector injector = new EMFInjector();
			EMFExtractor extractor = new EMFExtractor();
	
			IReferenceModel inputMetamodel = modelFactory.newReferenceModel();
			EPackage.Registry registry = new EPackageRegistryImpl();
			registry.put("http://www.eclipse.org/emf/2002/Ecore", EcorePackage.eINSTANCE);
			registry.put(GremlinPackage.eINSTANCE.getNsURI(), GremlinPackage.eINSTANCE);
			registry.put(packageInOcl.getNsURI(), packageInOcl);
			registry.put(
				     "http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore",
				     OCLStandardLibraryImpl.stdlibPackage);
			injector.inject(inputMetamodel, "http://www.eclipse.org/ocl/1.1.0/Ecore");
			IReferenceModel outputMetamodel = modelFactory.newReferenceModel();
			injector.inject(outputMetamodel, "fr.inria.atlanmod.ocl2query.gremlin");
			
			ResourceSet resSet = new ResourceSetImpl();
			resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			Resource oclResource = resSet.createResource(URI.createURI("oclInput"));
			oclResource.getContents().add(exp);
			
			IModel inputModel = modelFactory.newModel(inputMetamodel);
			injector.inject(inputModel, oclResource);
			
			IModel gModel = modelFactory.newModel(outputMetamodel);
			
			transformationLauncher.initialize(new HashMap<String, Object>());
			transformationLauncher.addInModel(inputModel, "IN", "OCL");
			transformationLauncher.addOutModel(gModel, "OUT", "Gremlin");
			
			List<Object> modules = new ArrayList<Object>();
//			modules.add(this.getClass().getResourceAsStream("/atl/ocl2gremlin.asm"));
//			modules.add(this.getClass().getResourceAsStream("/atl/mathExpressions.asm"));
//			modules.add(this.getClass().getResourceAsStream("/atl/literals.asm"));
//			modules.add(this.getClass().getResourceAsStream("/atl/common.asm"));
//			modules.add(this.getClass().getResourceAsStream("/atl/collections.asm"));
//			modules.add(this.getClass().getResourceAsStream("/atl/collectionOperations.asm"));
			
			InputStream o2gIS = this.getClass().getResourceAsStream("/atl/ocl2gremlin.asm");
			if(o2gIS == null) {
				System.out.println("using OSGI resolver");
				try {
				URL ocl2gremlinURL = new URL("platform:/plugin/fr.inria.atlanmod.mogwai.transformation/atl/ocl2gremlin.asm");
				URL mathExpressionsURL = new URL("platform:/plugin/fr.inria.atlanmod.mogwai.transformation/atl/mathExpressions.asm");
				URL literalsURL = new URL("platform:/plugin/fr.inria.atlanmod.mogwai.transformation/atl/literals.asm");
				URL commonURL = new URL("platform:/plugin/fr.inria.atlanmod.mogwai.transformation/atl/common.asm");
				URL collectionsURL = new URL("platform:/plugin/fr.inria.atlanmod.mogwai.transformation/atl/collections.asm");
				URL collectionOperationURL = new URL("platform:/plugin/fr.inria.atlanmod.mogwai.transformation/atl/collectionOperations.asm");

//				Bundle b = Platform.getBundle("fr.inria.atlanmod.mogwai.transformation");
//				Path ocl2gremlinPath = new Path("atl/ocl2gremlin.asm");
//				Path mathExpressionsPath = new Path("atl/mathExpressions.asm");
//				Path literalsPath = new Path("atl/literals.asm");
//				Path commonPath = new Path("atl/common.asm");
//				Path collectionsPath = new Path("atl/collections.asm");
//				Path collectionOperationsPath = new Path("atl/collectionOperations.asm");
				
				modules.add(ocl2gremlinURL.openConnection().getInputStream());
				modules.add(mathExpressionsURL.openConnection().getInputStream());
				modules.add(literalsURL.openConnection().getInputStream());
				modules.add(commonURL.openConnection().getInputStream());
				modules.add(collectionsURL.openConnection().getInputStream());
				modules.add(collectionOperationURL.openConnection().getInputStream());
				transformationLauncher.addLibrary("common",commonURL.openConnection().getInputStream());
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("using standard resolver");
				modules.add(this.getClass().getResourceAsStream("/atl/ocl2gremlin.asm"));
				modules.add(this.getClass().getResourceAsStream("/atl/mathExpressions.asm"));
				modules.add(this.getClass().getResourceAsStream("/atl/literals.asm"));
				modules.add(this.getClass().getResourceAsStream("/atl/common.asm"));
				modules.add(this.getClass().getResourceAsStream("/atl/collections.asm"));
				modules.add(this.getClass().getResourceAsStream("/atl/collectionOperations.asm"));
				transformationLauncher.addLibrary("common",this.getClass().getResourceAsStream("/atl/common.asm") );
			}
			
//			System.out.println(modules.get(0));
			
//			transformationLauncher.addLibrary("common",this.getClass().getResourceAsStream("/atl/common.asm") );
			
			

			
			transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), new HashMap<String, Object>(), modules.get(0), modules.get(1), modules.get(2), modules.get(4), modules.get(5));
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			extractor.extract(gModel, os, null);
			Resource gremlinResource = resSet.createResource(URI.createURI("gremlinOutput"));
			try {
				gremlinResource.load(new ByteArrayInputStream(os.toByteArray()), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*
			 * Unload all models and metamodels
			 */
			EMFModelFactory emfModelFactory = (EMFModelFactory)modelFactory;
			emfModelFactory.unload((EMFModel)gModel);
			emfModelFactory.unload((EMFModel)inputModel);
			emfModelFactory.unload((EMFReferenceModel)inputMetamodel);
			emfModelFactory.unload((EMFReferenceModel)outputMetamodel);
			return gremlinResource.getContents().get(0);
		}catch(ATLCoreException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
