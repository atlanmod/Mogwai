package fr.inria.atlanmod.mogwai.query.builder;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.processor.AbstractQueryProcessor;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.QueryException;

/**
 * Provides a fluent API to create {@link MogwaiQuery} instances.
 * <p>
 * This class defines the common methods that can be called on concrete builder
 * implementations.
 * <p>
 * <b>Note:</b> this class doesn't provide methods to associate a
 * {@link ModelDatastore} to the created query. {@link MogwaiQuery} are used as
 * an abstract layer that can be processed on any compatible(s)
 * {@link ModelDatastore}(s) (see
 * {@link #process(AbstractQueryProcessor, List, Map)}.
 * 
 * @see MogwaiQuery
 * @see AbstractQueryProcessor
 * 
 * @param <B>
 *            the concrete implementation of this builder
 * 
 * @author Gwendal DANIEL
 */
public abstract class AbstractMogwaiQueryBuilder<B extends AbstractMogwaiQueryBuilder<B>> {

	/**
	 * The raw input of the {@link MogwaiQuery} to create.
	 */
	protected Object input;

	/**
	 * Creates a new instance of this builder.
	 * <p>
	 * <b>Note:</b> this method is not public, use the static method
	 * {@code newBuilder()} in concrete subclasses to get an instance of the
	 * builder.
	 */
	protected AbstractMogwaiQueryBuilder() {

	}

	/**
	 * Returns the instance of the builder.
	 * 
	 * @return the instance of the builder
	 */
	@SuppressWarnings("unchecked")
	protected B me() {
		return (B) this;
	}

	/**
	 * Validates the provided informations and checks parameter conflicts.
	 * 
	 * @return {@code true} if the provided parameters are valid and don't
	 *         generate a conflict, {@code false} otherwise
	 */
	protected boolean validate() {
		return true;
	}

	/**
	 * Sets {@code file} as the input of the created {@link MogwaiQuery}.
	 * 
	 * @param file
	 *            the {@link File} used as the input of the {@link MogwaiQuery}
	 *            to create
	 * @return the instance of the builder
	 */
	public B fromFile(File file) {
		this.input = file;
		return me();
	}

	/**
	 * Sets {@code string} as the input of the created {@link MogwaiQuery}.
	 * 
	 * @param string
	 *            the {@link String} used as the input of the
	 *            {@link MogwaiQuery} to create
	 * @return the instance of the builder
	 */
	public B fromString(String string) {
		this.input = string;
		return me();
	}

	/**
	 * Sets {@code uri} as the input of the created {@link MogwaiQuery}.
	 * 
	 * @param uri
	 *            the {@link URI} used as the input of the {@link MogwaiQuery}
	 *            to create
	 * @return the instance of the builder
	 */
	public B fromURI(URI uri) {
		this.input = uri;
		return me();
	}

	/**
	 * Constructs the {@link MogwaiQuery} instance associated to this builder
	 * with the stored information.
	 * 
	 * @return the created {@link MogwaiQuery}
	 * @throws QueryException
	 *             if the {@link MogwaiQuery} cannot be built, or if the
	 *             provided information generate a conflict
	 */
	public MogwaiQuery build() throws QueryException {
		if (validate()) {
			return buildQuery();
		} else {
			throw new QueryException("An error occured when creating the query with the provided parameters");
		}
	}

	/**
	 * Constructs the {@link MogwaiQuery} instance associated to this builder.
	 * <p>
	 * This method is called after {@link #validate()} in {@link #build()}, and
	 * as to be implemented by concrete subclasses to create the
	 * {@link MogwaiQuery} instance associated to the builder.
	 * 
	 * @return the created {@link MogwaiQuery}
	 */
	protected abstract MogwaiQuery buildQuery();

}
