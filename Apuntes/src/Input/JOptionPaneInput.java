package Input;
//Bucles INDETERMINADOS: No sabes si se van a repetir 2 veces o 2000
//While = Mientras, mientras sea cierta ejecuta cuando sea false se para
//While (condición){
//Linea 1
//Linea 2
//Línea 3
//}
//Do While
import javax.swing.*;
public class JOptionPaneInput {
	public static void main(String[] args) {
		String clave = "Alejandra"; //El programa almacena dentro de la variable clave ese texto(Alejandra)
		String pass = ""; //DEntro de la pass almacena una cadena texto vacía 
		while (clave.equals(pass)==false) { //equals = Comparar cadenas de texto 
		//Mientras clave sea distinto a pass se ejecuta el while
			pass = JOptionPane.showInputDialog("Introduce la contraseña, por favor"); 
			//Al principio pass es una cadena vacia por lo tanto llamamos a una ventana preguntandome por la contraseña
			//Lo que el usuario intruzca en esa ventana se alamacenara en pass
			//Si la primera linea después del while es TRUE sale del bucle sino continua con la siguiente línea
			//Cada lía ejecutada vueleve a ejecutar el while
			if (clave.equals(pass)==false) {
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
				System.out.println("Contraseña incorrecta");
			}
			
		}
	System.out.println("Acceso permitido");
	JOptionPane.showMessageDialog(null, "Acceso permitido");
	}	

}
//Bucles DETERMINADOS: Son aquellos que mirando el código sabes exactamente cuantas veces se va a repetir
//For
//For - each



