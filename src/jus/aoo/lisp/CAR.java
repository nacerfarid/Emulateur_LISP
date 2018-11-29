package jus.aoo.lisp;

public class CAR extends SUBR {

	@Override
	public SEXPR apply(SEXPR fct, SEXPR largs) {
		if(!(largs.isListe() && largs.size()==1)) throw new LispException();
		return largs.Car().Car();
	}

}
