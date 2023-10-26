package ejercicio9;

import conexion.ConexionSQL;

public class LosInvestigadores {

	public static void main(String[] args) {
		ConexionSQL.mySQLConnection("root", "primero", "");
		ConexionSQL.createDB("los_investigadores");
		ConexionSQL.createTable("los_investigadores", "Facultad", "("
				+ "codigo INT primary key,"
				+ "nombre VARCHAR(100))");
		ConexionSQL.createTable("los_investigadores", "Equipos", "("
				+ "num_serie VARCHAR(4) primary key,"
				+ "nombre VARCHAR(100),"
				+ "facultad INT,"
				+ "foreign key (facultad) REFERENCES Facultad(codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE)");		
		ConexionSQL.createTable("los_investigadores", "Investigadores", "("
				+ "dni VARCHAR(8) primary key,"
				+ "nom_apels VARCHAR(255),"
				+ "facultad int,"
				+ "foreign key (facultad) REFERENCES Facultad(codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE)");
		ConexionSQL.createTable("los_investigadores", "Reserva", "("
				+ "dni VARCHAR(8),"
				+ "num_serie VARCHAR(4),"
				+ "comienzo datetime, "
				+ "fin datetime,"
				+ "foreign key (dni) REFERENCES Investigadores(dni)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "foreign key (num_serie) REFERENCES Equipos(num_serie)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE)");
		ConexionSQL.insertData("los_investigadores", "Facultad", "(codigo, nombre) values (1000, 'Medicina'),"
				+ "(1002, 'Historia'), (1003, 'Geografia'), (1004, 'Ingenieria'), (1005, 'Matemáticas');");
		ConexionSQL.insertData("los_investigadores", "Equipos", "(num_serie, nombre, facultad) values ('n123', 'Varanus', 1003),"
				+ "('n232', 'Heloderma horridum', 1002), ('n323', 'Canis lupus lycaon', 1000), ('n432', 'Aonyx cinerea', 1004), ('n523', 'Felis catus', 1005);");
		ConexionSQL.insertData("los_investigadores", "Investigadores", "(dni, nom_apels, facultad) values "
				+ "('3453467I', 'Barbara-anne Suart', 1002),('8876321P', 'Ibrahim Riha', 1000), ('9875432U', 'Peadar Lebbon', 1003), "
				+ "('5463721R', 'Arabele Dighton', 1004), ('7676543Y', 'Bogart Belchem', 1005);");
		ConexionSQL.insertData("los_investigadores", "Reserva", "(dni, num_serie, comienzo, fin) values "
				+ "('3453467I', 'n523', '2023-06-14 09:02:15', '2023-12-03 19:40:10'),"
				+ "('8876321P', 'n232', '2023-02-03 10:52:26', '2023-10-31 08:58:38'), "
				+ "('9875432U', 'n323', '2023-03-17 23:25:44', '2023-12-14 06:40:06'), "
				+ "('5463721R', 'n123', '2022-11-13 15:30:42', '2023-11-07 03:02:24'), "
				+ "('7676543Y', 'n523', '2023-09-25 15:58:11', '2023-12-09 01:49:48');");
		ConexionSQL.closeConnection();
	}

}
