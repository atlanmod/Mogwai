package fr.inria.atlanmod.mogwai.transformation.ocl.tests.translation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmt.modisco.java.Model;
import org.eclipse.gmt.modisco.java.Package;
import org.eclipse.gmt.modisco.java.emf.JavaFactory;
import org.eclipse.gmt.modisco.java.emf.JavaPackage;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.gremlin.printers.GremlinPrinterFactory;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.neoemf.util.MogwaiURI;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.builder.GremlinQueryBuilder;
import fr.inria.atlanmod.mogwai.transformation.files.OCL2Gremlin;
import fr.inria.atlanmod.mogwai.transformation.ocl.tests.util.EObjectComparator;
import fr.inria.atlanmod.mogwai.transformation.ocl.tests.util.FileUtil;
import fr.inria.atlanmod.mogwai.transformation.ocl.tests.util.ModelImporter;
import fr.inria.atlanmod.mogwai.transformation.ocl.tests.util.TestUtil;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;

public class MogwaiExecutionTest extends AbstractTranslationTest {

	/**
	 * The {@link Resource} containing the model to query.
	 * <p>
	 * This {@link Resource} is cleaned and reloaded before each test to avoid
	 * database corruption between query executions.
	 * 
	 * @see #setUp()
	 */
	protected MogwaiResource mogwaiResource;

	/**
	 * The {@link OCL} instance used to compute OCL queries on the provided
	 * {@link Resource}.
	 */
	protected OCL ocl;

	/**
	 * Constructs a new instance of the test case with the provided
	 * {@code constraintName}.
	 * <p>
	 * The provided parameter is used to find the input OCL file in the
	 * <i>resources/translation</i> directory.
	 * 
	 * @param constraintName
	 *            the name of the OCL expression to test
	 */
	public MogwaiExecutionTest(String constraintName) {
		super(constraintName);
		MogwaiLogger.info("------------------------------------");
		MogwaiLogger.info("Testing {0}", constraintName);
		MogwaiLogger.info("------------------------------------");
		ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
	}

	/**
	 * Cleans the content of the <i>.neoemf</i> directory and regenerates the
	 * NeoEMF resource to avoid database corruption between querie executions.
	 * 
	 * @throws IOException
	 *             if the input XMI model cannot be found
	 */
	@Before
	public void setUp() throws IOException {
		PersistenceBackendFactoryRegistry.register(MogwaiURI.MOGWAI_SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());

		String neoEMFResourcePath = TRANSLATION_RESOURCE_PREFIX + "/.neoemf/";
		MogwaiLogger.info("Deleting {0}", neoEMFResourcePath);
		FileUtil.delete(new File(neoEMFResourcePath));
		URI xmiURI = URI.createURI(RESOURCE_PREFIX + "models/set1.xmi");
		URI mogwaiURI = MogwaiURI.createMogwaiURI(new File(neoEMFResourcePath + "set1.graphdb"));
		try {
			mogwaiResource = ModelImporter.createNeoMogwaiResourceFromXMI(xmiURI, mogwaiURI);
		} catch (IOException e) {
			MogwaiLogger.error("Cannot create the Mogwai resource ({0})", mogwaiURI);
			throw e;
		}
	}

	/**
	 * Closes the Mogwai {@link Resource} used to query the model.
	 */
	@After
	public void tearDown() {
		mogwaiResource.close();
	}

	/**
	 * Executes the original OCL expression and the corresponding Gremlin script
	 * and compares their results.
	 * <p>
	 * Primitive types are compared using an extended version of
	 * {@link Objects#equals(Object, Object)} that bridges the gap between OCL
	 * primitive types and Gremlin ones. Note that double-based comparison may
	 * be inconsistent when using a low precision.
	 * <p>
	 * <b>Note:</b> EMF Compare is used to perform {@link EObject} comparisons.
	 * However, order of the result is not checked, because the Mogwai execution
	 * engine does not take into account elements' order when the query is
	 * executed.
	 */
	@Test
	public void test() {
		OCL2Gremlin runner = new OCL2Gremlin();
		GremlinScript gScript = (GremlinScript) runner.transform(JavaPackage.eINSTANCE, inputConstraint);
		assert gScript != null : "Generated script is null";

		EClass constraintContext = (EClass) inputConstraint.getSpecification().getContextVariable().getType();
		MogwaiLogger.info("Constraint context: {0}", constraintContext);
		/*
		 * Compute the original OCL query
		 */
		Query<?, ?, ?> oclQuery = ocl.createQuery(inputConstraint);
		Object oclResult = oclQuery.evaluate(mogwaiResource.getContents().get(0));

		/*
		 * Computes the generated Gremlin script
		 */
		String textualScript = GremlinPrinterFactory.getDefaultPrinter().print(gScript);
		MogwaiQuery gremlinQuery = GremlinQueryBuilder.newBuilder().fromString(textualScript).build();
		NeoEMFQueryResult mogwaiResult = mogwaiResource.query(gremlinQuery);

		compareResults(oclResult, mogwaiResult);

	}

