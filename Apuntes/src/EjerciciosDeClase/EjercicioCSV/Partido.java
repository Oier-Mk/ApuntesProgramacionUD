package EjerciciosDeClase.EjercicioCSV;

import java.util.ArrayList;
import java.util.Date;

public class Partido {
	Date fecha;
	String torneo;
	String tipo;
	String ronda;
	String ganador;
	String perdedor;
	int setsGanados;
	int setsPerdidos;
	public Partido(Date fecha, String torneo, String tipo, String ronda, String ganador, String perdedor,
			int setsGanados, int setsPerdidos) {
		setFecha(fecha);
		setGanador(ganador);
		setPerdedor(perdedor);
		setRonda(ronda);
		setSetsGanados(setsGanados);
		setSetsPerdidos(setsPerdidos);
		setTipo(tipo);
		setTorneo(torneo);
		addJugadorYPartido(ganador);
		addJugadorYPartido(perdedor);
	}
	@Override
	public String toString() {
		return "Partido [fecha=" + fecha + ", torneo=" + torneo + ", tipo=" + tipo + ", ronda=" + ronda + ", ganador="
				+ ganador + ", perdedor=" + perdedor + ", setsGanados=" + setsGanados + ", setsPerdidos=" + setsPerdidos
				+ "]";
	}

	private void addJugadorYPartido(String persona) {
		 ArrayList<ArrayList<Partido>> lista = ProcesoCSVTenis.mapaJugadores.get(persona);
		if (lista == null) {
			lista = new ArrayList<ArrayList<Partido>>();
			lista.add(new ArrayList<Partido>()); //lista ganados
			lista.add(new ArrayList<Partido>()); //lista perdidos
			
		} else {
			if (this.getGanador().contentEquals(persona)) {
				lista.get(0).add(this);
//				System.out.println(this.toString());
//				System.out.println("añadeganador");
			}
			else if (this.getPerdedor().contentEquals(persona)) {
				lista.get(1).add(this);
//				System.out.println(this.toString());
//				System.out.println("añadeperdedor");
			}
		}
		ProcesoCSVTenis.mapaJugadores.put(persona, lista);
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRonda() {
		return ronda;
	}

	public void setRonda(String ronda) {
		this.ronda = ronda;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public String getPerdedor() {
		return perdedor;
	}

	public void setPerdedor(String perdedor) {
		this.perdedor = perdedor;
	}

	public int getSetsGanados() {
		return setsGanados;
	}

	public void setSetsGanados(int setsGanados) {
		this.setsGanados = setsGanados;
	}

	public int getSetsPerdidos() {
		return setsPerdidos;
	}

	public void setSetsPerdidos(int setsPerdidos) {
		this.setsPerdidos = setsPerdidos;
	}
}
