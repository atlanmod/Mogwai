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
package fr.inria.atlanmod.mogwai.benchmarks.ocl.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmt.modisco.java.neoemf.impl.JavaPackageImpl;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.inria.atlanmod.neoemf.datastore.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.graph.blueprints.resources.BlueprintsResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.util.NeoBlueprintsURI;
import fr.inria.atlanmod.neoemf.resources.PersistentResource;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceFactory;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceOptions;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceOptions.StoreOption;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceImpl;

@RunWith(Parameterized.class)
public class OclQueryTest {

    @Parameters
    public static Collection<String[]> resourceNames() {
        return Arrays.asList(new String[][] { 
                { "src/main/resources/jdt-core.graph" },
                { "src/main/resources/modisco.graph" } });
    }

    protected OCL ocl = null;
    protected OCLHelper oclHelper = null;
    protected EPackage.Registry registry = null;
    protected OCLExpression<EClassifier> expression = null;
    protected Query<EClassifier, EClass, EObject> query = null;
    protected String resourceName = null;
    protected ResourceSet rSet = null;
    protected Resource resource = null;

    private long initialUsedMemory = 0;
    private long finalUsedMemory = 0;
    private long beginTime = 0;
    private long endTime = 0;
    
    public OclQueryTest(String resourceName) {
        this.resourceName = resourceName;
    }

    @Before
    public void setUp() throws Exception {
        PersistenceBackendFactoryRegistry.getFactories().put(NeoBlueprintsURI.NEO_GRAPH_SCHEME,
                new BlueprintsPersistenceBackendFactory());
        this.registry = new EPackageRegistryImpl();
        this.registry.put(JavaPackage.eINSTANCE.getNsURI(), JavaPackage.eINSTANCE);
        this.ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
        this.oclHelper = ocl.createOCLHelper();
        this.rSet = new ResourceSetImpl();
        JavaPackageImpl.init();
        this.rSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
                .put(NeoBlueprintsURI.NEO_GRAPH_SCHEME, PersistentResourceFactory.eINSTANCE);
        System.out.println("Creating resource " + resourceName);
        this.resource = rSet.createResource(NeoBlueprintsURI.createNeoGraphURI(new File(
                resourceName)));
        Map<String, Object> loadOpts = new HashMap<String, Object>();

        List<StoreOption> storeOptions = new ArrayList<StoreOption>();
        storeOptions.add(BlueprintsResourceOptions.EStoreGraphOption.AUTOCOMMIT);
        loadOpts.put(PersistentResourceOptions.STORE_OPTIONS, storeOptions);
        loadOpts.put("blueprints.neo4j.conf.cache_type", "weak");
        this.resource.load(loadOpts);
        // helper.setContext(JavaPackage.eINSTANCE.getClassDeclaration());
        // helper.setContext(JavaPackage.eINSTANCE.getModel());
    }

    public void startTimer() {
        Runtime.getRuntime().gc();
        System.out.println("Starting query");
        initialUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Initial Memory Used : " + initialUsedMemory/(1024*1024) + " MB");
        beginTime = System.currentTimeMillis();
    }

    public void endTimer() {
        endTime = System.currentTimeMillis();
        System.out.println("Query evaluated in " + (endTime - beginTime) + "ms");
        Runtime.getRuntime().gc();
        finalUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Final Memory Used : " + finalUsedMemory/(1024*1024) + " MB");
        System.out.println("Memory increase : "
                + ((finalUsedMemory - initialUsedMemory) / (1024 * 1024)) + " MB");
    }

    @After
    public void tearDown() throws Exception {
        registry.clear();
        this.oclHelper = null;
        this.ocl = null;
        this.expression = null;
        this.query = null;
        if (this.resource != null && this.resource instanceof PersistentResource) {
            PersistentResourceImpl.shutdownWithoutUnload((PersistentResourceImpl) resource);
        } else {
            throw new RuntimeException("The resource is not a PersistentResource");
        }
        this.resource = null;
        this.rSet.getResourceFactoryRegistry().getProtocolToFactoryMap().clear();
        this.rSet = null;
        PersistenceBackendFactoryRegistry.getFactories().clear();
        Runtime.getRuntime().gc();
    }

}
