package jus.aoo.lisp;

public abstract class Primitive extends Atome implements _Reducer {


	@Override
	public String toString() {
		// TODO Stub de la méthode généré automatiquement
		return getClass().getSimpleName();
	}
	protected abstract SEXPR evalArgs(SEXPR largs);

	@Override
	public SEXPR reduction(SEXPR fct, SEXPR largs) {
		return apply(fct,evalArgs(largs));
	}

}
