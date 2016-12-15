package fr.inria.atlanmod.mogwai.query;

import org.eclipse.emf.common.util.URI;

import fr.inria.atlanmod.mogwai.processor.MogwaiProcessor;

public abstract class MogwaiQuery {

	public MogwaiQuery(Object input) throws MogwaiQueryException {
		if(input instanceof String) {
			fromString((String) input);
		} else if(input instanceof URI) {
			fromURI((URI) input);
		}
	}
	
	public MogwaiQueryResult process(MogwaiProcessor processor, Object arg) throws MogwaiQueryException {
		if(processor.accept(this)) {
			return processor.process(this, arg);
		}
		else {
			throw new MogwaiQueryException("Processor " + processor.getName() + " cannot compute " + this.toString());
		}
	}
	
	protected abstract void fromString(String string);
	
	protected abstract void fromURI(URI uri);
	
	public abstract String getInput();
	
}
