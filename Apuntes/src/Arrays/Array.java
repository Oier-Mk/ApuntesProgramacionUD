package Arrays;
//MATRICES (ARRAYS, ARREGLOS)
//Matriz = Estructura de datos que sirve almacenar valores que normalmente tienen algo en común
//SINTAXIS:
//Declaración de una matriz
//int[] mi_matriz = new int[10];
//Inicialización
//mi_matriz[0] = 15;
//mi_mariz[1] = 25;
//mi_mariz[2] = 8; 
//mi_mariz[3] = -7;
//mi_mariz[4] = 92;
//Declaración e inicialización
//int [] mi_matriz = {15, 25, 8, -7, 92};
//Una matriz que se llame mi_matriz que almacene 10 datos de tipo entero
public class Array {
	public static void main(String[] args) {
		//int []  mi_matriz= new int[5];
		//mi_matriz[0] = 5;
		//mi_matriz[1] = 38;
		//mi_matriz[2] = -15;
		//mi_matriz[3] = 92; 
		//mi_matriz[4] = 71;
		boolean ho = false;
		Object [] mi_matriz = {5, 38, -15, 92, 71, "buenos dias", ho};
		for(int i = 0; i < mi_matriz.length; i ++) { //mi_matriz.leghth nos cuenta los valores de la matriz
			System.out.println("Valor de índice " + (i+1) + " = " + mi_matriz[i]);
			//Imprimir x pantalla todos los valores dentro de una matriz
			//i+1 porque porque no queremos que escriba posición 0 sino posición 1, queda feo
		}
			 
		

	}

}
