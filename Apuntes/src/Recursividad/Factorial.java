package Recursividad;


public class Factorial {
	public static void main(String[] args) {
		System.out.println("El factorial de 5 es " + factorial(5));
	}

	private static int factorial(int i) {
		if(i == 0 ) {
			return 1;
		}else{
			return factorial(i-1)*i;
		}
	}
	
}
