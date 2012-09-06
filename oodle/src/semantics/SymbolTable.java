package semantics;

import java.util.HashMap;
import java.util.Vector;


public class SymbolTable {
	private Vector<HashMap<String, Symbol>> maps = new Vector<HashMap<String, Symbol>>();
	private int scope = 0;
	
	public SymbolTable() {
		maps.add(new HashMap<String, Symbol>());
		push("out", new MethodDecl(Type.INT));
		push("in", new MethodDecl(Type.NULL));
	}
	
	public Symbol push(String name, Declaration decl) {
		Symbol sym = new Symbol(name, decl);
		HashMap<String, Symbol> map = maps.get(scope);
		map.put(name, sym);
		maps.set(scope, map);
		return sym;
	}
	
	public Symbol lookup(String  name) {
		HashMap<String, Symbol> map;
		for (int i = scope; i >= 0; --i) {
			map = maps.get(i);
			if (map.containsKey(name))
				return map.get(name);		
		}
		return null;
	}
	
	public Symbol lookup(String name, int level) {
		HashMap<String, Symbol> map;
		map = maps.get(level);
		if (map.containsKey(name))
			return map.get(name);
		return null;
	}
	
	public void beginScope() {
		maps.add(new HashMap<String, Symbol>());
		++scope;
	}
	
	public void endScope() {
		if (scope > 0) {
			maps.remove(scope);
			--scope;
		}
	}

	public int getScope() {
		return scope;
	}
	
	public int getScope(String name) {
		HashMap<String, Symbol> map;
		for (int i = scope; i >= 0; --i) {
			map = maps.get(i);
			if (map.containsKey(name))
				return i;		
		}
		return -1;
	}
}
