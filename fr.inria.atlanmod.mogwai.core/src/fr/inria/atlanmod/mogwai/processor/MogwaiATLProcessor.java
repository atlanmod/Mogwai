package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkArgument;

import java.util.Objects;

import org.eclipse.emf.ecore.resource.Resource;

import com.sun.istack.internal.Nullable;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.MogwaiATLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.transformation.atl.files.ATL2Gremlin;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class MogwaiATLProcessor extends MogwaiProcessor<MogwaiATLQuery> {

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
	public MogwaiQueryResult internalProcess(MogwaiATLQuery query, @Nullable Object arg) {
		GremlinScript gScript = createGremlinScript(query);
		// for now only input graph is considered (we assume the input and output are created in the same
		// resource ~= ATL refine mode)
//		Object result = GremlinScriptRunner.getInstance().runGremlinScript(gScript, arg, query.getInputGraph());
//		return adaptResult(result, gScript);
		return adaptResult(query, null, gScript);
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof MogwaiATLQuery;
	}
	
	private GremlinScript createGremlinScript(MogwaiATLQuery query) {
		Resource gremlinResource = transformation.transform(query.getATLResource());
		checkArgument(gremlinResource.getContents() != null, "Created resource content is null");
		checkArgument(gremlinResource.getContents().size() == 1,
				"Invalid resource content size, expected 1, found {0}", gremlinResource.getContents().size());
		checkArgument(gremlinResource.getContents().get(0) instanceof GremlinScript,
				"Created resource does not contain a GremlinScript element");
		return (GremlinScript) gremlinResource.getContents().get(0);
	}
	
	private MogwaiQueryResult adaptResult(MogwaiATLQuery query, Object result, GremlinScript gScript) {
		// Adapt the result to ATL2Gremlin
		return new MogwaiQueryResult(result, query.getInputGraph(), gScript);
	}

}
