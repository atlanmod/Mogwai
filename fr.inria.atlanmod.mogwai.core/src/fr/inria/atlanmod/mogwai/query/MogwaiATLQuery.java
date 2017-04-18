package fr.inria.atlanmod.mogwai.query;

import static com.google.common.base.Preconditions.checkNotNull;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.mogwai.data.mapping.ModelMapping;

public class MogwaiATLQuery<D> extends MogwaiQuery {
	
	// Datastores should be removed
	private Resource atlResource;
//	private PersistentResource inputResource;
//	private PersistentResource outputResource;
	private D inputDatasource;
	private D outputDatasource;
	private ModelMapping<?, ?, ?, ?> inputMapping;
	private ModelMapping<?, ?, ?, ?> outputMapping;
	private EPackage sourcePackage;
	private EPackage targetPackage;
	
	public MogwaiATLQuery(Resource atlResource, D inputDatasource, D outputDatasource, ModelMapping<?, ?, ?, ?> inputMapping, ModelMapping<?, ?, ?, ?> outputMapping, EPackage sourcePackage, EPackage targetPackage) {
		super(atlResource);
		checkNotNull(inputDatasource, "Null input resource");
		checkNotNull(outputDatasource, "Null output resource");
		this.atlResource = atlResource;
		this.inputDatasource = inputDatasource;
		this.outputDatasource = outputDatasource;
		this.inputMapping = inputMapping;
		this.outputMapping = outputMapping;
		this.sourcePackage = sourcePackage;
		this.targetPackage = targetPackage;
	}

	@Override
	public String getInput() {
		return atlResource.toString();
	}
	
	public Resource getATLResource() {
		return atlResource;
	}
	
	public D getInputDatasource() {
		return inputDatasource;
	}
	
	public D getOutputDatasource() {
		return outputDatasource;
	}
	
	public ModelMapping<?, ?, ?, ?> getInputMapping() {
		return inputMapping;
	}
	
	public ModelMapping<?, ?, ?, ?> getOutputMapping() {
		return outputMapping;
	}
	
	public EPackage getSourcePackage() {
		return sourcePackage;
	}
	
	public EPackage getTargetPackage() {
		return targetPackage;
	}
	
//	private BlueprintsPersistenceBackend getInnerGraph(PersistentResource pResource) {
//		throw new UnsupportedOperationException("Disabled for refactoring purposes");
//		checkArgument(pResource instanceof DefaultPersistentResource || pResource instanceof MogwaiResourceDecorator,
//				"Given resource is not an instance of DefaultPersistentResource or MogwaiResourceDecorator");
//		try {
//			Field f = null;
//			if(pResource instanceof DefaultPersistentResource) {
//				System.out.println("default");
//				f = DefaultPersistentResource.class.getDeclaredField("persistenceBackend");
//			} else if (pResource instanceof MogwaiResourceDecorator) {
//				System.out.println("mog");
//				f = MogwaiResourceDecorator.class.getDeclaredField("persistenceBackend");
//			} else {
//				throw new MogwaiQueryException(
//						"Given resource is not an instance of DefaultPersistentResource or MogwaiResourceDecorator");
//			}
//			f.setAccessible(true);
//			Object r = f.get(pResource);
//			checkArgument(r instanceof BlueprintsPersistenceBackend, "The field is not a BlueprintsPersistenceBackend");
//			return (BlueprintsPersistenceBackend) r;
//		} catch(NoSuchFieldException e) {
//			throw new MogwaiQueryException(e.getMessage());
//		} catch(SecurityException e) {
//			throw new MogwaiQueryException(e.getMessage());
//		} catch(IllegalAccessException e) {
//			throw new MogwaiQueryException(e.getMessage());
//		}
		
//	}

}
