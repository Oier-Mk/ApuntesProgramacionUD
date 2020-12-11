package BasesDeDatos;


import java.sql.*;
import java.util.ArrayList;

public class EjemploSQL {

	/** Inicializa una BD SQLITE y devuelve una conexión con ella
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
	 */
	
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
		    return con;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	
	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual. Devuelve un statement para trabajar con esa base de datos
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarCrearTablasBD( Connection con ) {
		
		//statement.executeUpdate : Cuando queramos hacer create, insert, delete, update, drop
		//statement.executeQuery : Cuando queramos hacer select
		
		
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("create table Meet "+
						   "(nombre string, "+
						   " email string, "+
						   " duracion string, "+
						   " horaInicio string, "+
						   "horaFin string )");
				return statement;
		} catch (SQLException e) {
			return null;
		}
	}
	
	/** Reinicia en blanco las tablas de la base de datos. 
	 * UTILIZAR ESTE MËTODO CON PRECAUCIÓN. Borra todos los datos que hubiera ya en las tablas
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se borra correctamente, null si hay cualquier error
	 */
	public static Statement reiniciarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("drop table if exists Meet");
			//statement.executeUpdate("drop table if exists otraTabla");
			return usarCrearTablasBD( con );
		} catch (SQLException e) {
			return null;
		}
	}
	
	/** Cierra la base de datos abierta
	 * @param con	Conexión abierta de la BD
	 * @param st	Sentencia abierta de la BD
	 */
	public static void cerrarBD( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
		} catch (SQLException e) {
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////
	//                      Operaciones sobre tablas                   //
	/////////////////////////////////////////////////////////////////////
	
	public static void borrarTabla(String nombreBD, String nombreTabla) {
		String s = "drop table if exists "+nombreTabla;
		Connection con = initBD(nombreBD);
		Statement st = null;
		
		try {
			st = con.createStatement();
			st.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarBD(con, st);
		}
	}
	public static void crearNuevaTabla(String nombreBD, String nomTabla) {
		borrarTabla(nombreBD, nomTabla);
		String s = "create table if not exists " + nomTabla + " (nombre string, email string, duracion string, horaInicio string, horaFin string)";
		Connection con = initBD(nombreBD);
		Statement st = null;
		
		try {
			st = con.createStatement();
			st.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarBD(con, st);
		}
		
	}
	//ANDONI
	public static void insertarNuevaFila(String nombreBD, String nomTabla, String nombre, String email, String duracion, String horaInicio, String horaFin) {
		String s = "insert into "+nomTabla+" values('"+nombre+"','"+email+"','"+duracion+"','"+horaInicio+"','"+horaFin+"')";
		Connection con = initBD(nombreBD);
		Statement st = null;
		
		try {
			st = con.createStatement();
			st.executeUpdate(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarBD(con, st);
		}
	}


	public static ArrayList<ArrayList<String>> obtenerTodasLasFilas(String nombreBD, String nomTabla){
		ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
		Connection con = EjemploSQL.initBD(nombreBD);
		Statement st = null;
		String s = "SELECT * FROM "+nomTabla;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(s);
			while(rs.next()) {
				ArrayList<String> fila = new ArrayList<>();
				/*fila.add(rs.getString(1));
				fila.add(rs.getString(2));
				fila.add(rs.getString(3));
				fila.add(rs.getString(4));
				fila.add(rs.getString(5));*/
				for(int i=1;i<=5;i++)
					fila.add(rs.getString(i));
				datos.add(fila);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}