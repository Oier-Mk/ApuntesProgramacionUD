package Basic;

public class MathematicalIssues {
	//Clase Math: clase predeterminada
	//Son métodos dentro de una clase (biblioteca) para hacer los cálculos más sencillos sin tener que aprenderlos
	//Math.sqrt(n); = raiz cuadrada de un nº al cuadrado
	//Math.pow(base, exponente): potencia de un numero. Base y exponente son doubles
	//Math.sin(ángulo);
	//Math.cos(ángulo);
	//Math.tan(ángulo);
	//Math.atan(ángulo); = arcotang
	//Math.round(decimal) = redondeo de un número
	//Math.PI = constante de clase con el numero PI
	public static void main(String[] args) {
		//ERROR prq sqrt solo puede ser double (int raiz = Math.sqrt(a))
		double raiz = Math.sqrt(9);
		System.out.println(raiz);
		//Nos devuelve un 3.0 porq es un double
		
		//Redondea este numero
		float num1=5.85f;
		int resultado = Math.round(num1);
		System.out.println(resultado);
		
		//REFUNDICION: cuando queremos hacer un metodo que nos obliga a sacar un primitivo que no queremos
		//ej. queremos hacer lo mismo que antes pero en vez de dar un float damos un doble
		//y queremos redondearlo a un int, si o si pero no nos deja
		double num2 = 5.85;
		int solucion = (int)Math.round(num2);
		System.out.println(solucion);
		
		double base = 5;
		double exponente = 3;
		double res = Math.pow(base, exponente);
		System.out.println(res);
		//REFUNDICION
		double base1 = 5;
		double exponente1 = 3;
		int res1 = (int)Math.pow(base1, exponente1);
		System.out.println("El resultado de " + base1 + " elevado a " + exponente1 + " es " + res1);

	}

}
