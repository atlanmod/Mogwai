package fr.inria.atlanmod.mogwai.query;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;
import fr.inria.atlanmod.mogwai.processor.AbstractQueryProcessor;

public abstract class MogwaiQuery {

	private Object rawInput;

	public MogwaiQuery(Object input) {
		this.rawInput = input;
	}

	@SuppressWarnings("rawtypes")
	public QueryResult process(AbstractQueryProcessor<? extends MogwaiQuery> processor, ModelDatastore datastore,
			Map<String, Object> options) throws QueryException {
		return process(processor, Arrays.asList(datastore), options);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public QueryResult process(AbstractQueryProcessor processor, List<ModelDatastore> datastores,
			Map<String, Object> options) throws QueryException {
		if (processor.accept(this)) {
			return processor.process(this, datastores, options);
		} else {
			throw new QueryException("Processor " + processor.getName() + " cannot compute " + this.toString());
		}
	}

	public Object getRawInput() {
		return rawInput;
	}

	public abstract String getInput();

}
