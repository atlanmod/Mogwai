package fr.inria.atlanmod.mogwai.query;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;

public class MogwaiGremlinQuery extends MogwaiQuery {

	private String literalQuery;
	
	public MogwaiGremlinQuery(Object input) throws MogwaiQueryException {
		super(input);
	}
	
	@Override
	protected void fromString(String string) {
		this.literalQuery = string;
	}

	@Override
	protected void fromURI(URI uri) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(uri.toFileString()));
		} catch(FileNotFoundException e) {
			throw new MogwaiQueryException(e.getMessage());
		}
		literalQuery = reader.lines().collect(Collectors.joining("\n"));
		try {
			reader.close();
		} catch (IOException e) {
			throw new MogwaiQueryException(e.getMessage());
		}
	}
	
	public String getGremlinScript() {
		return literalQuery;
	}

	@Override
	public String getInput() {
		return literalQuery;
	}

}
