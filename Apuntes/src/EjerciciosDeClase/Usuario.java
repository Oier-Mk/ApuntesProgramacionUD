package EjerciciosDeClase;

import java.io.File;

public class Usuario {
	protected String nombre, apellidos, grado, universidad;
	protected File pathDni;
	Usuario claseUsuario;
	
	protected Usuario(String nombre, String apellidos, String grado, String Unicersidad, File pathDni) {
		this.nombre = null;
		this.apellidos = null;
		this.grado = null;
		this.universidad = null;
		this.pathDni = null;
	}
	
	

	protected Usuario () { //Constructor vacio. Preguntar duda en clase. Podemos hacer un setX sobre un Usuario creado a partir de un constructor vacio. Si es asi, que se lo que se modifica si no es vacio?
	}
	
	
	
	public File getPathDni() {
		return pathDni;
	}
	public void setPathDni(File pathDni) {
		this.pathDni = pathDni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public String getUniversidad() {
		return universidad;
	}
	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", grado=" + grado + ", universidad="
				+ universidad + ", pathDni=" + pathDni + ", claseUsuario=" + claseUsuario + "]";
	}

}
