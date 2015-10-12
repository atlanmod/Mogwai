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
package fr.inria.atlanmod.mogwai.benchmarks;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmt.modisco.java.neoemf.impl.JavaPackageImpl;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.inria.atlanmod.mogwai.benchmarks.util.ModelCreator;
import fr.inria.atlanmod.neoemf.datastore.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.graph.blueprints.neo4j.resources.BlueprintsNeo4jResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.resources.BlueprintsResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.util.NeoBlueprintsURI;
import fr.inria.atlanmod.neoemf.resources.PersistentResource;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceFactory;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceOptions;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceOptions.StoreOption;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceImpl;

@RunWith(Parameterized.class)
public class AbstractQueryTest {
    
	private static String[][] parameters = new String[][]{
		{"src/main/resources/jdt-core.graph"}//,
//		{"src/main/resources/modisco.graph"}
		};
	
    @Parameters
    public static Collection<String[]> resourceNames() {
        return Arrays.asList(parameters);
    }
    
    protected EPackage.Registry registry = null;
    protected String resourceName = null;
    protected ResourceSet rSet = null;
    protected Resource resource = null;

    private long initialUsedMemory = 0;
    private long finalUsedMemory = 0;
    private long beginTime = 0;
    private long endTime = 0;
    
    public AbstractQueryTest(String resourceName) {
        this.resourceName = resourceName;
    }
    
    public void checkModels() {
    	System.out.println("Checking databases");
    	File modelFile = new File(parameters[0][0]);
    	System.out.println(modelFile.getAbsolutePath());
    }
    
    @BeforeClass
    public static void setUpBeforeClass() {
    	System.out.println("Checking databases");
    	File modelFile = new File(parameters[0][0]);
    	if(!modelFile.exists()) {
    		System.out.println("Databases can not be found, creating them");
    		JavaPackageImpl.init();
    		try {
    			System.out.println("Unzipping XMI models");
				ModelCreator.unzip("src/main/resources.zip", "src/main/xmi");
				System.out.println("Creating modisco.graph");
				ModelCreator.createNeoEMFModel(
						new File("src/main/xmi/resources/org.eclipse.gmt.modisco.java.kyanos.xmi"), 
						new File("src/main/resources/modisco.graph"));
				System.out.println("Creating jdt-core.graph");
				ModelCreator.createNeoEMFModel(
						new File("src/main/xmi/resources/org.eclipse.jdt.core.xmi"), 
						new File("src/main/resources/jdt-core.graph"));
				System.out.println("Cleaning temp files");
				File xmiFolder = new File("src/main/xmi/resources");
				File[] xmiContents = xmiFolder.listFiles();
				for(int i = 0; i < xmiContents.length; i++) {
					xmiContents[i].delete();
				}
				xmiFolder.delete();
				File xmiRoot = new File("src/main.xmi/");
				xmiRoot.delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
    
    @Before
    public void setUp() throws Exception {
        PersistenceBackendFactoryRegistry.getFactories().put(NeoBlueprintsURI.NEO_GRAPH_SCHEME,
                new BlueprintsPersistenceBackendFactory());
        this.registry = new EPackageRegistryImpl();
        this.registry.put(JavaPackage.eINSTANCE.getNsURI(), JavaPackage.eINSTANCE);
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
        loadOpts.put(BlueprintsNeo4jResourceOptions.OPTIONS_BLUEPRINTS_NEO4J_CACHE_TYPE, BlueprintsNeo4jResourceOptions.CACHE_TYPE.WEAK.toString());
//        loadOpts.put(BlueprintsNeo4jResourceOptions.OPTIONS_BLUEPRINTS_NEO4J_USE_MEMORY_MAPPED_BUFFERS, BlueprintsNeo4jResourceOptions.USE_MEMORY_MAPPED_BUFFER.FALSE.toString());
//        loadOpts.put("blueprints.neo4j.conf.cache_type", "weak");
        this.resource.load(loadOpts);
    }
    
    protected void startTimer() {
        Runtime.getRuntime().gc();
        System.out.println("Starting query");
        initialUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Initial Memory Used : " + initialUsedMemory/(1024*1024) + " MB");
        beginTime = System.currentTimeMillis();
    }

    protected void endTimer() {
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
        if (this.resource != null && this.resource instanceof PersistentResource) {
            PersistentResourceImpl.shutdownWithoutUnload((PersistentResourceImpl) resource);
        } else {
            throw new RuntimeException("The resource is not a PersistentResource");
        }
        this.resource = null;
        this.rSet.getResourceFactoryRegistry().getProtocolToFactoryMap().clear();
        this.rSet = null;
        PersistenceBackendFactoryRegistry.getFactories().clear();
    }

}
