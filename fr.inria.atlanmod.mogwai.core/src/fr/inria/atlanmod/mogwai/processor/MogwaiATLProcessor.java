package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.common.ATL.Module;

import fr.inria.atlanmod.mogwai.data.mapping.ModelMapping;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.MogwaiATLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.transformation.atl.files.ATL2Gremlin;
import fr.inria.atlanmod.mogwai.util.TransformationHelper;

public class MogwaiATLProcessor<D> extends AbstractATLProcessor<MogwaiATLQuery<D>, D> {

	public static final String TRANSFORMATION_HELPER_KEY = "transformation.helper";

	private static final String TRANSFORMATION_HELPER_BINDING = "tHelper";

	private static final String NAME = "ATL Processor";

	private final ATL2Gremlin transformation;

	public MogwaiATLProcessor() {
		transformation = new ATL2Gremlin();
	}

	@Override
	public String getName() {
		return NAME;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public MogwaiQueryResult process(MogwaiATLQuery<D> query, List<D> datastores, List<ModelMapping> mappings,
			Map<String, Object> options) {
		checkArgument(options.containsKey(TRANSFORMATION_HELPER_KEY),
				"MogwaiATLProcessor requires a TransformationHelper to compute the transformation");
		return super.process(query, datastores, mappings, options);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	protected Map<String, Object> createBindings(List<D> datastores, List<ModelMapping> mappings,
			Map<String, Object> options) {
		Map<String, Object> bindings = super.createBindings(datastores, mappings, options);
		bindings.put(TRANSFORMATION_HELPER_BINDING, (TransformationHelper) options.get(TRANSFORMATION_HELPER_KEY));
		return bindings;
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof MogwaiATLQuery;
	}
	
	@Override
	protected String createGremlinScript(MogwaiATLQuery<D> query, Map<String, Object> options) {
		Module atlModule = (Module) query.getATLResource().getContents().get(0);
		/*
		 * TODO support multiple input models
		 */
		String sourceMMName = atlModule.getInModels().get(0).getMetamodel().getName(); 
		/*
		 * TODO support multiple output models
		 */
		String targetMMName = atlModule.getOutModels().get(0).getMetamodel().getName();
		
		Resource gremlinResource = transformation.transform(query.getATLResource(), sourceMMName,
				query.getSourcePackage(), targetMMName, query.getTargetPackage());
		checkArgument(gremlinResource.getContents() != null, "Created resource content is null");
		// Relax that for debugging purposes
		// checkArgument(gremlinResource.getContents().size() == 1,
		// "Invalid resource content size, expected 1, found {0}",
		// gremlinResource.getContents().size());
		checkArgument(gremlinResource.getContents().get(0) instanceof GremlinScript,
				"Created resource does not contain a GremlinScript element");
		return ((GremlinScript) gremlinResource.getContents().get(0)).toString();
	}

	
	// private Map<String, Object> createQueryBindings(MogwaiATLQuery<D> query)
	// {
	// Map<String, Object> bindings = new HashMap<>();
	// bindings.put("inHelper", new
	// TransformationHelper(query.getInputMapping()));
	// bindings.put("outHelper", new
	// TransformationHelper(query.getOutputMapping()));
	// return bindings;
	// }

}
