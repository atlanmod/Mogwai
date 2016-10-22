package fr.inria.atlanmod.mogwai.console.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.examples.interpreter.OCLExamplePlugin;
import org.eclipse.ocl.examples.interpreter.console.DelegatingPackageRegistry;
import org.eclipse.ocl.examples.interpreter.console.IOCLFactory;
import org.eclipse.ocl.examples.interpreter.console.ModelingLevel;
import org.eclipse.ocl.examples.interpreter.console.TargetMetamodel;
import org.eclipse.ocl.examples.interpreter.console.text.ColorManager;
import org.eclipse.ocl.examples.interpreter.console.text.OCLDocument;
import org.eclipse.ocl.examples.interpreter.console.text.OCLSourceViewer;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.actions.ClearOutputAction;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;

import fr.inria.atlanmod.mogwai.core.MogwaiException;
import fr.inria.atlanmod.mogwai.core.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import fr.inria.atlanmod.mogwai.resources.MogwaiResourceFactory;
import fr.inria.atlanmod.mogwai.resources.MogwaiResourceFactoryImpl;
import fr.inria.atlanmod.mogwai.util.MogwaiURI;
import fr.inria.atlanmod.mogwai.util.MogwaiUtil;
import fr.inria.atlanmod.neoemf.graph.blueprints.util.NeoBlueprintsURI;
import fr.inria.atlanmod.neoemf.resources.PersistentResource;
import fr.inria.atlanmod.neoemf.resources.impl.PersistentResourceImpl;

public class MogwaiConsolePage extends Page {
	
private Composite page;
	
	protected ITextViewer output;
	protected OCLSourceViewer input;
	protected OCLDocument document;
	
	protected ColorManager colorManager;
	
	protected String lastOCLExpression;
	protected EObject context;
	protected Resource resource;
	
	protected ISelectionService selectionService;
	protected ISelectionListener selectionListener;
	
	protected IOCLFactory<Object> oclFactory = new EcoreOCLFactory();
	protected OCL ocl;
	
	private static final AdapterFactory reflectiveAdapterFactory =
			new ReflectiveItemProviderAdapterFactory();

		private static final AdapterFactory defaultAdapterFactory =
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	
	public MogwaiConsolePage() {
		super();
	}
	
