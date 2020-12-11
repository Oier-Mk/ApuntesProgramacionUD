package EjerciciosDeClase;

public class AquilesYLaTortuga {
	
	public static final double VEL_AQUILES = 10;   // metros / sg
	public static final double VEL_TORTUGA = 0.05; // m/sg (0.05m/sg = 1 metro cada 20 segs) 
	
	public static final double INICIO_AQUILES = 0;    // Aquiles empieza en el metro 0
	public static final double INICIO_TORTUGA = 1000; // La tortuga tiene 1 km de ventaja
	
	/** Devuelve la posición de Aquiles en la carrera, dado el tiempo transcurrido
	 * @param t	Tiempo transcurrido de carrera (en sgs)
	 * @return	Posición de Aquiles (en m)
	 */
	public static double dondeEstaAquiles( double t ) {
		return INICIO_AQUILES + VEL_AQUILES * t;
	}

	/** Devuelve la posición de la tortuga en la carrera, dado el tiempo transcurrido
	 * @param t	Tiempo transcurrido de carrera (en sgs)
	 * @return	Posición de la tortuga (en m)
	 */
	public static double dondeEstaLaTortuga( double t ) {
		return INICIO_TORTUGA + VEL_TORTUGA * t;
	}
	
	// Algoritmo recursivo
	public static double cuandoSeEncuentran(double tIni, double tFin) {
		numLlams++; // Auxiliar para contar el número de llamadas
		if (Math.abs(tIni-tFin) < 0.001) {
			return tIni;
		} else {
			double tMedio = (tIni+tFin)/2;
			if (dondeEstaAquiles( tMedio ) <= dondeEstaLaTortuga( tMedio )) {
				return cuandoSeEncuentran( tMedio , tFin );
			} else {
				return cuandoSeEncuentran( tIni, tMedio );
			}
		}
	}
	
	private static int numLlams = 0;
	public static void main(String[] args) {
		double t = 500000000;  // Tiempo de prueba
		try {
			System.out.println( "Solución:" + cuandoSeEncuentran(0,t));
			System.out.println(numLlams);
		} catch (StackOverflowError e) {
			System.out.println( "Stack overflow!! " + numLlams );
		}
		
	}
	
}
