package EjerciciosDeClase.Herencia;

public class Main {
	public static void main(String[] args) {
		opcion(3);
	}

	private static void opcion(int n) {
		Usuario u;
		VentanaUsuario v = null;
		switch (n) {
		case 1:
			u = new Usuario("Jon", "NOJ");
			v = new VentanaUsuario(u);
			break;
		case 2:
			u = new UsuarioFoto("Jon", "NOJ","Herencia/persona.png");
			v = new VentanaFoto((UsuarioFoto) u);
			break;
		case 3:
			u = new UsuarioNivel("Jon", "NOJ",2);
			v = new VentanaNivel((UsuarioNivel) u);
			break;
		}
		v.setVisible(true);
	}
}
