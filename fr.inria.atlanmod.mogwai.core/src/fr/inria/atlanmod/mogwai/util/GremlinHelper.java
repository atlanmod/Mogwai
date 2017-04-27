package fr.inria.atlanmod.mogwai.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Iterables;

import fr.inria.atlanmod.mogwai.query.MogwaiQuery;

/**
 * Provides utility methods on top of Gremlin steps to ease the definition of
 * complex traversals.
 * <p>
 * This class is binded to the Gremlin script runner before each execution of a
 * Mogwai query, making its operations visible for each database query computed
 * from a {@link MogwaiQuery}.
 * 
 * @author Gwendal DANIEL
 *
 */
public class GremlinHelper {

	/**
	 * The name of the Gremlin binding associated to this class.
	 */
	public static final String BINDING_NAME = "gremlinHelper";

	/**
	 * Returns the singleton instance of this class.
	 * 
	 * @return the singleton instance of this class
	 */
	public static GremlinHelper getInstance() {
		return Holder.INSTANCE;
	}

	/**
	 * Computes the union of two {@link Iterable}s.
	 * 
	 * @param left
	 *            the left part of the union
	 * @param right
	 *            the right part of the union
	 * @return an {@link Iterable} containing {@code left union right}
	 */
	public Iterable<Object> union(Iterable<Object> left, Iterable<Object> right) {
		Set<Object> set = new HashSet<>();
		Iterables.addAll(set, left);
		Iterables.addAll(set, right);
		return set;
	}

	/**
	 * Computes the intersection of two {@link Iterable}s.
	 * 
	 * @param left
	 *            the left part of the intersection
	 * @param right
	 *            the right part of the intersection
	 * @return an {@link Iterable} containing {@code left intersection right}
	 */
	public Iterable<Object> intersection(Iterable<Object> left, Iterable<Object> right) {
		List<Object> res = new ArrayList<>();
		for (Object o : left) {
			if (Iterables.contains(right, o)) {
				res.add(o);
			}
		}
		return res;
	}

	/**
	 * Computes the difference between two {@link Iterable}s.
	 * 
	 * @param left
	 *            the left part of the difference
	 * @param right
	 *            the right part of the difference
	 * @return an {@link Iterable} containing {@code left difference right}
	 */
	public Iterable<Object> difference(Iterable<Object> left, Iterable<Object> right) {
		List<Object> res = new ArrayList<>();
		for (Object o : left) {
			if (!Iterables.contains(right, o)) {
				res.add(o);
			}
		}
		return res;
	}

	/**
	 * A lazy holder maintaining a singleton instance of {@link GremlinHelper}.
	 *
	 */
	private static class Holder {

		/**
		 * The singleton instance of {@link GremlinHelper}.
		 */
		private static final GremlinHelper INSTANCE = new GremlinHelper();

	}

}
