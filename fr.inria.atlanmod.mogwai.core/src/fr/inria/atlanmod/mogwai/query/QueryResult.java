package fr.inria.atlanmod.mogwai.query;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;

import com.google.common.collect.Iterables;
import com.tinkerpop.gremlin.java.GremlinPipeline;

import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import static java.util.Objects.isNull;

/**
 * Wraps the result of a {@link MogwaiQuery} and provides information on the
 * query execution.
 * <p>
 * {@link QueryResult} implements {@link Iterable} to ease result processing in
 * client applications.
 * 
 * @author Gwendal DANIEL
 *
 */
public class QueryResult implements Iterable<Object> {

	/**
	 * Stores the result of the query computation.
	 * <p>
	 * This collection is used regardless whether the result is multi-valued or
	 * single-valued.
	 */
	protected List<Object> result;

	/**
	 * Stores the time needed to compute the result of the query.
	 * <p>
	 * If the query result is an instance of {@link Iterable} it is iterated to
	 * create the {@link QueryResult}. This can be costly in Gremlin-based
	 * queries that are computed when they are iterated.
	 */
	protected long computationTime = -1;

	/**
	 * Stores whether the query returned a single result.
	 */
	protected boolean isSingleResult = false;

	/**
	 * The textual representation of the computed query.
	 */
	protected String gremlinScript;

	/**
	 * Constructs a new {@link QueryResult} from the given {@code engineResult}
	 * and literal {@code gremlinScript}.
	 * <p>
	 * <b>Note:</b> if {@code engineResult} is an instance of {@link Iterable}
	 * this constructor iterates it to wrap the results. In case of
	 * Gremlin-based queries this can be costly because {@link GremlinPipeline}
	 * content is computed when iterated.
	 * 
	 * @param engineResult
	 *            the result of the query computation
	 * @param gremlinQuery
	 *            the textual representation of the computed query
	 */
	@SuppressWarnings("unchecked")
	public QueryResult(Object engineResult, String gremlinQuery) {
		this.gremlinScript = gremlinQuery;
		result = new BasicEList<Object>();
		long begin = System.currentTimeMillis();
		if (isNull(engineResult)) {
			/*
			 * Creates an empty collection is the engine doesn't return any
			 * object
			 */
			result = Collections.emptyList();
		} else if (engineResult instanceof GremlinPipeline<?, ?>) {
			/*
			 * Forces the iteration of the pipeline, and thus computes the
			 * query. This operation can be costly if the query hasn't been
			 * computed before.
			 */
			Iterables.addAll(result, (GremlinPipeline<?, Object>) engineResult);
		} else if (engineResult instanceof Collection<?>) {
			/*
			 * The query aimed to return a Collection, copy it to avoid any
			 * side-effect from the execution engine.
			 */
			Iterables.addAll(result, (Collection<Object>) engineResult);
		} else {
			/*
			 * The query aimed to return a single value, store this information
			 * and add the returned element to the result list to avoid any
			 * side-effect from the execution engine.
			 */
			isSingleResult = true;
			result.add(engineResult);
		}
		long end = System.currentTimeMillis();
		computationTime = (end - begin);
	}

	/**
	 * Constructs a new {@link QueryResult} from the given {@code engineResult}
	 * and {@code gremlinScript}.
	 * <p>
	 * <b>Note:</b> if {@code engineResult} is an instance of {@link Iterable}
	 * this constructor iterates it to wrap the results. In case of
	 * Gremlin-based queries this can be costly because {@link GremlinPipeline}
	 * content is computed when iterated.
	 * 
	 * @param engineResult
	 *            the result of the query computation
	 * @param gremlinScript
	 *            the {@link GremlinScript} element representing the root of the
	 *            computed query
	 */
	public QueryResult(Object engineResult, GremlinScript gremlinScript) {
		this(engineResult, gremlinScript.toString());
	}

	/**
	 * 
	 * @return true if the query result is a single value
	 */
	public boolean isSingleResult() {
		return isSingleResult;
	}

	/**
	 * Returns the result of the Mogwai query wrapped in a Collection.
	 * <p>
	 * This method always returns a Collection, even if the query doesn't return
	 * any object. Use it instead of {@link #getResult()} if the query result
	 * size is not known.
	 * 
	 * @return the result of the Mogwai query wrapped in a Collection
	 */
	public Collection<Object> getResults() throws MogwaiCoreException {
		return result;
	}

	/**
	 * Returns a casted value created from the single query result.
	 * <p>
	 * Note: this method throws a {@link MogwaiCoreException} if the query
	 * returns more than one result, see {@link #getResults() instead}.
	 * 
	 * @param <T>
	 *            the type to cast the result of the query
	 * @return a casted value created from the single query result
	 * @throws MogwaiCoreException
	 *             if the query returns more than one result
	 * @throws ClassCastException
	 *             if the result cannot be cast to {@code <T>}
	 */
	@SuppressWarnings("unchecked")
	public <T> T getResult() throws MogwaiCoreException {
		if (isSingleResult) {
			return (T) result.get(0);
		}
		throw new MogwaiCoreException(
				"Cannot compute a single result: the query returns multiple records. Use getResults() instead");
	}

	/**
	 * Returns the number of objects returned by the query.
	 * <p>
	 * Note: this method returns 1 even if the query result contains only the
	 * {@code null} value.
	 * 
	 * @return the number of objects returned by the query
	 */
	public int resultSize() {
		return result.size();
	}

	/**
	 * Returns the textual representation of the computed query.
	 * 
	 * @return the textual representation of the computed query
	 */
	public String getExecutedQuery() {
		return gremlinScript;
	}

	/**
	 * Returns the duration of the result computation (in milliseconds).
	 * 
	 * @return the duration of the result computation (in milliseconds)
	 */
	public long getComputationTime() {
		return computationTime;
	}

	/**
	 * Returns a String representation of this {@link QueryResult}.
	 * <p>
	 * Information displayed in the created String are truncated to ease
	 * readability. To get the complete values see {@link #getExecutedQuery()}
	 * and {@link #getComputationTime()}.
	 * 
	 * @return a String representation of this {@link QueryResult}
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Computed Query: ");
		if (gremlinScript.length() > 50) {
			sb.append(gremlinScript.substring(0, 50)).append(" [...]");
		} else {
			sb.append(gremlinScript);
		}
		sb.append('\n');
		sb.append("Computation Time: ").append(computationTime).append('\n');
		sb.append("Result: ").append(result.toString());
		return sb.toString();
	}

	/**
	 * Returns a new {@link Iterator} on the query result.
	 * 
	 * @return a new {@link Iterator} on the query result
	 */
	@Override
	public Iterator<Object> iterator() {
		return result.iterator();
	}

}
