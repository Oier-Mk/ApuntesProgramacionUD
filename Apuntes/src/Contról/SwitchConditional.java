package Contról;
import java.util.*;
import javax.swing.*;
public class SwitchConditional {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Elige una opcion: \n1: Cuadrado \n2: Rectángulo \n3: Triángulo \n4: Círculo "); // \n salto de linea
		int  figura= entrada.nextInt();
		
		switch(figura) {
		case 1:
			int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
			System.out.println("El área del cuadrado es " + Math.pow(lado,2));
			break;
		case 2:
			int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base: "));
			int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura: "));
			System.out.println("El área del rectángulo es " + base*altura);
			break;
		case 3:
			int base2 = Integer.parseInt(JOptionPane.showInputDialog("Introducir la base: "));
			int altura2 = Integer.parseInt(JOptionPane.showInputDialog("Introducir la altura: "));
			System.out.println("El área del triángulo es " + (base2*altura2)/2);
			break;
		case 4:
			int radio = Integer.parseInt(JOptionPane.showInputDialog("Introducir el radio: "));
			System.out.print("El área del círculo es ");
			System.out.printf("%1.2f", Math.PI*(Math.pow(radio, 2)));
			break;
		default:
			System.out.println("El número introducido no es correcto");
		}
	}

}
