package fr.inria.atlanmod.mogwai.query;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.data.mapping.ModelMapping;
import fr.inria.atlanmod.mogwai.processor.MogwaiProcessor;

public abstract class MogwaiQuery {

	private Object rawInput;
	
	public MogwaiQuery(Object input) {
		this.rawInput = input;
	}
	
	public <D>MogwaiQueryResult process(MogwaiProcessor processor, D datastore, ModelMapping mapping, Map<String, Object> options) throws MogwaiQueryException {
		return process(processor, Arrays.asList(datastore), Arrays.asList(mapping), options);
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"}) 
	public <D>MogwaiQueryResult process(MogwaiProcessor processor, List<D> datastores, List<ModelMapping> mappings, Map<String, Object> options) throws MogwaiQueryException {
		if(processor.accept(this)) {
			return processor.process(this, datastores, mappings, options);
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
