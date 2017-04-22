package fr.inria.atlanmod.mogwai.processor;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.common.ATL.Module;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.gremlin.printers.GremlinPrinterFactory;
import fr.inria.atlanmod.mogwai.query.ATLQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.QueryResult;
import fr.inria.atlanmod.mogwai.transformation.atl.files.ATL2Gremlin;
import fr.inria.atlanmod.mogwai.transformation.atl.helper.AbstractATLTransformationHelper;

public class ATLQueryProcessor extends AbstractATLProcessor<ATLQuery> {

	public static final String TRANSFORMATION_HELPER_KEY = "transformation.helper";

	private static final String NAME = "ATL Processor";

	public ATLQueryProcessor() {
		transformation = new ATL2Gremlin();
	}

	@Override
	protected ATL2Gremlin getTransformation() {
		return (ATL2Gremlin) transformation;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public QueryResult process(ATLQuery query, List<ModelDatastore> datastores, Map<String, Object> options) {
		checkArgument(options.containsKey(TRANSFORMATION_HELPER_KEY),
				"MogwaiATLProcessor requires a TransformationHelper to compute the transformation");
		return super.process(query, datastores, options);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Map<String, Object> createBindings(List<ModelDatastore> datastores, Map<String, Object> options) {
		Map<String, Object> bindings = super.createBindings(datastores, options);
		bindings.put(AbstractATLTransformationHelper.BINDING_NAME, (AbstractATLTransformationHelper) options.get(TRANSFORMATION_HELPER_KEY));
		return bindings;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Adds ATL Gremlin printer in the options if it contains the print option
	 * but no printer.
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

	@Override
	public boolean accept(MogwaiQuery query) {
		return !Objects.isNull(query) && query instanceof ATLQuery;
	}

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
		checkArgument(gremlinResource.getContents() != null, "Created resource content is null");
		// Relax that for debugging purposes
		// checkArgument(gremlinResource.getContents().size() == 1,
		// "Invalid resource content size, expected 1, found {0}",
		// gremlinResource.getContents().size());
		checkArgument(gremlinResource.getContents().get(0) instanceof GremlinScript,
				"Created resource does not contain a GremlinScript element");
		return ((GremlinScript) gremlinResource.getContents().get(0));
	}
}
