package cps450;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import cps450.oodle.analysis.DepthFirstAdapter;
import cps450.oodle.node.*;

public class CodeGen extends DepthFirstAdapter {
	private PrintWriter writer;

	public CodeGen() throws IOException {
		writer = new PrintWriter(new FileWriter("output.s"));
	}

	void emit(String instr, String operands, String comment) {
		writer.println("\t" + instr + "\t" + operands
				+ ((comment != null) ? "\t;" + comment : ""));
	}

	void emit(String instr, String operands) {
		emit(instr, operands, null);
	}

	void emitComment(String text) {
		writer.println("# " + text);
	}

	void emitDirectiveOrLabel(String text) {
		writer.println(text);
	}

	@Override
	public void outStart(Start node) {
		emit("pushl", "$0");
		emit("call", "exit");
		writer.close();
	}

	@Override
	public void outAIdAExpr(AIdAExpr node) {
		if (!node.getId().getText().equals("out"))
			emit("pushl", node.getId().getText());
	}

	@Override
	public void outAIntAExpr(AIntAExpr node) {
		emit("pushl", "$" + node.getIntlit().getText());
	}

	@Override
	public void outABinAExpr(ABinAExpr node) {
		emitComment("(" + node.getE1().toString() + ") "
				+ node.getAOp().toString() + "(" + node.getE2().toString()
				+ ")");
		emit("popl", "%ebx");
		emit("popl", "%eax");
		PAOp op = node.getAOp();
		if (op instanceof APlusAOp) {
			emit("addl", "%ebx, %eax");
		} else if (op instanceof AMinusAOp) {
			emit("subl", "%ebx, %eax");
		} else if (op instanceof AEqAOp) {
			emit("cmpl", "%ebx, %eax");
			emit("sete", "%al");
			emit("movzbl", "%al, %eax");
		} else if (op instanceof AGtAOp) {
			emit("cmpl", "%ebx, %eax");
			emit("setg", "%al");
			emit("movzbl", "%al, %eax");
		} else if (op instanceof AGteqAOp) {
			emit("cmpl", "%ebx, %eax");
			emit("setge", "%al");
			emit("movzbl", "%al, %eax");
		} else if (op instanceof ALtAOp) {
			emit("cmpl", "%ebx, %eax");
			emit("setl", "%al");
			emit("movzbl", "%al, %eax");
		} else if (op instanceof AMulAOp) {
			emit("imull", "%ebx, %eax");
		} else if (op instanceof ADivAOp) {
			emit("movl", "$0, %edx");
			emit("cltd", "");
			emit("idivl", "%ebx");
		} else if (op instanceof AAndAOp) {
			emit("andl", "%ebx, %eax");
		} else if (op instanceof AOrAOp) {
			emit("orl", "%ebx, %eax");
		}
		emit("pushl", "%eax");
	}

	@Override
	public void outAFalseAExpr(AFalseAExpr node) {
		emit("pushl", "$0");
	}

	@Override
	public void outAAssignAStmt(AAssignAStmt node) {
		emit("popl", node.getId().getText());
	}

	@Override
	public void inAAssignAStmt(AAssignAStmt node) {
		emitComment(node.getId() + ":= (" + node.getAExpr().toString() + ")");
	}

	@Override
	public void outATrueAExpr(ATrueAExpr node) {
		emit("pushl", "$1");
	}

	@Override
	public void inAAMethodDecl(AAMethodDecl node) {
		emitDirectiveOrLabel(".global main");
		emitDirectiveOrLabel("main:");
	}

	@Override
	public void outAAVarDecl(AAVarDecl node) {
		emitDirectiveOrLabel(".comm  " + node.getId().getText() + ", 4, 4");
	}

	@Override
	public void outACallAStmt(ACallAStmt node) {
		emit("call", "writeint"); // writeint is the only function this
									// compiler will ever call
		emit("popl", "%eax"); // remove parameter from stack
	}

	@Override
	public void outANegAExpr(ANegAExpr node) {
		emit("popl", "%eax");
		emit("negl", "%eax");
		emit("pushl", "%eax");
	}

	@Override
	public void outANotAExpr(ANotAExpr node) {
		emit("popl", "%eax");
		emit("cmpl", "$0, %eax");
		emit("sete", "%al");
		emit("movzbl", "%al, %eax");
		emit("pushl", "%eax");
	}

	@Override
	public void caseAIfAStmt(AIfAStmt node) {
		int ifLabel = node.getIf().getLine();
/*		if (node.getIf() != null) {
			node.getIf().apply(this);
		} */
		if (node.getAExpr() != null) {
			node.getAExpr().apply(this);
		}
		emit("popl", "%eax");
		emit("cmpl", "$0, %eax");
		emit("jne", "_doif" + ifLabel);
		emit("jmp", "_else" + ifLabel);
		emitDirectiveOrLabel("_doif" + ifLabel + ":");
		{
			List<PAStmt> copy = new ArrayList<PAStmt>(node.getIfStmt());
			for (PAStmt e : copy) {
				e.apply(this);
			}
		}
		emit("jmp","_endif" + ifLabel);
		emitDirectiveOrLabel("_else" + ifLabel + ":");
		{
			List<PAStmt> copy = new ArrayList<PAStmt>(node.getElseStmt());
			for (PAStmt e : copy) {
				e.apply(this);
			}
		}
		emitDirectiveOrLabel("_endif" + ifLabel + ":");
	}

	@Override
	public void caseALoopAStmt(ALoopAStmt node) {
		int label = node.getWhile().getLine();
        /*if(node.getWhile() != null)
        {
            node.getWhile().apply(this);
        }*/
		emitDirectiveOrLabel("_while" + label + ":");
        if(node.getAExpr() != null)
        {
            node.getAExpr().apply(this);
        }
		emit("popl", "%eax");
		emit("cmpl", "$0, %eax");
		emit("jne", "_dowhile" + label);
		emit("jmp", "_endwhile" + label);
		emitDirectiveOrLabel("_dowhile" + label + ":");
        {
            List<PAStmt> copy = new ArrayList<PAStmt>(node.getAStmt());
            for(PAStmt e : copy)
            {
                e.apply(this);
            }
        }
        emit("pushl", "%eax");
        emit("jmp", "_while" + label);
		emitDirectiveOrLabel("_endwhile" + label + ":");
	}

}
