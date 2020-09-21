package Input;
//Otro ejemplo del bucle while
import java.util.*;
public class ScannerInput {
	public static void main(String[] args) {
	int aleatorio = (int) (Math.random()*100);
	@SuppressWarnings("resource")
	Scanner entrada = new Scanner (System.in);
	int numero = 0;
	int intentos = 0;
	while(numero!=aleatorio) {//Mientras numero numero diferente de aletorio
		intentos ++; //Incremente la variable intento cada vez que haga un while porque es cuando se mete un num distinto
		System.out.println("Introduce un  número, por favor:");
		numero = entrada.nextInt(); //Numero tiene que ser igual al próximo entero que metas en consola
		if(aleatorio<numero) { //Si aleatorio(Num programa) mas pequeño que el nuestro = Más pequeño
			System.out.println("Más bajo"); 
		}
		else if (aleatorio>numero) {
			System.out.println("Más alto");
		}
	}
	System.out.println("Correcto. Lo has conseguido en "+ intentos + " intentos");
	}
}
