package fr.inria.atlanmod.mogwai.common.util;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

/**
 * Provides utility methods to load file and check if the application is
 * executed within Eclipse.
 * 
 * @author Gwendal DANIEL
 *
 */
public class MogwaiQueryUtil {

	/**
	 * Retrieves the {@link URL} associated to {@code fileName}
	 * 
	 * @param fromClass
	 *            the calling {@link Class}. This parameter is mandatory in OSGI
	 *            environment, where classloaders are bundle-specific.
	 * @param fileName
	 *            the name of the file to get the {@link URL} of
	 * @return an {@link URL} representing {@code fileName}'s location
	 * @throws IOException
	 *             if {@code fileName} cannot be found
	 */
	public static URL getFileURL(Class<?> fromClass, String fileName) throws IOException {
		URL fileURL;
		if (isEclipseRunning()) {
			URL resourceURL = fromClass.getResource(fileName);
			if (resourceURL != null) {
				fileURL = FileLocator.toFileURL(resourceURL);
			} else {
				fileURL = null;
			}
		} else {
			fileURL = fromClass.getResource(fileName);
		}
		if (fileURL == null) {
			throw new IOException("'" + fileName + "' not found");
		} else {
			return fileURL;
		}
	}

	/**
	 * Returns whether the executed application is running inside Eclipse.
	 * 
	 * @return {@code true} if the executed application is running inside
	 *         Eclipse, {@code false} otherwise
	 */
	public static boolean isEclipseRunning() {
		try {
			return Platform.isRunning();
		} catch (Throwable e) {

		}
		return false;
	}

}
