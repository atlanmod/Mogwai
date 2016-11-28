package fr.inria.atlanmod.mogwai.benchmarks.util;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmt.modisco.java.ASTNode;
import org.eclipse.gmt.modisco.java.BodyDeclaration;
import org.eclipse.gmt.modisco.java.ClassDeclaration;
import org.eclipse.gmt.modisco.java.Comment;
import org.eclipse.gmt.modisco.java.CompilationUnit;
import org.eclipse.gmt.modisco.java.Javadoc;
import org.eclipse.gmt.modisco.java.MethodDeclaration;
import org.eclipse.gmt.modisco.java.Model;
import org.eclipse.gmt.modisco.java.TagElement;
import org.eclipse.gmt.modisco.java.TextElement;
import org.eclipse.gmt.modisco.java.neoemf.meta.JavaPackage;

/**
 * Utility Class providing Java implementation of benchmark queries
 *
 */
public class JavaQueries {

	public static EList<TextElement> textElementInJavadoc(Resource resource) {
		EList<TextElement> listResult = new BasicEList<TextElement>();
		Model model = (Model)resource.getContents().get(0);
		for(CompilationUnit cu : model.getCompilationUnits()) {
			for(Comment com : cu.getCommentList()) {
				if(com instanceof Javadoc) {
					Javadoc jd = (Javadoc)com;
					for(TagElement tag : jd.getTags()) {
						for(ASTNode node : tag.getFragments()) {
							if(node instanceof TextElement) {
								listResult.add((TextElement)node);
							}
						}
					}
				}
			}
		}
		return listResult;
	}
	
	/**
	 * Grabats09 query: returns the ClassDeclarations that contain a static method 
	 * returning its containing type (singleton pattern)
	 * @param resource the resource containing the model to query
	 * @return an EList containing the matching ClassDeclaration objects
	 */
	public static EList<ClassDeclaration> grabats09(Resource resource) {
		EList<ClassDeclaration> listResult = new BasicEList<ClassDeclaration>();
		EList<? extends EObject> allClassDeclarations = getAllInstances(resource, JavaPackage.eINSTANCE.getClassDeclaration());
		for(EObject e : allClassDeclarations) {
			if(e instanceof ClassDeclaration) {
				ClassDeclaration cd = (ClassDeclaration)e;
				EList<BodyDeclaration> bodyDeclarations = cd.getBodyDeclarations();
				for(BodyDeclaration bd : bodyDeclarations) {
					if(bd instanceof MethodDeclaration) {
						if(bd.getModifier() != null &&
								bd.getModifier().isStatic()) {
							MethodDeclaration md = (MethodDeclaration)bd;
							if(md.getReturnType() != null &&
									md.getReturnType().getType().equals(cd)) {
								listResult.add(cd);
							}
						}
					}
				}
			}
		}
		return listResult;
	}
	
	/**
	 * Utility method that returns all the instances of a given EClass and its subclasses
	 * @param resource the resource containing the model to query
	 * @param eClass the EClass to match
	 * @return an EList containing the matching instances
	 */
	private static EList<? extends EObject> getAllInstances(Resource resource, EClass eClass) {
		Iterator<EObject> iterator = resource.getAllContents();
		EList<EObject> resultList = new BasicEList<EObject>();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			if (eClass.isInstance(eObject)) {
				resultList.add(eObject);
			}
		}
		return resultList;
	}
	
}
