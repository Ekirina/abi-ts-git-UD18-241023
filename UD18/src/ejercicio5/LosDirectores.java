package ejercicio5;

import conexion.ConexionSQL;

public class LosDirectores {

	public static void main(String[] args) {
		ConexionSQL.mySQLConnection("root", "primero", "");
		ConexionSQL.createDB("directores");
		ConexionSQL.createTable("directores", "Despachos", "("
				+ "numero INT primary key auto_increment,"
				+ "capacidad INT)");
		ConexionSQL.createTable("directores", "Director", "("
				+ "dni VARCHAR(8) primary key,"
				+ "nom_apels VARCHAR(255), "
				+ "dni_jefe VARCHAR(8), "
				+ "despacho INT, "
				+ "foreign key (dni_jefe) REFERENCES Director(dni)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "foreign key (despacho) REFERENCES Despachos (numero)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE)");
		ConexionSQL.insertData("directores", "Despachos", "(capacidad) values (2000),"
				+ "(9000), (8700), (2100), (5000);");
		ConexionSQL.insertData("directores", "Director", "(dni, nom_apels, dni_jefe, despacho) values "
				+ "('5678908T', 'Julio Méndez Torres', '5678908T', 1),('4562234O', 'Moria Juncosa Plana', '5678908T', 3), "
				+ "('9878732E', 'Valeria Paz Mella', '5678908T', 5), ('9711109X', 'Juan López Rosa', '9711109X', 2), "
				+ "('6554286R', 'Alejandro Gurnés Banzam', '9711109X', 3);");
		ConexionSQL.closeConnection();
	}

}
