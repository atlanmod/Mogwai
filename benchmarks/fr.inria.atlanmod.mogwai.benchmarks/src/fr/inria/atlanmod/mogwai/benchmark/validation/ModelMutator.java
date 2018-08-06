package fr.inria.atlanmod.mogwai.benchmark.validation;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmt.modisco.java.ASTNode;
import org.eclipse.gmt.modisco.java.ClassDeclaration;
import org.eclipse.gmt.modisco.java.CompilationUnit;
import org.eclipse.gmt.modisco.java.Javadoc;
import org.eclipse.gmt.modisco.java.TagElement;
import org.eclipse.gmt.modisco.java.TextElement;
import org.eclipse.gmt.modisco.java.neoemf.impl.JavaPackageImpl;
import org.eclipse.gmt.modisco.java.neoemf.impl.JavadocImpl;

import fr.inria.atlanmod.mogwai.benchmarks.AbstractQueryTest;
import fr.inria.atlanmod.mogwai.common.logging.MogwaiLogger;
import fr.inria.atlanmod.mogwai.neoemf.util.MogwaiURI;
import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

public class ModelMutator {
	
	public static void main(String[] args) throws IOException {
		JavaPackageImpl.init();
		AbstractQueryTest.setUpBeforeClass();
		MogwaiLogger.info("Loading resource");
		PersistenceBackendFactoryRegistry.register(BlueprintsURI.SCHEME, BlueprintsPersistenceBackendFactory.getInstance());
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());
		Resource r = rSet.createResource(BlueprintsURI.createFileURI(new File("resources/modisco.graph")));
		r.load(Collections.EMPTY_MAP);
		MogwaiLogger.info("Mutating resource");
		mutateResource(r);
		MogwaiLogger.info("Done");
	}
	
	public static Resource mutateResource(Resource resource) throws IOException {
		// NotEmptyClassName
		Iterator<EObject> contents = resource.getAllContents();
		int updateCount = 0;
		while(contents.hasNext()) {
			EObject ee = contents.next();
			if(ee instanceof ClassDeclaration && updateCount < 10) {
				((ClassDeclaration)ee).setName("");
				updateCount++;
			}
		}
		// ValidJavadocTags
		Set<CompilationUnit> cc = new HashSet<>();
		Iterator<EObject> it = resource.getAllContents();
		updateCount = 0;
		while(it.hasNext()) {
			EObject e = it.next();
			if(e instanceof Javadoc) {
				JavadocImpl j = (JavadocImpl)e;
				boolean localUpdate = false;
				if(!cc.contains(j.getOriginalCompilationUnit())) {
					cc.add(j.getOriginalCompilationUnit());
		    		for(TagElement t : j.getTags()) {
		    			for(ASTNode astNode : t.getFragments()) {
		    				if(astNode instanceof TextElement && updateCount < 20 &&!localUpdate) {
		    					((TextElement)astNode).setText("");
		    					updateCount++;
		    					localUpdate = true;
		    				}
		    			}
		    		}
				}
			}
		}
		resource.save(Collections.EMPTY_MAP);
		return resource;
	}
	
}
