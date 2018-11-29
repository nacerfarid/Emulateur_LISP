package jus.aoo.test;
import jus.aoo.lisp.*;

public class Test {

	public static void main(String[] args) {
		SEXPR s1 = new SCONS(Symbole.newSymbole("a"), Symbole.newSymbole("ad"));
		SEXPR s2 = new SCONS(Symbole.newSymbole("a"), Symbole.newSymbole("bd"));
		SEXPR s3 = new SCONS(Symbole.newSymbole("a"), s2);
		SEXPR s4 = new SCONS(Symbole.newSymbole("a"), s3);
		SEXPR s5 = new SCONS(s2,s3);
		SEXPR s6 = new SCONS(s2,s2);
		
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
	}

}