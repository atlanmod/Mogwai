package fr.inria.atlanmod.mogwai.query;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;

public class MogwaiGremlinQuery extends MogwaiQuery {

	private String literalQuery;
	private Map<String, Object> bindings;
	
	public MogwaiGremlinQuery(Object input, Map<String, Object> bindings) throws MogwaiQueryException {
		super(input);
		this.bindings = bindings;
		if(input instanceof String) {
			fromString((String) input);
		} else if(input instanceof URI) {
			fromURI((URI) input);
		} else if(input instanceof File) {
			fromFile((File) input);
		} else {
			throw new MogwaiQueryException("Unknown input type " + input);
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
		} catch(FileNotFoundException e) {
			throw new MogwaiQueryException(e.getMessage());
		}
		this.literalQuery = reader.lines().collect(Collectors.joining("\n"));
		try {
			reader.close();
		} catch (IOException e) {
			throw new MogwaiQueryException(e.getMessage());
		}
	}
	
	public String getGremlinScript() {
		return literalQuery;
	}
	
	public Map<String, Object> getBindings() {
		return bindings;
	}

	@Override
	public String getInput() {
		return literalQuery;
	}

}
