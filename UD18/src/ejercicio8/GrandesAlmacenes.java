package ejercicio8;

import conexion.ConexionSQL;

public class GrandesAlmacenes {

	public static void main(String[] args) {
		ConexionSQL.mySQLConnection("root", "primero", "");
		ConexionSQL.createDB("grandes_almacenes");
		ConexionSQL.createTable("grandes_almacenes", "Cajeros", "("
				+ "codigo INT primary key,"
				+ "nom_apels VARCHAR(255))");
		ConexionSQL.createTable("grandes_almacenes", "Productos", "("
				+ "codigo INT primary key,"
				+ "nombre VARCHAR(100),"
				+ "precio INT)");		
		ConexionSQL.createTable("grandes_almacenes", "Maquinas_registradoras", "("
				+ "codigo INT primary key,"
				+ "piso INT)");
		ConexionSQL.createTable("grandes_almacenes", "Venta", "("
				+ "cajero INT,"
				+ "maquina INT,"
				+ "producto INT,"
				+ "foreign key (cajero) REFERENCES Cajeros(codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "foreign key (maquina) REFERENCES Maquinas_registradoras(codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "foreign key (producto) REFERENCES Productos(codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE)");
		ConexionSQL.insertData("grandes_almacenes", "Cajeros", "(codigo, nom_apels) values (1000, 'Mónica Geler Trenza'),"
				+ "(1002, 'Josh Pull Mac'), (1003, 'Marina Lara Manga'), (1004, 'Leonardo Cabrales Zui'), (1005, 'Terry Monsier Nut');");
		ConexionSQL.insertData("grandes_almacenes", "Productos", "(codigo, nombre, precio) values (123, 'Cera depilatoria', 3),"
				+ "(232, 'Jabón de manos', 2), (323, 'Esponja exfoliante', 1), (432, 'Colonia', 20), (523, 'Desodorante', 2);");
		ConexionSQL.insertData("grandes_almacenes", "Maquinas_registradoras", "(codigo, piso) values "
				+ "(546578, 1),(34456, 0), (120676, 2), (244223, 3), (563373, 4);");
		ConexionSQL.insertData("grandes_almacenes", "Venta", "(cajero, maquina, producto) values (1000, 563373, 123),"
				+ "(1002, 546578, 323), (1002, 34456, 432), (1004, 120676, 523), (1005, 244223, 123);");
		ConexionSQL.closeConnection();
	}

}
