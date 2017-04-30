package fr.inria.atlanmod.mogwai.datastore.neo4j3;

import static java.util.Objects.isNull;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.pipes.PipesDatastore;

/**
 * An implementation of {@link ModelDatastore} representing a default
 * model-to-Neo4j3 mapping.
 * <p>
 * This mapping also implements {@link PipesDatastore}, making it available in
 * Gremlin traversals generated from Mogwai transformations.
 * <p>
 * This mapping is based on the default Neo4j3 guidelines (see method
 * documentation to have detailed on a specific operation):
 * <ul>
 * <li>Elements are represented as {@link Node}s.</li>
 * <li>Element types are mapped to {@link Node}'s {@link Label}s.</li>
 * <li>References are represented as {@link Relationship}s.</li>
 * <li>Attributes are represented as {@link Node}s properties.</li>
 * </ul>
 * <p>
 * <b>Note:</b> {@link DefaultNeo4j3Datastore} handles the same way types and
 * kinds, meaning that {@link #allOfKind(String)} is equivalent to
 * {@link #allOfType(String)}, and {@link #isKindOf(String)} is equivalent to
 * {@link #isTypeOf(String)}.
 * 
 * @see ModelDatastore
 * @see PipesDatastore
 * 
 * @author Gwendal DANIEL
 *
 */
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
		return allOfType(typeName);
	}

	/**
	 * Creates a new instance of {@code typeName} and adds it to the current
	 * database.
	 * <p>
	 * <b>Note:</b> this default implementation doesn't take into account
	 * {@code typePackageNsURI} and {@code resourceName}.
	 * 
	 * @param typeName
	 *            the name of the metaclass to create an instance of
	 * @param typePackageNsURI
	 *            <b>(Ignored)</b> the URI of the EPackage that defines the
	 *            metaclass {@code typeName}
	 * @param resourceName
	 *            <b>(Ignored)</b> the name of the resource where the new
	 *            element is stored
	 * @return a {@link Node} representing the created instance of
	 *         {@code typeName}
	 */
	@Override
	public Node newInstance(String typeName, String typePackageNsURI, String resourceName) {
		return graph.createNode(Label.label(typeName));
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This default mapping doesn't provide any explicit construct to represent
	 * {@code parent} relationships. Calling this method returns all the
	 * {@link Node}s that have at least one outgoing {@link Relationship}
	 * pointing on {@code from}.
	 * <p>
	 * TODO: getParent should return an {@link Iterable} (see #29).
	 * 
	 * @param from
	 *            the {@link Node} representing the element to compute the
	 *            parent of
	 * 
	 * @return the {@link Node} representing the parent of {@code from} if it
	 *         exists, {@code null} otherwise
	 */
	@Override
	public Node getParent(Node from) {
		for (Relationship r : from.getRelationships(Direction.INCOMING)) {
			return r.getStartNode();
		}
		return null;
	}

	/**
	 * Returns an {@link Iterable} containing the {@link Node}s connected to
	 * {@code from} with a {@code refName} {@link Relationship}.
	 * <p>
	 * <b>Note:</b> this default implementation doesn't take into account
	 * {@code oppositeName} and {@code isContainer}.
	 * 
	 * @param from
	 *            the {@link Node} representing the element to get the reference
	 *            from
	 * @param refName
	 *            the name of the reference to navigate
	 * @param <b>(Ignored)</b> the name of the reference's opposite if it exists
	 * @param <b>(Ignored)</b> {@code true} if {@code refName} is a containment,
	 *        {@code false} otherwise
	 * 
	 * @return an {@link Iterable} containing the {@link Node}s connected to
	 *         {@code from}
	 */
	@Override
	public Iterable<Node> getRef(Node from, String refName, String oppositeName, boolean isContainer) {
		Stream<Node> s = StreamSupport.stream(
				from.getRelationships(Direction.OUTGOING, RelationshipType.withName(refName)).spliterator(), false)
				.map(r -> r.getEndNode());
		return s::iterator;
	}

	/**
	 * Creates a {@link Relationship} between {@code from} and {@code to} with
	 * the label {@code refName}.
	 * <p>
	 * <b>Note:</b> this default implementation doesn't take into account
	 * {@code oppositeName} and {@code isContainer}.
	 * 
	 * @param from
	 *            the {@link Node} representing the incoming element of the
	 *            reference
	 * @param refName
	 *            the label of the reference
	 * @param oppositeName
	 *            <b>(Ignored)</b> the name of the reference's opposite if it
	 *            exists
	 * @param to
	 *            the {@link Node} representing the outgoing element of the
	 *            reference
	 * @param isContainment
	 *            <b>(Ignored)</b> {@code true} if the reference is a
	 *            containment, {@code false} otherwise
	 * @return the {@link Relationship} representing the created reference
	 */
	@Override
	public Relationship setRef(Node from, String refName, String oppositeName, Node to, boolean isContainment) {
		return from.createRelationshipTo(to, RelationshipType.withName(refName));
	}

	/**
	 * Removes the {@link Relationship} representing the reference between
	 * {@code from} and {@code to} with the label {@code refName}.
	 * <p>
	 * <b>Note:</b> this default implementation doesn't take into account
	 * {@code isContainment}.
	 * <p>
	 * TODO: removeRef should return an {@link Iterable} (see #30).
	 * 
	 * @param from
	 *            the {@link Node} representing the incoming element of the
	 *            reference to remove
	 * @param refName
	 *            the label of the reference to remove
	 * @param to
	 *            the {@link Node} representing the outgoing element of the
	 *            reference to remove
	 * @param <b>(Ignored)</b> {@code true} if the reference is a containment,
	 *        {@code false} otherwise
	 * 
	 * @return the {@link Node} representing the previously linked element
	 */
	@Override
	public Node removeRef(Node from, String refName, Node to, boolean isContainment) {
		for (Relationship r : from.getRelationships(Direction.OUTGOING, RelationshipType.withName(refName))) {
			if (r.getEndNode().equals(to)) {
				r.delete();
				return to;
			}
		}
		return null;
	}

	/**
	 * Returns an {@link Iterable} containing the attribute(s) {@code attName}
	 * of {@code from}.
	 * <p>
	 * This method always returns an {@link Iterable}. Single-valued and
	 * {@code null} attribute(s) are wrapped into a dedicated {@link Iterable}
	 * to provide a consistent API.
	 * 
	 * @param from
	 *            the {@link Node} representing the element to get the
	 *            attribute(s) from
	 * @param attName
	 *            the name of the attribute to retrieve
	 * 
	 * @return an {@link Iterable} containing the {@link Object}s representing
	 *         the attribute(s) {@code attName} of {@code from}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Object> getAtt(Node from, String attName) {
		Object property = from.getProperty(attName);
		Iterable<Object> result = null;
		if (property instanceof Iterable) {
			result = (Iterable<Object>) property;
		} else {
			result = Arrays.asList(property);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param from
	 *            the {@link Node} representing the element to set the attribute
	 *            of
	 * @param attName
	 *            the name of the attribute to set
	 * @param attValue
	 *            the value of the attribute to set
	 * 
	 * @return a {@link Node} representing the updated element
	 */
	@Override
	public Node setAtt(Node from, String attName, Object attValue) {
		from.setProperty(attName, attValue);
		return from;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * <b>Note:</b> this mapping considers each {@link Label} of {@code from} as
	 * a potential type. Calling {@link #getType(Node)} returns a {@link String}
	 * containing all the {@link Label}s of {@code from} prefixed by ':'. As an
	 * example, calling this method on a {@link Node} with the {@link Label}s
	 * {@code "l1}, {@code "l2"}, and {@code "l3"} returns the value
	 * {@code ":l1:l2:l3"}
	 * 
	 * @return a {@link String} containing all the {@link Label}s of
	 *         {@code from} prefixed with ':'
	 */
	@Override
	public String getType(Node from) {
		StringBuilder sb = new StringBuilder();
		from.getLabels().forEach(l -> sb.append(':').append(l.name()));
		return sb.toString();
	}

	/**
	 * Returns whether {@code from} is an instance of {@code type}.
	 * <p>
	 * This mapping assumes that element types are represented as {@link Node}'s
	 * labels. A call to this method checks all the {@link Label}s of
	 * {@code from} and returns {@code true} if at least one is equal to
	 * {@code type}. Note that equality comparison is checked using the
	 * {@link String#equals(Object)} method and not {@code ==}.
	 * <p>
	 * <b>Note:</b> for this mapping there is no difference between
	 * {@link #isTypeOf(String)} and {@link #isKindOf(String)}.
	 * 
	 * @param from
	 *            the {@link Node} to check the type of
	 * @param type
	 *            the type to check
	 * 
	 * @return {@code true} if at least one {@link Label} of {@code from} is
	 *         equal to {@code type}, {@code false} otherwise
	 */
	@Override
	public boolean isTypeOf(Node from, String type) {
		for (Label l : from.getLabels()) {
			if (l.name().equals(type)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns whether {@code from} is an instance of {@code type} or any of its
	 * sub-type.
	 * <p>
	 * This mapping assumes that element types are represented as {@link Node}'s
	 * labels. A call to this method checks all the {@link Label}s of
	 * {@code from} and returns {@code true} if at least one is equal to
	 * {@code type} Note that equality comparison is checked using the
	 * {@link String#equals(Object)} method and not {@code ==}.
	 * <p>
	 * <b>Note:</b> for this mapping there is no difference between
	 * {@link #isKindOf(String)} and {@link #isTypeOf(String)}.
	 * 
	 * @param from
	 *            the {@link Node} to check the type of
	 * @param the
	 *            type to check
	 * 
	 * @return {@code true} is at least one {@link Label} of {@code from} is
	 *         equal to {@code type}, {@code false} otherwise
	 */
	@Override
	public boolean isKindOf(Node from, String type) {
		return isTypeOf(from, type);
	}

}
