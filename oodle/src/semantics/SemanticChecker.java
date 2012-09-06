package semantics;

import java.util.HashMap;
import java.util.LinkedList;

import cps450.Globals;
import cps450.oodle.analysis.DepthFirstAdapter;
import cps450.oodle.node.*;


public class SemanticChecker extends DepthFirstAdapter {
	private SymbolTable symtab = Globals.symtab;
	private HashMap<Node, Type> typeMap = new HashMap<Node, Type>();
	private int errorCount = 0;
	
	private void reportError(String msg, int line) {
		System.err.println(line + ":" + msg);
		++errorCount;
	}
	
	public int getErrorCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Type typeFromNode(PAType node) {
		if (node instanceof AIntAType) {
			return Type.INT;
		} else if (node instanceof ABooleanAType) {
			return Type.BOOLEAN;
		} else if (node instanceof AStringAType) {
			reportError("Feature Unsupported: String", ((AStringAType)node).getString().getLine());
			return Type.ERROR;
		} else {
			return Type.ERROR;
		}
	}
	
	private int getLine(PAOp op) {
		if (op instanceof APlusAOp) {
			return ((APlusAOp)op).getPlusOp().getLine();
		} else if (op instanceof AMinusAOp) {
			return ((AMinusAOp)op).getMinusOp().getLine();
		} else if (op instanceof AGtAOp) {
			return ((AGtAOp)op).getGtOp().getLine();
		} else if (op instanceof AGteqAOp) {
			return ((AGteqAOp)op).getGteqOp().getLine();
		} else if (op instanceof AEqAOp) {
			return ((AEqAOp)op).getEqOp().getLine();
		} else if (op instanceof AOrAOp) {
			return ((AOrAOp)op).getOr().getLine();
		} else if (op instanceof AAndAOp) {
			return ((AAndAOp)op).getAnd().getLine();
		} else if (op instanceof ALtAOp) {
			return ((ALtAOp)op).getLtOp().getLine();
		} else if (op instanceof AConcatAOp) {
			return ((AConcatAOp)op).getConcatOp().getLine();
		} else if (op instanceof AMulAOp) {
			return ((AMulAOp)op).getMultOp().getLine();
		} else if (op instanceof ADivAOp) {
			return ((ADivAOp)op).getDivOp().getLine();
		} else {
			throw new RuntimeException("Unexpected operator: " + op);
		}
	}

	
	@Override
	public void inAAVarDecl(AAVarDecl node) {
		String id = node.getId().getText();
		Symbol s = symtab.lookup(id);
		if (s == null || (s != null && symtab.getScope(id) != symtab.getScope())) {
			if (node.getAType() == null) {
				reportError("Undefined Type: " + id, node.getId().getLine());
			}
			symtab.push(id, new VarDecl(typeFromNode(node.getAType())));
		} else {
			reportError("Redefined variable: " + id, node.getId().getLine());
		}
		if (symtab.getScope() == 0 && node.getAExpr() != null) {
			reportError("Feature Unsupported: attribute init " + id, node.getId().getLine());			
		}

	}

	@Override
	public void inAAMethodDecl(AAMethodDecl node) {
		String startid = node.getStartId().getText();
		String endid = node.getEndId().getText();
		if (!startid.equals(endid)) {
			reportError("Class name does not match end name: "+ startid + ", "+ endid, node.getStartId().getLine());
		}
		Symbol s = symtab.lookup(startid);
		if (s == null && !startid.equals("readint") && !startid.equals("writeint")) {
			symtab.push(startid, new VarDecl(typeFromNode(node.getAType())));
			symtab.beginScope();
		} else {
			reportError("Redefined method: " + startid, node.getStartId().getLine());
		}
	}

	@Override
	public void outAAMethodDecl(AAMethodDecl node) {
		symtab.endScope();
	}

