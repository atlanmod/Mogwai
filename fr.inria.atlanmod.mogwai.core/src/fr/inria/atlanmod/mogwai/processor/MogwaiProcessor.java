package fr.inria.atlanmod.mogwai.processor;

import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;

public abstract class MogwaiProcessor<Q extends MogwaiQuery, D> {

	/**
	 * Stores the last datastore used to compute a query.
	 * <p>
	 * This attribute can be used by subclasses that perform additional
	 * operations after the query computation.
	 */
	protected D lastDatastore;

	public abstract String getName();

	public final MogwaiQueryResult process(Q query, D datastore, Object arg) {
		lastDatastore = datastore;
		return internalProcess(query, datastore, arg);
	}

	public abstract MogwaiQueryResult internalProcess(Q query, D datastore, Object arg);

	public abstract boolean accept(MogwaiQuery query);

	protected abstract MogwaiQueryResult adaptResult(Object result, String gremlinQuery);

}
