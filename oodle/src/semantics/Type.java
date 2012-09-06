package semantics;

public class Type {
	public static final Type ERROR = new Type("<error>"),
			INT = new Type("int"), 
			BOOLEAN = new Type("boolean"),
			STRING = new Type("string"),
			NULL = new Type("null");

	protected String name;

	protected Type(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

}
