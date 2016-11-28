/*******************************************************************************
 * Copyright (c) 2013 Atlanmod INRIA LINA Mines Nantes
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Atlanmod INRIA LINA Mines Nantes - initial API and implementation
 *******************************************************************************/
package fr.inria.atlanmod.mogwai.resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;
import java.util.stream.Collectors;

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
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceImpl;

public class MogwaiResourceImpl extends PersistentResourceImpl implements MogwaiResource {

	private static final ThreadLocal<Mogwai> mogwai = 
		new ThreadLocal<Mogwai>() {
			
			@Override
			protected Mogwai initialValue() {
				return new Mogwai();
			}
		};
		
	private EcoreFactory eFactory = EcoreFactory.eINSTANCE;
	
    public MogwaiResourceImpl(URI uri) {
        super(uri);
        assert this.persistenceBackend instanceof BlueprintsPersistenceBackend;
    }

    public MogwaiQueryResult query(URI oclFileURI, Object obj) {
        Constraint exp = MogwaiUtil.parseOCL(oclFileURI,this);
        return this.query(exp,obj);
    }
    
    public MogwaiQueryResult query(Constraint exp, Object obj) {
        return mogwai.get().performQuery(exp, obj, this, (BlueprintsPersistenceBackend)persistenceBackend);
    }
    
    /**
     * Compute the result of an OCLExpression that is not attached to
     * a constraint. This typically happens when a textual query is
     * parsed using {@see OCLHelper#createQuery}.
     * @param exp the expression to compute
     * @param obj query parameters
     * @return a {@see MogwaiQueryResult}
     */
    public MogwaiQueryResult query(OCLExpression exp, Object obj) {
    	Constraint mockConstraint = eFactory.createConstraint();
    	ExpressionInOCL mockExp = eFactory.createExpressionInOCL();
    	mockConstraint.setSpecification(mockExp);
    	mockConstraint.setName(UUID.randomUUID().toString());
    	mockExp.setBodyExpression(exp);
    	return query(mockConstraint,obj);
    }
    
    public MogwaiQueryResult query(URI oclFileURI) {
        Constraint exp = MogwaiUtil.parseOCL(oclFileURI, this);
        return this.query(exp,null);
    }
    
    public MogwaiQueryResult query(Constraint exp) {
        return this.query(exp,null);
    }
    
    public MogwaiQueryResult query(OCLExpression exp) {
    	return this.query(exp,null);
    }
    
    @Override
	public MogwaiQueryResult gQuery(String gScript) {
		return mogwai.get().gPerformQuery(gScript, this, (BlueprintsPersistenceBackend)persistenceBackend);
	}
	
	@Override
	public MogwaiQueryResult gQuery(String gScript, Object context) {
		return mogwai.get().gPerformQuery(gScript, context, this, (BlueprintsPersistenceBackend)persistenceBackend);
	}
	
	@Override
	public MogwaiQueryResult gQuery(URI gremlinFileURI) throws MogwaiException {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(gremlinFileURI.toFileString()));
		} catch (FileNotFoundException e) {
			throw new MogwaiException(e.getMessage());
		}
		MogwaiQueryResult result =  this.gQuery(br.lines().collect(Collectors.joining("\n")));
		try {
			br.close();
		} catch (IOException e) {
			throw new MogwaiException(e.getMessage());
		}
		return result;
	}
	
	@Override
	public MogwaiQueryResult gQuery(URI gremlinFileURI, Object context) throws MogwaiException {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(gremlinFileURI.toFileString()));
		} catch (FileNotFoundException e) {
			throw new MogwaiException(e.getMessage());
		}
		MogwaiQueryResult result =  this.gQuery(br.lines().collect(Collectors.joining("\n")), context);
		try {
			br.close();
		} catch (IOException e) {
			throw new MogwaiException(e.getMessage());
		}
		return result;
	}

    @Override
    public void enableATLDebug() {
    	mogwai.get().enableATLDebug();
    }
    
    @Override
    public void disableATLDebug() {
    	mogwai.get().disableATLDebug();
    }
    
}
