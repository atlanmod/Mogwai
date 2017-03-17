package fr.inria.atlanmod.mogwai.transformation.atl;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;


public class Activator extends Plugin {
	
	private static Activator plugin;
	
	public static final String PLUGIN_ID = "fr.inria.atlanmod.mogwai.transformation.atl";
	
	public Activator() {
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
	
	public static Activator getDefault() {
		return plugin;
	}
}