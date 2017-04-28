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
package fr.inria.atlanmod.mogwai.neoemf.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.atlanmod.mogwai.core.exception.MogwaiCoreException;
import fr.inria.atlanmod.mogwai.neoemf.util.MogwaiURI;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;

/**
 * The factory that creates {@link MogwaiResource} instances.
 * 
 * @author Gwendal DANIEL
 *
 */
public class MogwaiResourceFactory extends PersistentResourceFactory {

	/**
	 * Constructs a new {@link MogwaiResourceFactory}.
	 * <p>
	 * This method is not public because only one factory should be in memory at
	 * any time. Use {@link MogwaiResourceFactory#getInstance()} instead.
	 */
	protected MogwaiResourceFactory() {

	}

	/**
	 * Returns the singleton instance of this class.
	 * 
	 * @return the singleton instance of this class
	 */
	public static MogwaiResourceFactory getInstance() {
		return Holder.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method delegates to {@link PersistentResourceFactory} if the
	 * provided {@code uri} doesn't use either {@link MogwaiURI#MOGWAI_SCHEME}
	 * or {@link BlueprintsURI#SCHEME} as its {@code scheme}.
	 */
	@Override
	public Resource createResource(URI uri) {
		if (uri.scheme().equals(MogwaiURI.MOGWAI_SCHEME) || uri.scheme().equals(BlueprintsURI.SCHEME)) {
			return new DefaultMogwaiResource(uri);
		} else {
			return super.createResource(uri);
		}
	}

	/**
	 * Creates a new {@link MogwaiResource} wrapping the provided
	 * {@code persistentResource}.
	 * <p>
	 * Use this method when {@code persistentResource} is already opened and
	 * loaded to avoid embedded database multiple connection errors and benefit
	 * from the setup caches from the underlying database.
	 * 
	 * @param persistentResource
	 *            the {@link PersistentResource} to wrap
	 * @return a {@link MogwaiResource} wrapping the provided
	 *         {@code persistentResource}
	 * @throws MogwaiCoreException
	 *             if the provided {@code persistentResource} is not compatible
	 *             with Mogwai
	 */
	public MogwaiResource decoratePersistentResource(PersistentResource persistentResource) throws MogwaiCoreException {
		if (DefaultMogwaiResource.isMogwaiCompatible(persistentResource)) {
			return new MogwaiResourceDecorator(persistentResource);
		} else {
			throw new MogwaiCoreException("Resource " + persistentResource.toString()
					+ " is not compatible with Mogwaï");
		}
	}

	/**
	 * A lazy holder maintaining a singleton instance of {@link MogwaiResourceFactory}.
	 */
	private static class Holder {
		
		/**
		 * The singleton instance of {@link MogwaiResourceFactory}.
		 */
		private static final MogwaiResourceFactory INSTANCE = new MogwaiResourceFactory();
	}

}
