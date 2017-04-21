package fr.inria.atlanmod.mogwai.gremlin.printers;

public class GremlinPrinterFactory {

	public static final String DEFAULT_GREMLIN_PRINTER = "default";
	
	public static final String ATL_GREMLIN_PRINTER = "atl";
	
	public static GremlinPrinter getDefaultPrinter() {
		return new DefaultGremlinPrinter();
	}
	
	public static GremlinPrinter getPrinter(String printerId) {
		switch(printerId) {
			case DEFAULT_GREMLIN_PRINTER:
				return new DefaultGremlinPrinter();
			case ATL_GREMLIN_PRINTER:
				return new MogwaiATLGremlinPrinter();
			default:
				return new DefaultGremlinPrinter();
		}
	}
	
}
