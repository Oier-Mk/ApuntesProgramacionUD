package BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class BaseDatos {
	protected static Connection conexion;
	public static Statement stmt;

	/** Abre conexión con la base de datos
	 * @param nombreBD	Nombre del fichero de base de datos
	 * @return	true si la conexión ha sido correcta, false en caso contrario
	 */
	public static boolean abrirConexion( String nombreBD ) {
		try {
			System.out.println( "Conexión abierta" );
			Class.forName("org.sqlite.JDBC");  // Carga la clase de BD para sqlite
			conexion = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			stmt = conexion.createStatement();

			/*
			// No lo pide el ejercicio, pero si se quiere crear la base de datos si no existe desde el propio programa habría que hacer esto:
			// creación bd
			Statement statement = conexion.createStatement();
			String sent = "CREATE TABLE IF NOT EXISTS producto (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre varchar(100), precio real);";
			System.out.println( sent );
			statement.executeUpdate( sent );
			sent = "CREATE TABLE IF NOT EXISTS compra (id INTEGER PRIMARY KEY AUTOINCREMENT, idProducto int, fecha bigint, cantidad int);";
			System.out.println( sent );
			statement.executeUpdate( sent );
			try {
				sent = "insert into producto (id, nombre, precio) values (1,'Jamón para profesor',345);";
				System.out.println( sent );
				statement.executeUpdate( sent );
				sent = "insert into producto (id, nombre, precio) values (2,'Crucifijo rezos pre-examen',42);";
				System.out.println( sent );
				statement.executeUpdate( sent );
				sent = "insert into producto (id, nombre, precio) values (3,'Asesor programación Java (hora)',25);";
				System.out.println( sent );
				statement.executeUpdate( sent );
			} catch(Exception e) {}  // Es normal que haya error en los inserts si ya existen las claves
			// fin creación bd
			 */
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/** Cierra la conexión abierta de base de datos ({@link #abrirConexion(String)})
	 */
	public static void cerrarConexion() {
		try {
			conexion.close();
			System.out.println( "Conexión cerrada" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/** Lee los productos de la conexión de base de datos abierta
	 * @return	Lista completa de productos, null si hay algún error
	 */
	public static ArrayList<Producto> getProductos() {
		ArrayList<Producto> lista = new ArrayList<>();
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCTO");
			while(rs.next()) {
				Producto p = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getInt("precio"), new ArrayList<>());
				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	/** Inserta una compra en la base de datos abierta
	 * Actualiza el id de la compra insertada
	 * @param compra	Compra a insertar
	 * @return	true si la inserción es correcta, false en caso contrario
	 */
	public static boolean insertarCompra( Compra compra ) {
		try {
			stmt.executeQuery("INSERT INTO compras (id,ifproducto,cantidad,fecha) VALUES ('"+compra.getId()+"','"+compra.getProducto().getId()+"','"+compra.getCantidad()+"','"+compra.getFecha()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/** Lee las compras de un producto dado de la conexión de base de datos abierta
	 * @return	Lista completa de compras de ese producto, vacía si no hay ninguna, null si hay algún error
	 */
	public static ArrayList<Compra> getCompras() {
		ArrayList<Compra> lista = new ArrayList<>();
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM compras");
			while(rs.next()) {
				int id = rs.getInt("id");
				int fecha = rs.getInt("fecha");
				int cantidad = rs.getInt("cantidad");
				int idprod = rs.getInt("ifproducto");
				ResultSet rs2 = stmt.executeQuery("SELECT * FROM producto");
				Producto producto1 = new Producto(rs2.getInt("id"), rs2.getString("nombre"), rs2.getInt("precio"), new ArrayList<>());
				Compra c = new Compra(id, fecha, cantidad, producto1);
				lista.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return lista;
	}

	/** Borra una compra en la base de datos abierta
	 * @param compra	Compra a borrar
	 * @return	true si el borrado es correcto, false en caso contrario
	 */
	public static boolean borrarCompra( Compra compra ) {
		// TODO
		return false;
	}


}
