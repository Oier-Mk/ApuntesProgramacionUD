package Basic;
import javax.swing.JOptionPane;

//Porq vamos a utilizar las clases dentro de javax.swing
//En este caso ES STATIC por tanto no tendremos que crear un objecto sino tenemos que poner el nombre de la calse antes del metodo
public class Entrada_Ejemplo2 {

	public static void main(String[] args) {
		String nombre_usuario = JOptionPane.showInputDialog("Introduce tu nombre, profavor: ");
		String edad = JOptionPane.showInputDialog("Introduce la edad, por favor");
		int edad_usuario = Integer.parseInt(edad);
		//edad_usuario ++ ; (se podría hacer asi)
		System.out.println("Hola " + nombre_usuario + ". El año que viente tendrás " + (edad_usuario + 1) + " años");
		JOptionPane.showMessageDialog(null, "Hola " + nombre_usuario + ". El año que viente tendrás " + (edad_usuario + 1) + " años");

	}

}
