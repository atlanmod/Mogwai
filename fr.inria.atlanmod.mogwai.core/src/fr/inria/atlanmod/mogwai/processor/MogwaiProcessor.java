package fr.inria.atlanmod.mogwai.processor;

import com.sun.istack.internal.Nullable;

import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;

public abstract class MogwaiProcessor<Q extends MogwaiQuery> {
	
	public abstract String getName();
	
	public MogwaiQueryResult process(Q query, @Nullable Object arg) {
		return internalProcess(query, arg);
	}
	
	public abstract MogwaiQueryResult internalProcess(Q query, @Nullable Object arg);
	
	public abstract boolean accept(MogwaiQuery query);
	
}
