package jus.aoo.lisp;

public interface _Reducer {
	public SEXPR reduction(SEXPR fct, SEXPR largs);
	public SEXPR apply(SEXPR fct, SEXPR largs);

}
