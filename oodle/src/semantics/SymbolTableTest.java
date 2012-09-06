package semantics;

import junit.framework.TestCase;

public class SymbolTableTest extends TestCase {
	public void testSymbolTable() {
		SymbolTable table = new SymbolTable();
		
		assertTrue(table.getScope() == 0);
		Symbol s = table.push("x", new VarDecl(Type.INT));
		assertTrue(s.getName().equals("x"));
		assertTrue(table.getScope() == 0);
		assertTrue(table.lookup("x").getName().equals("x"));
		assertTrue(table.lookup("x").decl.type == Type.INT);
		
		assertTrue(table.getScope() == 0);
		s = table.push("y", new VarDecl(Type.INT));
		assertTrue(s.getName().equals("y"));
		assertTrue(table.getScope() == 0);
		assertTrue(table.lookup("y").getName().equals("y"));
		assertTrue(table.lookup("y").decl.type == Type.INT);

		table.beginScope();
		assertTrue(table.getScope() == 1);
		s = table.push("x", new VarDecl(Type.BOOLEAN));
		assertTrue(s.getName().equals("x"));
		assertTrue(table.getScope() == 1);
		assertTrue(table.lookup("x").getName().equals("x"));
		assertTrue(table.lookup("x").decl.type == Type.BOOLEAN);
		
		assertTrue(table.lookup("y").getName().equals("y"));
		assertTrue(table.lookup("y").decl.type == Type.INT);		
		assertTrue(table.getScope() == 1);
		
		table.endScope();
		assertTrue(table.getScope() == 0);
		table.endScope();
		assertTrue(table.getScope() == 0);
		assertTrue(table.lookup("x").getName().equals("x"));
		assertTrue(table.lookup("x").decl.type == Type.INT);
		assertTrue(table.lookup("y").getName().equals("y"));
		assertTrue(table.lookup("y").decl.type == Type.INT);
	}
}
