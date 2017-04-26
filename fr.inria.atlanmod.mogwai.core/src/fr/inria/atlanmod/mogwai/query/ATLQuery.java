package fr.inria.atlanmod.mogwai.query;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.mogwai.query.builder.ATLQueryBuilder;

/**
 * A {@link MogwaiQuery} implementation that wraps an ATL transformation to
 * compute.
 * <p>
 * Instances of this class can be created using the fluent
 * {@link ATLQueryBuilder} API.
 * 
 * @see MogwaiQuery
 * @see ATLQueryBuilder
 * 
 * @author Gwendal DANIEL
 *
 */
public class ATLQuery extends MogwaiQuery {

	/**
	 * The internal {@link Resource} containing the ATL transformation to
	 * compute.
	 */
	private Resource atlResource;

	/**
	 * The source {@link EPackage} of the internal ATL transformation.
	 * <p>
	 * TODO: handle multiple source {@link EPackage}.
	 */
	private EPackage sourcePackage;

	/**
	 * The target {@link EPackage} of the internal ATL transformation.
	 * <p>
	 * TODO: handle multiple target {@link EPackage}.
	 */
	private EPackage targetPackage;

	/**
	 * Constructs a new {@link ATLQuery} from the given {@code atlResource}.
	 * <p>
	 * The provided {@link EPackage}s corresponds to the {@code source} and
	 * {@code target} packages used in the ATL transformation.
	 * <p>
	 * Instances of {@link ATLQuery} can be created using the fluent
	 * {@link ATLQueryBuilder} API.
	 * 
	 * @param atlResource
	 *            the {@link Resource} containing the ATL transformation to
	 *            compute
	 * @param sourcePackage
	 *            the source {@link EPackage} of the ATL transformation
	 * @param targetPackage
	 *            the target {@link EPackage} of the ATL transformation
	 * 
	 * @see ATLQueryBuilder
	 */
	public ATLQuery(Resource atlResource, EPackage sourcePackage, EPackage targetPackage) {
		super(atlResource);
		this.atlResource = atlResource;
		this.sourcePackage = sourcePackage;
		this.targetPackage = targetPackage;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInput() {
		return atlResource.toString();
	}

	/**
	 * Returns the {@link Resource} containing the ATL transformation to
	 * compute.
	 * 
	 * @return the {@link Resource} containing the ATL transformation to compute
	 */
	public Resource getATLResource() {
		return atlResource;
	}

	/**
	 * Returns the source {@link EPackage} of the ATL transformation to compute.
	 * 
	 * @return the source {@link EPackage} of the ATL transformation to compute
	 */
	public EPackage getSourcePackage() {
		return sourcePackage;
	}

	/**
	 * Returns the target {@link EPackage} of the ATL transformation to compute.
	 * 
	 * @return the target {@link EPackage} of the ATL transformation to compute
	 */
	public EPackage getTargetPackage() {
		return targetPackage;
	}
}
