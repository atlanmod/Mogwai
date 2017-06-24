package fr.inria.atlanmod.mogwai.gremlin.printers;

import org.eclipse.emf.ecore.EObject;

import fr.inria.atlanmod.mogwai.gremlin.AddAllCall;
import fr.inria.atlanmod.mogwai.gremlin.AffectationExpression;
import fr.inria.atlanmod.mogwai.gremlin.AndExpression;
import fr.inria.atlanmod.mogwai.gremlin.BooleanLiteral;
import fr.inria.atlanmod.mogwai.gremlin.Closure;
import fr.inria.atlanmod.mogwai.gremlin.CollectionDefinition;
import fr.inria.atlanmod.mogwai.gremlin.ContainsAllCall;
import fr.inria.atlanmod.mogwai.gremlin.ContainsCall;
import fr.inria.atlanmod.mogwai.gremlin.CountCall;
import fr.inria.atlanmod.mogwai.gremlin.CustomMethodCall;
import fr.inria.atlanmod.mogwai.gremlin.CustomStep;
import fr.inria.atlanmod.mogwai.gremlin.DifferenceExpression;
import fr.inria.atlanmod.mogwai.gremlin.DoubleLiteral;
import fr.inria.atlanmod.mogwai.gremlin.EdgesStep;
import fr.inria.atlanmod.mogwai.gremlin.EqualityExpression;
import fr.inria.atlanmod.mogwai.gremlin.ExceptStep;
import fr.inria.atlanmod.mogwai.gremlin.FillStep;
import fr.inria.atlanmod.mogwai.gremlin.FilterStep;
import fr.inria.atlanmod.mogwai.gremlin.FirstCall;
import fr.inria.atlanmod.mogwai.gremlin.GatherStep;
import fr.inria.atlanmod.mogwai.gremlin.GreaterExpression;
import fr.inria.atlanmod.mogwai.gremlin.GreaterOrEqualExpression;
import fr.inria.atlanmod.mogwai.gremlin.GremlinScript;
import fr.inria.atlanmod.mogwai.gremlin.HasNextCall;
import fr.inria.atlanmod.mogwai.gremlin.IdentityStep;
import fr.inria.atlanmod.mogwai.gremlin.InEStep;
import fr.inria.atlanmod.mogwai.gremlin.InExpression;
import fr.inria.atlanmod.mogwai.gremlin.InVStep;
import fr.inria.atlanmod.mogwai.gremlin.IndexCall;
import fr.inria.atlanmod.mogwai.gremlin.Instruction;
import fr.inria.atlanmod.mogwai.gremlin.IntegerLiteral;
import fr.inria.atlanmod.mogwai.gremlin.IntersectionCall;
import fr.inria.atlanmod.mogwai.gremlin.IsEmptyCall;
import fr.inria.atlanmod.mogwai.gremlin.LeftShiftExpression;
import fr.inria.atlanmod.mogwai.gremlin.LessExpression;
import fr.inria.atlanmod.mogwai.gremlin.LessOrEqualExpression;
import fr.inria.atlanmod.mogwai.gremlin.ListDeclaration;
import fr.inria.atlanmod.mogwai.gremlin.MethodDeclaration;
import fr.inria.atlanmod.mogwai.gremlin.NextCall;
import fr.inria.atlanmod.mogwai.gremlin.NotExpression;
import fr.inria.atlanmod.mogwai.gremlin.NullLiteral;
import fr.inria.atlanmod.mogwai.gremlin.OrExpression;
import fr.inria.atlanmod.mogwai.gremlin.OutEStep;
import fr.inria.atlanmod.mogwai.gremlin.OutVStep;
import fr.inria.atlanmod.mogwai.gremlin.PlusExpression;
import fr.inria.atlanmod.mogwai.gremlin.PropertyStep;
import fr.inria.atlanmod.mogwai.gremlin.RetainAllCall;
import fr.inria.atlanmod.mogwai.gremlin.RetainStep;
import fr.inria.atlanmod.mogwai.gremlin.ReturnStatement;
import fr.inria.atlanmod.mogwai.gremlin.ScatterStep;
import fr.inria.atlanmod.mogwai.gremlin.SetDeclaration;
import fr.inria.atlanmod.mogwai.gremlin.SizeCall;
import fr.inria.atlanmod.mogwai.gremlin.SortedSetDeclaration;
import fr.inria.atlanmod.mogwai.gremlin.StartStep;
import fr.inria.atlanmod.mogwai.gremlin.StringLiteral;
import fr.inria.atlanmod.mogwai.gremlin.TernaryOperator;
import fr.inria.atlanmod.mogwai.gremlin.ToIntegerCall;
import fr.inria.atlanmod.mogwai.gremlin.ToListCall;
import fr.inria.atlanmod.mogwai.gremlin.TransformStep;
import fr.inria.atlanmod.mogwai.gremlin.UnionCall;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;
import fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration;
import fr.inria.atlanmod.mogwai.gremlin.VerticesStep;
import fr.inria.atlanmod.mogwai.gremlin.util.GremlinSwitch;

