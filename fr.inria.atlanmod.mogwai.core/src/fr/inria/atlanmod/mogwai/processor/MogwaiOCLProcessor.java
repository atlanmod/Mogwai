package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.MogwaiOCLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.transformation.files.OCL2Gremlin;

public class MogwaiOCLProcessor<D> extends MogwaiProcessor<MogwaiOCLQuery, D> {

	private static final String NAME = "OCL Processor";

	private final OCL2Gremlin transformation;

	public MogwaiOCLProcessor() {
		transformation = new OCL2Gremlin();
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
	public MogwaiQueryResult internalProcess(MogwaiOCLQuery query, D datastore, Object arg) {
		checkNotNull(datastore, "Cannot compute a query without a graph");
		GremlinScript gScript = createGremlinScript(query);
		Object result = GremlinScriptRunner.getInstance().runGremlinScript(gScript, arg, datastore, null);
		return adaptResult(result, gScript.toString());
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof MogwaiOCLQuery;
	}
	
	protected GremlinScript createGremlinScript(MogwaiOCLQuery query) {
		EPackage ePackage = query.getContext().getEPackage();
		EObject transformedQuery = transformation.transform(ePackage, query.getConstraint());
		if (transformedQuery instanceof GremlinScript) {
			return (GremlinScript) transformedQuery;
		} else {
			throw new MogwaiException(
					"An error in the transformation occured, enable ATL debugging for further informations");
		}
	}
	

	@Override
	protected MogwaiQueryResult adaptResult(Object result, String gremlinQuery) {
		return new MogwaiQueryResult(result, gremlinQuery);
	}

}
