
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class t18_1 {
	
	static Connection conexion;

	public static void main(String[] args) {
		/*mySQLConnection ("root", "primero","");
		createDB ("manuel");*/
	}
 
	public static void createDB(String name) {
		try {
			String Query = "CREATE DATABASE " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
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
}