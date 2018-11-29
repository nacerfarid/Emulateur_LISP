package jus.aoo.lisp;

public class NIL extends Atome implements Liste{
	
	public static final NIL instance = new NIL();
	@Override
	public SEXPR Car() throws LispException {
		return this;
	}

	@Override
	public SEXPR Cdr() throws LispException {
		return this;
	}

	@Override
	public boolean EQ(SEXPR s) {
		return s==instance;
	}

	@Override
	public boolean Atom() {
		return true;
	}

	@Override
	public boolean isListe() {
		return false;
	}

	@Override
	public boolean isAtome() {
		return true;
	}
	
	private NIL(){
	}
	
	
	public static NIL getNIL(){
		return instance;
	}
	
	public String toString(){
		return "()";
	}

	@Override
	public boolean isNil() {
		return true;
	}


}
