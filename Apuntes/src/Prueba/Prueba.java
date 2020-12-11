package Prueba;

import Library.Counter;

public class Prueba{
	public static void main(String[] args) {
		System.out.println(sustituirPrimeraBarra("src-2020-12-09-new"));
	}
	private static String sustituirPrimeraBarra(String nomFic) {
		if(nomFic.charAt(0) == '-' ) {
			return '/'+ nomFic.substring(1);
		}
		else {
			System.out.println(nomFic.charAt(0) + sustituirPrimeraBarra(nomFic.substring(1)));
			return nomFic.charAt(0) + sustituirPrimeraBarra(nomFic.substring(1));
		}
	}
}