public class DefaultGremlinPrinter extends GremlinSwitch<String> implements GremlinPrinter {

	@Override
	public String print(EObject eObject) {
		return doSwitch(eObject);
	}

	@Override
	public String caseGremlinScript(GremlinScript o) {
		StringBuffer sb = new StringBuffer();
		for (Instruction i : o.getInstructions()) {
			sb.append(doSwitch(i) + ";\n");
		}
		/*
		 * Handles GremlinStringWrappers that are simple wrappers around a
		 * textual representation of the query.
		 */
		String result = sb.toString();
		if (result.isEmpty()) {
			result = o.toString();
		}
		return result;
	}
	
	@Override
	public String caseReturnStatement(ReturnStatement o) {
		StringBuffer res = new StringBuffer();
		res.append("return ");
		res.append(o.getValue());
		return res.toString();
	}

	@Override
	public String caseMethodDeclaration(MethodDeclaration o) {
		StringBuffer res = new StringBuffer();
		res.append("def ");
		res.append(o.getName());
		res.append("(");
		int gen = 0;
		for (String s : o.getParameters()) {
			res.append(s);
			gen++;
			if (gen < o.getParameters().size()) {
				res.append(", ");
			}
		}
		res.append(") {");
		for (Instruction i : o.getInstructions()) {
			res.append(doSwitch(i)).append(";");
		}
		res.append("}");
		return res.toString();
	}

	@Override
	public String caseListDeclaration(ListDeclaration o) {
		return " List";
	}

	@Override
	public String caseSetDeclaration(SetDeclaration o) {
		return " Set";
	}

	@Override
	public String caseSortedSetDeclaration(SortedSetDeclaration o) {
		return " SortedSet";
	}

	@Override
	public String caseVariableDeclaration(VariableDeclaration o) {
		if (o.getType() != null) {
			if (o.getValue() != null) {
				return doSwitch(o.getType()) + " " + o.getName() + " = " + doSwitch(o.getValue());
			} else {
				return doSwitch(o.getType()) + " " + o.getName();
			}
		} else {
			if (o.getValue() != null) {
				if (o.isFinal()) {
					return "final def " + o.getName() + " = " + doSwitch(o.getValue());
				}
				return "def " + o.getName() + " = " + doSwitch(o.getValue());
			} else {
				return "def " + o.getName();
			}
		}
	}

