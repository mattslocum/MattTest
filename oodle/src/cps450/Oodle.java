// Oodle.java
// 2nd comment line

package cps450;

import cps450.oodle.node.*;
import cps450.oodle.parser.Parser;
import cps450.oodle.parser.ParserException;

import cps450.oodle.lexer.*;
import java.io.*;

import semantics.SemanticChecker;

public class Oodle {
	private static final String TEMPFILE = "temp.ood";

	public static void main(String[] arguments) throws IOException {
		if (arguments.length < 1) {
			System.out.println("usage:");
			System.out.println("  java Oodle [-ds] filename(s)");
			System.exit(1);
		}
		
    	boolean ds = false;
    	if (arguments[0].equals("-ds")) {
    		ds = true;
    	}
		String srcFile = loadSource(arguments, ds);

		int errors = 0;
		try {
			Parser parser = new MyParser(new MyLexer(new PushbackReader(
					new BufferedReader(new FileReader(srcFile)), 1024),ds,TEMPFILE));

			Start node = parser.parse();
			
	        SemanticChecker checker = new SemanticChecker();
	        node.apply(checker);
	        
	        if (checker.getErrorCount() == 0) {
	        	// generate assembly
	            CodeGen codegen = new CodeGen();
	            node.apply(codegen);
	        }

		} catch (Exception ex) {
			if (ex instanceof ParserException) {
				String err = ex.getMessage();
				System.out.println(TEMPFILE + ":"
						+ err.substring(1, err.indexOf(',')) + ":"
						+ err.substring(err.indexOf(',') + 1, err.indexOf(']'))
						+ ":error " + err.substring(err.indexOf(']') + 2));
				++errors;
			} else if (ex instanceof LexerException) {
				System.out.println(ex.getMessage());
				++errors;
			} else {
				System.out.println(ex.toString());
			}
		}

		if (errors > 0) {
			System.out.println("\n" + errors + " error(s) found");
		}

	}

	static Token getNextToken(Lexer l) throws IOException {
		Token t = null;
		try {
			t = l.next();
		} catch (LexerException e) {
			System.out.println(e);

		}
		return t;
	}

	/**
	 * If <arguments> contains only one filename, returns it Otherwise, creates
	 * a temporary file containing the contents of each file in <arguments>, and
	 * returns its name
	 * 
	 * @param arguments
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String loadSource(String[] arguments, boolean ds) throws IOException {

		if (!ds && arguments.length == 1) {
			return arguments[0];
		} else if (ds && arguments.length == 2) {
			return arguments[1];
		} else {

			FileWriter fw = new FileWriter(TEMPFILE);
			try {
				for (int i = (ds ? 1 : 0); i < arguments.length; i++) {
					File f = new File(arguments[i]);
					char data[] = new char[(int) f.length()];
					FileReader fr = new FileReader(f);
					fr.read(data);
					fr.close();
					fw.write(data);
				}
			} finally {
				fw.close();
			}
			return TEMPFILE;
		}

	}

}
