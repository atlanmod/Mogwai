package fr.inria.atlanmod.mogwai.transformation.atl.files;

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
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.eclipse.m2m.atl.common.ATL.ATLPackage;
import org.eclipse.m2m.atl.common.OCL.OCLPackage;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceFactoryImpl;
import org.eclipse.m2m.atl.engine.emfvm.ASM;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;

public class ATL2Gremlin {

	private ModelFactory modelFactory;
	private IReferenceModel inputMetamodel;
	private IReferenceModel outputMetamodel;
	private ILauncher transformationLauncher;
	private EPackage.Registry registry;
	private EMFInjector injector;
	private EMFExtractor extractor;
	private ResourceSet rSet;
	private List<ASM> modules;
	// private ASM ASMCommon;
	
	
	public ATL2Gremlin() {
		try {
			// Default value
			ATLLogger.getLogger().setLevel(Level.OFF);
			
			transformationLauncher = new EMFVMLauncher();
			modelFactory = new EMFModelFactory();
			injector = new EMFInjector();
			extractor = new EMFExtractor();
			
			inputMetamodel = modelFactory.newReferenceModel();
			registry = new EPackageRegistryImpl();
			registry.put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
			registry.put(ATLPackage.eINSTANCE.getNsURI(), ATLPackage.eINSTANCE);
			registry.put(OCLPackage.eINSTANCE.getNsURI(), OCLPackage.eINSTANCE);
			registry.put(GremlinPackage.eINSTANCE.getNsURI(), GremlinPackage.eINSTANCE);
			
			// TODO check this works
			injector.inject(inputMetamodel, ATLPackage.eINSTANCE.getNsURI());
			outputMetamodel = modelFactory.newReferenceModel();
			injector.inject(outputMetamodel, GremlinPackage.eINSTANCE.getNsURI());
			
			rSet = new ResourceSetImpl();
			rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreFactoryImpl());
			rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
			
			transformationLauncher.initialize(new HashMap<String, Object>());
			modules = new ArrayList<>();
			
			InputStream atl2gremlinStream = getFileURL("atl2gremlin.asm").openStream();
			
			modules.add((ASM) transformationLauncher.loadModule(atl2gremlinStream));
			
			atl2gremlinStream.close();
			
			
		} catch(ATLCoreException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Transform the input ATL resource into a Gremlin resource containing the script
	 * to execute to perform the transformation
	 * <p/>
	 * @param inputResource the resource containing the ATL model to transform
	 * @return a {@link Resource} containing the Gremlin script corresponding to the transformation
	 */
	public Resource transform(Resource inputResource) {
		try {
			IModel inputModel = modelFactory.newModel(inputMetamodel);
			injector.inject(inputModel, inputResource);
			
			IModel gModel = modelFactory.newModel(outputMetamodel);
			
			transformationLauncher = new EMFVMLauncher();
			transformationLauncher.initialize(new HashMap<String, Object>());
			
			transformationLauncher.addInModel(inputModel, "IN", "ATL");
			transformationLauncher.addOutModel(gModel, "OUT", "Gremlin");
			
			transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), new HashMap<String, Object>(), modules.toArray());
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			extractor.extract(gModel, os, null);
			Resource gremlinResource = rSet.createResource(URI.createURI("gremlinOutput"));
			
			try {
				gremlinResource.load(new ByteArrayInputStream(os.toByteArray()), null);
			} catch(IOException e) {
				e.printStackTrace();
			}
			/*
			 * Unload all models and metamodels
			 */
			EMFModelFactory emfModelFactory = (EMFModelFactory) modelFactory;
			emfModelFactory.unload((EMFModel) gModel);
			emfModelFactory.unload((EMFModel)inputModel);
			return gremlinResource;
		} catch(ATLCoreException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected static URL getFileURL(String fileName) throws IOException {
		URL fileURL;
		if(isEclipseRunning()) {
			URL resourceURL = ATL2Gremlin.class.getResource(fileName);
			if(resourceURL != null) {
				fileURL = FileLocator.toFileURL(resourceURL);
			} else {
				fileURL = null;
			}
		} else {
			fileURL = ATL2Gremlin.class.getResource(fileName);
		}
		if(fileURL == null) {
			throw new IOException("'" + fileName + "' not found");
		} else {
			return fileURL;
		}
	}
	
	public static boolean isEclipseRunning() {
		try {
			return Platform.isRunning();
		} catch(Throwable e) {
			
		}
		return false;
	}
	
	public void enableATLDebug() {
		ATLLogger.getLogger().setLevel(Level.ALL);
	}
	
	public void disableATLDebug() {
		ATLLogger.getLogger().setLevel(Level.OFF);
	}
}
