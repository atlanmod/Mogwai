package fr.inria.atlanmod.mogwai.transformation;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

	private static Activator plugin;

	public static final String PLUGIN_ID = "fr.inria.atlanmod.mogwai.transformation";
	
	public Activator() {
		System.out.println("Mogwai Transformation Plugin Activated");
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		System.out.println("Mogwai Transformation Plugin Started");
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		System.out.println("Mogwai Transformation Plugin Stopped");
		super.stop(bundleContext);
	}
	
	public static Activator getDefault() {
		return plugin;
	}

}
