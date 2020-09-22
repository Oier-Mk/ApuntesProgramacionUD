package Basic;
import javax.swing.*;

//Importamos este este paquete para poder utilizar JOptionPane etc
public class Entrada_Numeros {

	public static void main(String[] args) {
		
		//double x = 10000.0;
		
		//System.out.printf("%1.2f", x/3); //2 = 2 decimales
		String num1 = JOptionPane.showInputDialog("Introduce número"); //JOptionPane nos sacará una ventanita para poder escribir lo que queramos
		//Lo que hay en la ventanita devuelve un String que lo almacenaremos en num1
		//Pero tenemos que convertir ese String a valo numerico double
		//Porque el argumento de la clase Math.sqrt exige que ese argumento sea double
		double num2 = Double.parseDouble(num1); //Aqui estamos cambiando el valor STRING X EL DOUBLE
		//asi que declaramos un una nueva variable con nombre num2 en la que almacene la conversion a double el num1
		//c+Como el metodo es static, necesitamos poner delante del sqrt el nombre de la clase (Math.sqrt)
		JOptionPane.showMessageDialog(null, "La raiz de " + num2 + " es ");
		System.out.print("La raiz de " + num2 + " es ");
		JOptionPane.showMessageDialog(null, "%1.2"+ Math.sqrt(num2));
		System.out.printf("%1.2", Math.sqrt(num2));
		
	}
	

}
