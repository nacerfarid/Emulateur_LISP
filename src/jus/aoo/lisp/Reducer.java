package jus.aoo.lisp;

public abstract class Reducer {
	public SEXPR reduction(SEXPR fct, SEXPR largs){
		return apply(fct,evalArgs(largs));
	}
	protected abstract SEXPR evalArgs(SEXPR largs);
	public SEXPR apply(SEXPR fct, SEXPR largs){
		try{
			Context.bind(fct.Cdr().Car(), largs);
			SEXPR r = fct.Cdr().Cdr().Car().eval();
			return r;
		}finally{
			Context.unbind();
		}
	}
}
