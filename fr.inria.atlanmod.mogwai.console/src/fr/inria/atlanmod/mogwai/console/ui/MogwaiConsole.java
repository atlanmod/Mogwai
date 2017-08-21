package fr.inria.atlanmod.mogwai.console.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.AbstractConsole;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.part.IPageBookViewPage;

import fr.inria.atlanmod.mogwai.console.Activator;

/**
 * An {@link AbstractConsole} implementation that registers the Mogwai specific
 * console in the running {@link ConsolePlugin} and creates the console view
 * when requested.
 * <p>
 * This class is instantiated and accessed by the {@link MogwaiConsoleFactory}
 * that is responsible of registering it as a valid Eclipse console.
 * 
 * @see MogwaiConsoleFactory
 * 
 * @author Gwendal DANIEL
 *
 */
public class MogwaiConsole extends AbstractConsole {

	/**
	 * The singleton instance of the {@link MogwaiConsole}.
	 */
	private static MogwaiConsole instance;

	/**
	 * Returns the singleton instance of the {@link MogwaiConsole}.
	 * <p>
	 * Calling this method for the first time will constructs a new
	 * {@link MogwaiConsole} instance and register it to the global
	 * {@link ConsolePlugin}.
	 * 
	 * @return the singleton instance of the {@link MogwaiConsole}
	 */
	public static MogwaiConsole getInstance() {
		if (instance == null) {
			instance = new MogwaiConsole();
			ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { instance });
		}
		return instance;
	}

	/**
	 * The last {@link MogwaiConsolePage} presented to the end-user.
	 */
	private MogwaiConsolePage page;

	/**
	 * Constructs a new {@link MogwaiConsole} and sets its associated title and
	 * icon.
	 * <p>
	 * This constructor is private to avoid multiple instantiation of the
	 * {@link MogwaiConsole}. Use {@link #getInstance()} if you want to access
	 * the singleton instance of the {@link MogwaiConsole} instead.
	 */
	private MogwaiConsole() {
		super("Mogwaï Console", ImageDescriptor.createFromURL(Activator.getDefault().getBundle()
				.getEntry("/icons/mogwai.gif")));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void dispose() {
		/*
		 * Release all console-related resources here.
		 */
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	public IPageBookViewPage createPage(IConsoleView view) {
		page = new MogwaiConsolePage();
		return page;
	}

	/**
	 * Closes the console and removes it from the global {@link ConsolePlugin}.
	 */
	void close() {
		try {
			ConsolePlugin.getDefault().getConsoleManager().removeConsoles(new IConsole[] { this });
			dispose();
		} finally {
			instance = null;
		}
	}

}
