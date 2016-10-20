package fr.inria.atlanmod.mogwai.tests.inline;

import java.io.IOException;

import org.junit.Test;

public class AllInstancesTest extends MogwaiInlineTest {
	
	@Override
	public void setUp() throws IOException {
		this.inlineOCL = "ClassDeclaration.allInstances()";
		this.context = jPackage.getClassDeclaration();
		super.setUp();
	}
	
	@Test
	public void test() {
		
	}

}
