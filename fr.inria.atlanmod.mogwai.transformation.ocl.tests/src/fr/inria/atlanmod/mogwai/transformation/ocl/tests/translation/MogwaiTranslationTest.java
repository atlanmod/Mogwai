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

@RunWith(Parameterized.class)
public class MogwaiTranslationTest {

	private static String RESOURCE_PREFIX = "resources/translation";

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

	private ResourceSet rSet;

	private Constraint inputConstraint;
	private Resource generatedGremlinResource;
	private Resource expectedGremlinResource;

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

	@BeforeClass
	public static void setUpBeforeClass() {
		String tmpPath = RESOURCE_PREFIX + "/.tmp";
		MogwaiLogger.info("Deleting {0}", tmpPath);
		FileUtil.delete(new File(tmpPath));
	}

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
