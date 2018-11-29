package jus.aoo.lisp;

public class CONS extends SUBR {
	@Override
	public SEXPR apply(SEXPR fct, SEXPR largs) {
		if(!(largs.isListe() && largs.size()==2)) throw new LispException();
		return new SCONS(largs.Car(),largs.Cdr().Car() );
	}
}
