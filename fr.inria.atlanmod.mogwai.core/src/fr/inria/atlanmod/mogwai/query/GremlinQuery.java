package fr.inria.atlanmod.mogwai.query;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;

import fr.inria.atlanmod.mogwai.query.builder.GremlinQueryBuilder;

/**
 * A simple {@link MogwaiQuery} implementation that wraps a Gremlin script to
 * compute.
 * <p>
 * Instances of this class can be created using the fluent
 * {@link GremlinQueryBuilder} API.
 * 
 * @see MogwaiQuery
 * @see GremlinQueryBuilder
 * 
 * @author Gwendal DANIEL
 *
 */
public class GremlinQuery extends MogwaiQuery {

	/**
	 * The literal representation of the Gremlin script.
	 */
	private String literalQuery;

	/**
	 * Constructs a new {@link GremlinQuery} from the given {@code input}.
	 * <p>
	 * {@link GremlinQuery} supports {@link String}, {@link URI}, {@link File}
	 * inputs. If another {@code input} type is provided the constructor throws
	 * a {@link QueryException}.
	 * <p>
	 * Instances of {@link GremlinQuery} can be created using the fluent
	 * {@link GremlinQueryBuilder} API.
	 * 
	 * @param input
	 *            an {@link Object} containing the input query
	 * @throws QueryException
	 *             if {@code input} doesn't contain a Gremlin script or if it
	 *             cannot be cast to a supported input type
	 * 
	 * @see GremlinQueryBuilder
	 */
	public GremlinQuery(Object input) throws QueryException {
		super(input);
		if (input instanceof String) {
			fromString((String) input);
		} else if (input instanceof URI) {
			fromURI((URI) input);
		} else if (input instanceof File) {
			fromFile((File) input);
		} else {
			throw new QueryException("Cannot construct a {0} from the provided input ({1})",
					GremlinQuery.class.getName(), input.getClass().getName());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInput() {
		return literalQuery;
	}

	/**
	 * Sets the internal query representation from the provided {@code string}.
	 * 
	 * @param string
	 *            the {@link String} representation of the Gremlin script
	 * 
	 * @see GremlinQuery#GremlinQuery(Object)
	 */
	protected void fromString(String string) {
		this.literalQuery = string;
	}

	/**
	 * Sets the internal query representation from the provided {@code file}.
	 * 
	 * @param file
	 *            the {@link File} containing the Gremlin script
	 * 
	 * @see GremlinQuery#GremlinQuery(Object)
	 */
	protected void fromFile(File file) {
		fromFileString(file.getAbsolutePath());
	}

	/**
	 * Set the internal query representation from the provided {@code uri}.
	 * 
	 * @param uri
	 *            the {@link URI} containing the Gremlin script
	 * 
	 * @see GremlinQuery#GremlinQuery(Object)
	 */
	protected void fromURI(URI uri) {
		fromFileString(uri.toFileString());
	}

	/**
	 * Parses the Gremlin script contained in the file at the provided
	 * {@code fileLocation}.
	 * 
	 * @param fileLocation
	 *            a {@link String} representation of the file's path
	 */
	private void fromFileString(String fileLocation) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileLocation));
		} catch (FileNotFoundException e) {
			throw new QueryException(e.getMessage());
		}
		this.literalQuery = reader.lines().collect(Collectors.joining("\n"));
		try {
			reader.close();
		} catch (IOException e) {
			throw new QueryException(e.getMessage());
		}
	}

}
