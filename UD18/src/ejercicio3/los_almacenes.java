package ejercicio3;

import conexion.ConexionSQL;

public class los_almacenes {

	public static void main(String[] args) {
		ConexionSQL.mySQLConnection("root", "primero", "");
		ConexionSQL.createDB("losAlmacenes");
		ConexionSQL.createTable("losAlmacenes", "Almacenes", "("
				+ "codigo INT primary key auto_increment,"
				+ "lugar VARCHAR(100),"
				+ "capacidad INT)");
		ConexionSQL.createTable("losAlmacenes", "Cajas", "("
				+ "num_ref VARCHAR(5) primary key,"
				+ "contenido VARCHAR(100), "
				+ "valor INT, "
				+ "almacen INT, "
				+ "foreign key (almacen) REFERENCES Almacenes(codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE)");
		ConexionSQL.insertData("losAlmacenes", "Almacenes", "(lugar, capacidad) values "
				+ "('París', 20000), ('Londres', 10000), ('Berlín', 15000), ('Madrid', 9000), "
				+ "('Dublín', 5600);");
		ConexionSQL.insertData("losAlmacenes", "Cajas", "(num_ref, contenido, valor, almacen) values "
				+ "(1000, 'caramelos', 90000, 1),(1001, 'chocolate', 15000, 2), (1002, 'agua con gas', 7000, 3),"
				+ "(1003, 'queso', 30000, 4), (1004, 'regaliz', 60000, 5);");
		ConexionSQL.closeConnection();

	}
}
