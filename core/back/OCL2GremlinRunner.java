package fr.inria.atlanmod.mogwai.transformation;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.eclipse.core.runtime.NullProgressMonitor;
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
			modules.add(this.getClass().getResourceAsStream("ocl2gremlin.asm"));
			modules.add(this.getClass().getResourceAsStream("mathExpressions.asm"));
			modules.add(this.getClass().getResourceAsStream("literals.asm"));
			modules.add(this.getClass().getResourceAsStream("common.asm"));
			modules.add(this.getClass().getResourceAsStream("collections.asm"));
			modules.add(this.getClass().getResourceAsStream("collectionOperations.asm"));
			transformationLauncher.addLibrary("common",this.getClass().getResourceAsStream("common.asm") );
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
