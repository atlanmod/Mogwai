package fr.inria.atlanmod.mogwai.transformation.atl.helper;

import fr.inria.atlanmod.mogwai.datastore.ModelDatastore;

public class DelegateATLTransformationHelper<ES, ET> extends AbstractATLTransformationHelper<ES, ET> {

	public DelegateATLTransformationHelper(ModelDatastore<?, ES, ?, ?> sourceDatastore,
			ModelDatastore<?, ET, ?, ?> targetDatastore) {
		super(sourceDatastore, targetDatastore);
	}
	
	@Override
	public ET createElement(ES source, String targetLabel, String metaclassType, String nsURI, String resourceName) {
		return targetDatastore.newInstance(metaclassType, nsURI, resourceName);
	}
	
	@Override
	protected void createProxyLink(ET from, ES to, String label, String oppositeLabel, boolean isContainment) {
		
	}
	
	@Override
	public void resolveProxies(ES sourceProxy, ET targetElement) {
		
	}
	
	@Override
	public boolean isResolvable(ES sourceProxy) {
		return false;
	}
	
	@Override
	public ET resolve(ES sourceProxy) {
		return null;
	}
}
