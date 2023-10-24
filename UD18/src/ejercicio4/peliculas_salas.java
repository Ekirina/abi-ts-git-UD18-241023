package ejercicio4;

import conexion.ConexionSQL;

public class peliculas_salas {

	public static void main(String[] args) {
		ConexionSQL.mySQLConnection("root", "primero", "");
		ConexionSQL.createDB("peliculas_salas");
		ConexionSQL.createTable("peliculas_salas", "Peliculas", "("
				+ "codigo INT primary key auto_increment,"
				+ "nombre VARCHAR(100),"
				+ "calificacion_edad INT)");
		ConexionSQL.createTable("peliculas_salas", "Salas", "("
				+ "codigo INT primary key auto_increment,"
				+ "nombre VARCHAR(100), "
				+ "pelicula INT, "
				+ "foreign key (pelicula) REFERENCES Peliculas(codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE)");
		ConexionSQL.insertData("peliculas_salas", "Peliculas", "(nombre, calificacion_edad) values ('Top Gun', 12 ),"
				+ "('Malditos bastardos', 18 ), ('Tarzán', 8), ('Regreso al futuro', 8), ('Fight Club', 18);");
		ConexionSQL.insertData("peliculas_salas", "Salas", "(nombre, pelicula) values "
				+ "('Terra', 3),('Foc', 2), ('Vent', 1),"
				+ " ('Aigua', 5), ('Cor', 4);");
		ConexionSQL.closeConnection();

	}

}