	@Override
	public void createControl(Composite parent) {
		page = new SashForm(parent, SWT.VERTICAL | SWT.LEFT_TO_RIGHT);
		
		output = new TextViewer(page, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		output.getTextWidget().setLayoutData(new GridData(GridData.FILL_BOTH));
		output.getTextWidget().setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
		output.setEditable(false);
		output.setDocument(new Document());
		
		colorManager = new ColorManager();
		document = new OCLDocument();
		document.setOCLFactory(oclFactory);
		document.setModelingLevel(ModelingLevel.M2);
		
		input = new OCLSourceViewer(page, colorManager, SWT.BORDER | SWT.MULTI);
		input.setDocument(document);
		input.getTextWidget().addKeyListener(new InputKeyListener());
		
		selectionListener = new ISelectionListener() {
			@Override
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				MogwaiConsolePage.this.selectionChanged(selection);
			}
		};
		selectionService = getSite().getWorkbenchWindow().getSelectionService();
		selectionService.addPostSelectionListener(selectionListener);
		
		// get current selection
		ISelection selection = selectionService.getSelection();
		if(selection == null) {
			selection = getActiveSelection();
		}
		selectionChanged(selection);
		
		((SashForm)page).setWeights(new int[] {2,1});
		
		ClearOutputAction clear = new ClearOutputAction(output);
		CloseAction close = new CloseAction();
		
		IMenuManager menu = getSite().getActionBars().getMenuManager();
		menu.add(clear);
		menu.add(close);
		
		IToolBarManager toolbar = getSite().getActionBars().getToolBarManager();
		toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, clear);
		toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, close);
	}
	
	boolean evaluate(String expression) {
		boolean result = true;
		
		if (context == null) {
			result = false;
			error("No context element is selected");
		} else {
			// create an OCL helper to do our parsing and evaluating
            ocl = oclFactory.createOCL(ModelingLevel.M2);
            OCLHelper helper = ocl.createOCLHelper();
			
			try {
				// set our helper's context classifier to parse against it
	            ConstraintKind kind = ModelingLevel.M2.setContext(helper, context, oclFactory);
				
				IDocument doc = getDocument();
				Color outputDefault = colorManager.getColor(ColorManager.DEFAULT);
                Color outputResults = colorManager.getColor(ColorManager.OUTPUT_RESULTS);
				Color outputGremlin = colorManager.getColor(new RGB(0, 153, 51));
                
				if (doc.getLength() > 0) {
					// separate previous output by a blank line
					append("", outputDefault, false); //$NON-NLS-1$
				}
				
				append("Evaluating: ", outputDefault, true);
				append(expression, outputDefault, false);

				org.eclipse.ocl.ecore.OCLExpression parsed = (org.eclipse.ocl.ecore.OCLExpression) helper.createQuery(expression);
				if(resource == null || !MogwaiUtil.isMogwaiCompatible(resource)) {
					append("The model is not compatible with Mogwai, using standard OCL interpreter", outputDefault, true);
	                append("Results: ", outputDefault, true);
	                print(ocl.evaluate(context, parsed), outputResults, false);
				} else {
					ResourceSet rSet = resource.getResourceSet();
					URI rURI = resource.getURI();
					// Decorate the resource to enable Mogwai query API
					MogwaiResource mr = MogwaiResourceFactory.eINSTANCE.decoratePersistentResource((PersistentResource)resource);
					MogwaiQueryResult qR = mr.query(parsed, context);
					append("Computing query: ", outputDefault, true);
					append(qR.getGremlinScript().toString(), outputGremlin, false);
					append("Results: ", outputDefault, true);
					printMogwaiResult(qR, outputResults, false);
				}
				// store the successfully parsed expression
				lastOCLExpression = expression;
			} catch (Exception e) {
				result = false;
				error((e.getLocalizedMessage() == null) ? e.getClass().getName()
						: e.getLocalizedMessage());
			}
		}
		
		return result;
	}
	
	@Override
	public Control getControl() {
		return page;
	}
	
	@Override
	public void setFocus() {
		input.getTextWidget().setFocus();
	}
	
	@Override
	public void dispose() {
		colorManager.dispose();
		selectionService.removePostSelectionListener(selectionListener);
		super.dispose();
	}
	
	protected ISelection getActiveSelection() {
		try {
			IPageSite site = getSite();
			if (site == null) {
				return null;
			}
			IWorkbenchWindow workbenchWindow = site.getWorkbenchWindow();
			if (workbenchWindow == null) {
				return null;
			}
			IWorkbenchPage activePage = workbenchWindow.getActivePage();
			if (activePage == null) {
				return null;
			}
			IEditorPart activeEditor = activePage.getActiveEditor();
			if (activeEditor == null) {
				return null;
			}
			IEditorSite editorSite = activeEditor.getEditorSite();
			if (editorSite == null) {
				return null;
			}
			ISelectionProvider selectionProvider = editorSite.getSelectionProvider();
			if (selectionProvider == null) {
				return null;
			}
			return selectionProvider.getSelection();
		}
		catch (Exception e) {
			return  null;
		}
	}
	
	protected void selectionChanged(ISelection sel) {
	    if (sel instanceof IStructuredSelection) {
            IStructuredSelection ssel = (IStructuredSelection) sel;
            
            if (!ssel.isEmpty()) {
                Object selected = ssel.getFirstElement();
                
                if (selected instanceof EObject) {
                    context = (EObject) selected;
                } else if (selected instanceof IAdaptable) {
            		@SuppressWarnings("cast")			// Cast not needed after Mars M6
                    EObject adapter = (EObject) ((IAdaptable) selected).getAdapter(EObject.class);
					context = adapter;
                }
                this.resource = context.eResource();
                document.setOCLContext(context);
            }
	    }
	}
	
	/**
	 * Obtains the document in the output viewer.
	 * 
	 * @return the output document
	 */
	private IDocument getDocument() {
		return output.getDocument();
	}
	
	/**
	 * Prints the specified <code>object</code> to the output viewer.  The
	 * object is converted to a string using the best matching EMF label
	 * provider adapter if it is an {@link EObject}; otherwise, just use
	 * {@link String#valueOf(java.lang.Object)} on it.  If the
	 * <code>object</code> is a collection or an array, then we print each
	 * element on a separate line.
	 * 
	 * @param object the object or collection to print
	 * @param color the color to print the <code>object</code> with
	 * @param bold whether to display it in bold text
	 */
	private void print(Object object, Color color, boolean bold) {
		Collection<?> toPrint;
		
		if (object == null) {
			toPrint = Collections.EMPTY_SET;
		} else if (object instanceof Collection) {
			toPrint = (Collection<?>) object;
		} else if (object.getClass().isArray()) {
			toPrint = Arrays.asList((Object[]) object);
		} else {
			toPrint = Collections.singleton(object);
		}
		
		for (Iterator<?> iter = toPrint.iterator(); iter.hasNext();) {
			append(toString(iter.next()), color, bold);
		}
		
		scrollText();
	}
	
	private void printMogwaiResult(MogwaiQueryResult queryResult, Color color, boolean bold) throws MogwaiException {
		Collection<?> toPrint;
		if(queryResult.isReifiable()) {
			if(queryResult.isSingleResult()) {
				// Should be reified
				toPrint = Collections.singleton(queryResult.getResult());
			}
			else {
				toPrint = queryResult.reifyResults((PersistentResource)resource);
			}
		} else {
			if(queryResult.isSingleResult()) {
				toPrint = Collections.singleton(queryResult.getResult());
			}
			else {
				toPrint = queryResult.getResults();
			}
		}
		for(Iterator<?> iter = toPrint.iterator(); iter.hasNext();) {
			append(toString(iter.next()), color, bold);
		}
		
		scrollText();
	}
	
	/**
	 * Converts a single object to a string, according to the rules described
	 * for the {@link #print(Object, Color, boolean)} method.
	 * 
	 * @param object the object to print (not a collection type)
	 * @return the string form of the <code>object</code>
	 * 
	 * @see #print(Object, Color, boolean)
	 */
	String toString(Object object) {
		if (ocl.isInvalid(object)) {
			return "OclInvalid"; //$NON-NLS-1$
		} else if (object instanceof String) {
			return "'" + object + "'";  //$NON-NLS-1$//$NON-NLS-2$
//		} else if (object instanceof Tuple) {
//			return tupleTypeLabelProvider.getText(object);
		} else if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			
			IItemLabelProvider labeler =
				(IItemLabelProvider) defaultAdapterFactory.adapt(
					eObject,
					IItemLabelProvider.class);
			
			if (labeler == null) {
				labeler = (IItemLabelProvider) reflectiveAdapterFactory.adapt(
					eObject,
					IItemLabelProvider.class);
			}
			
			if (labeler != null) {
				return labeler.getText(object);
			}
		}
		
		return String.valueOf(object);
	}
	
	/**
	 * Prints an error message to the output viewer, in red text.
	 * 
	 * @param message the error message to print
	 */
	private void error(String message) {
		append(message, colorManager.getColor(ColorManager.OUTPUT_ERROR), false);
		scrollText();
	}
	
	/**
	 * Ensures that the last text printed to the output viewer is shown.
	 */
	private void scrollText() {
		output.revealRange(getDocument().getLength(), 0);
	}
	
	/**
	 * Appends the specidied text to the output viewer.
	 * 
	 * @param text the text to append
	 * @param color the color to print the text with
	 * @param bold whether to print the text bold
	 */
	private void append(String text, Color color, boolean bold) {
		
		IDocument doc = getDocument();
		try {
			int offset = doc.getLength();
			int length = text.length();
			
			text = text + '\n';
			
			if (offset > 0) {
				doc.replace(offset, 0, text);
			} else {
				doc.set(text);
			}
			
			StyleRange style = new StyleRange();
			style.start = offset;
			style.length = length;
			style.foreground = color;
			
			if (bold) {
				style.fontStyle = SWT.BOLD;
			}
			
			output.getTextWidget().setStyleRange(style);
		} catch (BadLocationException e) {
			IStatus status = new Status(
				IStatus.ERROR,
				OCLExamplePlugin.getPluginId(),
				1,
				"Exception appending to OCL console output.",
				e);
			
			OCLExamplePlugin.getDefault().getLog().log(status);
		}
	}
	
	
	/**
	 * A key listener that listens for the Enter key to evaluate the OCL
	 * expression.
	 */
	private class InputKeyListener implements KeyListener {
		private boolean evaluationSuccess = false;		
		private List<String> history = new ArrayList<String>();
		private int currentHistoryPointer = 0;
		
		public void keyPressed(KeyEvent e) {
			switch (e.keyCode) {
			case SWT.CR :
			    if (!input.isContentAssistActive()
			            && (e.stateMask & (SWT.CTRL | SWT.SHIFT)) == 0) {
					String text = document.get();
					evaluationSuccess = evaluate(text.trim());
				}				
				break;
			case SWT.PAGE_UP :
				if (!input.isContentAssistActive()
						&& (e.stateMask & (SWT.CTRL | SWT.SHIFT)) == 0) {					
					// history
					if (currentHistoryPointer == 0 && history.size() > 0) {
						if (history.size() > 0 && history.get(0).length() == 0) {
							history.remove(0);
						}
						history.add(0, document.get().trim());
						currentHistoryPointer = 1;
						setTextFromHistory();
					} else if (currentHistoryPointer < history.size() - 1) {
						currentHistoryPointer++;
						setTextFromHistory();
					}
				}				
				break;
			case SWT.PAGE_DOWN :
				if (!input.isContentAssistActive()
						&& (e.stateMask & (SWT.CTRL | SWT.SHIFT)) == 0) {					
					// history
					if (currentHistoryPointer > 0) {
						currentHistoryPointer--;
						setTextFromHistory();
					}
				}				
				break;
			}
		}

		public void keyReleased(KeyEvent e) {
			switch (e.keyCode) {
			case SWT.CR :
				if ((e.stateMask & SWT.CTRL) == 0) {
					if (evaluationSuccess) {
						document.set(""); //$NON-NLS-1$
						// history
						if (history.size() > 0 && history.get(0).trim().length() == 0) {
							history.remove(0);
						}
						if (history.size() == 0 || !history.get(0).equals(lastOCLExpression.trim())) {
							history.add(0, lastOCLExpression.trim());
						}
						currentHistoryPointer = 0;
					}					
					evaluationSuccess = false;
				}				
				break;
			case ' ':
			    if ((e.stateMask & SWT.CTRL) == SWT.CTRL) {
			        input.getContentAssistant().showPossibleCompletions();
			    }
			}
		}

		protected void setTextFromHistory() {
			String newText = history.get(currentHistoryPointer);
			document.set(newText);
			input.setSelectedRange(newText.length(), 0);
		}
	}
	
	private class CloseAction extends Action {
		private final String tip;
		
		/**
		 * Initializes me.
		 */
		CloseAction() {
			super(
				"Close",
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_TOOL_DELETE));
			
			tip = "Close Console";
		}
		
		@Override
        public String getToolTipText() {
			return tip;
		}
		
		@Override
        public void run() {
			MogwaiConsole.getInstance().close();
		}
	}
	
	private class EcoreOCLFactory implements IOCLFactory<Object> {
        public TargetMetamodel getTargetMetamodel() {
            return TargetMetamodel.Ecore;
        }
        
	    @SuppressWarnings("unchecked")
	    public OCL<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> createOCL(ModelingLevel level) {
            return OCL.newInstance(
                new EcoreEnvironmentFactory(
                    new DelegatingPackageRegistry(
                            context.eResource().getResourceSet().getPackageRegistry(),
                            EPackage.Registry.INSTANCE)));
	    }
	    
        @SuppressWarnings("unchecked")
        public OCL<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> createOCL(ModelingLevel level,
                Resource res) {
            
            return OCL.newInstance(
                new EcoreEnvironmentFactory(
                    new DelegatingPackageRegistry(
                            context.eResource().getResourceSet().getPackageRegistry(),
                            EPackage.Registry.INSTANCE)),
                res);
        }
        
	    public Object getContextClassifier(EObject object) {
	        return context.eClass();
	    }
	    
	    public String getName(Object modelElement) {
	        return ((ENamedElement) modelElement).getName();
	    }
	}
}
