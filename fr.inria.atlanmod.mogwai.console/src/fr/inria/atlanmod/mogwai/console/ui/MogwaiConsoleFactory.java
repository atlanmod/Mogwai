package fr.inria.atlanmod.mogwai.console.ui;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsoleFactory;
import org.eclipse.ui.console.IConsoleManager;

/**
 * Console factory for the Mogwaï Console, to enable it on any
 * editor that supports EObject selections.
 */
public class MogwaiConsoleFactory implements IConsoleFactory {

	@Override
	public void openConsole() {
		MogwaiConsole console = MogwaiConsole.getInstance();
		
		IConsoleManager mgr = ConsolePlugin.getDefault().getConsoleManager();
		
		mgr.showConsoleView(console);
		mgr.showConsoleView(console);
	}
	
}
