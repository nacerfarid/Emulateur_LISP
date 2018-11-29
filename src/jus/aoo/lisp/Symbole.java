package jus.aoo.lisp;

import java.util.HashMap;
import java.util.Map;

public class Symbole extends Atome {
	
	private static Map<String,Symbole> symboles = new HashMap<String,Symbole>();
	String symbole;
	
	private Symbole(String s){
		this.symbole = s;
		symboles.put(s, this);
	}
	
	public static Symbole newSymbole(String s){
		if(symboles.containsKey(s))
			return symboles.get(s);
		else 
			return new Symbole(s);
	}
	
	public String toString(){
		return symbole;
	}
	
	public SEXPR eval(){
		return Context.get(this);
	}
}
