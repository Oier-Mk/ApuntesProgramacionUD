package EjerciciosDeClase.EjercicioCSV;

import Library.PersonalFuncions;

public class Jugador {
	String nombre;
	int ganados;
	int perdidos;

	public Jugador(String nombre, int ganados, int perdidos) {
		setGanados(ganados);
		setPerdidos(perdidos);
		setNombre(nombre);
		/*
		 * Define la ordenación de ese conjunto para que los tenistas se ordenen por diferencia de 
		 * partidos ganados menos perdidos (primero los de mayor diferencia), y a igualdad por mayor 
		 * número de partidos ganados
		 * PARA MI ESTO NO TIENE NINGÚN SENTIDO
		 */
		if (ganados-perdidos == 0) {
			ProcesoCSVTenis.ranking.put(PersonalFuncions.num2threeDigitStr(ganados)+nombre, this);
		}else{
			ProcesoCSVTenis.ranking.put(PersonalFuncions.num2threeDigitStr(ganados-perdidos)+nombre, this);
		}
	}

	@Override
	public String toString() {
		if (ganados-perdidos == 0) {
			return PersonalFuncions.num2threeDigitStr(ganados) + "Jugador [nombre=" + nombre + ", ganados=" + ganados + ", perdidos=" + perdidos + "]";
		}else{
			return PersonalFuncions.num2threeDigitStr(ganados-perdidos) + "Jugador [nombre=" + nombre + ", ganados=" + ganados + ", perdidos=" + perdidos + "]";
		}
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGanados() {
		return ganados;
	}

	public void setGanados(int ganados) {
		this.ganados = ganados;
	}

	public int getPerdidos() {
		return perdidos;
	}

	public void setPerdidos(int perdidos) {
		this.perdidos = perdidos;
	}
}