	@Override
	public void inAAArgDecl(AAArgDecl node) {
		String id = node.getId().getText();
		Symbol s = symtab.lookup(id);
		if (s == null || (s != null && symtab.getScope(id) != symtab.getScope())) {
			symtab.push(id, new VarDecl(typeFromNode(node.getAType())));
		} else {
			reportError("Redefined variable: " + id, node.getId().getLine());
		}	
	}

	@Override
	public void outAAClassDef(AAClassDef node) {
		String startid = node.getStartId().getText();
		String endid = node.getEndId().getText();
		if (!startid.equals(endid)) {
			reportError("Class name does not match end name: "+ startid + ", "+ endid, node.getStartId().getLine());
		}
	}

	@Override
	public void outAAssignAStmt(AAssignAStmt node) {
		String id = node.getId().getText();
		Symbol sym = symtab.lookup(id);
		if (sym == null) {
			reportError("Undeclared variable: " + id, node.getId().getLine());
			return;
		}
		
		Type lhsType = sym.decl.type;
		Type rhsType = typeMap.get(node.getAExpr());
		if (lhsType != rhsType) {
			reportError("The type of the left-hand side (" + lhsType + ") is not compatible with the type of the right-hand side (" + rhsType + ").", node.getId().getLine());
		}
	}
	
	@Override
	public void outAIdAExpr(AIdAExpr node) {
		Type result = Type.ERROR;
		String id = node.getId().getText();
		Symbol s = symtab.lookup(id);
		if (s == null) {
			reportError("Undefined variable: " + id, node.getId().getLine());
		} else {
			result = s.decl.type;
		}
		typeMap.put(node, result);
	}

	@Override
	public void inACallAExpr(ACallAExpr node) {
		String id = node.getId().getText();
		Symbol s = symtab.lookup(id);
		LinkedList<PAExpr> args = node.getList();
		if (id.equals("readint")) {
			if (args.size() > 0) {
				reportError("Expected 0 parameters in call to readint(); received " 
						+ args.size(), node.getId().getLine());
			}
		} else if (id.equals("writeint")) {
			if (args.size() != 1) {
				reportError("Expected 1 parameters in call to readint(); received " 
						+ args.size(), node.getId().getLine());
			}
		} else if (s == null) {
			reportError("Undeclared Method: " + id + "()", node.getId().getLine());			
		}
	}

	@Override
	public void inACallAStmt(ACallAStmt node) {
		String id = node.getId().getText();
		Symbol s = symtab.lookup(id);
		LinkedList<PAExpr> args = node.getList();
		if (id.equals("readint")) {
			if (args.size() > 0) {
				reportError("Expected 0 parameters in call to readint(); received " 
						+ args.size(), node.getId().getLine());
			}
		} else if (id.equals("writeint")) {
			if (args.size() != 1) {
				reportError("Expected 1 parameters in call to readint(); received " 
						+ args.size(), node.getId().getLine());
			}
		} else if (s == null) {
			reportError("Undeclared Method: " + id + "()", node.getId().getLine());			
		}
	}

	@Override
	public void outACallAExpr(ACallAExpr node) {
		Type result = Type.ERROR;
		String id = node.getId().getText();
		Symbol s = symtab.lookup(node.getId().getText());
		if (id.equals("readint")) {
			result = Type.INT;
		} else if (id.equals("writeint")) {
			result = Type.NULL;
		} else if (s != null){
			result = s.decl.type;
		}
		typeMap.put(node, result);
	}

	@Override
	public void outAIntAExpr(AIntAExpr node) {
		typeMap.put(node, Type.INT);
	}

	@Override
	public void outAFalseAExpr(AFalseAExpr node) {
		typeMap.put(node, Type.BOOLEAN);
	}

	@Override
	public void outATrueAExpr(ATrueAExpr node) {
		typeMap.put(node, Type.BOOLEAN);
	}

