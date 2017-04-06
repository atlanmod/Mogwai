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
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

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
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;
import fr.inria.atlanmod.neoemf.util.logging.NeoLogger;

@RunWith(Parameterized.class)
public class AbstractQueryTest {
    
	private static String[][] parameters = new String[][]{
//		{"resources/jdt-core.graph"}//,
		{"resources/modisco.graph"}
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
				ModelCreator.unzip("resources/resources.zip", "resources/xmi");
				System.out.println("Creating modisco.graph");
				ModelCreator.createNeoEMFModel(
						new File("resources/xmi/resources/org.eclipse.gmt.modisco.java.kyanos.xmi"), 
						new File("resources/modisco.graph"));
				System.out.println("Creating jdt-core.graph");
				/*ModelCreator.createNeoEMFModel(
						new File("resources/xmi/resources/org.eclipse.jdt.core.xmi"), 
						new File("resources/jdt-core.graph"));
				System.out.println("Cleaning temp files");*/
				File xmiFolder = new File("resources/xmi/resources");
				File[] xmiContents = xmiFolder.listFiles();
				for(int i = 0; i < xmiContents.length; i++) {
					xmiContents[i].delete();
				}
				xmiFolder.delete();
				File xmiRoot = new File("resources/xmi/");
				xmiRoot.delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
    
    @Before
    public void setUp() throws Exception {
        PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
                BlueprintsPersistenceBackendFactory.getInstance());
        this.registry = new EPackageRegistryImpl();
        this.registry.put(JavaPackage.eINSTANCE.getNsURI(), JavaPackage.eINSTANCE);
        this.rSet = new ResourceSetImpl();
        JavaPackageImpl.init();
        this.rSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
                .put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());
        NeoLogger.info("Creating resource {0}", resourceName);
        this.resource = rSet.createResource(BlueprintsURI.createFileURI(new File(
                resourceName)));
        
		Map<String, Object> loadOpts = BlueprintsNeo4jOptionsBuilder
				.newBuilder().autocommit().weakCache().asMap();
        
        this.resource.load(loadOpts);
    }
    
    protected void startTimer() {
    	for(int i = 0; i < 5; i++) {
    		Runtime.getRuntime().gc();
    	}
        NeoLogger.info("Starting query");
        initialUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        NeoLogger.info("Initial Memory Used : {0} MB", initialUsedMemory/(1024*1024));
        beginTime = System.currentTimeMillis();
    }

    protected void endTimer() {
        endTime = System.currentTimeMillis();
        NeoLogger.info("Query evaluated in {0}ms", (endTime - beginTime));
        for(int i = 0; i < 5; i++) {
    		Runtime.getRuntime().gc();
    	}
        finalUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        NeoLogger.info("Final Memory Used : {0} MB", finalUsedMemory/(1024*1024));
        NeoLogger.info("Memory increase : {0} MB", ((finalUsedMemory - initialUsedMemory) / (1024 * 1024)));
    }

    @After
    public void tearDown() throws Exception {
        registry.clear();
        if (this.resource != null && this.resource instanceof PersistentResource) {
        	((PersistentResource)resource).close();
        } else {
            throw new RuntimeException("The resource is not a PersistentResource");
        }
        this.resource = null;
        this.rSet.getResourceFactoryRegistry().getProtocolToFactoryMap().clear();
        this.rSet = null;
        PersistenceBackendFactoryRegistry.unregisterAll();
        Runtime.getRuntime().gc();
    }

}
