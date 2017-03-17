package fr.inria.atlanmod.mogwai.transformation.atl.files;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
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

import ClassDiagram.ClassDiagramPackage;
import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;

public class ATL2Gremlin {

	private ModelFactory modelFactory;
	private IReferenceModel atlMetamodel;
	private IReferenceModel sourceMetamodel;
	private IReferenceModel targetMetamodel;
	private IReferenceModel gremlinMetamodel;
	private ILauncher transformationLauncher;
	private EPackage.Registry registry;
	private EMFInjector injector;
	private EMFExtractor extractor;
	private ResourceSet rSet;
	private List<ASM> modules;
	private ASM ASMCommon;
	
	
	public ATL2Gremlin() {
		try {
			// Default value
			ATLLogger.getLogger().setLevel(Level.ALL);
			
			transformationLauncher = new EMFVMLauncher();
			modelFactory = new EMFModelFactory();
			injector = new EMFInjector();
			extractor = new EMFExtractor();
			
			atlMetamodel = modelFactory.newReferenceModel();
			sourceMetamodel = modelFactory.newReferenceModel();
			targetMetamodel = modelFactory.newReferenceModel();
			
			registry = new EPackageRegistryImpl();
			registry.put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
			registry.put(ATLPackage.eINSTANCE.getNsURI(), ATLPackage.eINSTANCE);
			registry.put(OCLPackage.eINSTANCE.getNsURI(), OCLPackage.eINSTANCE);
			registry.put(GremlinPackage.eINSTANCE.getNsURI(), GremlinPackage.eINSTANCE);
			// Dev
			registry.put(ClassDiagramPackage.eINSTANCE.getNsURI(), ClassDiagramPackage.eINSTANCE);
			
			injector.inject(atlMetamodel, ATLPackage.eINSTANCE.getNsURI());
			injector.inject(sourceMetamodel, EcorePackage.eINSTANCE.getNsURI());
			injector.inject(targetMetamodel, EcorePackage.eINSTANCE.getNsURI());
			gremlinMetamodel = modelFactory.newReferenceModel();
			injector.inject(gremlinMetamodel, GremlinPackage.eINSTANCE.getNsURI());
			
			rSet = new ResourceSetImpl();
			rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreFactoryImpl());
			rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
			
			transformationLauncher.initialize(new HashMap<String, Object>());
			modules = new ArrayList<>();
			
			InputStream atl2gremlinStream = getFileURL("atl2gremlin.asm").openStream();
			InputStream atlEmbeddedOcl2gremlinStream = getFileURL("atlEmbeddedOcl2gremlin.asm").openStream();
			InputStream atlLiteralsStream = getFileURL("atlLiterals.asm").openStream();
			InputStream atlMathExpressionsStream = getFileURL("atlMathExpressions.asm").openStream();
			InputStream atlCollectionsStream = getFileURL("atlCollections.asm").openStream();
			InputStream atlCollectionOperationsStream = getFileURL("atlCollectionOperations.asm").openStream();
			InputStream commonStream = getFileURL("common.asm").openStream();
			
			modules.add((ASM) transformationLauncher.loadModule(atl2gremlinStream));
			modules.add((ASM) transformationLauncher.loadModule(atlEmbeddedOcl2gremlinStream));
			modules.add((ASM) transformationLauncher.loadModule(atlLiteralsStream));
			modules.add((ASM) transformationLauncher.loadModule(atlMathExpressionsStream));
			modules.add((ASM) transformationLauncher.loadModule(atlCollectionsStream));
			modules.add((ASM) transformationLauncher.loadModule(atlCollectionOperationsStream));
			
			ASMCommon = (ASM) transformationLauncher.loadModule(commonStream);
			
			atl2gremlinStream.close();
			atlEmbeddedOcl2gremlinStream.close();
			atlLiteralsStream.close();
			atlMathExpressionsStream.close();
			atlCollectionsStream.close();
			atlCollectionOperationsStream.close();
			commonStream.close();
			
			
		} catch(ATLCoreException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Resource transform(URI atlURI) throws IOException {
		ResourceSet rSet = new ResourceSetImpl();
		EPackage.Registry.INSTANCE.put(ATLPackage.eNS_URI, ATLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(OCLPackage.eNS_URI, OCLPackage.eINSTANCE);

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
		
		Resource atlResource = rSet.createResource(atlURI);
		atlResource.load(Collections.EMPTY_MAP);
		return transform(atlResource);
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
			IModel inputModel = modelFactory.newModel(atlMetamodel);
			injector.inject(inputModel, inputResource);
			
			IModel sourceMM = modelFactory.newModel(sourceMetamodel);
			IModel targetMM = modelFactory.newModel(targetMetamodel);
			// dev
			injector.inject(sourceMM, ClassDiagramPackage.eINSTANCE.eResource());
			injector.inject(targetMM, ClassDiagramPackage.eINSTANCE.eResource());
			// /dev
			
			IModel gModel = modelFactory.newModel(gremlinMetamodel);
			
			transformationLauncher = new EMFVMLauncher();
			transformationLauncher.initialize(new HashMap<String, Object>());
			transformationLauncher.addLibrary("common", ASMCommon);
			
			transformationLauncher.addInModel(inputModel, "IN", "ATL");
			transformationLauncher.addInModel(sourceMM, "SOURCEMM", "SourceEcore");
			transformationLauncher.addInModel(targetMM, "TARGETMM", "TargetEcore");
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
