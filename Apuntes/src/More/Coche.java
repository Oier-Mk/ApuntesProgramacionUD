package More;
//Método setter = definir(cambiar, proporcionar) un atributo/propiedad
//Método getter = captar(obtener) un atributo/propiedad

//SINTAXIS del GETTER
//public dato_a_devolver nombre_método(){ código + return}

//SINTAXIS del SETTER
//public void nombre_método() {código}
//void = NO DEVUELVE VALOR, osea, no tiene return
public class Coche { //la public es la unica que puede dar nombre al fichero de java
	private int ruedas; //int porque tiene 4 ruedas un coche siempre
	//Con el private, ENCAPSULAMOS las ruedas para que no puedan modificarse
	private int largo; //int porq estará en cm
	private int ancho; //int porque estará en cm
	@SuppressWarnings("unused")
	private int motor; //int porq cm3
	private int peso_plataforma;
	private String color;
	private int peso_total;
	private boolean asientos_cuero, climatizador;
	
	public Coche() { //Constructor de la clase
		ruedas = 4;
		largo = 2000;
		ancho = 300;
		motor = 1600;
		peso_plataforma = 500;
	}
	public String dime_largo(){//Método GETTER
		return "El largo del coche es " + largo;
	}
	public String dime_datos_generales(){//Método GETTER
		return "La plataforma del vehículo tiene " + ruedas + " ruedas" +
				". Mide " + largo/1000 + " metros con un ancho de " + ancho +
				" cm y un peso de plataforma " + peso_plataforma +  "kg.";
	}
	public String dime_color() {
		return "El color del coche es " + color;
	}
	//Si solo quisiese que me devolviese el numero de ruedas pondría
	//public int , pero como en este caso quesemos que nos devuelva una frase rollo "El coche tiene c4 ruedas" ponermos
	//public String
	
	public void establece_color(String color_coche) {//Método SETTER
		color = color_coche;
	}
	public void configura_asientos(String asientos_cuero) {//SETTER
		if (asientos_cuero.equalsIgnoreCase("si")) {
			this.asientos_cuero = true;
			//this.asientos_cuero = asientos_cuero
			//el THIS lo ponemos en caso de la clase coincida con el nombre de la variable y para diferenciarlo
		}else {
			this.asientos_cuero = false;
		}
	}
	public String dime_asientos() { //GETTER
		if(asientos_cuero==true) {
			return "El coche tiene asientos de cuero";
		}else {
			return "El coche tiene asientos de serie";
	}			
	}
	public void configura_climatizador (String climatizador) {
		if(climatizador.equalsIgnoreCase("si")) {
			this.climatizador = true;
		}else {
			this.climatizador = false;
		}
	}
	public String dime_climatizador() {
		if(climatizador == true) {
			return "El coche tiene climatizador";	
		}else {
			return "El coche tiene aire acondicionado";
		}
	}
	public String dime_peso_coche() {
		int peso_carroceria = 500;
		peso_total = peso_plataforma + peso_carroceria;
		if(asientos_cuero==true) {
			peso_total += 50;			
		}
		if(climatizador=true) {
			peso_total += 20;
		}
		return "El peso del coche es " + peso_total;
	}
	public int dime_precio_coche() {//GETTER = RETURN
		int precio_final = 10000;
		if(asientos_cuero==true) {
			precio_final +=2000;
		}
		if(climatizador==true) {
			precio_final+=1500;
		}
		return precio_final;
	}
}
