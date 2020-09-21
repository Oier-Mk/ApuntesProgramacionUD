package Arrays;

public class BidimensioalDirectArray {

	public static void main(String[] args) {
		int [][] matrix = {
				{10,15,18,19,21},
				{05,25,37,41,15},
				{07,19,32,14,90},
				{85,02,07,40,27}
		};
		for(int[]fila:matrix) {
			System.out.println();//Para que hago salto de línea y sea más visual
			for(int z: fila) { //Se llama z porque sí
				System.out.print(z + " ");
			}
		}
			
		
	}

}
