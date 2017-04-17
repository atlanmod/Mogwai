package fr.inria.atlanmod.mogwai.query;

import fr.inria.atlanmod.mogwai.processor.MogwaiProcessor;

public abstract class MogwaiQuery<D> {

	private Object rawInput;
	
	public MogwaiQuery(Object input) {
		this.rawInput = input;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"}) 
	public MogwaiQueryResult process(MogwaiProcessor processor, D datastore, Object arg) throws MogwaiQueryException {
		if(processor.accept(this)) {
			return processor.process(this, datastore, arg);
		}
		else {
			throw new MogwaiQueryException("Processor " + processor.getName() + " cannot compute " + this.toString());
		}
	}
	
	public Object getRawInput() {
		return rawInput;
	}
	
	public abstract String getInput();
	
}
