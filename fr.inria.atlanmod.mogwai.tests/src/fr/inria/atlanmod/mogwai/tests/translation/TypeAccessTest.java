package fr.inria.atlanmod.mogwai.tests.translation;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import fr.inria.atlanmod.mogwai.gremlin.IndexCall;
import fr.inria.atlanmod.mogwai.gremlin.Instruction;
import fr.inria.atlanmod.mogwai.gremlin.NextCall;
import fr.inria.atlanmod.mogwai.gremlin.StartPipe;
import fr.inria.atlanmod.mogwai.gremlin.VariableAccess;
import fr.inria.atlanmod.mogwai.gremlin.VariableDeclaration;

public class TypeAccessTest extends MogwaiTranslationTest {
	
	/**
	 * Check the translation of TypeAccess to Gremlin steps
	 * A TypeAccess generates 3 instructions following those patterns:
	 * 	- A variable declaration to store the result of the corresponding index query
	 * 		- <b>def meta<ClassName> = g.idx("metaclasses")[[name:"<ClassName>"]];</b>
	 * 	- A variable declaration to store the node containing the meta class
	 * 		- <b>def meta<ClassName>Node = meta<ClassName>.next();</b>
	 * 	- A variable access that return the node containing the meta class
	 * 		- <b>meta<ClassName>Node.[next steps]</b>
	 */
	@Test
	public void test() {
		assert gScript.getInstructions().size() == 3;
		// 1st Instruction
		EList<Instruction> gScriptInstructions = gScript.getInstructions();
		assert gScriptInstructions.get(0) instanceof VariableDeclaration;
		VariableDeclaration vd1 = (VariableDeclaration)gScriptInstructions.get(0);
		assert vd1.getName().equals("metaPackage");
		assert vd1.getValue() instanceof StartPipe;
		StartPipe sp1 = (StartPipe)vd1.getValue();
		assert sp1.getNextElement() instanceof IndexCall;
		IndexCall idxCall1 = (IndexCall)sp1.getNextElement();
		assert idxCall1.getIndexName().equals("metaclasses");
		assert idxCall1.getIndexProperty().equals("name");
		assert idxCall1.getIndexQuery().equals("Package");
		assert idxCall1.getNextElement() == null;
		// 2nd Instruction
		assert gScriptInstructions.get(1) instanceof VariableDeclaration;
		VariableDeclaration vd2 = (VariableDeclaration)gScriptInstructions.get(1);
		assert vd2.getName().equals("metaPackageNode");
		assert vd2.getValue() instanceof VariableAccess;
		VariableAccess va2 = (VariableAccess)vd2.getValue();
		assert va2.getName().equals("metaPackage");
		assert va2.getNextElement() instanceof NextCall;
		NextCall nc2 = (NextCall)va2.getNextElement();
		assert nc2.getNextElement() == null;
		// 3rd Instruction
		assert gScriptInstructions.get(2) instanceof VariableAccess;
		VariableAccess va3 = (VariableAccess)gScriptInstructions.get(2);
		assert va3.getName().equals("metaPackageNode");
		assert va3.getNextElement() == null;
	}

}
