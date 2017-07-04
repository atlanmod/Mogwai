package fr.inria.atlanmod.mogwai.transformation.ocl.tests.translation;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.JavaPackage;
import org.eclipse.ocl.ecore.Constraint;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.util.OCLImporter;

@RunWith(Parameterized.class)
public class AbstractTranslationTest {

	/**
	 * The base directory containg testing resources. 
	 * TODO this should be moved in an abstract class that is the super type 
	 * of all the OCL related tests.
	 */
	protected static String RESOURCE_PREFIX = "resources/";

	/**
	 * The base directory containing OCL expression to translate and expected
	 * Gremlin scripts.
	 */
	protected static String TRANSLATION_RESOURCE_PREFIX = "resources/translation";

	/**
	 * Find the list of OCL files containing the expression to translate and
	 * return them in a {@link Collection} that can be used by Junit to
	 * parameterized the test.
	 * <p>
	 * The content of the returned {@link Collection} is automatically generated
	 * by inspected the <i>resource/translation/ocl</i> folder. To add a new OCL
	 * expression in the test suite you have to add a new OCL file
	 * <code>my_expression.ocl</code> in the <i>resources/translation/ocl</i>
	 * directory and its expected translation in the
	 * <i>resources/translation/gremlin</i> one.
	 * <p>
	 * <b>Note:</b> the returned {@link Collection} contains {@link String}
	 * representation of the OCL {@link File}s to translate. These
	 * representations are constructed by using the {@link File} name and
	 * removing the <code>.ocl</code> extension.
	 * 
	 * @return a {@link Collection} containing the names of the OCL {@link File}
	 *         s that are used to parameterized the test.
	 */
	@Parameters(name = "{0}")
	public static Collection<String[]> data() {
		File inputConstraintDirectory = new File(TRANSLATION_RESOURCE_PREFIX + "/ocl/");
		Collection<String> constraintFiles = Arrays.asList(inputConstraintDirectory.list());
		Collection<String[]> parameters = new ArrayList<String[]>();
		for (String inputConstraintFile : constraintFiles) {
			String[] parameter = { inputConstraintFile.substring(0, inputConstraintFile.lastIndexOf(".ocl")) };
			parameters.add(parameter);
		}
		return parameters;
	}

	/**
	 * The {@link ResourceSet} used to create the input OCL, generated Gremlin,
	 * and expected Gremlin {@link Resource}s.
	 */
	protected ResourceSet rSet;

	/**
	 * The OCL {@link Constraint} to translate.
	 */
	protected Constraint inputConstraint;

	/**
	 * The {@link Resource} containing the Gremlin script generated from the
	 * input OCL expression.
	 */
	protected Resource generatedGremlinResource;

	public AbstractTranslationTest(String constraintName) {
		EPackage.Registry.INSTANCE.put(JavaPackage.eNS_URI, JavaPackage.eINSTANCE);
		String constraintPath = TRANSLATION_RESOURCE_PREFIX + "/ocl/" + constraintName + ".ocl";
		String generatedGremlinResourcePath = TRANSLATION_RESOURCE_PREFIX + "/.tmp/" + constraintName + ".gremlin";

		rSet = new ResourceSetImpl();
		/*
		 * Allows to load .gremlin files as XMI models
		 */
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("gremlin", new XMIResourceFactoryImpl());
		/*
		 * Register the Gremlin EPackage to enable expected script loading
		 */
		rSet.getPackageRegistry().put(GremlinPackage.eINSTANCE.getNsURI(), GremlinPackage.eINSTANCE);

		MogwaiLogger.info("Importing OCL constraint ({0})", constraintPath);
		inputConstraint = OCLImporter.parseOCL(URI.createURI(constraintPath), JavaPackage.eINSTANCE);
		generatedGremlinResource = rSet.createResource(URI.createURI(generatedGremlinResourcePath));
		MogwaiLogger.info("Tmp resource holding generated script created ({0})", generatedGremlinResourcePath);
	}

}
