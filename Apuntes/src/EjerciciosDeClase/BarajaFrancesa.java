package EjerciciosDeClase;
import java.util.ArrayList;


//T4. Recursividad [2,5] [T4Ext.java, 30 líneas] Crea una baraja francesa de la siguiente forma:
// Crear baraja
//ArrayList<String> baraja = new ArrayList<>();
//for (int carta=1; carta<=10; carta++) {
//	for (int palo=1; palo<=4; palo++) {
//		baraja.add( "" + carta );
//	}
//}
//for (int palo=1; palo<=4; palo++) {
//	baraja.add( "J" );
//	baraja.add( "Q" );
//	baraja.add( "K" );
//}
//La baraja entonces es una lista de 52 strings donde cada valor es una carta (del 1 al 10, J, Q o K) y hay 4
//cartas iguales de cada.
//Programa un método recursivo que cuente todas las combinaciones posibles de 4 cartas de esa baraja
//y muestre el conteo final. Además, comprueba con cada una de esas combinaciones si es o no poker (las
//4 cartas son iguales) y cuenta también el número de pokers. El programa finalmente debe visualizar esas
//dos informaciones:
//Hay 270725 combinaciones de las cuales 13 son pokers. 


public class BarajaFrancesa {
	public static void main(String[] args) {
		ArrayList<String> baraja = new ArrayList<>();
		crearBaraja(baraja);
		System.out.println("size "+baraja.size());
		for (int i = 0; i<baraja.size();i++) System.out.println(baraja.get(i));

		ArrayList<ArrayList<String>> combinaciones = combinacionesDeCartas(4,new ArrayList<>(),baraja,new ArrayList<>());
		for (int i = 0; i<combinaciones.size();i++) {
			for (int j = 0; i<combinaciones.get(i).size();j++) {
				System.out.println(combinaciones.get(j));
			}
		}
		System.out.println(combinatoria(52,4));
	}

	public static int combinatoria( int m , int n ){
		if( n == 0 || n == m) return 1;
		if( n > m) return 0;
		else{
			int a , b;
			a = combinatoria( m - 1 , n - 1 );
			b = combinatoria( m - 1 , n );
			return a + b;
		}
	}

	private static ArrayList<ArrayList<String>> combinacionesDeCartas(int num, ArrayList<ArrayList<String>> comb, ArrayList<String> cartas, ArrayList<String> actual) {
		if(comb.size()==combinatoria(cartas.size(),num)) {
			return comb;
		}else{
			if(actual.size()==num) {
				comb.add(actual);
				return combinacionesDeCartas(num, comb, cartas, new ArrayList<>());
			}else{
				return combinacionesDeCartas(num, comb, (ArrayList<String>) cartas.subList(1, cartas.size()), actual);
			}
		}
	}
	private static int encuentraSumas( int numSiguiente, int numMax, int sumaBuscada, int sumaAct, ArrayList<Integer> sumandos ) {
		ArrayList<Integer> sumandos2 = new ArrayList<Integer>( sumandos );
		sumandos2.add( numSiguiente );
		return encuentraSumas( numSiguiente+1, numMax, sumaBuscada, sumaAct, sumandos ) +
				encuentraSumas( numSiguiente+1, numMax, sumaBuscada, sumaAct+numSiguiente, sumandos2 );
	} 

	private static void crearBaraja(ArrayList<String> arr) {
		if (arr.size()==52) {
			System.out.println("Caso base "+arr.size());
			return;
		}else{
			if(arr.size()<12) {
				if(arr.size()==10){
					arr.add("CJ");
				}if(arr.size()==11){
					arr.add("CQ");
				}if(arr.size()==12){
					arr.add("CK");
				}else{
					arr.add("C"+(arr.size()+1));
				}
				crearBaraja(arr);
			}if(arr.size()>12 && arr.size()<=23) {
				if(arr.size()==23){
					arr.add("DJ");
				}if(arr.size()==24){
					arr.add("DQ");
				}if(arr.size()==25){
					arr.add("DK");

				}else{
					arr.add("D"+(arr.size()+1-13));
				}
				crearBaraja(arr);
			}if(arr.size()>23 && arr.size()<=36) {
				if(arr.size()==36){
					arr.add("SJ");
				}if(arr.size()==37){
					arr.add("SQ");
				}if(arr.size()==38){
					arr.add("SK");
				}else{
					arr.add("S"+(arr.size()+1-26));
				}
				crearBaraja(arr);
			}if(arr.size()>36 && arr.size()<52) {
				if(arr.size()==49){
					arr.add("TJ");
				}if(arr.size()==50){
					arr.add("TQ");
				}if(arr.size()==51){
					arr.add("TK");
				}else{
					arr.add("T"+(arr.size()+1-39));
				}
				crearBaraja(arr);
			}
		}
	}
}
