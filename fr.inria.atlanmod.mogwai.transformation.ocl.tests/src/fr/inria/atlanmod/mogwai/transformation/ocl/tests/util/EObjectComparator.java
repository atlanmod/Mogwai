package fr.inria.atlanmod.mogwai.transformation.ocl.tests.util;

import java.util.Comparator;

import org.eclipse.emf.ecore.EObject;

import fr.inria.atlanmod.neoemf.core.Id;
import fr.inria.atlanmod.neoemf.core.PersistentEObject;

/**
 * An EObject {@link Comparator} implementation
 * <p>
 * This comparator relies on {@link Id} comparison when the provided
 * {@link EObject}s implement {@link PersistentEObject}. Otherwise a hash code
 * comparison is performed using {@link EObject#hashCode()}.
 * 
 * @author Gwendal DANIEL
 *
 */
public class EObjectComparator implements Comparator<EObject> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare(EObject o1, EObject o2) {
		if (o1 instanceof PersistentEObject && o2 instanceof PersistentEObject) {
			return ((PersistentEObject) o1).id().compareTo(((PersistentEObject) o2).id());
		} else {
			return Integer.compare(o1.hashCode(), o2.hashCode());
		}
	}

}
