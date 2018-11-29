package jus.aoo.lisp;

public interface SEXPR {
	
	public SEXPR Car() throws LispException;
	public SEXPR Cdr() throws LispException;
	public boolean EQ(SEXPR s);
	public boolean Atom();
	public boolean isListe();
	public boolean isAtome();
	public boolean isNil();
	public int size();
	public SEXPR eval() throws LispException;
}
