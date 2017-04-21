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

import fr.inria.atlanmod.mogwai.query.ATLQuery;
import fr.inria.atlanmod.mogwai.query.QueryException;

public class ATLQueryBuilder extends AbstractMogwaiQueryBuilder<ATLQueryBuilder> {

	private ResourceSet rSet;
	private EPackage sourcePackage;
	private EPackage targetPackage;

	protected ATLQueryBuilder() {
		rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
	}

	public static ATLQueryBuilder newBuilder() {
		return new ATLQueryBuilder();
	}

	public ATLQueryBuilder sourcePackage(EPackage ePackage) {
		checkNotNull(ePackage, "null ePackage");
		this.sourcePackage = ePackage;
		return me();
	}
	
	public ATLQueryBuilder targetPackage(EPackage ePackage) {
		checkNotNull(ePackage, "null package");
		this.targetPackage = ePackage;
		return me();
	}

	@Override
	protected boolean validate() {
		if (isNull(input)) {
			throw new QueryException("No transformation provided");
		} else {
			return true;
		}
	}

	@Override
	protected ATLQuery buildQuery() {
		Resource atlResource;
		if(input instanceof URI) {
			atlResource = rSet.getResource((URI) input, true);
		}
		else if(input instanceof File) {
			atlResource = rSet.getResource(URI.createURI(((File)input).getAbsolutePath()), true);
		}
		else if(input instanceof String) {
			atlResource = rSet.getResource(URI.createURI((String) input), true);
		}
		else {
			throw new QueryException("Cannot find the ATL resource at " + input);
		}
		return new ATLQuery(atlResource, sourcePackage, targetPackage);
	}

}
