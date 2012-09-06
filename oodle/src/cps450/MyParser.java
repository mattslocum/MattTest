package cps450;

import java.io.IOException;

import com.sun.org.apache.xalan.internal.xsltc.dom.Filter;

import cps450.oodle.lexer.Lexer;
import cps450.oodle.lexer.LexerException;
import cps450.oodle.node.Start;
import cps450.oodle.parser.Parser;
import cps450.oodle.parser.ParserException;

public class MyParser extends Parser{

	public MyParser(Lexer lexer) {
		super(lexer);
		// TODO Auto-generated constructor stub
	}
	
}
