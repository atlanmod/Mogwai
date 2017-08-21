package fr.inria.atlanmod.mogwai.console;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The Mogwai Console plugin activator.
 * <p>
 * This class is a default implementation of {@link AbstractUIPlugin} that
 * allows to register the Mogwai Console as an Eclipse console.
 * 
 * @author Gwendal DANIEL
 *
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The unique identifier of the plugin.
	 */
	public static final String PLUGIN_ID = "fr.inria.atlanmod.mogwai.console";

	/**
	 * The singleton instance of the plugin.
	 */
	private static Activator plugin;

	/**
	 * Creates a new Mogwai Console Activator instance and registers it as a
	 * singleton.
	 */
	public Activator() {
		super();
		plugin = this;
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
