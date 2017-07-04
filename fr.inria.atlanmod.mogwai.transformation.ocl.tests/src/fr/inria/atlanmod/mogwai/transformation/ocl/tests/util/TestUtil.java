package fr.inria.atlanmod.mogwai.transformation.ocl.tests.util;

import java.math.BigDecimal;
import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import fr.inria.atlanmod.mogwai.gremlin.GremlinPackage;

/**
 * A utility class that provides test-level helpers to handle empty resource
 * creation, resource management, and EMF-based utility functions.
 * 
 * @author Gwendal DANIEL
 *
 */
public class TestUtil {

	/**
	 * Creates a new empty gremlin {@link Resource} from a dedicated, empty
	 * {@link ResourceSet}.
	 * <p>
	 * The generated resource has a static {@link URI} and should not be saved.
	 * It is intended to be used within a test case and deleted after usage. The
	 * created {@link Resource} has a <code>.gremlin</code> extension and can
	 * store Gremlin elements.
	 * <p>
	 * To create an empty Gremlin {@link Resource} from an existing
	 * {@link ResourceSet} see {@link #createEmptyGremlinResource(ResourceSet)}.
	 * 
	 * @see #createEmptyGremlinResource(ResourceSet)
	 * 
	 * @return the created gremlin {@link Resource}
	 */
	public static Resource createEmptyGremlinResource() {
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getPackageRegistry().put(GremlinPackage.eINSTANCE.getNsURI(), GremlinPackage.eINSTANCE);
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("gremlin", GremlinPackage.eINSTANCE);
		return createEmptyGremlinResource(rSet);
	}

	/**
	 * Creates a new empty gremlin {@link Resource} from the given
	 * {@link ResourceSet}.
	 * <p>
	 * The generated resource has a static {@link URI} and should not be saved.
	 * It is intended to be used within a test case and deleted after usage. The
	 * created {@link Resource} has a <code>.gremlin</code> extension and can
	 * store Gremlin elements.
	 * <p>
	 * To create an empty Gremlin {@link Resource} from a dedicated, empty
	 * {@link ResourceSet} see {@link #createEmptyGremlinResource()}.
	 * 
	 * @see #createEmptyGremlinResource()
	 * 
	 * @param rSet
	 *            the {@link ResourceSet} used to create the gremlin resource
	 * @return the created gremlin {@link Resource}
	 */
	public static Resource createEmptyGremlinResource(ResourceSet rSet) {
		return rSet.createResource(URI.createURI("empty_resource.gremlin"));
	}

	/**
	 * A custom implementation of {@link Objects#equals(Object, Object)} that
	 * provides additional equivalence classes.
	 * <p>
	 * As an example, this method returns {@code true} when comparing a
	 * {@link Double} and a {@link BigDecimal} which have the same double value.
	 * <p>
	 * This method aims to bridge the gap between OCL return types and Gremlin
	 * return types, that may be considered as equivalent for general use cases.
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static boolean equals(Object o1, Object o2) {
		boolean result = Objects.equals(o1, o2);
		if (!result) {
			if (o1 instanceof Double) {
				if (o2 instanceof BigDecimal) {
					result = ((BigDecimal) o2).doubleValue() == (Double) o1;
				}
			}
		}
		return result;
	}

}
