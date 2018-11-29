package jus.aoo.lisp;

public abstract class Atome implements SEXPR{
	public boolean isAtom(){
		return this instanceof Atome;
	}
	public boolean EQ(SEXPR s) {
		return this==s;
	}
	public boolean isNil(){
		return false;
	}

	@Override
	public int size() {
		return 1;
	}
	@Override
	public boolean isListe() {
		return false;
	}

	@Override
	public boolean isAtome() {
		return true;
	}
	@Override
	public SEXPR Car() throws LispException {
		throw new LispException();
	}

	@Override
	public SEXPR Cdr() throws LispException {
		throw new LispException();
	}

	@Override
	public boolean Atom() {
		return true;
	}
	@Override
	public SEXPR eval() throws LispException {
		// TODO Stub de la méthode généré automatiquement
		return this;
	}
	
}
