package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import com.sun.istack.internal.Nullable;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.MogwaiOCLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.transformation.files.OCL2Gremlin;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

public class MogwaiOCLProcessor extends MogwaiProcessor<MogwaiOCLQuery> {

	private static final String NAME = "OCL Processor";

	private final OCL2Gremlin transformation;
	private BlueprintsPersistenceBackend graphBackend;

	public MogwaiOCLProcessor() {
		transformation = new OCL2Gremlin();
	}
	
	public MogwaiOCLProcessor(BlueprintsPersistenceBackend graphBackend) {
		this();
		checkNotNull(graphBackend, "Cannot instanciate a processor without a graph");
		this.graphBackend = graphBackend;
		
	}

	@Override
	public String getName() {
		return NAME;
	}
	
	public void setGraphBackend(BlueprintsPersistenceBackend graphBackend) {
		this.graphBackend = graphBackend;
	}
	
	public void enableATLDebug() {
		transformation.enableATLDebug();
	}
	
	public void disableATLDebug() {
		transformation.disableATLDebug();
	}

	@Override
	public MogwaiQueryResult internalProcess(MogwaiOCLQuery query, @Nullable Object arg) {
		checkNotNull(graphBackend, "Cannot compute a query without a graph");
		GremlinScript gScript = createGremlinScript(query);
		Object result = GremlinScriptRunner.getInstance().runGremlinScript(gScript, arg, graphBackend);
		return adaptResult(result, gScript);
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof MogwaiOCLQuery;
	}
	
	private GremlinScript createGremlinScript(MogwaiOCLQuery query) {
		EPackage ePackage = query.getContext().getEPackage();
		EObject transformedQuery = transformation.transform(ePackage, query.getConstraint());
		if (transformedQuery instanceof GremlinScript) {
			return (GremlinScript) transformedQuery;
		} else {
			throw new MogwaiException(
					"An error in the transformation occured, enable ATL debugging for further informations");
		}
	}
	
	private MogwaiQueryResult adaptResult(Object result, GremlinScript gScript) {
		return new MogwaiQueryResult(result, graphBackend, gScript);
	}

}
