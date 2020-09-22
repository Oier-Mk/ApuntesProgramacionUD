package Basic;
import javax.swing.*;

public class Factorial {

	public static void main(String[] args) {
		long resultado = 1L; //Utilizamos el long porque sino resultado no admitiría todos los resultados
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
		for(int i = numero; i>0; i--) {
			
			resultado = resultado * i;
		}
		JOptionPane.showMessageDialog(null, "El factorial de " + numero + " es " + resultado);
		System.out.println("El factorial de " + numero + " es " + resultado);
	}

}
