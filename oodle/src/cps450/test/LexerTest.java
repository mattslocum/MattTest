package cps450.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;

import cps450.oodle.lexer.Lexer;
import cps450.oodle.lexer.LexerException;
import cps450.oodle.node.*;

import junit.framework.TestCase;


public class LexerTest extends TestCase {
	Lexer lex;

	public void testSuccessfulScan() throws IOException, LexerException {
		lex = new Lexer(new PushbackReader(new InputStreamReader(getClass().getResourceAsStream(
				"lexertest.ood"))));

		assertNextToken(TComment.class);
		// Tokens
		assertNextToken(TEol.class);
		assertNextToken(TBoolean.class);
		assertNextToken(TEol.class);
		assertNextToken(TBegin.class);
		assertNextToken(TEol.class);
		assertNextToken(TClassKw.class);
		assertNextToken(TEol.class);
		assertNextToken(TElse.class);
		assertNextToken(TEol.class);
		assertNextToken(TEnd.class);
		assertNextToken(TEol.class);
		assertNextToken(TFalse.class);
		assertNextToken(TEol.class);
		assertNextToken(TFrom.class);
		assertNextToken(TEol.class);
		assertNextToken(TIf.class);
		assertNextToken(TEol.class);
		assertNextToken(TInherits.class);
		assertNextToken(TEol.class);
		assertNextToken(TInt.class);
		assertNextToken(TEol.class);
		assertNextToken(TIs.class);
		assertNextToken(TEol.class);
		assertNextToken(TLoop.class);
		assertNextToken(TEol.class);
		assertNextToken(TMe.class);
		assertNextToken(TEol.class);
		assertNextToken(TNew.class);
		assertNextToken(TEol.class);
		assertNextToken(TNot.class);
		assertNextToken(TEol.class);
		assertNextToken(TNull.class);
		assertNextToken(TEol.class);
		assertNextToken(TString.class);
		assertNextToken(TEol.class);
		assertNextToken(TThen.class);
		assertNextToken(TEol.class);
		assertNextToken(TTrue.class);
		assertNextToken(TEol.class);
		assertNextToken(TWhile.class);
		assertNextToken(TEol.class);
		assertNextToken(TEol.class);
		//comparison operators
		assertNextToken(TLtOp.class);
		assertNextToken(TEol.class);
		assertNextToken(TGtOp.class);
		assertNextToken(TEol.class);
		assertNextToken(TEqOp.class);
		assertNextToken(TEol.class);
		assertNextToken(TGteqOp.class);
		assertNextToken(TEol.class);
		assertNextToken(TEol.class);
		// operators
		assertNextToken(TConcatOp.class);
		assertNextToken(TEol.class);
		assertNextToken(TPlusOp.class);
		assertNextToken(TEol.class);
		assertNextToken(TMinusOp.class);
		assertNextToken(TEol.class);
		assertNextToken(TMultOp.class);
		assertNextToken(TEol.class);
		assertNextToken(TDivOp.class);
		assertNextToken(TEol.class);
		assertNextToken(TEol.class);
		// misc
		assertNextToken(TAsignOp.class);
		assertNextToken(TLPar.class);
		assertNextToken(TRPar.class);
		assertNextToken(TLBar.class);
		assertNextToken(TRBar.class);
		assertNextToken(TBang.class);
		assertNextToken(TBlank.class);
		assertNextToken(TComma.class);
		assertNextToken(TSemicolon.class);
		assertNextToken(TColon.class);
		assertNextToken(TPeriod.class);
		assertNextToken(TEol.class);
		assertNextToken(TEol.class);
		// id
		assertNextToken(TId.class);
		assertNextToken(TEol.class);
		assertNextToken(TId.class);
		assertNextToken(TEol.class);
		assertNextToken(TEol.class);
		// int lit
		assertNextToken(TIntlit.class);
		assertNextToken(TEol.class);
		assertNextToken(TIntlit.class);
		assertNextToken(TEol.class);
		assertNextToken(TIntlit.class);
		assertNextToken(TEol.class);
		assertNextToken(TEol.class);
		// string lit
		assertNextToken(TStrlit.class);
		assertNextToken(TEol.class);
		assertNextToken(TStrlit.class);
		assertNextToken(TEol.class);
		assertNextToken(TStrlit.class);
		assertNextToken(TEol.class);
		assertNextToken(TErrUntermStr.class);
		assertNextToken(TEol.class);
		assertNextToken(TErrIllStr.class);
		assertNextToken(TEol.class);
		assertNextToken(TErrIllChar.class);
		assertNextToken(TEol.class);
		// end of file
		assertNextToken(EOF.class);

	}

	private void assertNextToken(Class type, String value) throws LexerException, IOException {
		Token tok = lex.next();
		System.err.println(tok);
		assertTrue(tok.getClass() == type);
		assertTrue(tok.getText().equals(value));
		
	}

	private void assertNextToken(Class type) throws LexerException, IOException {
		Token tok = lex.next();
		System.err.println(tok);
		assertTrue(tok.getClass() == type);	
	}
}
