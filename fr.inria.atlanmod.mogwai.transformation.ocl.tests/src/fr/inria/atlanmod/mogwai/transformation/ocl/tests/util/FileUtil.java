package fr.inria.atlanmod.mogwai.transformation.ocl.tests.util;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

/**
 * A utility class that provides file management methods.
 * <p>
 * This class reimplements some of the Apache FileUtils methods in order to
 * avoid an unnecessary dependency.
 * 
 * @author Gwendal DANIEL
 *
 */
public class FileUtil {

	/**
	 * Deletes a {@link File}.
	 * <p>
	 * If the provided {@link File} represents a directory its content is
	 * recursively deleted.
	 * 
	 * @param file
	 *            the {@link File} to delete
	 */
	public static void delete(File file) {
		if (file.isDirectory()) {
			Collection<File> content = Arrays.asList(file.listFiles());
			for (File f : content) {
				/*
				 * Deletes recursively sub-directory contents
				 */
				delete(f);
			}
		} else {
			file.delete();
		}
	}
}
