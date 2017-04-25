package fr.inria.atlanmod.mogwai.datastore.blueprints;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.util.wrappers.id.IdGraph;

/**
 * A {@link NeoEMFGraphDatastore} implementation that automatically commits
 * modifications after a given number of performed operations.
 * <p>
 * This mapping uses the transactional capabilities of the underlying
 * {@link Graph} to free memory by committing changes in the database during the
 * execution. It can be used in memory constrained environments to improve model
 * access scalability.
 * 
 * @see NeoEMFGraphDatastore
 * 
 * @author Gwendal DANIEL
 *
 */
public class AutocommitNeoEMFGraphDatastore extends NeoEMFGraphDatastore {

	/**
	 * The default number of operations to perform between each commit.
	 */
	private static final int DEFAULT_OPS_BETWEEN_COMMITS = 100000;

	/**
	 * The current number of operations to perform between each commit.
	 */
	private int opsBetweenCommits;

	/**
	 * The number of operations currently pending in the transaction.
	 */
	private int opCount;

	/**
	 * Constructs a new {@link AutocommitNeoEMFGraphDatastore} wrapping the
	 * provided {@code graph}. The default number of operations between commits
	 * is used to trigger transaction commits.
	 * 
	 * @param graph
	 *            the underlying {@link Graph} used to store the NeoEMF model
	 */
	public AutocommitNeoEMFGraphDatastore(Graph graph) {
		this(graph, DEFAULT_OPS_BETWEEN_COMMITS);
	}

	/**
	 * Constructs a new {@link AutocommitNeoEMFGraphDatastore} wrapping the
	 * provided {@code graph} and committing the changes after
	 * {@code opsBetweenCommits} operations.
	 * 
	 * @param graph
	 *            the underlying {@link Graph} used to store the NeoEMF model
	 * @param opsBetweenCommits
	 *            the number of operations to perform between each commit
	 */
	public AutocommitNeoEMFGraphDatastore(Graph graph, int opsBetweenCommits) {
		super(graph);
		this.opsBetweenCommits = opsBetweenCommits;
		this.opCount = 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<Vertex> allOfType(String typeName) {
		Iterable<Vertex> result = super.allOfType(typeName);
		incrementAndCommit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<Vertex> allOfKind(String typeName) {
		Iterable<Vertex> result = super.allOfKind(typeName);
		incrementAndCommit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vertex newInstance(String typeName, String typePackageNsURI, String resourceName)
			throws NullPointerException {
		Vertex result = super.newInstance(typeName, typePackageNsURI, resourceName);
		incrementAndCommit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vertex getParent(Vertex from) {
		Vertex result = super.getParent(from);
		incrementAndCommit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<Vertex> getRef(Vertex from, String refName, String oppositeName, boolean isContainer) {
		Iterable<Vertex> result = super.getRef(from, refName, oppositeName, isContainer);
		incrementAndCommit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Edge setRef(Vertex from, String refName, String oppositeName, Vertex to, boolean isContainment) {
		Edge result = super.setRef(from, refName, oppositeName, to, isContainment);
		incrementAndCommit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vertex removeRef(Vertex from, String refName, Vertex to, boolean isContainment) {
		Vertex result = super.removeRef(from, refName, to, isContainment);
		incrementAndCommit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<Object> getAtt(Vertex from, String attName) {
		Iterable<Object> result = super.getAtt(from, attName);
		incrementAndCommit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vertex setAtt(Vertex from, String attName, Object attValue) {
		Vertex result = super.setAtt(from, attName, attValue);
		incrementAndCommit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getType(Vertex from) {
		String result = super.getType(from);
		incrementAndCommit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isTypeOf(Vertex from, String type) {
		boolean result = super.isTypeOf(from, type);
		incrementAndCommit();
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isKindOf(Vertex from, String type) {
		boolean result = super.isKindOf(from, type);
		incrementAndCommit();
		return result;
	}

	/**
	 * Increments the number of performed operations and commits the changes if
	 * necessary.
	 */
	private void incrementAndCommit() {
		opCount = (opCount + 1) % opsBetweenCommits;
		if (opCount == 0) {
			((IdGraph<?>) getDataSource()).commit();
		}
	}

}
