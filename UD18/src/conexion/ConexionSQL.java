package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionSQL {
	
	static Connection conexion;

	public static void createDB(String name) {
		try {
			String query = "DROP DATABASE IF EXISTS " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(query);
			query = "CREATE DATABASE " + name;
			st = conexion.createStatement();
			st.executeUpdate(query);
			closeConnection();
			mySQLConnection("root", "primero", name);
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exitosa.");
		}catch (SQLException ex) {
			System.out.println("Falla la creación");
		}
	}
	public static void mySQLConnection(String usuario, String contrasenya, String bbdd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:32768/", "root", "primero");
			System.out.println("Server Connected");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con la bbdd");
			System.out.println(ex);
		}
	}

	public static void closeConnection() {
		try {
			conexion.close();
			System.out.println("Se ha finalizado la conexion con el servidor");

		}catch(SQLException ex){
			System.out.println("Falla el cierre de conexión");
		}	
	}
	
	public static void createTable(String db, String name, String sentencia) {
		try {
			String Querydb = "USE " +db+ ";";
			Statement stdb= conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			
			String Query = "CREATE TABLE "+name+ " " + sentencia;
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Tabla creada con éxito");
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla");
		}
	}
	public static void insertData(String db, String name, String sentencia) {
		try {
			String Querydb = "USE " +db+ ";";
			Statement stdb= conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT into "+name + " "+ sentencia;
			
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Datos insertados con éxito");
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error insertando datos");
		}
	}
}