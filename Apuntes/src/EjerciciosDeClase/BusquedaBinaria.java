package EjerciciosDeClase;

public class BusquedaBinaria {

	public static void main(String[] args) {
		int[] array = new int[]
				{1,2,3,4,15,16,17,18,119,220};
		int buscado = 17;
		int inicio = 0;
		int fin = array.length-1;
		System.out.println(busca(buscado, array, inicio, fin));
	}

	private static int busca(int buscado, int[] array, int inicio, int fin) {
		int mitad = (fin+inicio)/2;
		if (buscado == array[mitad]){
			return mitad;
		}else if(buscado<array[mitad]){
			return busca(buscado, array,inicio, mitad-1);
		}else if(buscado>array[mitad]){
			return busca(buscado, array,mitad+1, fin);
		}else{
			return -1;
		}
	}
}
