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
package fr.inria.atlanmod.mogwai.benchmarks.mogwai.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmt.modisco.java.neoemf.impl.JavaPackageImpl;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.eclipse.ocl.ecore.Constraint;
import org.junit.After;
import org.junit.Before;

import fr.inria.atlanmod.mogwai.benchmarks.AbstractQueryTest;
import fr.inria.atlanmod.mogwai.resources.MogwaiResourceFactory;
import fr.inria.atlanmod.mogwai.util.MogwaiURI;
import fr.inria.atlanmod.neoemf.datastore.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.graph.blueprints.resources.BlueprintsResourceOptions;
import fr.inria.atlanmod.neoemf.resources.PersistentResource;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceOptions;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceOptions.StoreOption;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceImpl;

public class MogwaiQueryTest extends AbstractQueryTest{

	protected Constraint oclConstraint = null;
	
    public MogwaiQueryTest(String resourceName) {
        super(resourceName);
    }

    @Before
    public void setUp() throws Exception {
        PersistenceBackendFactoryRegistry.register(MogwaiURI.MOGWAI_SCHEME, BlueprintsPersistenceBackendFactory.getInstance());
        this.registry = new EPackageRegistryImpl();
        this.registry.put(JavaPackage.eINSTANCE.getNsURI(),JavaPackage.eINSTANCE);
        this.rSet = new ResourceSetImpl();
        JavaPackageImpl.init();
        this.rSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(MogwaiURI.MOGWAI_SCHEME, MogwaiResourceFactory.eINSTANCE);
        System.out.println("Creating Mogwai resource " + resourceName);
        this.resource = rSet.createResource(MogwaiURI.createMogwaiURI(new File(resourceName)));
        Map<String,Object> loadOpts = new HashMap<String,Object>();
        List<StoreOption> storeOptions = new ArrayList<StoreOption>();
        storeOptions.add(BlueprintsResourceOptions.EStoreGraphOption.AUTOCOMMIT);
        loadOpts.put(PersistentResourceOptions.STORE_OPTIONS, storeOptions);
        loadOpts.put("blueprints.neo4j.conf.cache_type","weak");
        this.resource.load(loadOpts);
    }

    @After
    public void tearDown() throws Exception {
        registry.clear();
        if(this.resource != null && this.resource instanceof PersistentResource) {
            PersistentResourceImpl.shutdownWithoutUnload((PersistentResourceImpl)resource);
        }
        else {
            throw new RuntimeException("The resource is not a PersistentResource");
        }
        this.resource = null;
        this.rSet.getResourceFactoryRegistry().getProtocolToFactoryMap().clear();
        this.rSet = null;
        PersistenceBackendFactoryRegistry.getFactories().clear();
        Runtime.getRuntime().gc();
    }

}
