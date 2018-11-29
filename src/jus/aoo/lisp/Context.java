package jus.aoo.lisp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {	
	public static Map<Symbole,SEXPR> context = new HashMap<Symbole,SEXPR>();
	private static Map<SEXPR,SEXPR> pile = new HashMap<SEXPR,SEXPR>();
	public static SEXPR get(Symbole s){
		if(context.containsKey(s))
			return context.get(s);
		else 
			throw new LispException();
	}
	static{
		context.put(Symbole.newSymbole("car"), new CAR());
		context.put(Symbole.newSymbole("cdr"), new CDR());
		context.put(Symbole.newSymbole("cond"), new COND());
		context.put(Symbole.newSymbole("cons"), new CONS());
		
		SEXPR s1 = new SCONS(Symbole.newSymbole("l"), NIL.getNIL());
		SEXPR s2 = new SCONS(Symbole.newSymbole("lambda"), NIL.getNIL());
		SEXPR s22 = new SCONS(Symbole.newSymbole("quote"), s2);
		SEXPR s3 = new SCONS( s22,s1);
		SEXPR s4 = new SCONS(s3, NIL.getNIL());
		SEXPR s5 = new SCONS(Symbole.newSymbole("cons"), s4);
		SEXPR s6 = new SCONS(s5, NIL.getNIL());
		SEXPR s7 = new SCONS(Symbole.newSymbole("l"), s6);
		SEXPR s8 = new SCONS(Symbole.newSymbole("flambda"), s7);
		context.put(Symbole.newSymbole("lambda"),s8);
		
		s1 = new SCONS(Symbole.newSymbole("a"), NIL.getNIL());
		s2 = new SCONS(Symbole.newSymbole("a"), NIL.getNIL());
		s3 = new SCONS(s2, s1);
		s4 = new SCONS(Symbole.newSymbole("flambda"), s3);
		context.put(Symbole.newSymbole("quote"), s4);
		
		s1 = new SCONS(Symbole.newSymbole("l"), NIL.getNIL());
		s2 = new SCONS(Symbole.newSymbole("flambda"), NIL.getNIL());
		s22 = new SCONS(Symbole.newSymbole("quote"), s2);
		s3 = new SCONS( s22,s1);
		s4 = new SCONS(s3, NIL.getNIL());
		s5 = new SCONS(Symbole.newSymbole("cons"), s4);
		s6 = new SCONS(s5, NIL.getNIL());
		s7 = new SCONS(Symbole.newSymbole("l"), s6);
		s8 = new SCONS(Symbole.newSymbole("flambda"), s7);
		context.put(Symbole.newSymbole("flambda"),s8);
	}
	public static void bind( SEXPR paramFormel, SEXPR paramEffectif){
//		if(paramFormel instanceof Symbole){
//			pile.put(paramFormel, paramEffectif);
//		}
//		else {
			internalBind(paramFormel, paramEffectif);
		
	}
	private static void internalBind(SEXPR paramFormel, SEXPR paramEffectif){
		if(paramFormel instanceof Symbole){
			pile.put(paramFormel, paramEffectif);
		}
		else if(paramEffectif.isNil() && !paramFormel.isNil())
			throw new LispException();
		else if(paramEffectif.Car().isListe() && !paramFormel.Car().isListe())
			throw new LispException();
		else if (!paramFormel.isNil() && !paramEffectif.isNil()){
			internalBind(paramFormel.Cdr(), paramEffectif.Cdr());
			internalBind(paramFormel.Car(), paramEffectif.Car());
		}				
	}
	public static void unbind() {
		// TODO Stub de la méthode généré automatiquement
		
	}
}
