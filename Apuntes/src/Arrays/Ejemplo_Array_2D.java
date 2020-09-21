package Arrays;

public class Ejemplo_Array_2D {

	public static void main(String[] args) {
		double acumulado; //Double PQ tiene DECIMALES, solo declarar
		double interes = 0.10; //0.10 = 10%
		double [][] saldo = new double [6][5];
		
		for(int i = 0; i < 6; i++) {
			saldo[i][0] = 10000; //x0, x0, x0, x0, x0, x0 Parte de arriba
			acumulado = 10000;
			
			for(int j = 1; j < 5; j++) {//Empieza en 1 porque hemsos dicho que j0 = 10000
				acumulado = acumulado + (acumulado*interes);
				saldo[i][j] = acumulado;
			}
			interes = interes + 0.01;
		}
		for (int z=0; z<6; z++) {
			System.out.println();
			for(int h=0; h<5; h++) {
				System.out.printf("%1.2f", saldo[z][h]);
				System.out.print(" "); //El resultado si lo elevamos a la traspuesta queda más visual
			}
		}

	}

}
