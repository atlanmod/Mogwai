package fr.inria.atlanmod.mogwai.transformation.atl.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.neo4j.kernel.impl.util.FileUtils;

import static java.util.Objects.isNull;
import ClassDiagram.Attribute;
import ClassDiagram.ClassDiagramFactory;
import ClassDiagram.ClassDiagramPackage;
import ClassDiagram.DataType;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResource;
import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResourceFactory;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.neo4j.option.BlueprintsNeo4jOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class ModelUtil {

	public static ModelUtil getInstance() {
		return Holder.INSTANCE;
	}

	public MogwaiResource createSampleModel() throws IOException {

		FileUtils.deleteRecursively(new File("materials/ClassDiagram2Relational/ClassDiagram/sample.graphdb"));

		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());

		ResourceSet rSet = new ResourceSetImpl();

		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
				.put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());

		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());

		EPackage.Registry.INSTANCE.put(ClassDiagramPackage.eINSTANCE.getNsURI(), ClassDiagramPackage.eINSTANCE);

		Resource classModel = rSet.getResource(
				URI.createURI("materials/ClassDiagram2Relational/ClassDiagram/Sample-ClassDiagram.xmi"), true);

		Resource neoResource = rSet.createResource(BlueprintsURI.createFileURI(new File(
				"materials/ClassDiagram2Relational/ClassDiagram/sample.graphdb")));

		Map<String, Object> options = BlueprintsNeo4jOptionsBuilder.newBuilder().asMap();

		// Creating new resource
		neoResource.save(options);

		neoResource.getContents().addAll(EcoreUtil.copyAll(classModel.getContents()));

		neoResource.save(Collections.emptyMap());

		MogwaiResource mogResource = MogwaiResourceFactory.getInstance().decoratePersistentResource(
				(PersistentResource) neoResource);

		return mogResource;
	}

	public MogwaiResource getResource(String path) throws IOException {
		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
				.put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());

		EPackage.Registry.INSTANCE.put(ClassDiagramPackage.eINSTANCE.getNsURI(), ClassDiagramPackage.eINSTANCE);

		Resource neoResource = rSet.createResource(BlueprintsURI.createFileURI(new File(path)));
		neoResource.load(BlueprintsNeo4jOptionsBuilder.newBuilder().autocommit(1000).asMap());
		MogwaiResource mogResource = MogwaiResourceFactory.getInstance().decoratePersistentResource(
				(PersistentResource) neoResource);
		
		return mogResource;
	}

	private static String DEFAULT_LARGE_MODEL_PATH = "materials/ClassDiagram2Relational/ClassDiagram/large.graphdb";

	public MogwaiResource createLargeSampleModel() throws IOException {
		return this.createLargeSampleModel(null);
	}

	public MogwaiResource createLargeSampleModel(String modelPath) throws IOException {

		String path = isNull(modelPath) ? DEFAULT_LARGE_MODEL_PATH : modelPath;

		FileUtils.deleteRecursively(new File(path));

		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME,
				BlueprintsPersistenceBackendFactory.getInstance());

		int classCount = 10;
		int attributePerClass = 4;

		ResourceSet rSet = new ResourceSetImpl();

		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap()
				.put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());

		EPackage.Registry.INSTANCE.put(ClassDiagramPackage.eINSTANCE.getNsURI(), ClassDiagramPackage.eINSTANCE);

		Resource neoResource = rSet.createResource(BlueprintsURI.createFileURI(new File(path)));

		Map<String, Object> options = BlueprintsNeo4jOptionsBuilder.newBuilder().autocommit(1000).asMap();

		// Monitoring
		int multivaluedCount = 0;
		int singleValuedCount = 0;
		
		// Creating new resource
		neoResource.save(options);

		DataType dt = ClassDiagramFactory.eINSTANCE.createDataType();
		dt.setName("Integer");

		DataType dt2 = ClassDiagramFactory.eINSTANCE.createDataType();
		dt2.setName("String");

		neoResource.getContents().add(dt);
		neoResource.getContents().add(dt2);

		List<ClassDiagram.Class> classes = new ArrayList<>();
		for (int i = 0; i < classCount; i++) {
			ClassDiagram.Class c = ClassDiagramFactory.eINSTANCE.createClass();
			c.setName(UUID.randomUUID().toString());
			classes.add(c);
		}

		for (int i = 0; i < classCount; i++) {
			ClassDiagram.Class c = classes.get(i);
			for (int j = 0; j < attributePerClass; j++) {
				Attribute att = ClassDiagramFactory.eINSTANCE.createAttribute();
				att.setName(UUID.randomUUID().toString());
				if (Math.random() > 0.5) {
					att.setMultiValued(true);
					multivaluedCount++;
				} else {
					att.setMultiValued(false);
					singleValuedCount++;
				}
				if (Math.random() > 0.5) {
					// set datatype attribute
					if (Math.random() > 0.5) {
						att.setType(dt);
					} else {
						att.setType(dt2);
					}
				} else {
					// set class attribute
					int idx = (int) Math.random() * classCount;
					att.setType(classes.get(idx));
				}
				c.getAttr().add(att);
			}
			neoResource.getContents().add(c);
		}

		neoResource.save(options);

		PersistentResource pr = (PersistentResource) neoResource;
		System.out.println("Class count: " + pr.getAllInstances(ClassDiagramPackage.eINSTANCE.getClass_()).size());
		System.out.println("Attribute count: "
				+ pr.getAllInstances(ClassDiagramPackage.eINSTANCE.getAttribute()).size());
		System.out.println("\tmultivalued: " + multivaluedCount);
		System.out.println("\tsinglevalued: " + singleValuedCount);
		System.out.println("DataType count: " + pr.getAllInstances(ClassDiagramPackage.eINSTANCE.getDataType()).size());

		MogwaiResource mogResource = MogwaiResourceFactory.getInstance().decoratePersistentResource(
				(PersistentResource) neoResource);

		return mogResource;
	}

	private static class Holder {

		public static final ModelUtil INSTANCE = new ModelUtil();
	}

}
