package fr.inria.atlanmod.mogwai.transformation.ocl.tests.translation;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.java.JavaPackage;
import org.eclipse.ocl.ecore.Constraint;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.transformation.files.OCL2Gremlin;
import fr.inria.atlanmod.mogwai.transformation.ocl.tests.util.FileUtil;
import fr.inria.atlanmod.mogwai.transformation.ocl.tests.util.TestUtil;
import fr.inria.atlanmod.mogwai.util.OCLImporter;

/**
 * Tests the Gremlin translation of simple OCL expressions.
 * <p>
 * This class uses the {@link OCL2Gremlin} transformation runner to translate
 * all the <code>.ocl</code> files in the <i>resources/translation/ocl</i>
 * directory, and compare the generated gremlin script with the expected ones in
 * the <i>resource/translation/gremlin</i> directory.
 * <p>
 * Generated gremlin scripts are stored in the <i>resources/translation/.tmp</i>
 * directory and can be used for debugging purposes. Note that the content of
 * this directory is deleted before each run.
 * <p>
 * Generated and expected scripts are compared with EMF Compare, differences
 * between the scripts are logged by default in the console. See
 * {@link MogwaiLogger} to change the logging configuration.
 * <p>
 * To add a new OCL expression in the test suite you have to add a new OCL file
 * <code>my_expression.ocl</code> in the <i>resources/translation/ocl</i>
 * directory and its expected translation in the
 * <i>resources/translation/gremlin</i> one.
 * 
 * @author Gwendal DANIEL
 *
 */
@RunWith(Parameterized.class)
public class MogwaiTranslationTest {

	/**
	 * The base directory containing OCL expression to translate and expected
	 * Gremlin scripts.
	 */
	private static String RESOURCE_PREFIX = "resources/translation";

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
		File inputConstraintDirectory = new File(RESOURCE_PREFIX + "/ocl/");
		Collection<String> constraintFiles = Arrays.asList(inputConstraintDirectory.list());
		Collection<String[]> parameters = new ArrayList<String[]>();
		for (String inputConstraintFile : constraintFiles) {
			String[] parameter = { inputConstraintFile.substring(0, inputConstraintFile.lastIndexOf(".ocl")) };
			parameters.add(parameter);
		}
		return parameters;
	}

	/**
	 * Deletes the content of the <i>.tmp</i> directory to remove generated
	 * Gremlin save conflict.
	 * <p>
	 * This method is only invoked once at the beginning of the execution to
	 * empty the <i>.tmp</i> directory. As a result all the generated Gremlin
	 * scripts during the execution are stored and accessible for debugging
	 * purposes.
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		String tmpPath = RESOURCE_PREFIX + "/.tmp";
		MogwaiLogger.info("Deleting {0}", tmpPath);
		FileUtil.delete(new File(tmpPath));
	}

	/**
	 * The {@link ResourceSet} used to create the input OCL, generated Gremlin,
	 * and expected Gremlin {@link Resource}s.
	 */
	private ResourceSet rSet;

	/**
	 * The OCL {@link Constraint} to translate.
	 */
	private Constraint inputConstraint;

	/**
	 * The {@link Resource} containing the Gremlin script generated from the
	 * input OCL expression.
	 */
	private Resource generatedGremlinResource;

	/**
	 * The {@link Resource} containing the expected Gremlin script.
	 */
	private Resource expectedGremlinResource;

	/**
	 * Constructs a new instance of the test case with the provided
	 * <code>constraintName</code>.
	 * <p>
	 * The provided parameter is used to find the input OCL file and the
	 * expected Gremlin file in the <i>resources/translation</i> directory.
	 * 
	 * @param constraintName
	 *            the name of the OCL expression to test
	 */
	public MogwaiTranslationTest(String constraintName) {
		MogwaiLogger.info("------------------------------------");
		MogwaiLogger.info("Testing {0}", constraintName);
		MogwaiLogger.info("------------------------------------");
		String constraintPath = RESOURCE_PREFIX + "/ocl/" + constraintName + ".ocl";
		String expectedGremlinResourcePath = RESOURCE_PREFIX + "/gremlin/" + constraintName + ".gremlin";
		String generatedGremlinResourcePath = RESOURCE_PREFIX + "/.tmp/" + constraintName + ".gremlin";

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
		expectedGremlinResource = rSet.createResource(URI.createURI(expectedGremlinResourcePath));
		try {
			expectedGremlinResource.load(Collections.emptyMap());
			MogwaiLogger.info("Expected result loaded ({0})", expectedGremlinResourcePath);
		} catch (IOException e) {
			MogwaiLogger.error("Cannot load expected result at {0}. using empty resource instead",
					expectedGremlinResourcePath);
			MogwaiLogger.error(e.getMessage());
			expectedGremlinResource = TestUtil.createEmptyGremlinResource(rSet);
		}
		generatedGremlinResource = rSet.createResource(URI.createURI(generatedGremlinResourcePath));
		MogwaiLogger.info("Tmp resource holding generated script created ({0})", generatedGremlinResourcePath);
	}

	/**
	 * Translates the input OCL expression and compares it with the expected
	 * Gremlin script.
	 * <p>
	 * This test ensures that the generated Gremlin script is not
	 * <code>null</code>, and compares it against the expected one using EMF
	 * Compare {@link DefaultComparisonScope}.
	 * <p>
	 * <b>Note:</b> if the expected Gremlin model cannot be found in the
	 * <i>resources/translation</i> directory an error message is printed in the
	 * console and an empty Gremlin {@link Resource} is used for the comparison.
	 * 
	 * @throws IOException
	 *             if the generated Gremlin script cannot be stored in the
	 *             <i>.tmp</i> directory
	 */
	@Test
	public void test() throws IOException {
		OCL2Gremlin runner = new OCL2Gremlin();
		GremlinScript gScript = (GremlinScript) runner.transform(JavaPackage.eINSTANCE, inputConstraint);
		assert gScript != null : "Generated script is null";

		generatedGremlinResource.getContents().add(gScript);
		/*
		 * Save the generated script for debugging purposes.
		 */
		generatedGremlinResource.save(Collections.emptyMap());
		MogwaiLogger.info("Saving tmp resource containing the generated script");

		IComparisonScope scope = new DefaultComparisonScope(generatedGremlinResource, expectedGremlinResource, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);
		MogwaiLogger.info("Comparing generated resource and expected one ({0}/{1})", generatedGremlinResource.getURI(),
				expectedGremlinResource.getURI());
		MogwaiLogger.info("Left: generated Gremlin query");
		MogwaiLogger.info("Right: expected Gremlin query");

		List<Diff> differences = comparison.getDifferences();
		if (differences.size() > 0) {
			MogwaiLogger.error("Found {0} differences between the generated Gremlin script and the expected one:",
					differences.size());
			for (Diff diff : differences) {
				MogwaiLogger.error("\t{0}", diff.toString());
			}
			fail("Found "
					+ differences.size()
					+ " differences between the generated Gremlin script and the expected one (see log for diff details)");
		}
		MogwaiLogger.info("Generated Gremlin script and expected one are similar");
	}

}
