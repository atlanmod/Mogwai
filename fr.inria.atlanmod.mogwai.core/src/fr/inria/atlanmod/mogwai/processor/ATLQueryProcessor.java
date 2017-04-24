package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.isNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.common.ATL.Module;

import fr.inria.atlanmod.mogwai.core.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.gremlin.printers.GremlinPrinter;
import fr.inria.atlanmod.mogwai.gremlin.printers.GremlinPrinterFactory;
import fr.inria.atlanmod.mogwai.query.ATLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;
import fr.inria.atlanmod.mogwai.transformation.atl.files.ATL2Gremlin;
import fr.inria.atlanmod.mogwai.transformation.atl.helper.AbstractATLTransformationHelper;

/**
 * An ATL-based processor that computes a {@link ATLQuery}.
 * <p>
 * The input ATL transformation is translated by the <b>ATL2Gremlin</b> ATL
 * transformation that generates the corresponding Gremlin script to compute.
 * 
 * @see AbstractATLProcessor
 * 
 * @author Gwendal DANIEL
 *
 */
public class ATLQueryProcessor extends AbstractATLProcessor<ATLQuery> {

	/**
	 * The option key used to specify the
	 * {@link AbstractATLTransformationHelper} to use in the generated Gremlin
	 * query.
	 */
	public static final String TRANSFORMATION_HELPER_KEY = "transformation.helper";

	/**
	 * The name of the processor.
	 */
	private static final String NAME = "ATL Processor";

	/**
	 * Constructs a new {@link ATLQueryProcessor}.
	 */
	public ATLQueryProcessor() {
		transformation = new ATL2Gremlin();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ATL2Gremlin getTransformation() {
		return (ATL2Gremlin) transformation;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException
	 *             if there is no {@link AbstractATLTransformationHelper}
	 *             specified in the {@code options} map.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public QueryResult process(ATLQuery query, List<ModelDatastore> datastores, Map<String, Object> options) {
		checkArgument(options.containsKey(TRANSFORMATION_HELPER_KEY),
				"MogwaiATLProcessor requires a TransformationHelper to compute the transformation");
		return super.process(query, datastores, options);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return {@code true} if {@code query} is an instance of {@link ATLQuery},
	 *         {@code false} otherwise
	 */
	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof ATLQuery;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Adds ATL Gremlin printer in the options if it contains the print option
	 * without an explicit {@link GremlinPrinter}.
	 * 
	 * @see GremlinPrinter
	 * @see GremlinPrinterFactory
	 */
	@Override
	protected void adaptOptions(Map<String, Object> options) {
		if (options.containsKey(GremlinScriptRunner.PRINT_SCRIPT_OPTION)) {
			boolean print = (boolean) options.get(GremlinScriptRunner.PRINT_SCRIPT_OPTION);
			if (print) {
				if (!options.containsKey(GremlinScriptRunner.PRINTER_OPTION)) {
					options.put(GremlinScriptRunner.PRINTER_OPTION, GremlinPrinterFactory.ATL_GREMLIN_PRINTER);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Adds the {@link AbstractATLTransformationHelper} {@code option} within
	 * the created bindings.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected Map<String, Object> createBindings(List<ModelDatastore> datastores, Map<String, Object> options) {
		Map<String, Object> bindings = super.createBindings(datastores, options);
		bindings.put(AbstractATLTransformationHelper.BINDING_NAME,
				(AbstractATLTransformationHelper) options.get(TRANSFORMATION_HELPER_KEY));
		return bindings;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws MogwaiCoreException
	 *             if the underlying transformation failed during the execution
	 */
	@Override
	protected GremlinScript createGremlinScript(ATLQuery query, Map<String, Object> options) {
		Module atlModule = (Module) query.getATLResource().getContents().get(0);
		/*
		 * TODO support multiple input models
		 */
		String sourceMMName = atlModule.getInModels().get(0).getMetamodel().getName();
		/*
		 * TODO support multiple output models
		 */
		String targetMMName = atlModule.getOutModels().get(0).getMetamodel().getName();

		Resource gremlinResource = getTransformation().transform(query.getATLResource(), sourceMMName,
				query.getSourcePackage(), targetMMName, query.getTargetPackage());
		if (isNull(gremlinResource.getContents())) {
			throw new MogwaiCoreException("Created script is null");
		}
		if (!(gremlinResource.getContents().get(0) instanceof GremlinScript)) {
			throw new MogwaiCoreException("Generated script is invalid: expected {0}, found {1}",
					GremlinScript.class.getName(), gremlinResource.getContents().get(0).getClass().getName());
		}
		// Relax that for debugging purposes
		// checkArgument(gremlinResource.getContents().size() == 1,
		// "Invalid resource content size, expected 1, found {0}",
		// gremlinResource.getContents().size());
		return ((GremlinScript) gremlinResource.getContents().get(0));
	}
}
