package Basic;
//Bucles INDETERMINADOS: No sabes si se van a repetir 2 veces o 2000
//Do While = aunque la condición sea FALSE este Do While te aegura de que al menos 1 vez se ejecutará
//Do{
//Línea 1
//Línea 2
//Línea 3
//while(condición);
import javax.swing.*; //JOptioPane

public class Peso_ideal {
	public static void main (String[] args) {
		String genero = "";
		do {
			genero = JOptionPane.showInputDialog("Introduce tu género (H/M)");
		}while(genero.equalsIgnoreCase("H")== false && genero.equalsIgnoreCase("M")==false);
		
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura en cm"));
		//ParseInt=pasar a valor numérico la variable introducida y ponemos interger porque esta dentro de la clase Integer
				//Ejemplo Math.pow() = Integer.parseInt
		int pesoideal = 0;
		if (genero.equalsIgnoreCase("H")) {
			pesoideal = altura-110;
		}
		else if(genero.equalsIgnoreCase("M")) {
			pesoideal = altura-120;
		
		}
		System.out.println("Tu peso ideal es " + pesoideal);
	}
}
