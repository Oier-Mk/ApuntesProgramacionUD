package Control;
//CONTROL DE FLUJO
import java.util.*;
public class Evalua_edad {
	//Condicionales: saltos de línea
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); //Preguntarnos input
		System.out.println("Introduce tu edad, por favor"); 
		
		int edad = entrada.nextInt(); //Almacenamiento el la variable edad
		
		if(edad<18) {
			System.out.println("Eres un adolescente");
		}
		else if(edad<40) {
			System.out.println("Eres joven");
				
		}
		else if(edad<65) {
			System.out.println("Eres maduro");
			
		}
		else {
			System.out.println("Cuidate");
		}
	}

}
