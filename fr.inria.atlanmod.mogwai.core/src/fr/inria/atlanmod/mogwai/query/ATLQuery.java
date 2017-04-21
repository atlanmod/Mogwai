package fr.inria.atlanmod.mogwai.query;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

public class ATLQuery extends MogwaiQuery {

	private Resource atlResource;
	private EPackage sourcePackage;
	private EPackage targetPackage;

	public ATLQuery(Resource atlResource, EPackage sourcePackage, EPackage targetPackage) {
		super(atlResource);
		this.atlResource = atlResource;
		this.sourcePackage = sourcePackage;
		this.targetPackage = targetPackage;
	}

	@Override
	public String getInput() {
		return atlResource.toString();
	}

	public Resource getATLResource() {
		return atlResource;
	}

	public EPackage getSourcePackage() {
		return sourcePackage;
	}

	public EPackage getTargetPackage() {
		return targetPackage;
	}
}