	@Override
	public void outABinAExpr(ABinAExpr node) {
		Type result = Type.ERROR;
		Type lhExprType = typeMap.get(node.getE1());
		Type rhExprType = typeMap.get(node.getE2());
		assert lhExprType != null && rhExprType != null;
		PAOp op = node.getAOp();
		// requires int
		if (op instanceof APlusAOp || op instanceof AMinusAOp || op instanceof AMulAOp
				|| op instanceof ADivAOp || op instanceof AEqAOp || op instanceof AGtAOp 
				|| op instanceof AGteqAOp || op instanceof ALtAOp) {
			if (lhExprType != Type.INT || rhExprType != Type.INT) {
				reportError(op + " operator requires int operands; received " + lhExprType + " and " + rhExprType, getLine(op));			
			} else {
				if (op instanceof AEqAOp || op instanceof AGtAOp || op instanceof AGteqAOp
						|| op instanceof ALtAOp) {
					result = Type.BOOLEAN;
				} else {
					result = Type.INT;
				}
			}
		// requires boolean
		} else if (op instanceof AAndAOp || op instanceof AOrAOp
				) {
			if (lhExprType != rhExprType) {
				reportError(op + " operator requires boolean operands; received " + lhExprType + " and " + rhExprType, getLine(op));			
			} else {
				result = Type.BOOLEAN;			
			}

		} else if (op instanceof AConcatAOp) {
			reportError("Feature Unsupported: " + "concatination", ((AConcatAOp)op).getConcatOp().getLine());			
		} else {
			reportError("Unexpected operator: " + op, getLine(op));
		}
		typeMap.put(node, result);
	}

	@Override
	public void outANewAExpr(ANewAExpr node) {
		reportError("Feature Unsupported: " + "new", node.getNew().getLine());			
	}

	@Override
	public void outANotAExpr(ANotAExpr node) {
		typeMap.put(node, Type.BOOLEAN);
	}

	@Override
	public void outANullAExpr(ANullAExpr node) {
		typeMap.put(node, Type.NULL);
	}

	@Override
	public void outAArrayAExpr(AArrayAExpr node) {
		reportError("Feature Unsupported: Array", node.getId().getLine());			
	}

	@Override
	public void outAMeAExpr(AMeAExpr node) {
		reportError("Feature Unsupported: Me", node.getMe().getLine());			
	}

	@Override
	public void outANegAExpr(ANegAExpr node) {
		Type result = Type.ERROR;
		Type t = typeMap.get(node.getAExpr());
		if (t == Type.INT) {
			result = Type.INT;
		} else {
			reportError("- operator requires int operand; received " + t, node.getMinusOp().getLine());
		}
		typeMap.put(node, result);
	}

	@Override
	public void outAParAExpr(AParAExpr node) {
		typeMap.put(node, typeMap.get(node.getAExpr()));
	}

	@Override
	public void outAPosAExpr(APosAExpr node) {
		Type result = Type.ERROR;
		Type t = typeMap.get(node.getAExpr());
		if (t == Type.INT) {
			result = Type.INT;
		} else {
			reportError("+ operator requires int operand; received " + t, node.getPlusOp().getLine());
		}
		typeMap.put(node, result);
	}

	@Override
	public void outAStrAExpr(AStrAExpr node) {
		reportError("Feature Unsupported: String", node.getStrlit().getLine());			
	}

	@Override
	public void inAAStart(AAStart node) {
		if (node.getMore().size() > 0) {
			AAClassDef cl = (AAClassDef)node.getMore().getFirst();
			reportError("Feature Unsupported: Mulitiple Classes", cl.getStartId().getLine());
		}
	}

	@Override
	public void outAIfAStmt(AIfAStmt node) {
		Type t = typeMap.get(node.getAExpr());
		if (t != Type.BOOLEAN) {
			reportError("If statement expecting boolean and got " + t.name, node.getIf().getLine());
		}
	}

	@Override
	public void outALoopAStmt(ALoopAStmt node) {
		Type t = typeMap.get(node.getAExpr());
		if (t != Type.BOOLEAN) {
			reportError("Loop statement expecting boolean and got " + t.name, node.getWhile().getLine());
		}
	}

	@Override
	public void outAExpAType(AExpAType node) {
		reportError("Feature Unsupported: Array Type", node.getLBar().getLine());
	}

}
