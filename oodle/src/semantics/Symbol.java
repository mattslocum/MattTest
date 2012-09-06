package semantics;


public class Symbol {
	public final String name;
	public final Declaration decl;
	
	public Symbol(String name, Declaration decl) {
		this.name = name;
		this.decl = decl;
	}

	public String getName() {
		return name;
	}
}
