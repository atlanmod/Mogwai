package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.common.ATL.Module;

import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.MogwaiATLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.transformation.atl.files.ATL2Gremlin;
import fr.inria.atlanmod.mogwai.util.TransformationHelper;

public class MogwaiATLProcessor<D> extends MogwaiProcessor<MogwaiATLQuery<D>, D> {

	private static final String NAME = "ATL Processor";

	private final ATL2Gremlin transformation;

	public MogwaiATLProcessor() {
		transformation = new ATL2Gremlin();
	}
	
	@Override
	public String getName() {
		return NAME;
	}
	
	public void enableATLDebug() {
		transformation.enableATLDebug();
	}
	
	public void disableATLDebug() {
		transformation.disableATLDebug();
	}

	@Override
	public MogwaiQueryResult internalProcess(MogwaiATLQuery<D> query, D datastore, Object arg) {
		final Map<String, Object> bindings = createQueryBindings(query);
		GremlinScript gScript = createGremlinScript(query);
		// for now only input graph is considered (we assume the input and output are created in the same
		// resource ~= ATL refine mode)
//		Object result = GremlinScriptRunner.getInstance().runGremlinScript(gScript, arg, query.getInputGraph(), bindings);
//		return adaptResult(result, gScript);
		return adaptResult(query, gScript.toString());
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof MogwaiATLQuery;
	}
	
	private GremlinScript createGremlinScript(MogwaiATLQuery<D> query) {
		Module atlModule = (Module)query.getATLResource().getContents().get(0);
		String sourceMMName = atlModule.getInModels().get(0).getMetamodel().getName(); // TODO support multiple input models
		String targetMMName = atlModule.getOutModels().get(0).getMetamodel().getName(); // TODO support multiple output models
		Resource gremlinResource = transformation.transform(query.getATLResource(), sourceMMName, query.getSourcePackage(), targetMMName, query.getTargetPackage());
		checkArgument(gremlinResource.getContents() != null, "Created resource content is null");
//		Relax that for debugging purposes
//		checkArgument(gremlinResource.getContents().size() == 1,
//				"Invalid resource content size, expected 1, found {0}", gremlinResource.getContents().size());
		checkArgument(gremlinResource.getContents().get(0) instanceof GremlinScript,
				"Created resource does not contain a GremlinScript element");
		return (GremlinScript) gremlinResource.getContents().get(0);
	}
	
	@Override
	protected MogwaiQueryResult adaptResult(Object result, String gremlinQuery) {
		return new MogwaiQueryResult(result, gremlinQuery);
	}
	
	private Map<String, Object> createQueryBindings(MogwaiATLQuery<D> query) {
		Map<String, Object> bindings = new HashMap<>();
		bindings.put("inHelper", new TransformationHelper(query.getInputMapping()));
		bindings.put("outHelper", new TransformationHelper(query.getOutputMapping()));
		return bindings;
	}

}
