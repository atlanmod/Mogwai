package fr.inria.atlanmod.mogwai.processor;

import com.sun.istack.internal.Nullable;

import fr.inria.atlanmod.mogwai.query.MogwaiQuery;
import fr.inria.atlanmod.mogwai.query.MogwaiQueryResult;
import fr.inria.atlanmod.mogwai.resources.MogwaiResource;
import static com.google.common.base.Preconditions.checkNotNull;

public abstract class MogwaiProcessor<Q extends MogwaiQuery> {
	
	public abstract String getName();
	
//	public void bindResource(MogwaiResource resource) {
//		checkNotNull(resource, "Cannot bind null resource");
//		this.resource = resource;
//	}
	
	public MogwaiQueryResult process(Q query, @Nullable Object arg) {
//		checkNotNull(resource,
//				"Cannot process query %s, please bind a resource first",
//				query.toString());
		return internalProcess(query, arg);
	}
	
	public abstract MogwaiQueryResult internalProcess(Q query, @Nullable Object arg);
	
	public abstract boolean accept(MogwaiQuery query);
	
}
