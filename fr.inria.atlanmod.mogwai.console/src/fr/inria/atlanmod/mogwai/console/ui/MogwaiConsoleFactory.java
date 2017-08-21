package fr.inria.atlanmod.mogwai.console.ui;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;

/**
 * An {@link IConsoleFactory} instance that is used to register the
 * {@link MogwaiConsole} as an Eclipse console.
 * <p>
 * This class is used in the plugin's extension points to notify the running
 * installation that a new {@link MogwaiConsole} should be presented to the user
 * and displayed in the related menus.
 * 
 * @see MogwaiConsole
 * 
 * @author Gwendal DANIEL
 */
public class MogwaiConsoleFactory implements IConsoleFactory {

	/**
	 * Gets the singleton instance of the {@link MogwaiConsole} and opens it
	 * using the running {@link ConsolePlugin}.
	 */
	@Override
	public void openConsole() {
		MogwaiConsole console = MogwaiConsole.getInstance();

		IConsoleManager mgr = ConsolePlugin.getDefault().getConsoleManager();

		/*
		 * Quick fix: Eclipse does not open the console if this method is only
		 * called once.
		 */
		mgr.showConsoleView(console);
		mgr.showConsoleView(console);
	}

}