	/**
	 * Compare OCL and Mogwai query results.
	 * <p>
	 * This method is used to compare single results such as primitive types or
	 * single {@link EObject} as well as collection results such as lists of
	 * {@link EObject}s or primitive types.
	 * <p>
	 * An {@link AssertionError} is thrown if the results are not found to be
	 * equivalent.
	 * 
	 * @param oclResult
	 *            the query result computed by the {@link OCL} environment
	 * @param mogwaiResult
	 *            the query result computed by the Mogwai framework
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void compareResults(Object oclResult, NeoEMFQueryResult mogwaiResult) {
		if (oclResult instanceof Collection) {
			assertTrue(MessageFormat.format("Mogwai query returns {0} results while OCL one returns {0} results",
					mogwaiResult.getResults().size(), ((Collection) oclResult).size()), mogwaiResult.getResults()
					.size() == ((Collection) oclResult).size());
			if (((Collection) oclResult).iterator().next() instanceof EObject) {
				/*
				 * The OCL query returns EObjects. Note: here we assume that the
				 * type of the first element of the collection defines the type
				 * of the other elements. This is obviously false (for example
				 * if the evaluated constraint returns a collection of OclAny
				 * elements) and should be fixed.
				 */
				assertTrue("MogwaiQuery result is not reifiable while OCL result is an EObject",
						mogwaiResult.isReifiable());

				List<EObject> reifiedResults = mogwaiResult.reifyResults(mogwaiResource);

				Notifier mogwaiResultResource = createComparableNotifier(reifiedResults);

				/*
				 * Create a List containing the OCL results. This allows to
				 * handle seamlessly OCL expressions returning Bags, (Ordered)
				 * Sets, and Sequences.
				 */
				List<EObject> oclList = new ArrayList<EObject>();
				oclList.addAll((Collection<EObject>) oclResult);

				Notifier oclResultResource = createComparableNotifier(oclList);

				MogwaiLogger.info("Comparing Mogwai result and OCL result");
				MogwaiLogger.info("Left: Mogwai result");
				MogwaiLogger.info("Right: OCL result");

				IComparisonScope scope = new DefaultComparisonScope(mogwaiResultResource, oclResultResource, null);
				Comparison comparison = EMFCompare.builder().build().compare(scope);
				List<Diff> differences = comparison.getDifferences();
				if (differences.size() > 0) {
					MogwaiLogger.error("Found {0} differences between Mogwai and OCL results:", differences.size());
					for (Diff diff : differences) {
						MogwaiLogger.error("\t{0}", diff.toString());
					}
					fail("Found " + differences.size()
							+ " differences between the generated Gremlin script and the expected one");
				}
				MogwaiLogger.info("Mogwai and OCL results are similar");
			} else {
				fail("Multiple non-EObject results are not handled for now");
			}
		} else {
			/*
			 * The OCL query return a single value
			 */
			assertTrue("MogwaiQuery result contains multiple results while OCL result is a single EObject",
					mogwaiResult.isSingleResult());
			if (oclResult instanceof EObject) {
				assertTrue("MogwaiQuery result is not reifiable while OCL result is an EObject",
						mogwaiResult.isReifiable());
				EObject reifiedResult = mogwaiResult.reifyResults(mogwaiResource).get(0);
				MogwaiLogger.info("Comparing Mogwai result and OCL result ({0}, {1})", reifiedResult, oclResult);
				MogwaiLogger.info("Left: Mogwai result");
				MogwaiLogger.info("Right: OCL result");
				IComparisonScope scope = new DefaultComparisonScope(reifiedResult, (EObject) oclResult, null);
				Comparison comparison = EMFCompare.builder().build().compare(scope);
				List<Diff> differences = comparison.getDifferences();
				if (differences.size() > 0) {
					MogwaiLogger.error("Found {0} differences between Mogwai and OCL results:", differences.size());
					for (Diff diff : differences) {
						MogwaiLogger.error("\t{0}", diff.toString());
					}
					fail("Found " + differences.size()
							+ " differences between the generated Gremlin script and the expected one");
				}
				MogwaiLogger.info("Mogwai and OCL results are similar");
			} else {
				/*
				 * The OCL query returns a primitive type or null
				 */
				assertTrue(MessageFormat.format(
						"Comparison failed: OCL returned {0}(type: {1}) while Mogwai returned {2}(type: {3})",
						oclResult, oclResult.getClass().getName(), mogwaiResult.getResult(), mogwaiResult.getResult()
								.getClass().getName()), TestUtil.equals(oclResult, mogwaiResult.getResult()));
			}
		}
	}

	/**
	 * Creates a {@link Notifier} instance that can be used as a root element in
	 * an EMF Compare comparison.
	 * <p>
	 * The created {@link Notifier} can be a {@link Resource} or a specific
	 * {@link EObject} depending on the metamodel structure.
	 * <p>
	 * <b>Note:</b> the current implementation only supports {@link List} of
	 * Package elements. This should be fixed but require to have a container in
	 * the metamodel that can handle any kind of {@link EObject}.
	 * <p>
	 * <b>Note:</b> this method does not create {@link Resource} instances for
	 * now because resource-based comparison are not working properly when using
	 * NeoEMF with EMF Compare.
	 * 
	 * @param eObjects
	 *            the {@link List} of {@link EObject} to create a comparable
	 *            container for
	 * @return the created {@link Notifier} instance
	 */
	@SuppressWarnings("unchecked")
	private Notifier createComparableNotifier(List<EObject> eObjects) {
		/*
		 * Bug: this method only works for Package instances
		 */
		Collections.sort(eObjects, new EObjectComparator());
		Model model = JavaFactory.eINSTANCE.createModel();
		model.getOwnedElements().addAll((Collection<? extends Package>) EcoreUtil.copyAll(eObjects));
		return model;
	}
}
