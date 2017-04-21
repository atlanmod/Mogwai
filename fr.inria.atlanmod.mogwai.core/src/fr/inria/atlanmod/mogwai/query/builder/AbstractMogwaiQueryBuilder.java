package fr.inria.atlanmod.mogwai.query.builder;

import java.io.File;

import org.eclipse.emf.common.util.URI;

import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.QueryException;

public abstract class AbstractMogwaiQueryBuilder<B extends AbstractMogwaiQueryBuilder<B>> {

	protected Object input;

	protected AbstractMogwaiQueryBuilder() {

	}

	@SuppressWarnings("unchecked")
	protected B me() {
		return (B) this;
	}

	/**
	 * @return {@code true} if no conflict is detected
	 */
	protected boolean validate() {
		return true;
	}

	public B fromFile(File file) {
		this.input = file;
		return me();
	}

	public B fromString(String string) {
		this.input = string;
		return me();
	}

	public B fromURI(URI uri) {
		this.input = uri;
		return me();
	}

	public MogwaiQuery build() {
		if (validate()) {
			return buildQuery();
		} else {
			throw new QueryException("An error occured when creating the query with the provided parameters");
		}
	}

	protected abstract MogwaiQuery buildQuery();

}
