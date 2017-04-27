package fr.inria.atlanmod.mogwai.query.builder;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.isNull;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceFactoryImpl;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.processor.ATLQueryProcessor;
import fr.inria.atlanmod.mogwai.query.ATLQuery;
import fr.inria.atlanmod.mogwai.query.QueryException;

/**
 * An {@link AbstractMogwaiQueryBuilder} that allows to create {@link ATLQuery}
 * instances.
 * <p>
 * This builder accepts all the input types of
 * {@link AbstractMogwaiQueryBuilder} (File, String, and URI). Note that the
 * String used to create an {@link ATLQuery} should contain the path of the ATL
 * transformation (.atl) file to compute.
 * <p>
 * The created {@link ATLQuery} can be processed by an {@link ATLQueryProcessor}
 * on top of any {@link ModelDatastore} implementation.
 * 
 * @see ATLQuery
 * @see ATLQueryProcessor
 * 
 * @author Gwendal DANIEL
 *
 */
public class ATLQueryBuilder extends AbstractMogwaiQueryBuilder<ATLQueryBuilder> {

	/**
	 * The {@link ResourceSet} used to load and parse the ATL input ATL file.
	 */
	private ResourceSet rSet;

	/**
	 * The source {@link EPackage} of the input ATL transformation.
	 * <p>
	 * TODO: handle multiple source {@link EPackage}s.
	 */
	private EPackage sourcePackage;

	/**
	 * The target {@link EPackage} of the input ATL transformation.
	 * <p>
	 * TODO: handle multiple target {@link EPackage}s.
	 */
	private EPackage targetPackage;

	/**
	 * Creates a new instance of this builder.
	 * <p>
	 * <b>Note:</b> this method is not public, use the static
	 * {@link #newBuilder()} that allows to chain build operations instead.
	 */
	protected ATLQueryBuilder() {
		rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
	}

	/**
	 * Creates a new instance of this builder that can be chained with build
	 * operations.
	 * 
	 * @return a new instance of this builder that can be chained with build
	 *         operations
	 */
	public static ATLQueryBuilder newBuilder() {
		return new ATLQueryBuilder();
	}
	
	/**
	 * {@inheritDoc}
	 * <p>
	 * This method checks if an ATL transformation has been provided and ifthe
	 * mandatory {@code sourcePackage} and {@code targetPackage} arguments are
	 * set.
	 * 
	 * @return {@code true} if the mandatory parameters have been provided and
	 *         are valid, {@code false} otherwise
	 * 
	 */
	@Override
	protected boolean validate() {
		boolean valid = true;
		if (isNull(input)) {
			valid = false;
			MogwaiLogger.error("No transformation provided");
		}
		if(isNull(sourcePackage)) {
			valid = false;
			MogwaiLogger.error("{0} is not a valid source EPackage", sourcePackage);
		}
		if(isNull(targetPackage)) {
			valid = false;
			MogwaiLogger.error("{0} is not a valid target EPackage", targetPackage);
		}
		return valid;
	}

	/**
	 * Sets the source {@link EPackage} used in the input ATL transformation.
	 * <p>
	 * This parameter is mandatory to create an {@link ATLQuery} instance.
	 * {@link #validate()} fails if it is not set.
	 * <p>
	 * TODO: handle multiple source {@link EPackage}s.
	 * 
	 * @param ePackage
	 *            the source {@link EPackage} of the input ATL transformation
	 * @return the instance of the builder
	 */
	public ATLQueryBuilder sourcePackage(EPackage ePackage) {
		checkNotNull(ePackage, "null ePackage");
		this.sourcePackage = ePackage;
		return me();
	}

	/**
	 * Sets the target {@link EPackage} used in the input ATL transformation.
	 * <p>
	 * This parameter is mandatory to create an {@link ATLQuery} instance.
	 * {@link #validate()} fails if it is not set.
	 * <p>
	 * TODO: handle multiple target {@link EPackage}s.
	 * 
	 * @param ePackage
	 *            the target {@link EPackage} of the input ATL transformation
	 * @return the instance of the builder
	 */
	public ATLQueryBuilder targetPackage(EPackage ePackage) {
		checkNotNull(ePackage, "null package");
		this.targetPackage = ePackage;
		return me();
	}
	
	/**
	 * Constructs a new {@link ATLQuery} instance from the provided parameters.
	 * 
	 * @return the created {@link ATLQuery}
	 */
	@Override
	protected ATLQuery buildQuery() {
		Resource atlResource;
		if (input instanceof URI) {
			atlResource = rSet.getResource((URI) input, true);
		} else if (input instanceof File) {
			atlResource = rSet.getResource(URI.createURI(((File) input).getAbsolutePath()), true);
		} else if (input instanceof String) {
			atlResource = rSet.getResource(URI.createURI((String) input), true);
		} else {
			throw new QueryException("Cannot find the ATL resource at " + input);
		}
		return new ATLQuery(atlResource, sourcePackage, targetPackage);
	}

}
