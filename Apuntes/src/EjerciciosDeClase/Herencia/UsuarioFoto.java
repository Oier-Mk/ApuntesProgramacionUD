package EjerciciosDeClase.Herencia;


public class UsuarioFoto extends Usuario{
	String foto;
	public UsuarioFoto(String nombre, String contraseña, String foto) {
		super(nombre, contraseña);
		setFoto(foto);
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	@Override
	public String toString() {
		return "UsuarioFoto [foto=" + foto + ", nombre=" + nombre + ", contraseña=" + contraseña + "]";
	}
}
