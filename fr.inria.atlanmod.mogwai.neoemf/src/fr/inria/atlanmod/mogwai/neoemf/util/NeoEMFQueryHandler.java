package fr.inria.atlanmod.mogwai.neoemf.util;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.expressions.OCLExpression;

import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.datastore.blueprints.NeoEMFGraphDatastore;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFATLQueryProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFGremlinQueryProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFOCLQueryProcessor;
import fr.inria.atlanmod.mogwai.neoemf.processor.NeoEMFQueryProcessor;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFQueryResult;
import fr.inria.atlanmod.mogwai.neoemf.query.NeoEMFValidationResult;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.processor.AbstractQueryProcessor;
import fr.inria.atlanmod.mogwai.query.ATLQuery;
import fr.inria.atlanmod.mogwai.query.GremlinQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.OCLQuery;
import fr.inria.atlanmod.mogwai.query.QueryException;
import fr.inria.atlanmod.mogwai.query.builder.OCLQueryBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackend;

/**
 * The query handler used in Mogwai resources to compute {@link MogwaiQuery} on
 * top of NeoEMF resources.
 * <p>
 * This class provides a simple API that accepts {@link MogwaiQuery} instances
 * and delegate their computation to the appropriated
 * {@link NeoEMFQueryProcessor}.
 * <p>
 * {@link MogwaiQuery} execution options are filled with default values
 * optimized for the model mapping used in NeoEMF graph.
 * <p>
 * This class is thread-safe and avoids query execution concurrency issues by
 * allowing only one computation per processor at a time.
 * 
 * @author Gwendal DANIEL
 *
 */
public class NeoEMFQueryHandler {

	/**
	 * Returns the singleton instance of this class.
	 * 
	 * @return the singleton instance of this class
	 */
	public static NeoEMFQueryHandler getInstance() {
		return Holder.INSTANCE;
	}

	/**
	 * The synchronized instance of {@link NeoEMFGremlinQueryProcessor} used to
	 * compute {@link GremlinQuery}.
	 */
	private static final ThreadLocal<NeoEMFGremlinQueryProcessor> gremlinProcessor = new ThreadLocal<NeoEMFGremlinQueryProcessor>() {

		/**
		 * Constructs the {@link NeoEMFGremlinQueryProcessor} used to compute
		 * {@link GremlinQuery}.
		 * 
		 * @return the {@link NeoEMFGremlinQueryProcessor} used to compute
		 *         {@link GremlinQuery}
		 */
		@Override
		protected NeoEMFGremlinQueryProcessor initialValue() {
			return new NeoEMFGremlinQueryProcessor();
		}
	};

	/**
	 * The synchronized instance of {@link NeoEMFOCLQueryProcessor} used to
	 * compute {@link OCLQuery}.
	 */
	private static final ThreadLocal<NeoEMFOCLQueryProcessor> oclProcessor = new ThreadLocal<NeoEMFOCLQueryProcessor>() {

		/**
		 * Constructs the {@link NeoEMFOCLQueryProcessor} used to compute
		 * {@link OCLQuery}.
		 * 
		 * @return the {@link NeoEMFOCLQueryProcessor} used to compute
		 *         {@link OCLQuery}
		 */
		@Override
		protected NeoEMFOCLQueryProcessor initialValue() {
			return new NeoEMFOCLQueryProcessor();
		}
	};

	/**
	 * The synchronized instance of {@link NeoEMFATLQueryProcessor} used to
	 * compute {@link ATLQuery}.
	 */
	private static final ThreadLocal<NeoEMFATLQueryProcessor> atlProcessor = new ThreadLocal<NeoEMFATLQueryProcessor>() {

		/**
		 * Constructs the {@link NeoEMFATLQueryProcessor} used to compute
		 * {@link ATLQuery}.
		 * 
		 * @return the {@link NeoEMFATLQueryProcessor} used to compute
		 *         {@link ATLQuery}
		 */
		@Override
		protected NeoEMFATLQueryProcessor initialValue() {
			return new NeoEMFATLQueryProcessor();
		};
	};

