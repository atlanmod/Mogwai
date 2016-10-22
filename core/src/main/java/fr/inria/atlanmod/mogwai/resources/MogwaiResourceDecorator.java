package fr.inria.atlanmod.mogwai.resources;

import java.lang.reflect.Field;
import java.util.UUID;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.OCLExpression;

import fr.inria.atlanmod.mogwai.core.Mogwai;
import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.core.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackend;
import fr.inria.atlanmod.neoemf.resources.PersistentResource;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceDecorator;

public class MogwaiResourceDecorator extends PersistentResourceDecorator implements MogwaiResource {

	private static final ThreadLocal<Mogwai> mogwai = 
		new ThreadLocal<Mogwai>() {
			
			@Override
			protected Mogwai initialValue() {
				return new Mogwai();
			}
		};
	private EcoreFactory eFactory = EcoreFactory.eINSTANCE;
	
	protected BlueprintsPersistenceBackend persistenceBackend;
	
	public MogwaiResourceDecorator(PersistentResource resource) throws MogwaiException {
		super(resource);
		if(resource == null) {
			throw new MogwaiException("Cannot construct a MogwaiResourceDecorator on a "
					+ "null PersistentResource");
		}
		if(!MogwaiUtil.isMogwaiCompatible(resource)) {
			throw new MogwaiException("Cannot construct a MogwaiResourceDecorator: resource " 
					+ resource.toString() + " is not compatible with Mogwaï");
		}
		// Retrieve the PersistenceBackend defined in the base resource
		Field persistenceBackendField;
		try {
			persistenceBackendField = resource.getClass().getDeclaredField("persistenceBackend");
			persistenceBackendField.setAccessible(true);
			persistenceBackend = (BlueprintsPersistenceBackend) persistenceBackendField.get(base);
		} catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
			throw new MogwaiException(e.getMessage());
		}
	}

	@Override
	public MogwaiQueryResult query(URI oclFileURI, Object obj) {
		Constraint exp = MogwaiUtil.parseOCL(oclFileURI, this);
		return this.query(exp,obj);
	}

	@Override
	public MogwaiQueryResult query(Constraint exp, Object obj) {
		return mogwai.get().performQuery(exp, obj, this, persistenceBackend);
	}

	@Override
	public MogwaiQueryResult query(OCLExpression exp, Object obj) {
		Constraint mockConstraint = eFactory.createConstraint();
		ExpressionInOCL mockExp = eFactory.createExpressionInOCL();
		mockConstraint.setSpecification(mockExp);
		mockConstraint.setName(UUID.randomUUID().toString());
		mockExp.setBodyExpression(exp);
		return query(mockConstraint,obj);
	}

	@Override
	public MogwaiQueryResult query(URI oclFileURI) {
		Constraint exp = MogwaiUtil.parseOCL(oclFileURI, this);
		return this.query(exp,null);
	}

	@Override
	public MogwaiQueryResult query(Constraint exp) {
		return this.query(exp, null);
	}

	@Override
	public MogwaiQueryResult query(OCLExpression exp) {
		return this.query(exp, null);
	}
	
}
