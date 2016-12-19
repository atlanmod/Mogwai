package fr.inria.atlanmod.mogwai.transformation.atl;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import fr.inria.atlanmod.neoemf.logging.NeoLogger;


public class Activator extends Plugin {
	
	private static Activator plugin;
	
	public static final String PLUGIN_ID = "fr.inria.atlanmod.mogwai.transformation.atl";
	
	public Activator() {
		NeoLogger.debug("Mogwai ATL Transformation plugin activated");
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		NeoLogger.debug("Mogwai ATL Transformation plugin started");
		plugin = this;
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		NeoLogger.debug("Mogwai ATL Transformation plugin stopped");
		super.stop(context);
	}
	
	public static Activator getDefault() {
		return plugin;
	}
}