	@Override
	public String caseCollectionDefinition(CollectionDefinition o) {
		StringBuffer res = new StringBuffer();
		if (o.getType() != null) {
			res.append("(");
		}
		res.append("[");
		int gen = 0;
		for (Instruction i : o.getValues()) {
			res.append(doSwitch(i));
			gen++;
			if (gen < o.getValues().size()) {
				res.append(",");
			}
		}
		res.append("]");
		if (o.getType() != null) {
			res.append(" as ");
			res.append(doSwitch(o.getType()));
			res.append(")");
		}
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseClosure(Closure o) {
		StringBuffer res = new StringBuffer();
		res.append("{");
		for (Instruction i : o.getInstructions()) {
			res.append(doSwitch(i)).append(";");
		}
		res.append("}");
		return res.toString();
	}

	@Override
	public String caseVariableAccess(VariableAccess o) {
		StringBuffer res = new StringBuffer();
		if (o.getCast() != null) {
			res.append("(");
		}
		res.append(o.getName());
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		if (o.getCast() != null) {
			res.append(" as ");
			res.append(doSwitch(o.getCast()));
			res.append(")");
		}
		return res.toString();
	}

	@Override
	public String caseIdentityStep(IdentityStep o) {
		StringBuffer res = new StringBuffer();
		if (o.isNeeded() || o.getNextElement() == null) {
			res.append("_()");
			if (o.getNextElement() != null) {
				res.append(".").append(doSwitch(o.getNextElement()));
			}
		} else {
			res.append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseFillStep(FillStep o) {
		StringBuffer res = new StringBuffer();
		res.append("fill(").append(doSwitch(o.getInstruction())).append(")");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseStartStep(StartStep o) {
		StringBuffer res = new StringBuffer();
		res.append("g");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseVerticesStep(VerticesStep o) {
		StringBuffer res = new StringBuffer();
		if (o.getVertexId() == null) {
			res.append("V");
		} else {
			res.append("v(").append(o.getVertexId()).append(")");
		}
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseEdgesStep(EdgesStep o) {
		StringBuffer result = new StringBuffer();
		result.append(" (relationshipName: ");
		result.append(o.getRelationshipName());
		result.append(')');
		return result.toString();
	}

	@Override
	public String casePropertyStep(PropertyStep o) {
		StringBuffer res = new StringBuffer();
		res.append("property('");
		res.append(o.getName());
		if (o.getValue() != null) {
			res.append(",");
			res.append(doSwitch(o.getValue()));
		}
		res.append("')");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseOutEStep(OutEStep o) {
		StringBuffer res = new StringBuffer();
		res.append("outE");
		if (o.getRelationshipName() != null) {
			res.append("(\"").append(o.getRelationshipName()).append("\")");
		}
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseInEStep(InEStep o) {
		StringBuffer res = new StringBuffer();
		res.append("inE");
		if (o.getRelationshipName() != null) {
			res.append("(\"" + o.getRelationshipName() + "\")");
		}
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseInVStep(InVStep o) {
		StringBuffer res = new StringBuffer();
		res.append("inV");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseOutVStep(OutVStep o) {
		StringBuffer res = new StringBuffer();
		res.append("outV");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseFilterStep(FilterStep o) {
		StringBuffer res = new StringBuffer();
		res.append("filter");
		res.append(doSwitch(o.getClosure()));
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseRetainStep(RetainStep o) {
		StringBuffer res = new StringBuffer();
		res.append("retain(");
		res.append(doSwitch(o.getCollection()));
		res.append(")");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseExceptStep(ExceptStep o) {
		StringBuffer res = new StringBuffer();
		res.append("except(");
		res.append(doSwitch(o.getCollection()));
		res.append(")");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseTransformStep(TransformStep o) {
		StringBuffer res = new StringBuffer();
		res.append("transform");
		res.append(doSwitch(o.getClosure()));
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseGatherStep(GatherStep o) {
		StringBuffer res = new StringBuffer();
		res.append("gather");
		if (o.getClosure() != null) {
			res.append(doSwitch(o.getClosure()));
		}
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseScatterStep(ScatterStep o) {
		StringBuffer res = new StringBuffer();
		res.append("scatter");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseCustomMethodCall(CustomMethodCall o) {
		StringBuffer res = new StringBuffer();
		res.append(o.getName());
		res.append("(");
		if (!o.getParams().isEmpty()) {
			String delim = "";
			for (EObject p : o.getParams()) {
				res.append(delim).append(doSwitch(p));
				delim = ",";
			}
		}
		res.append(")");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseNextCall(NextCall o) {
		StringBuffer res = new StringBuffer();
		res.append("next()");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseHasNextCall(HasNextCall o) {
		StringBuffer res = new StringBuffer();
		res.append("hasNext()");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseIndexCall(IndexCall o) {
		StringBuffer res = new StringBuffer();
		res.append("getIndex(\"" + o.getIndexName() + "\",Vertex.class)[[" + o.getIndexProperty() + ":\""
				+ o.getIndexQuery() + "\"]]");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseCountCall(CountCall o) {
		StringBuffer res = new StringBuffer();
		res.append("count()");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseFirstCall(FirstCall o) {
		StringBuffer res = new StringBuffer();
		res.append("first()");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseToListCall(ToListCall o) {
		StringBuffer res = new StringBuffer();
		res.append("toList()");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseIsEmptyCall(IsEmptyCall o) {
		StringBuffer res = new StringBuffer();
		res.append("isEmpty()");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseContainsCall(ContainsCall o) {
		StringBuffer res = new StringBuffer();
		res.append("contains(");
		res.append(doSwitch(o.getValue()) + ")");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseContainsAllCall(ContainsAllCall o) {
		StringBuffer res = new StringBuffer();
		res.append("containsAll(");
		res.append(doSwitch(o.getValue()) + ")");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseAddAllCall(AddAllCall o) {
		StringBuffer res = new StringBuffer();
		res.append("addAll(");
		res.append(doSwitch(o.getValue()) + ")");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseRetainAllCall(RetainAllCall o) {
		StringBuffer res = new StringBuffer();
		res.append("retainAll(");
		res.append(doSwitch(o.getValue()) + ")");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseUnionCall(UnionCall o) {
		StringBuffer res = new StringBuffer();
		if (o.getCast() != null) {
			res.append("(");
		}
		res.append("computeUnion(");
		res.append(doSwitch(o.getLeftCollection()));
		res.append(", ");
		res.append(doSwitch(o.getRightCollection()));
		res.append(")");
		if (o.getCast() != null) {
			res.append(" as " + doSwitch(o.getCast()));
			res.append(")");
		}
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseIntersectionCall(IntersectionCall o) {
		StringBuffer res = new StringBuffer();
		if (o.getCast() != null) {
			res.append("(");
		}
		res.append("computeIntersection(");
		res.append(doSwitch(o.getLeftCollection()));
		res.append(", ");
		res.append(doSwitch(o.getRightCollection()));
		res.append(")");
		if (o.getCast() != null) {
			res.append(" as " + doSwitch(o.getCast()));
			res.append(")");
		}
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseSizeCall(SizeCall o) {
		StringBuffer res = new StringBuffer();
		res.append("size()");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String caseNotExpression(NotExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(" !( ").append(doSwitch(o.getExp())).append(")");
		return res.toString();
	}

	@Override
	public String caseEqualityExpression(EqualityExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" == ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseInExpression(InExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" in ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseDifferenceExpression(DifferenceExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" != ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseOrExpression(OrExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" || ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseAndExpression(AndExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" && ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseGreaterExpression(GreaterExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" > ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseGreaterOrEqualExpression(GreaterOrEqualExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" >= ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseLessExpression(LessExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" < ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseLessOrEqualExpression(LessOrEqualExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" <= ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseAffectationExpression(AffectationExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" = ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseLeftShiftExpression(LeftShiftExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" << ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseTernaryOperator(TernaryOperator o) {
		StringBuffer res = new StringBuffer();
		res.append("(");
		res.append(doSwitch(o.getCondition())).append(" ? ").append(doSwitch(o.getIfTrue())).append(" : ")
				.append(doSwitch(o.getIfFalse())).append(")");
		return res.toString();
	}

	@Override
	public String caseStringLiteral(StringLiteral o) {
		StringBuffer res = new StringBuffer();
		res.append("\"").append(o.getValue()).append("\"");
		return res.toString();
	}

	@Override
	public String caseIntegerLiteral(IntegerLiteral o) {
		return Integer.toString(o.getValue());
	}

	@Override
	public String caseDoubleLiteral(DoubleLiteral o) {
		return Double.toString(o.getValue());
	}

	@Override
	public String caseBooleanLiteral(BooleanLiteral o) {
		return Boolean.toString(o.isValue());
	}

	@Override
	public String caseNullLiteral(NullLiteral o) {
		StringBuffer res = new StringBuffer();
		res.append("null");
		return res.toString();
	}

	@Override
	public String caseToIntegerCall(ToIntegerCall o) {
		StringBuffer res = new StringBuffer();
		res.append("toInteger()");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}

	@Override
	public String casePlusExpression(PlusExpression o) {
		StringBuffer res = new StringBuffer();
		res.append(doSwitch(o.getLeft())).append(" + ").append(doSwitch(o.getRight()));
		return res.toString();
	}

	@Override
	public String caseCustomStep(CustomStep o) {
		StringBuffer res = new StringBuffer();
		res.append(o.getName());
		res.append("(");
		if (!o.getParams().isEmpty()) {
			String delim = "";
			for (EObject p : o.getParams()) {
				res.append(delim).append(doSwitch(p));
				delim = ",";
			}
		}
		res.append(")");
		if (o.getNextElement() != null) {
			res.append(".").append(doSwitch(o.getNextElement()));
		}
		return res.toString();
	}
}
