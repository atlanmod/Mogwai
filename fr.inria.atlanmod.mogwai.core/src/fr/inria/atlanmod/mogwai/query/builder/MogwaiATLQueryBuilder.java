package fr.inria.atlanmod.mogwai.query.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.common.ATL.ATLPackage;
import org.eclipse.m2m.atl.common.OCL.OCLPackage;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceFactoryImpl;
import org.eclipse.ocl.ecore.impl.EcoreFactoryImpl;

import fr.inria.atlanmod.mogwai.mapping.EMFtoGraphMapping;
import fr.inria.atlanmod.mogwai.query.MogwaiATLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryException;
import fr.inria.atlanmod.mogwai.resources.MogwaiResourceFactory;
import fr.inria.atlanmod.mogwai.util.MogwaiURI;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class MogwaiATLQueryBuilder extends AbstractMogwaiQueryBuilder<MogwaiATLQueryBuilder> {

	private EPackage.Registry ePackageRegistry = EPackage.Registry.INSTANCE;
	private Resource.Factory.Registry resourceRegistry = Resource.Factory.Registry.INSTANCE;
	private ResourceSet rSet;
	private URI transformationURI;
	private PersistentResource inputResource;
	private PersistentResource outputResource;
	private EMFtoGraphMapping inputMapping;
	private EMFtoGraphMapping outputMapping;
	private EPackage sourcePackage;
	private EPackage targetPackage;

	protected MogwaiATLQueryBuilder() {
		rSet = new ResourceSetImpl();
		ePackageRegistry.put(ATLPackage.eNS_URI, ATLPackage.eINSTANCE);
		ePackageRegistry.put(OCLPackage.eNS_URI, OCLPackage.eINSTANCE);

		resourceRegistry.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		resourceRegistry.getExtensionToFactoryMap().put("ecore", new EcoreFactoryImpl());
		resourceRegistry.getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
		
		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME, BlueprintsPersistenceBackendFactory.getInstance());
		PersistenceBackendFactoryRegistry.register(MogwaiURI.MOGWAI_SCHEME, BlueprintsPersistenceBackendFactory.getInstance());
		
		resourceRegistry.getProtocolToFactoryMap().put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());
		resourceRegistry.getProtocolToFactoryMap().put(MogwaiURI.MOGWAI_SCHEME, MogwaiResourceFactory.getInstance());
	}

	public static MogwaiATLQueryBuilder newBuilder() {
		return new MogwaiATLQueryBuilder();
	}

	public MogwaiATLQueryBuilder transformation(URI transformationURI) {
		this.transformationURI = transformationURI;
		return me();
	}

	public MogwaiATLQueryBuilder input(URI inputURI) {
		checkNotNull(inputURI, "null input URI");
		this.inputResource = (PersistentResource) rSet.getResource(inputURI, true);
		return me();
	}
	
	public MogwaiATLQueryBuilder input(PersistentResource inputResource) {
		checkNotNull(inputResource, "null input resource");
		this.inputResource = inputResource;
		return me();
	}

	public MogwaiATLQueryBuilder output(URI outputURI) {
		checkNotNull(outputURI, "null output URI");
		this.outputResource = (PersistentResource) rSet.createResource(outputURI);
		return me();
	}
	
	public MogwaiATLQueryBuilder output(PersistentResource outputResource) {
		this.outputResource = outputResource;
		return me();
	}
	
	public MogwaiATLQueryBuilder inMapping(EMFtoGraphMapping mapping) {
		checkNotNull(mapping, "null mapping");
		this.inputMapping = mapping;
		return me();
	}
	
	public MogwaiATLQueryBuilder outMapping(EMFtoGraphMapping mapping) {
		checkNotNull(mapping, "null mapping");
		this.outputMapping = mapping;
		return me();
	}
	
	public MogwaiATLQueryBuilder sourcePackage(EPackage ePackage) {
		checkNotNull(ePackage, "null ePackage");
		this.sourcePackage = ePackage;
		return me();
	}
	
	public MogwaiATLQueryBuilder targetPackage(EPackage ePackage) {
		checkNotNull(ePackage, "null package");
		this.targetPackage = ePackage;
		return me();
	}

	@Override
	protected boolean validate() {
		if (transformationURI == null) {
			throw new MogwaiQueryException("No transformation provided");
		} else {
			return true;
		}
	}

	@Override
	protected MogwaiATLQuery buildQuery() {
		Resource atlResource = rSet.getResource(transformationURI, true);
		return new MogwaiATLQuery(atlResource, inputResource, outputResource, inputMapping, outputMapping, sourcePackage, targetPackage);
	}

}
