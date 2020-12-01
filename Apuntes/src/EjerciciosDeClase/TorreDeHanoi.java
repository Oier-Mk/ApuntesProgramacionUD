package EjerciciosDeClase;

public class TorreDeHanoi {
	public static void main(String[] args) {
		doHanoi(3, 'A', 'C', 'B');
	}
	public static void doHanoi(int nVeces, char origen, char destino, char auxiliar) {
		if (nVeces==1) {
			System.out.println("Mover "+nVeces+" de "+origen+" a "+destino);
		}else {
			doHanoi(nVeces-1, origen, auxiliar, destino);
			System.out.println("Mover "+nVeces+" de "+origen+" a "+destino);
			doHanoi(nVeces-1, auxiliar, destino, origen);
		}
	}
}