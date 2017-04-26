package fr.inria.atlanmod.mogwai.query;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.processor.AbstractQueryProcessor;
import fr.inria.atlanmod.mogwai.query.builder.AbstractMogwaiQueryBuilder;

/**
 * Provides an abstract API to specify Mogwai queries that can be executed by an
 * {@link AbstractQueryProcessor}.
 * <p>
 * This class defines the methods any query has to implement in order to be
 * processed by an {@link AbstractQueryProcessor}. Default implementation of
 * some methods are provided to ease integration.
 * <p>
 * <b>Note:</b> {@link MogwaiQuery} instances are not associated to a specific
 * {@link ModelDatastore}, they are used as an abstract layer that can be
 * processed on any compatible(s) {@link ModelDatastore}(s) (see
 * {@link #process(AbstractQueryProcessor, List, Map)}.
 * <p>
 * Instances this class can be created using concrete implementations of the
 * fluent {@link AbstractMogwaiQueryBuilder} API.
 * 
 * @see AbstractQueryProcessor
 * @see AbstractMogwaiQueryBuilder
 * 
 * @author Gwendal DANIEL
 *
 */
public abstract class MogwaiQuery {

	/**
	 * An {@link Object} representing the raw input of the query.
	 */
	protected Object rawInput;

	/**
	 * Constructs a new {@link MogwaiQuery} from the provided {@code input}.
	 * 
	 * @param input
	 *            the raw input of the query
	 */
	public MogwaiQuery(Object input) {
		this.rawInput = input;
	}

	/**
	 * Executes the query with the given {@link AbstractQueryProcessor} on the
	 * provided {@link ModelDatastore}.
	 * <p>
	 * This method is a convenience wrapper for
	 * {@code process(processor, Arrays.asList(datastore), options)}.
	 * 
	 * @param processor
	 *            the {@link AbstractQueryProcessor} used to compute the query
	 * @param datastore
	 *            the {@link ModelDatastore} to compute the query on
	 * @param options
	 *            a {@link Map} containing query execution options
	 * @return a {@link QueryResult} representing the output of the executed
	 *         query
	 * @throws QueryException
	 *             if the provided {@code processor} cannot compute the query
	 * 
	 * @see #process(AbstractQueryProcessor, List, Map)
	 * @see AbstractQueryProcessor#process(MogwaiQuery, List, Map)
	 */
	@SuppressWarnings("rawtypes")
	public QueryResult process(AbstractQueryProcessor<? extends MogwaiQuery> processor, ModelDatastore datastore,
			Map<String, Object> options) throws QueryException {
		return process(processor, Arrays.asList(datastore), options);
	}

	/**
	 * Executes the query with the given {@link AbstractQueryProcessor} on the
	 * provided {@link ModelDatastore}s.
	 * 
	 * @param processor
	 *            the {@link AbstractQueryProcessor} used to compute the query
	 * @param datastores
	 *            the {@link ModelDatastore}s to compute the query on
	 * @param options
	 *            a {@link Map} containing query execution options
	 * @return a {@link QueryResult} representing the output of the executed
	 *         query
	 * @throws QueryException
	 *             if the provided {@code processor} cannot compute the query
	 * 
	 * @see #process(AbstractQueryProcessor, ModelDatastore, Map)
	 * @see AbstractQueryProcessor#process(MogwaiQuery, List, Map)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public QueryResult process(AbstractQueryProcessor processor, List<ModelDatastore> datastores,
			Map<String, Object> options) throws QueryException {
		if (processor.accept(this)) {
			return processor.process(this, datastores, options);
		} else {
			throw new QueryException("Processor " + processor.getName() + " cannot compute " + this.toString());
		}
	}

	/**
	 * Returns the raw input of the query.
	 * 
	 * @return the raw input of the query
	 */
	public Object getRawInput() {
		return rawInput;
	}

	/**
	 * Returns a literal representation of the query.
	 * 
	 * @return a literal representation of the query
	 */
	public abstract String getInput();

}
