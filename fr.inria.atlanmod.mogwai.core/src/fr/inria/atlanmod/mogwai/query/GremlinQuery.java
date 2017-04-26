package fr.inria.atlanmod.mogwai.query;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;

/**
 * A simple {@link MogwaiQuery} implementation that wraps a Gremlin script to
 * compute.
 * 
 * @author Gwendal DANIEL
 *
 */
public class GremlinQuery extends MogwaiQuery {

	/**
	 * The literal representation of the Gremlin script.
	 */
	private String literalQuery;
	
	public GremlinQuery(Object input) throws QueryException {
		super(input);
		if (input instanceof String) {
			fromString((String) input);
		} else if (input instanceof URI) {
			fromURI((URI) input);
		} else if (input instanceof File) {
			fromFile((File) input);
		} else {
			throw new QueryException("Unknown input type " + input);
		}
	}

	protected void fromString(String string) {
		this.literalQuery = string;
	}

	protected void fromFile(File file) {
		fromFileString(file.getAbsolutePath());
	}

	protected void fromURI(URI uri) {
		fromFileString(uri.toFileString());
	}

	private void fromFileString(String fileString) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileString));
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

	@Override
	public String getInput() {
		return literalQuery;
	}

}
