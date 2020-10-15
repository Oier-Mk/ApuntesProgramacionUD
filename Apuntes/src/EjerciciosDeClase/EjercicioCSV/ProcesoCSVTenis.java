package EjerciciosDeClase.EjercicioCSV;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import EjerciciosDeClase.EjercicioCSV.es.deusto.prog3.utils.tabla.Tabla;
import EjerciciosDeClase.EjercicioCSV.es.deusto.prog3.utils.tabla.iu.VentanaDatos;
import EjerciciosDeClase.EjercicioCSV.es.deusto.prog3.utils.tabla.iu.VentanaGeneral;

/*0.8. Refrescando las Java Collections con Nadal
Puedes encontrar un historial de partidos de ATP en muchos sitios en Internet. Por ejemplo:
https://www.kaggle.com/jordangoblet/atp-tour-20002016
Si descargas el fichero encontrarás un .csv con datos que también puedes encontrar en el repositorio, en el paquete es.deusto.prog3.utils
Tienes un programa que ya hace la gestión de un csv en ese paquete, ProcesoCSVTenis.java. Parte de esa clase para procesar los datos de ese csv, pero en lugar de hacer lo que hace el programa de ejemplo (sacar las finales de torneos de Grand Slam) realiza lo siguiente:
Crea una clase Partido que permita guardar de cada partido los siguientes datos: torneo, tipo, ronda, ganador, perdedor, setsGanados, setsPerdidos (son todos los datos que se cogen en el ejemplo, líneas 60-67)
Crea un mapa cuya clave sea un tenista (string) y cuyo valor sea una lista de partidos
Carga en el mapa todos los partidos de todos los tenistas, metiendo cada partido en dos listas del mapa: el ganador y el perdedor. (es decir, en el mapa habrá una entrada por cada tenista y el valor asociado será la lista de todos los partidos que ha jugado, algunos perdidos y otros ganados).
Crea una clase Jugador que contenga nombre de tenista, número de partidos ganados y número de partidos perdidos.
Recorre el mapa para crear un objeto por cada jugador calculando el número de partidos ganados y perdidos de ese jugador. Añade esos objetos a un conjunto ordenado de jugadores.
Define la ordenación de ese conjunto para que los tenistas se ordenen por diferencia de partidos ganados menos perdidos (primero los de mayor diferencia), y a igualdad por mayor número de partidos ganados.
Saca a consola el ranking de tenistas en función de ese conjunto ordenado.
 */

/** Prueba de carga de un CSV de datos de ATP en tabla visual
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class ProcesoCSVTenis {
	public static Map<String , ArrayList<ArrayList<Partido>>> mapaJugadores = new HashMap<>();
	public static TreeMap<String, Jugador> ranking = new TreeMap<String, Jugador>();

	public static void main( String[] s ) {
		atp();
		recorreMapa();
		imprimoRanking();
	}

	private static void imprimoRanking() {
		List<Jugador> list = new ArrayList<Jugador>(ranking.values());
		for (int i = list.size()-1; i >= 0;i--) {
			System.out.println(list.get(i));
		}
		//MAPA AL REVES, DE MENOR A MAYOR. PUEDE SER UN TANTO INEFICIENTE EL FOR DE ARRIBA PERO ITERANDO 
		//SOBRE UN MAPA SE LLEGA AL MISMO RESULTADO.
		//		for (Entry<String, Jugador> entry : ranking.entrySet()) {
		//			System.out.println(entry.getKey() + " " + entry.getValue());
		//		}

	}

	private static void recorreMapa() {

		for (Map.Entry<String, ArrayList<ArrayList<Partido>>> entry : mapaJugadores.entrySet()) {
			System.out.println("\nJugador\t"+entry.getKey()+"\n");
			int ganados;
			int perdidos;
			System.out.println("Ganados:\n");
			ganados = compruebo1Array(entry.getValue().get(0));
			System.out.println("Perdidos:\n");
			perdidos = compruebo1Array(entry.getValue().get(1));
			Jugador j = new Jugador(entry.getKey(), ganados , perdidos);

		}
	}

	private static int compruebo1Array(ArrayList<Partido> arrayList) {
		int i;
		for (i = 0 ; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i).toString());
		}
		System.out.println();
		return i;
	}


	private static VentanaDatos newVentanaTabla( VentanaGeneral vg, Tabla tabla, String codTabla, int posX, int posY ) {
		try {
			String tit = codTabla + " (" + tabla.size() + ")";
			VentanaDatos vd = new VentanaDatos( vg, codTabla, tit ); 
			vd.setSize( 1400, 800 );
			vd.setTabla( tabla ); 
			vg.addVentanaInterna( vd, codTabla );
			vd.setLocation( posX, posY );
			vd.addBoton( "-> clipboard", new Tabla.CopyToClipboard( tabla, vd ) );
			vd.setVisible( true ); 
			try { Thread.sleep( 100 ); } catch (InterruptedException e) {}
			return vd;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static VentanaGeneral ventana;
	private static final SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );

	private static void atp() {
		try {
			String urlATP = "dataATP.csv";

			ventana = new VentanaGeneral();
			ventana.setSize( 1800, 1000 );
			ventana.setEnCierre( new Runnable() { public void run() {  } } );
			ventana.setTitle( "Revisión de datos de Inspira 2020" );
			ventana.setVisible( true );

			// Crea la tabla con todos los datos
			Tabla tablaATPBruto = Tabla.processCSV( ProcesoCSVTenis.class.getResource( urlATP ) );
			System.out.println( tablaATPBruto.getHeadersTabs( "" ) );

			// Filtra solo las columnas interesantes y muestra la ventana
			Tabla tablaATPFiltrada = tablaATPBruto.crearTablaConCols( "ATP", "Location", "Tournament", "Date", "Series", "Court", "Surface", "Round", "Best of", "Winner", "Loser", "WRank", "LRank", "W1", "L1", "W2", "L2", "W3", "L3", "W4", "L4", "W5", "L5", "Wsets", "Lsets" );
			newVentanaTabla( ventana, tablaATPFiltrada, "ATP Filtrada", 20, 20 );

			// Hace algo con los datos (cambiar esto si se quiere hacer otra cosa)
			for (int i=0; i<tablaATPFiltrada.size(); i++) {
				Date fecha = tablaATPFiltrada.getDate( i, "Date" );
				String torneo = tablaATPFiltrada.get( i, "Tournament" );
				String tipo = tablaATPFiltrada.get( i, "Series" );
				String ronda = tablaATPFiltrada.get( i, "Round" );
				String ganador = tablaATPFiltrada.get( i, "Winner" );
				String perdedor = tablaATPFiltrada.get( i, "Loser" );
				int setsGanados = tablaATPFiltrada.getInt( i, "Wsets" );
				int setsPerdidos = tablaATPFiltrada.getInt( i, "Lsets" );
				// Ejemplo: se visualizan solo las finales
				if (ronda.equals("The Final") && tipo.equals( "Grand Slam" )) {
					System.out.println( torneo + "\t" + sdf.format(fecha) + "\t" + ronda + "\t" + ganador + "\t" + perdedor + "\t" + (setsGanados + "-" + setsPerdidos) );
				}
				Partido p = new Partido(fecha, torneo, tipo, ronda, ganador, perdedor, setsGanados, setsPerdidos);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
