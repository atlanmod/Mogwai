package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.OCLQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;
import fr.inria.atlanmod.mogwai.transformation.files.OCL2Gremlin;

/**
 * An ATL-based processor that computes a {@link OCLQuery}.
 * <p>
 * The input OCL query is translated by the <b>OCL2Gremlin</b> ATL
 * transformation that generates the corresponding Gremlin script to compute.
 * 
 * @see AbstractATLProcessor
 * 
 * @author Gwendal DANIEL
 *
 */
public class OCLQueryProcessor extends AbstractATLProcessor<OCLQuery> {

	/**
	 * The name of the processor.
	 */
	private static final String NAME = "OCL Processor";

	/**
	 * Constructs a new {@link OCLQueryProcessor}.
	 */
	public OCLQueryProcessor() {
		transformation = new OCL2Gremlin();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected OCL2Gremlin getTransformation() {
		return (OCL2Gremlin) transformation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException
	 *             if no datastore is provided
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public QueryResult process(OCLQuery query, List<ModelDatastore> datastores, Map<String, Object> options) {
		checkArgument(!datastores.isEmpty(), "Cannot process the query: no datastore provided");
		return super.process(query, datastores, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return {@code true} if {@code query} is an instance of {@link OCLQuery},
	 *         {@code false} otherwise
	 */
	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof OCLQuery;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MogwaiCoreException
	 *             if the underlying transformation failed during the
	 *             translation
	 */
	@Override
	protected GremlinScript createGremlinScript(OCLQuery query, Map<String, Object> options) {
		EPackage ePackage = query.getContext().getEPackage();
		long beforeTransformation = System.currentTimeMillis();
		EObject transformedQuery = getTransformation().transform(ePackage, query.getConstraint());
		long afterTransformation = System.currentTimeMillis();
		MogwaiLogger.info("Input query transformed ({0}ms)", (afterTransformation-beforeTransformation));
		if (transformedQuery instanceof GremlinScript) {
			return ((GremlinScript) transformedQuery);
		} else {
			throw new MogwaiCoreException(
					"An error in the transformation occured, enable ATL debugging for further informations");
		}
	}

}
