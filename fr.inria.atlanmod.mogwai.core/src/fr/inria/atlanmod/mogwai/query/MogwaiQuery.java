package fr.inria.atlanmod.mogwai.query;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.processor.MogwaiProcessor;

public abstract class MogwaiQuery {

	private Object rawInput;

	public MogwaiQuery(Object input) {
		this.rawInput = input;
	}

	@SuppressWarnings("rawtypes")
	public MogwaiQueryResult process(MogwaiProcessor<? extends MogwaiQuery> processor, ModelDatastore datastore,
			Map<String, Object> options) throws MogwaiQueryException {
		return process(processor, Arrays.asList(datastore), options);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MogwaiQueryResult process(MogwaiProcessor processor, List<ModelDatastore> datastores,
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
