package cps450;

import java.io.IOException;
import java.io.PushbackReader;

import cps450.oodle.lexer.Lexer;
import cps450.oodle.lexer.LexerException;
import cps450.oodle.node.*;

public class MyLexer extends Lexer{
	
	private String file = "";
	private boolean ds;


	public MyLexer(PushbackReader in, boolean print, String filename) {
		super(in);
		file = filename;
		ds = print;
	}
	
    protected void filter() throws LexerException, IOException
    {
    	boolean quote = true;
    	String error = "";
       	if (token instanceof TComment || token instanceof TBlank) {
    		token = null;
    	}
    	if (token instanceof TEol) {
    		token.setText("cr"); 		// I am not sure this is a good idea
    		quote = false;
    	}
    	if (token instanceof TErrIllChar) {
			error = "Unrecognized char:";
    	} else if (token instanceof TErrIllStr) {
    		error = "Illegal string:";
    	} else if (token instanceof TErrUntermStr) {
			error = "Unterminated string:";
		}
        if (token != null && ds && !(token instanceof EOF)) {
        	System.out.print(file + ":" + token.getLine() + ":" + token.getPos() + ":");
        	if (token instanceof TBoolean ||
    			token instanceof TBegin ||
    			token instanceof TClassKw ||
    			token instanceof TElse ||
    			token instanceof TEnd ||
    			token instanceof TFalse ||
    			token instanceof TFrom ||
    			token instanceof TIf ||
    			token instanceof TInherits ||
    			token instanceof TInt ||
    			token instanceof TIs ||
    			token instanceof TLoop ||
    			token instanceof TMe ||
    			token instanceof TNew ||
    			token instanceof TNot ||
    			token instanceof TNull ||
    			token instanceof TString ||
    			token instanceof TThen ||
    			token instanceof TTrue ||
    			token instanceof TWhile) {
        			System.out.print("keyword:"); 
            		quote = false;
        	} else if (token instanceof TId) {
        		System.out.print("identifier:");
        		quote = false;
        	} else if (token instanceof TStrlit) {
        		System.out.print("string lit:");
        		quote = false;
        	}else if (token instanceof TConcatOp ||
        			token instanceof TPlusOp ||
        			token instanceof TMinusOp ||
        			token instanceof TMultOp ||
        			token instanceof TDivOp ||
        			token instanceof TLtOp ||
        			token instanceof TGtOp ||
        			token instanceof TEqOp ||
        			token instanceof TGteqOp ||
        			token instanceof TBang) {
        		System.out.print("operator:'");
        		quote = true;
        	} else if (quote && error.equals("")){
            	System.out.print("'");
        	}
            System.out.print(error + token.getText());
            if (quote && error.equals("")) {
            	System.out.print("'");
            }
            System.out.println();

        } else if (!error.equals("")) {
        	LexerException ex = new LexerException(file + ":" + token.getLine() + ":" + token.getPos() + ":" + error + token.getText());
        	
        	throw ex;
        	//System.out.println(file + ":" + token.getLine() + ":" + token.getPos() + ":" + error + token.getText());
        }
    }


}
