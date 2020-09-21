package Arrays;
import javax.swing.*; //JOptionPane

public class InputArrayRandomJOptionpane {

	public static void main(String[] args) {
		String [] paises = new String[8];
		//paises [0]="España";
		//paises [1]="México";
		//paises [2]="Colombio";
		//paises [3]="Perú";
		//paises [4]="Chile";
		//paises [5]="Argentina";
		//paises [6]="Ecuador";
		//paises [7]="Venezuela";
		for(int i = 0; i < paises.length; i++) {
			paises[i] = JOptionPane.showInputDialog("Introduce un país");
			System.out.println("País " + (i+1) + " = " + paises[i] );
		}
			
		
		//BUCLE FOR EACH
		//Te olvidas del lenght
		String [] paises2 = {"España", "México", "Colombio","Perú", "Chile", "Argentina", "Ecuador", "Venezuela"};
		//Declaramos e inicializamos la matriz
		for(String elemento: paises2) {
			System.out.println("País: " + elemento);
		}
		
		int[] matriz_aleatorios = new int[150];
		for (int i = 0; i<matriz_aleatorios.length; i++) {
			matriz_aleatorios[i] = (int)Math.round(Math.random()*100);
		}
		for(int numeros:matriz_aleatorios) {
			System.out.print(numeros + " ");
			
		}
	
	}

}
