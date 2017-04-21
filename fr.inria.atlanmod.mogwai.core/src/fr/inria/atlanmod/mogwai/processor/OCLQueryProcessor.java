package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import fr.inria.atlanmod.mogwai.core.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.OCLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;
import fr.inria.atlanmod.mogwai.transformation.files.OCL2Gremlin;

public class OCLQueryProcessor extends AbstractATLProcessor<OCLQuery> {

	private static final String NAME = "OCL Processor";

	public OCLQueryProcessor() {
		transformation = new OCL2Gremlin();
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	protected OCL2Gremlin getTransformation() {
		return (OCL2Gremlin) transformation;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public QueryResult process(OCLQuery query, List<ModelDatastore> datastores, Map<String, Object> options) {
		checkArgument(!datastores.isEmpty(), "Cannot process the query: no datastore provided");
		return super.process(query, datastores, options);
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof OCLQuery;
	}

	@Override
	protected GremlinScript createGremlinScript(OCLQuery query, Map<String, Object> options) {
		EPackage ePackage = query.getContext().getEPackage();
		EObject transformedQuery = getTransformation().transform(ePackage, query.getConstraint());
		if (transformedQuery instanceof GremlinScript) {
			return ((GremlinScript) transformedQuery);
		} else {
			throw new MogwaiCoreException(
					"An error in the transformation occured, enable ATL debugging for further informations");
		}
	}

}
