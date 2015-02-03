package fr.inria.atlanmod.mogwai.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.Constraint;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.GraphFactory;
import com.tinkerpop.blueprints.KeyIndexableGraph;
import com.tinkerpop.blueprints.util.wrappers.id.IdGraph;

import fr.inria.atlanmod.mogwai.MogwaiException;

public class MogwaiUtil {
	
	private static final String CONFIG_FILE = "config.properties";
	private static final String GRAPH_TYPE = "blueprints.graph";
	
	public static Constraint parseOCL(URI oclFileURI, EPackage pack) throws Exception {
		OCLParser oclParser = new OCLParser(pack);
		String cleanOCLQuery = removeImports(oclFileURI);
		Constraint constraint= oclParser.parseTextualOCL(cleanOCLQuery);
		return constraint;
	}
	
	public static Graph openBlueprintsGraph(File dbDirectory) throws MogwaiException {
		PropertiesConfiguration configuration = null;
		String directoryProperty = null;
		Graph graph = null;
		Path path = Paths.get(dbDirectory.getAbsolutePath()).resolve(CONFIG_FILE);
		try {
			configuration = new PropertiesConfiguration(path.toFile());
		}catch(ConfigurationException e) {
			throw new MogwaiException("Can not open the database");
		}
		String graphType = configuration.getString(GRAPH_TYPE);
		if (graphType == null) {
			throw new MogwaiException("Graph type is undefined");
		}
		String[] segments = graphType.split("\\.");
		// TODO: Add sanity check for array access
		String graphName = segments[segments.length - 2];
		directoryProperty = "blueprints."+graphName+".directory";
		configuration.setProperty(directoryProperty, dbDirectory.getAbsolutePath());
		Graph baseGraph = GraphFactory.open(configuration);
		if (baseGraph instanceof KeyIndexableGraph) {
			graph = new IdGraph((KeyIndexableGraph) baseGraph);
		} else {
			throw new MogwaiException(("Graph type does not support Key Indices"));
		}
		return graph;
	}
	
	private static String removeImports(URI oclFileURI) throws Exception {
		StringBuffer oclQuery = new StringBuffer();
		BufferedReader br = new BufferedReader(new FileReader(oclFileURI.toFileString()));
		String line;
		while ((line = br.readLine()) != null) {
		   if(!line.contains("import")) {
			   oclQuery.append(line);
			   oclQuery.append("\n");
		   }
		}
		br.close();
		return oclQuery.toString();
	}
	
}