	/**
	 * Computes the provided {@code query} with the given {@code arguments} on
	 * {@code datastore}.
	 * <p>
	 * TODO handle OCL query arguments (self, free variables).
	 * 
	 * @param query
	 *            the {@link MogwaiQuery} to compute
	 * @param arguments
	 *            the optional arguments of the {@link MogwaiQuery} to compute
	 * @param datastore
	 *            the {@link BlueprintsPersistenceBackend} to compute the
	 *            {@code query} on
	 * @param options
	 *            the {@link Map} containing {@code query} execution options
	 * @return a {@link NeoEMFQueryResult} wrapping the output of the executed
	 *         {@code query} and allowing {@link EObject}s reification
	 * @throws QueryException
	 *             if the handler cannot find a processor for the provided
	 *             {@code query}
	 * 
	 * @see NeoEMFGremlinQueryProcessor
	 * @see NeoEMFOCLQueryProcessor
	 */
	@SuppressWarnings("unchecked")
	public NeoEMFQueryResult query(MogwaiQuery query, Object arguments, BlueprintsPersistenceBackend datastore,
			Map<String, Object> options) throws QueryException {
		Map<String, Object> theOptions = options;
		if (isNull(theOptions)) {
			theOptions = new HashMap<>();
		}
		ModelDatastore<?, ?, ?, ?> modelDatastore = getModelDatastore(theOptions, datastore);
		if(nonNull(arguments)) {
			/*
			 * Add the provided argument in the query bindings
			 */
			Map<String, Object> bindings = (Map<String, Object>) theOptions.get(AbstractQueryProcessor.BINDINGS_KEY);
			if(isNull(bindings)) {
				bindings = new HashMap<>();
			}
			bindings.put("self", arguments);
			theOptions.put(AbstractQueryProcessor.BINDINGS_KEY, bindings);
		}
		if (oclProcessor.get().accept(query)) {
			oclProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) query.process(oclProcessor.get(), modelDatastore, theOptions);
		} else if (gremlinProcessor.get().accept(query)) {
			gremlinProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) query.process(gremlinProcessor.get(), modelDatastore, theOptions);
		}
		throw new QueryException("Cannot find a processor for " + query);
	}

	/**
	 * Computes the provided model {@code transformation} on {@code datastore}.
	 * 
	 * @param transformation
	 *            the {@link MogwaiQuery} representing the transformation to
	 *            compute
	 * @param datastore
	 *            the {@link BlueprintsPersistenceBackend} to compute the
	 *            {@code transformation} on
	 * @param options
	 *            a {@link Map} containing {@code transformation} execution
	 *            options
	 * @return a {@link NeoEMFQueryResult} wrapping the output of the executed
	 *         {@code transformation} and allowing {@link EObject}s reification
	 * @throws QueryException
	 *             if the handler cannot find a processor for the provided
	 *             {@code transformation}
	 * 
	 * @see NeoEMFATLQueryProcessor
	 */
	public NeoEMFQueryResult transform(MogwaiQuery transformation, BlueprintsPersistenceBackend datastore,
			Map<String, Object> options) throws QueryException {
		Map<String, Object> theOptions = options;
		if (isNull(theOptions)) {
			theOptions = new HashMap<>();
		}
		ModelDatastore<?, ?, ?, ?> modelDatastore = getModelDatastore(theOptions, datastore);
		if (atlProcessor.get().accept(transformation)) {
			atlProcessor.get().setBackend(datastore);
			return (NeoEMFQueryResult) transformation.process(atlProcessor.get(), modelDatastore, theOptions);
		}
		throw new QueryException("Cannot find a processor for " + transformation);
	}
	
	public NeoEMFValidationResult validate(MogwaiQuery constraintQuery, BlueprintsPersistenceBackend datastore, Map<String, Object> options) throws QueryException {
		if(constraintQuery instanceof OCLQuery) {
			OCLQuery oclQuery = (OCLQuery) constraintQuery;
			Constraint translatedConstraint = translateValidationConstraint(oclQuery.getConstraint());
			MogwaiQuery translatedQuery = OCLQueryBuilder.newBuilder().fromConstraint(translatedConstraint).build();
			NeoEMFQueryResult result = this.query(translatedQuery, null, datastore, options);
			return new NeoEMFValidationResult(result);
		} else {
			throw new QueryException("Cannot validate a model with the provided query " + constraintQuery.getClass().getSimpleName());
		}
	}
	
	private Constraint translateValidationConstraint(Constraint c) {
		MogwaiLogger.info("Translating input constraint into global query");
		EClass constraintedEClass = (EClass) c.getConstrainedElements().get(0);
        
        OCLStandardLibraryImpl stdPackage = OCLStandardLibraryImpl.INSTANCE;
        EPackage oclEPackage = stdPackage.stdlibPackage;
        
        TypeExp typeExp = EcoreFactory.eINSTANCE.createTypeExp();
        typeExp.setReferredType(constraintedEClass);
        
        EClass oclTypeClass = (EClass)oclEPackage.getEClassifier("OclType_Class");
        EOperation allInstancesOperation = null;
        for(EOperation eOperation : oclTypeClass.getEOperations()) {
        	if(eOperation.getName().equals("allInstances")) {
        		allInstancesOperation = eOperation;
        	}
        }
        
        EClass booleanClass = (EClass)oclEPackage.getEClassifier("Boolean_Class");
        EOperation notOperation = null;
        for(EOperation eOperation : booleanClass.getEOperations()) {
        	if(eOperation.getName().equals("not")) {
        		notOperation = eOperation;
        	}
        }
        
        OperationCallExp allInstancesOperationCallExp = EcoreFactory.eINSTANCE.createOperationCallExp();
        allInstancesOperationCallExp.setReferredOperation(allInstancesOperation);
        allInstancesOperationCallExp.setSource(typeExp);
        
        IteratorExp selectExp = EcoreFactory.eINSTANCE.createIteratorExp();
        selectExp.setName("select");
        selectExp.setSource(allInstancesOperationCallExp);
        
        Variable selectVariable = EcoreFactory.eINSTANCE.createVariable();
        selectVariable.setName("mogwaiVar");
        selectExp.getIterator().add(selectVariable);
        
        OperationCallExp notOperationCallExp = EcoreFactory.eINSTANCE.createOperationCallExp();
        notOperationCallExp.setReferredOperation(notOperation);
        selectExp.setBody(notOperationCallExp);
        
        Iterator<EObject> it = c.getSpecification().eAllContents();
        while(it.hasNext()) {
        	EObject eObject = it.next();
        	if(eObject instanceof VariableExp) {
        		VariableExp vExp = (VariableExp)eObject;
        		if(vExp.getName().equals("self")) {
        			vExp.setName("mogwaiVar");
        			vExp.setReferredVariable(selectVariable);
        		}
        	}
        }
        
        OCLExpression mainBody = c.getSpecification().getBodyExpression();
        notOperationCallExp.setSource(mainBody);
        
        c.getSpecification().setBodyExpression(selectExp);
        return c;
	}

	/**
	 * Gets the {@link ModelDatastore} instance defined in the provided
	 * {@code options}.
	 * <p>
	 * If {@code options} doesn't define a {@link ModelDatastore} a default
	 * value is retrieved using
	 * {@link #getDefaultModelDatastore(Map, BlueprintsPersistenceBackend)}.
	 * 
	 * @param options
	 *            the {@link Map} containing query execution options
	 * @param datastore
	 *            the {@link BlueprintsPersistenceBackend} used to access the
	 *            underlying graph
	 * @return the value of the {@link ModelDatastore} option if it exists, the
	 *         default {@link ModelDatastore} otherwise
	 * 
	 * @see MogwaiResource#NEOEMF_MODEL_DATASTORE
	 * @see #getDefaultModelDatastore(Map, BlueprintsPersistenceBackend)
	 */
	private ModelDatastore<?, ?, ?, ?> getModelDatastore(Map<String, Object> options,
			BlueprintsPersistenceBackend datastore) {
		ModelDatastore<?, ?, ?, ?> modelDatastore = getDefaultModelDatastore(datastore);
		if (options.containsKey(MogwaiResource.NEOEMF_MODEL_DATASTORE)) {
			modelDatastore = (ModelDatastore<?, ?, ?, ?>) options.get(MogwaiResource.NEOEMF_MODEL_DATASTORE);
			checkArgument(modelDatastore instanceof NeoEMFGraphDatastore,
					"Cannot transform a resource, expected a {0} instance, found {1}",
					NeoEMFGraphDatastore.class.getName(), modelDatastore.getClass().getName());
		}
		return modelDatastore;
	}

	/**
	 * Returns the default {@link ModelDatastore} instance to use if
	 * {@code options} doesn't contain any datastore.
	 * 
	 * @param datastore
	 *            the {@link BlueprintsPersistenceBackend} used to access the
	 *            underlying graph
	 * @return the default {@link ModelDatastore} implementation to use to
	 *         access the provided {@code datastore}
	 * 
	 * @see #getModelDatastore(Map, BlueprintsPersistenceBackend)
	 */
	private ModelDatastore<?, ?, ?, ?> getDefaultModelDatastore(BlueprintsPersistenceBackend datastore) {
		return new NeoEMFGraphDatastore(datastore.getGraph());
	}

	/**
	 * A lazy holder maintaining a singleton instance of
	 * {@link NeoEMFQueryHandler}.
	 */
	private static class Holder {

		/**
		 * The singleton instance of {@link NeoEMFQueryHandler}.
		 */
		private static final NeoEMFQueryHandler INSTANCE = new NeoEMFQueryHandler();

	}

}
