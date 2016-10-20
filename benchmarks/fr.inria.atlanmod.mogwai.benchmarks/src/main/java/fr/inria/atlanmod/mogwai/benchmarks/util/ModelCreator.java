package fr.inria.atlanmod.mogwai.benchmarks.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.inria.atlanmod.neoemf.datastore.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.graph.blueprints.datastore.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.graph.blueprints.neo4j.resources.BlueprintsNeo4jResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.resources.BlueprintsResourceOptions;
import fr.inria.atlanmod.neoemf.graph.blueprints.util.NeoBlueprintsURI;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceFactory;
import fr.inria.atlanmod.neoemf.resources.PersistentResourceOptions.StoreOption;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceImpl;

public class ModelCreator {

	private static final int BUFFER_SIZE = 4096;
    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public static void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }
    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
    
    
    
    public static void createNeoEMFModel(File sourceFile, File targetFile) throws IOException {
    	PersistenceBackendFactoryRegistry.register(NeoBlueprintsURI.NEO_GRAPH_SCHEME, BlueprintsPersistenceBackendFactory.getInstance());
		
		URI sourceURI = URI.createFileURI(sourceFile.getAbsolutePath());
		URI targetURI = NeoBlueprintsURI.createNeoGraphURI(targetFile);

		ResourceSet resourceSet = new ResourceSetImpl();
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("zxmi", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(NeoBlueprintsURI.NEO_GRAPH_SCHEME, PersistentResourceFactory.eINSTANCE);
		
		Resource sourceResource = resourceSet.createResource(sourceURI);
		Map<String, Object> loadOpts = new HashMap<String, Object>();
		
		sourceResource.load(loadOpts);
		
		Resource targetResource = resourceSet.createResource(targetURI);
		
		Map<String, Object> saveOpts = new HashMap<String, Object>();
		
		saveOpts.put(BlueprintsResourceOptions.OPTIONS_BLUEPRINTS_GRAPH_TYPE, BlueprintsNeo4jResourceOptions.OPTIONS_BLUEPRINTS_TYPE_NEO4J);
		List<StoreOption> storeOptions = new ArrayList<StoreOption>();
		storeOptions.add(BlueprintsResourceOptions.EStoreGraphOption.AUTOCOMMIT);
		saveOpts.put(BlueprintsResourceOptions.STORE_OPTIONS, storeOptions);
		targetResource.save(saveOpts);

		targetResource.getContents().clear();
		targetResource.getContents().addAll(sourceResource.getContents());
		targetResource.save(saveOpts);
		
		if (targetResource instanceof PersistentResourceImpl) {
			PersistentResourceImpl.shutdownWithoutUnload((PersistentResourceImpl) targetResource); 
		} else {
			targetResource.unload();
		}
    }
	
}
