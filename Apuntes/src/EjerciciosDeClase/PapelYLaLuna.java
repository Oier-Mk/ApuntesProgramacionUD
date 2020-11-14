package EjerciciosDeClase;

/** Cómo está de lejos la luna? A tiro de folio?
 *
 */
public class PapelYLaLuna {

	public static void main(String[] args) {
		doble( 0.0001, 384400000.0, 0 );
		dobleRecursivo(0.0001, 384400000.0);
		doble2(0.0001, 384400000.0);
	}
	
	private static void dobleRecursivo(double d, double e) {
		int cont = 0;
		while(d<=e) {
			d = d*2;
			cont += 1;
		}
		System.out.println( "Luna encontrada en " + cont + " dobleces!" );
	}

	private static long doble2(double grosor, double dist) {
		int cont = 0;
		if (grosor >= dist) { //CASO BASE: cuando el grosor llega al tamaño de la luna
			return cont;
		} else { //CASO RECURSIVO: cuando el grosor es menor que el de la luna
				 //el numero de dobleces se duplica cada ves que se dobla
			doble( grosor*2, dist, doble2(grosor, dist ) );
		}
		return cont;
	}

	private static void doble( double grosor, double dist, long dobles ) {
		if (grosor >= dist) { //CASO BASE: cuando el grosor llega al tamaño de la luna
			System.out.println( "Luna encontrada en " + dobles + " dobleces!" );
		} else { //CASO RECURSIVO: cuando el grosor es menor que el de la luna
				 //el numero de dobleces se duplica cada ves que se dobla
			doble( grosor*2, dist, dobles+1 );
		}
	}

}
