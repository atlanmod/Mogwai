package fr.inria.atlanmod.mogwai.datastore.neo4j3;

import static java.util.Objects.isNull;

import java.util.function.Function;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesDatastore;

// No autocommit
public class DefaultNeo4j3Datastore implements ModelDatastore<GraphDatabaseService, Node, Relationship, Object>,
		PipesDatastore<GraphDatabaseService, Node, Relationship, Object> {

	/**
	 * The {@link GraphDatabaseService} instance containing the model to
	 * manipulate.
	 */
	private GraphDatabaseService graph;

	/**
	 * The current {@link Transaction} used to perform database operations.
	 */
	private Transaction transaction;

	/**
	 * Constructs a new {@link DefaultNeo4j3Datastore} wrapping the provided
	 * {@code graph}.
	 * <p>
	 * A new transaction is started to handle database operations. Note that
	 * this implementation doesn't provide an autocommit feature, and will
	 * perform all the requested operations within a single transaction.
	 * <p>
	 * TODO handle autocommit feature in a dedicated subclass.
	 * 
	 * @param graph
	 *            the underlying {@link GraphDatabaseService} used access the
	 *            model to manipulate
	 */
	public DefaultNeo4j3Datastore(GraphDatabaseService graph) {
		this.setDataSource(graph);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * If a {@link GraphDatabaseService} is already set the running transaction
	 * is committed and a new one is opened on the provided {@code dataSource}.
	 * Note that this implementation doesn't provide an autocommit feature, and
	 * will perform all the requested operations within a single transaction.
	 * <p>
	 * TODO handle autocommit feature in a dedicated subclass.
	 */
	@Override
	public void setDataSource(GraphDatabaseService dataSource) {
		this.graph = dataSource;
		if (isNull(transaction)) {
			/*
			 * There is no running transaction, start a new one from the
			 * provided GraphDatabaseService and store it.
			 */
			transaction = graph.beginTx();
		} else {
			/*
			 * There is a running transaction, we first need to stop it, commit
			 * the changes, then open a new transaction on the provided
			 * GraphDatabaseService. Note that the previous instance of
			 * transaction is associated to the previous value of this.graph
			 */
			transaction.success();
			transaction.close();
			transaction = graph.beginTx();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GraphDatabaseService getDataSource() {
		return graph;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This mapping assumes that element types are represented as {@link Node}'s
	 * labels. A call to this method returns all the {@link Node}s that contain
	 * at least one {@link Label} with the provided {@code typeName}.
	 * <p>
	 * <b>Note:</b> for this mapping there is no difference between
	 * {@link #allOfType(String)} and {@link #allOfKind(String)}.
	 * 
	 * @see #allOfKind(String)
	 */
	@Override
	public Iterable<Node> allOfType(String typeName) {
		return () -> graph.findNodes(Label.label(typeName));
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This mapping assumes that elements type are represented as {@link Node}'s
	 * labels. A call to this method returns all the {@link Node}s that contain
	 * at least one {@link Label} with the provided {@code typeName}.
	 * <p>
	 * <b>Note:</b> for this mapping there is no difference between
	 * {@link #allOfType(String)} and {@link #allOfKind(String)}.
	 * 
	 * @see #allOfType(String);
	 */
	@Override
	public Iterable<Node> allOfKind(String typeName) {
		return () -> graph.findNodes(Label.label(typeName));
	}

	@Override
	public Node newInstance(String typeName, String typePackageNsURI, String resourceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getParent(Node from) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Node> getRef(Node from, String refName, String oppositeName, boolean isContainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relationship setRef(Node from, String refName, String oppositeName, Node to, boolean isContainment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node removeRef(Node from, String refName, Node to, boolean isContainment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Object> getAtt(Node from, String attName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node setAtt(Node from, String attName, Object attValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType(Node from) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTypeOf(Node from, String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isKindOf(Node from, String type) {
		// TODO Auto-generated method stub
		return false;
	}

}
