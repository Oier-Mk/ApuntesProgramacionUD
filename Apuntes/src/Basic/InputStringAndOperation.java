package Basic;
import java.util.*;

//* Asterisco es que importe todas las clases de java.util
//Si pusiesemos java.util.Scanner solo nos importaría la clase scanner por ejemplo
//Normalmente no se especifica porq a efectos generales es mas comodo aunq consume mas recusrsos porq reservas más espacios en memoria 
public class InputStringAndOperation {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		//String nombre; // java.lang,String
		//Scanner miobjeto; //java.util.Scanner
		//Locale miobjeto2; //java.util.Locale
//Si ponemos Scanner obj; u nos pone error podemos buscarla en la API
//Tamb lo podemos hacer desde java: source > organize imports (Te organiza todo)

//Static = tenemos que poner delante la clase de donde estamos sacando el método.
//NO STATIC = tenemos que crear un objeto dentro de la clase que estemos utilizando para que cuando utilicemos la clase nuevo tenemos que meterle el objecto q habiamos creado		
//Constructor = 
//Hay métodos que tienen 1 método constructor y hay métodos que tienen MÁS de 1 método constructor (depende de los argumentos que tenga)
		Scanner entrada = new Scanner(System.in); //Hemos declarado una variable de tipo objeto
		System.out.println("Introduce tu nombre, por favor: ");//Imprime lo de la segunda línea
		String nombre_usuario = entrada.nextLine(); //Esta a la espera de que introduzcamos un texto
		//Ese texto lo almacenrá dentro de la clase string
		System.out.println("Introduce edad, por favor: "); //Imprime x pantalla
		int edad = entrada.nextInt(); //Esta a la espera de que introduzcamos un entero (int)
		//Ese entero lo almacenrá dentro de int
		System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad + 1) + " años");
	}

}
