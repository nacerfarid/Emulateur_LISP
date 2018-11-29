package jus.aoo.lisp;

public abstract class SUBR extends Primitive {
	@Override
	protected SEXPR evalArgs(SEXPR largs) {
		if(largs.isNil()) return NIL.getNIL();
		return new SCONS(largs.Car().eval(),evalArgs(largs.Cdr()));
	}
}
