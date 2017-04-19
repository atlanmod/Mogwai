package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.data.mapping.ModelMapping;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.MogwaiOCLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.transformation.files.OCL2Gremlin;

public class MogwaiOCLProcessor<D> extends AbstractATLProcessor<MogwaiOCLQuery, D> {

	private static final String NAME = "OCL Processor";

	public MogwaiOCLProcessor() {
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
	public MogwaiQueryResult process(MogwaiOCLQuery query, List<D> datastores, List<ModelMapping> mappings,
			Map<String, Object> options) {
		checkArgument(!datastores.isEmpty(), "Cannot process the query: no datastore provided");
		checkArgument(!mappings.isEmpty(), "Cannot process the query: no mapping provided");
		return super.process(query, datastores, mappings, options);
	}

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof MogwaiOCLQuery;
	}
	
	@Override
	protected String createGremlinScript(MogwaiOCLQuery query, Map<String, Object> options) {
		EPackage ePackage = query.getContext().getEPackage();
		EObject transformedQuery = getTransformation().transform(ePackage, query.getConstraint());
		if (transformedQuery instanceof GremlinScript) {
			return ((GremlinScript) transformedQuery).toString();
		} else {
			throw new MogwaiException(
					"An error in the transformation occured, enable ATL debugging for further informations");
		}
	}
	
}
