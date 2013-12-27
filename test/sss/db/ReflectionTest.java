package sss.db;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionTest {


	/**
	 * 오픈소스 자바 파서
	 * 참조 :  http://code.google.com/p/javaparser/
	 * @throws ParseException
	 * @throws IOException
	 */
	@Test
	public void javaparserTest() throws ParseException, IOException {

		String path = "C:/Labs/KEB/webapps/ng2g/WEB-INF/src/ng2g/dp/dp00/dao";

		FileInputStream in = new FileInputStream(new File(path, "DP0001_DAO.java"));

		CompilationUnit compilationUnit;

		try {
			compilationUnit =  JavaParser.parse(in);
		}
		finally {
			in.close();
		}

//		System.out.println(compilationUnit.toString());

		new MethodVisitor().visit(compilationUnit, null);

	}

	    private static class MethodVisitor extends VoidVisitorAdapter {

	        @Override
	        public void visit(MethodDeclaration n, Object arg) {
	            // here you can access the attributes of the method.
	            // this method will be called for all methods in this
	            // CompilationUnit, including inner class methods
	            System.out.println(n.getName());
	            System.out.println(n.getBody());
	        }
	    }


	public void reflectionTest() throws Exception {

		Class class1 = getClass();
		Method [] methods = class1.getMethods();

		for (Method method : methods) {
			System.out.println(method.getName());
			System.out.println(method.toGenericString());
		}

	}
}
