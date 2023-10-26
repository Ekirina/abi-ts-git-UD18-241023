package ejercicio7;

import conexion.ConexionSQL;

public class LosCientificos {

	public static void main(String[] args) {
		ConexionSQL.mySQLConnection("root", "primero", "");
		ConexionSQL.createDB("los_cientificos");
		ConexionSQL.createTable("los_cientificos", "Cientificos", "("
				+ "dni VARCHAR(8) primary key,"
				+ "nom_apels VARCHAR(255))");
		ConexionSQL.createTable("los_cientificos", "Proyecto", "("
				+ "id VARCHAR(4) primary key,"
				+ "nombre VARCHAR(255), "
				+ "horas INT)");
		ConexionSQL.createTable("los_cientificos", "Asignado", "("
				+ "dni_cientifico VARCHAR(8),"
				+ "id_proyecto VARCHAR(4),"
				+ "foreign key (dni_cientifico) REFERENCES Cientificos (dni)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "foreign key (id_proyecto) REFERENCES Proyecto (id)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "primary key (dni_cientifico, id_proyecto))");
		ConexionSQL.insertData("los_cientificos", "Cientificos", "(dni, nom_apels) values ('4543211Q', 'Juditha Franchioni'),"
				+ "('4987564K', 'Rory Bleasdale'), ('9085554G', 'Marta Benito Lunares'), ('8711290H', 'Loralie Alberti'), "
				+ "('7654328J', 'Sidonnie Scutcheon');");
		ConexionSQL.insertData("los_cientificos", "Proyecto", "(id, nombre, horas) values "
				+ "('1212', 'Jenkins', 150),('1213', 'Gutkowski', 400), ('1214', 'Hilpert-Yost', 200),"
				+ " ('1215', 'Daugherty Group', 350), ('1216', 'Pearl', 700);");
		ConexionSQL.insertData("los_cientificos", "Asignado", "(dni_cientifico, id_proyecto) values ('4543211Q', '1212'),"
				+ "('4987564K', '1213'), ('9085554G', '1214'), ('8711290H', '1214'), ('7654328J', '1214');");
		ConexionSQL.closeConnection();
	}

}
