package Strings;
//NO Primitivos => objeto
//String
//String mi_nombre = "Alejandra"
//instanciar una clase => Poner nombre a un objeto/un string
//String. => averigurar la las las palabras que tiene, si tiene @ un email etc
//Método length(): devielve la longitud de una cadena de caracteres
//mi_nombre.length() , nos devuelve 9 porqueAlejandra tiene 9 letras-caracteres
//charAt(): devuleve la posión de un caraccter dentro dentro de una cadena.(Las posiciones empiezan a contar desde 0)
//mi_nombre.charAt(2) , nos devuleve e (pq empieza a contar desde 0)
//substring(x,y): devuleve una subcadena dentro de la cadena, siendo X el carácter a partir del cuál se extrae e Y el nº de caracteres que se quiere extraer.
//mi_nombre.substring(a,2)
//equals(cadena): devuelve TRUE si dos cadenas que comparamos son iguales y devuelve FALSE si no lo son.Distingue mayúsculas y minúsculas. 
//equalsIgnoreCase(cadena): igual qu la anterior pero no tiene en cuenta mayúsculas y minúculas

public class manipula_cadenas {

	public static void main(String[] args) {
		//DEclarar una variable objeto de tipo string
		String nombre = "Alejandra";
		System.out.println("Mi nombre es " + nombre); //Concatenar
		//Mi nombre es Alejandra
		
		System.out.println("Mi nombre tiene " + nombre.length() + " letras");
		//Mi nombre tiene 9 letras
		
		System.out.println("La primera letra de mi nombre es " + nombre.charAt(0));
		//La primera letra de mi nombre es A
		
		//Saber cual es la ultima letra en cualquier cas, aun sin saber cuantas letras tiene
		int ultima_letra;
		ultima_letra = nombre.length();//Tamb podría haber sido todo a la vez
		System.out.println("Y la última letra es la " + nombre.charAt(ultima_letra-1));//Es -1 porque charAt cuentta a partir de 0
		//Y la última letra es la a
		
		String frase = "Hoy es un estupendo día para aprender a programar en java";
		String frase_resumen = frase.substring(1, 3); //Empieza desde 0 a contar en la frase
		//El primero que quiero exraer = 1
		//El primero que NO quiero extraer = 3
		System.out.println(frase_resumen);
		//oy
		String frase_resumen2 = frase.substring(0, 29) + "irnos a la playa y olvidarnos de todo..." + " y " +
		frase.substring(29, 57);
		System.out.println(frase_resumen2);
		
		String alumno1, alumno2;
		alumno1 = "David";
		alumno2 = "David";
		System.out.println(alumno1.equals(alumno2));
		//true
		System.out.println(alumno1.equals(alumno2));//ignora mayus y minus
		//true
		
		
	}

}
