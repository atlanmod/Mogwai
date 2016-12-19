package fr.inria.atlanmod.mogwai.query;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkArgument;

import java.lang.reflect.Field;

import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;

public class MogwaiATLQuery extends MogwaiQuery {
	
	private Resource atlResource;
	private PersistentResource inputResource;
	private PersistentResource outputResource;
	
	public MogwaiATLQuery(Resource atlResource, PersistentResource inputResource, PersistentResource outputResource) {
		super(atlResource);
		checkNotNull(inputResource, "Null input resource");
		checkNotNull(outputResource, "Null output resource");
		this.atlResource = atlResource;
		this.inputResource = inputResource;
		this.outputResource = outputResource;
	}

	@Override
	public String getInput() {
		return atlResource.toString();
	}
	
	public Resource getATLResource() {
		return atlResource;
	}
	
	public PersistentResource getInputResource() {
		return inputResource;
	}
	
	public PersistentResource getOutputResource() {
		return outputResource;
	}
	
	public BlueprintsPersistenceBackend getInputGraph() {
		return getInnerGraph(inputResource);
	}
	
	public BlueprintsPersistenceBackend getOutputGraph() {
		return getInnerGraph(outputResource);
	}
	
	private BlueprintsPersistenceBackend getInnerGraph(PersistentResource pResource) {
		try {
			Field f = PersistentResource.class.getField("persistenceBackend");
			f.setAccessible(true);
			Object r = f.get(pResource);
			checkArgument(r instanceof BlueprintsPersistenceBackend, "The field is not a BlueprintsPersistenceBackend");
			return (BlueprintsPersistenceBackend) r;
		} catch(NoSuchFieldException e) {
			throw new MogwaiQueryException(e.getMessage());
		} catch(SecurityException e) {
			throw new MogwaiQueryException(e.getMessage());
		} catch(IllegalAccessException e) {
			throw new MogwaiQueryException(e.getMessage());
		}
		
	}

}
