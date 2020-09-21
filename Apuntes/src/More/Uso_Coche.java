package More;
import javax.swing.*; //JOptionPane

	public class Uso_Coche {
	public static void main(String[] args) { //Esta es la clase principal siempre hay solo 1 x cada obj y es
		//La clase x dodnde empieza el programa a ejecutarse
		
		
		Coche Renault = new Coche(); //Instanciar una clase de la CLASE COCHE
		//Aqui se llama al contructor de la clase
		
		System.out.println(Renault.dime_largo());
		System.out.println(Renault.dime_datos_generales());
		
		Renault.establece_color(JOptionPane.showInputDialog("Introduce el color del coche: "));//Establecemos el color del coche
		//color_coche = Amarillo
		System.out.println(Renault.dime_color());
		Renault.configura_asientos(JOptionPane.showInputDialog("¿Tiene asientos de cuero? (si/no): "));
		System.out.println(Renault.dime_asientos());
		Renault.configura_climatizador(JOptionPane.showInputDialog("¿Tiene climatizador? (si/no): "));
		System.out.println(Renault.dime_climatizador());
		System.out.println(Renault.dime_peso_coche());//PORQUE ES GETTER SETTER
		System.out.println("El precio final del coche es "+ Renault.dime_precio_coche());
	}
	
	
	
}
