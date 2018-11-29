package jus.aoo.lisp;

public class SCONS implements Liste {

	private SEXPR car, cdr;
	
	@Override
	public SEXPR Car() throws LispException {
		return car;
	}

	@Override
	public SEXPR Cdr() throws LispException {
		return cdr;
	}

	@Override
	public boolean EQ(SEXPR s) {
		return this == s;
	}

	@Override
	public boolean Atom() {
		return false;
	}
	
	public SCONS(SEXPR car, SEXPR cdr){
		this.car = car;
		this.cdr = cdr;
	}

	public boolean isListe() {
		return true;
	}

	@Override
	public boolean isAtome() {
		return false;
	}
	
	public String toString(){
		return "(" + this.toString((SEXPR)this) + ")";
	}
	
	public String toString(SEXPR s){
		if(s.Cdr().isNil()) return s.Car().toString();
		if(s.Cdr().Atom()) return s.Car().toString() + " . " + s.Cdr().toString();
		return s.Car().toString() + " " + toString(s.Cdr());
	}
	
	public boolean isNil(){
		return false;
	}
	

	@Override
	public SEXPR eval() throws LispException {
		SEXPR foncteur = car.eval();
		SEXPR largs = this.Cdr();
		if(foncteur instanceof Primitive) 
			return ((Primitive) foncteur).reduction(foncteur, largs);
		if(foncteur.Car().EQ(Symbole.newSymbole("lambda"))){
			return EXPR.expr.reduction(foncteur, largs);
		}else if(foncteur.Car().EQ(Symbole.newSymbole("flambda"))){
			return FEXPR.fexpr.reduction(foncteur, largs);
		}else
			throw new LispException();
	}

	@Override
	public int size() {
		int res = 1;
		SEXPR tmp = this.Cdr();
		while(!tmp.Car().isNil()){
			res++;
			tmp = tmp.Cdr();
		}
		return res;
	}
	
}
