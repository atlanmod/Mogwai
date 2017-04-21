package fr.inria.atlanmod.mogwai.query;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.processor.AbstractMogwaiProcessor;

public abstract class MogwaiQuery {

	private Object rawInput;

	public MogwaiQuery(Object input) {
		this.rawInput = input;
	}

	@SuppressWarnings("rawtypes")
	public MogwaiQueryResult process(AbstractMogwaiProcessor<? extends MogwaiQuery> processor, ModelDatastore datastore,
			Map<String, Object> options) throws MogwaiQueryException {
		return process(processor, Arrays.asList(datastore), options);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MogwaiQueryResult process(AbstractMogwaiProcessor processor, List<ModelDatastore> datastores,
			Map<String, Object> options) throws MogwaiQueryException {
		if (processor.accept(this)) {
			return processor.process(this, datastores, options);
		} else {
			throw new MogwaiQueryException("Processor " + processor.getName() + " cannot compute " + this.toString());
		}
	}

	public Object getRawInput() {
		return rawInput;
	}

	public abstract String getInput();

}
