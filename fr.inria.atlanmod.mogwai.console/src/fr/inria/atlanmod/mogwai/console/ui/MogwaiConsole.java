package fr.inria.atlanmod.mogwai.console.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.AbstractConsole;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.part.IPageBookViewPage;

import fr.inria.atlanmod.mogwai.console.Activator;


public class MogwaiConsole extends AbstractConsole {
	
	private static MogwaiConsole instance;
	private MogwaiConsolePage page;

	private MogwaiConsole() {
		super("Mogwaï Console",
			ImageDescriptor.createFromURL(
				Activator.getDefault()
				.getBundle()
				.getEntry("/icons/mogwai.gif")));
	}
	
	protected void dispose() {
		super.dispose();
	}
	
	public static MogwaiConsole getInstance() {
		if(instance == null) {
			instance = new MogwaiConsole();
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(
				new IConsole[] {instance});
		}
		return instance;
	}
	
	public IPageBookViewPage createPage(IConsoleView view) {
		page = new MogwaiConsolePage();
		return page;
	}
	
	void close() {
		try {
			ConsolePlugin.getDefault().getConsoleManager().removeConsoles(
				new IConsole[] {this});
			dispose();
		} finally {
			instance = null;
		}
	}
	
}
