package ejercicio1;

import conexion.ConexionSQL;

public class tienda_informatica {

	public static void main(String[] args) {
		ConexionSQL.mySQLConnection("root", "primero", "");
		ConexionSQL.createDB("tienda");
		ConexionSQL.createTable("tienda", "Fabricantes", "("
				+ "codigo INT primary key auto_increment,"
				+ "nombre VARCHAR(100))");
		ConexionSQL.createTable("tienda", "Articulos", "("
				+ "codigo INT primary key auto_increment,"
				+ "nombre VARCHAR(100), "
				+ "precio INT, "
				+ "fabricante INT, "
				+ "foreign key (fabricante) REFERENCES Fabricantes(codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE)");
		ConexionSQL.insertData("tienda", "Fabricantes", "(codigo, nombre) values (1, 'Sony'),"
				+ "(2, 'Nikon'), (3, 'Olympus'), (4, 'Kodak'), (5, 'Canon');");
		ConexionSQL.insertData("tienda", "Articulos", "(nombre, precio, fabricante) values "
				+ "('Camara compacta', 15, 1),('Camara aps', 40, 1), ('Camara reflex SLR', 120, 5),"
				+ " ('Camara digital', 23, 3), ('Camara sin espejo', 73, 2);");
		ConexionSQL.closeConnection();
	}

}
