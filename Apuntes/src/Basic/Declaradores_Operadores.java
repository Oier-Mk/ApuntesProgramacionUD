package Basic;

public class Declaradores_Operadores {

	public static void main(String[] args) {
		//Operacdores con variables
		int a=5;
		int b;
		b=7;
		int c=b+a;
		//Operador suma, almacenamos en c un 12; c=12
		c++;
		//si hiciesemos c+=6 y quitasemos el incremento seria 18
		//c-=6; =6
		//Si hiciesemos int c=b/a => 1 en vez de 1,porque hay un int delante.
		//Para que fuese un 1,4 deberia de ser un double o un float
		//si es esacta pero es un double o float va a poner decimales tamb
		System.out.println(c);
		//intellisense:entornos de desarrollos que sacan menus a medida que vas programando
		//println = con salto de linea
		//print = lo escribe al lado
		
		
		//Operadores con constantes
		//final int c=5;
		//Aquí no podríamos utilizar c=8; porque es una constante 
		final double apulgadas = 2.54;
		double cm=6;
		double resultado =cm/apulgadas;
		System.out.println("En " + cm + "cm hay " + resultado + " pulgadas" );
		
		
		//Se puede declarar variables a la vez
		int operador1, operador2, solucion;
		//Las 3 son ints
		operador1 = 8;
		operador2 = 7;
		solucion = operador1 + operador2;
		System.out.println(solucion);
	}

}
