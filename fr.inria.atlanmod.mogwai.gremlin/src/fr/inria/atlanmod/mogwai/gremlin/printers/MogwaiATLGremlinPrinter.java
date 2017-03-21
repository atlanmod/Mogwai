package fr.inria.atlanmod.mogwai.gremlin.printers;

import org.eclipse.emf.ecore.EObject;

import fr.inria.atlanmod.mogwai.gremlin.Closure;
import fr.inria.atlanmod.mogwai.gremlin.CustomStep;
import fr.inria.atlanmod.mogwai.gremlin.FilterStep;
import fr.inria.atlanmod.mogwai.gremlin.Instruction;
import fr.inria.atlanmod.mogwai.gremlin.TransformStep;

public class MogwaiATLGremlinPrinter extends DefaultGremlinPrinter {

	private int padding = 0;
	
	@Override
	public String caseTransformStep(TransformStep o) {
		if(isRuleTransform(o)) {
			StringBuffer res = new StringBuffer();
			res.append("transform\n");
			res.append(doSwitch(o.getClosure()));
			if(o.getNextElement() != null) {
				res.append(".").append(doSwitch(o.getNextElement()));
			}
			return res.toString();
		}
		else {
			return super.caseTransformStep(o);
		}
	}
	
	@Override
	public String caseClosure(Closure o) {
		StringBuffer res = new StringBuffer();
		pad(res).append("{\n");
		padding++;
		for(Instruction i : o.getInstructions()) {
			pad(res).append(doSwitch(i)).append(";\n");
		}
		padding--;
		pad(res).append("}");
		return res.toString();
	}
	
	private boolean isRuleTransform(TransformStep o) {
		EObject parent = o.eContainer();
		if(parent instanceof CustomStep) {
			CustomStep cs = (CustomStep)parent;
			return cs.getName().equals("allOfType");
		}
		else if(parent instanceof FilterStep) {
			if(parent.eContainer() instanceof CustomStep) {
				return ((CustomStep)parent.eContainer()).getName().equals("allOfType");
			}
		}
		return false;
	}
	
	private StringBuffer pad(StringBuffer sb) {
		for(int i = 0; i < padding; i++) {
			sb.append("\t");
		}
		return sb;
	}
	
}
