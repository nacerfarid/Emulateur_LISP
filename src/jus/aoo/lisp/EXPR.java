package jus.aoo.lisp;

public class EXPR extends Reducer {
	public static final EXPR expr = new EXPR();
	private EXPR() {
		// TODO Stub du constructeur généré automatiquement
	}

	@Override
	protected SEXPR evalArgs(SEXPR largs) {
		if(largs.isNil()) return NIL.getNIL();
		return new SCONS(largs.Car().eval(),evalArgs(largs.Cdr()));
	}

}
