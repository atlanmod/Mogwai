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
package fr.inria.atlanmod.mogwai.neoemf.util;

import java.io.File;
import java.text.MessageFormat;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;

import fr.inria.atlanmod.mogwai.neoemf.resource.MogwaiResourceFactory;
import fr.inria.atlanmod.neoemf.util.PersistenceURI;

/**
 * A specific {@link PersistenceURI} that creates Mogwai specific resource
 * {@link URI}s from a {@link File} descriptor or an existing {@link URI}.
 * <p>
 * This class defines a Mogwai specific {@link URI} scheme that is used to
 * register {@link BlueprintsPersistenceBackendFactory} in
 * {@link PersistenceBackendFactoryRegistry} and configure the {@code protocol
 * to factory} map of an existing {@link ResourceSet} with a
 * {@link MogwaiResourceFactory}.
 *
 * @see PersistenceBackendFactoryRegistry
 * @see BlueprintsPersistenceBackendFactory
 * @see MogwaiResourceFactory
 */
public class MogwaiURI extends PersistenceURI {

	/**
	 * The scheme associated to the URI. This scheme is used to register
	 * {@link BlueprintsPersistenceBackendFactory} and provide a
	 * {@link MogwaiResourceFactory} to an existing {@link ResourceSet}.
	 *
	 * @see PersistenceBackendFactoryRegistry
	 * @see BlueprintsPersistenceBackendFactory
	 * @see MogwaiResourceFactory
	 */
	public final static String MOGWAI_SCHEME = "mogwai";

	/**
	 * Constructs a new {@link MogwaiURI} from the given {@code internalURI}.
	 * <p>
	 * <b>Note:</b> This constructor is protected to avoid wrong {@link URI}
	 * instantiations. Use {@link #createURI(URI)}, {@link #createFileURI(File)}
	 * , or {@link #createFileURI(URI)} instead.
	 * 
	 * @param internalURI
	 *            the base {@link URI}
	 */
	protected MogwaiURI(URI internalURI) {
		super(internalURI);
	}

	/**
	 * Creates a new {@link MogwaiURI} from the given {@code uri}. This method
	 * checks that the scheme of the provided {@code uri} can be used to create
	 * a new {@link MogwaiURI}.
	 *
	 * @param uri
	 *            the base {@link URI}
	 *
	 * @return the created {@link URI}
	 *
	 * @throws NullPointerException
	 *             if the {@code uri} is {@code null}
	 * @throws IllegalArgumentException
	 *             if the scheme of the provided {@code uri} is not
	 *             {@link #MOGWAI_SCHEME} or {@link #FILE_SCHEME}
	 * @see #createMogwai(File)
	 */
	public static URI createMogwaiURI(URI uri) {
		if (PersistenceURI.FILE_SCHEME.equals(uri.scheme())) {
			return createMogwaiURI(FileUtils.getFile(uri.toFileString()));
		} else if (MOGWAI_SCHEME.equals(uri.scheme())) {
			return PersistenceURI.createURI(uri);
		} else {
			throw new IllegalArgumentException(MessageFormat.format(
					"Can not create NeoGraphURI from the URI scheme {0}", uri.scheme()));
		}
	}

	/**
	 * Creates a new {@link MogwaiURI} from the given {@link File} descriptor.
	 *
	 * @param file
	 *            the {@link File} to build a {@link URI} from
	 *
	 * @return the created {@link URI}
	 *
	 * @throws NullPointerException
	 *             if the {@code file} is {@code null} or if it cannot be found
	 * 
	 * @see #createMogwaiURI(URI)
	 */
	public static URI createMogwaiURI(File file) {
		return PersistenceURI.createFileURI(file, MOGWAI_SCHEME);
	}

}
