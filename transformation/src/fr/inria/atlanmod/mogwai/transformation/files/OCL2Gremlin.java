package fr.inria.atlanmod.mogwai.transformation.files;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.eclipse.m2m.atl.engine.emfvm.ASM;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;

public class OCL2Gremlin {

	private ModelFactory modelFactory;
	private IReferenceModel inputMetamodel;
	private IReferenceModel outputMetamodel;
	private ILauncher transformationLauncher;
	private EPackage.Registry registry;
	private EMFInjector injector;
	private EMFExtractor extractor;
	private ResourceSet resSet;
	private List<ASM> modules;
	private ASM ASMCommon;
	
	public OCL2Gremlin() {
		try {
			ATLLogger.getLogger().setLevel(Level.ALL);
			
			transformationLauncher = new EMFVMLauncher();
			modelFactory = new EMFModelFactory();
			injector = new EMFInjector();
			extractor = new EMFExtractor();
			
			inputMetamodel = modelFactory.newReferenceModel();
			registry = new EPackageRegistryImpl();
			registry.put("http://www.eclipse.org/emf/2002/Ecore", EcorePackage.eINSTANCE);
			registry.put("http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore", OCLStandardLibraryImpl.stdlibPackage);
			registry.put(GremlinPackage.eINSTANCE.getNsURI(), GremlinPackage.eINSTANCE);
			
			injector.inject(inputMetamodel, "http://www.eclipse.org/ocl/1.1.0/Ecore");
			outputMetamodel = modelFactory.newReferenceModel();
			injector.inject(outputMetamodel, "fr.inria.atlanmod.ocl2query.gremlin");
			
			resSet = new ResourceSetImpl();
			resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			
			transformationLauncher.initialize(new HashMap<String,Object>());
			modules = new ArrayList<ASM>();
			modules.add((ASM)transformationLauncher.loadModule(getFileURL("ocl2gremlin.asm").openStream()));
			modules.add((ASM)transformationLauncher.loadModule(getFileURL("mathExpressions.asm").openStream()));
			modules.add((ASM)transformationLauncher.loadModule(getFileURL("literals.asm").openStream()));
			modules.add((ASM)transformationLauncher.loadModule(getFileURL("collections.asm").openStream()));
			modules.add((ASM)transformationLauncher.loadModule(getFileURL("collectionOperations.asm").openStream()));
			ASMCommon = (ASM)transformationLauncher.loadModule(getFileURL("common.asm").openStream());
			transformationLauncher.addLibrary("common",ASMCommon);
			
		} catch(ATLCoreException e) {
			e.printStackTrace();
		} catch(IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("restriction")
	public EObject transform(EPackage packageInOcl, Constraint exp) {
		try {
			
			registry.put(packageInOcl.getNsURI(), packageInOcl);
			
			Resource oclResource = resSet.createResource(URI.createURI("oclInput"));
			oclResource.getContents().add(exp);
			
			IModel inputModel = modelFactory.newModel(inputMetamodel);
			injector.inject(inputModel, oclResource);
			
			IModel gModel = modelFactory.newModel(outputMetamodel);
			
			transformationLauncher = new EMFVMLauncher();
			transformationLauncher.initialize(new HashMap<String,Object>());
			transformationLauncher.addLibrary("common", ASMCommon);

			transformationLauncher.addInModel(inputModel, "IN", "OCL");
			transformationLauncher.addOutModel(gModel, "OUT", "Gremlin");

			transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), new HashMap<String, Object>(), modules.toArray());
			
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
			return gremlinResource.getContents().get(0);
		}catch(ATLCoreException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void finalize() throws Throwable {
		EMFModelFactory emfModelFactory = (EMFModelFactory)modelFactory;
		emfModelFactory.unload((EMFReferenceModel)inputMetamodel);
		emfModelFactory.unload((EMFReferenceModel)outputMetamodel);
		super.finalize();
	}
	
	protected static URL getFileURL(String fileName) throws IOException {
		URL fileURL;
		if (isEclipseRunning()) {
			URL resourceURL = OCL2Gremlin.class.getResource(fileName);
			if (resourceURL != null) {
				fileURL = FileLocator.toFileURL(resourceURL);
			} else {
				fileURL = null;
			}
		} else {
			fileURL = OCL2Gremlin.class.getResource(fileName);
		}
		if (fileURL == null) {
			throw new IOException("'" + fileName + "' not found");
		} else {
			return fileURL;
		}
	}

	/**
	 * Tests if eclipse is running.
	 * 
	 * @return <code>true</code> if eclipse is running
	 *
	 * @generated
	 */
	public static boolean isEclipseRunning() {
		try {
			return Platform.isRunning();
		} catch (Throwable exception) {
			// Assume that we aren't running.
		}
		return false;
	}
	
}
