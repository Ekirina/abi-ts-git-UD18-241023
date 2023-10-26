package ejercicio6;

import conexion.ConexionSQL;

public class PiezasProveedores {

	public static void main(String[] args) {
		ConexionSQL.mySQLConnection("root", "primero", "");
		ConexionSQL.createDB("piezasproveedores");
		ConexionSQL.createTable("piezasproveedores", "Piezas", "("
				+ "codigo INT primary key,"
				+ "nombre VARCHAR(100))");
		ConexionSQL.createTable("piezasproveedores", "Proveedores", "("
				+ "id VARCHAR(4) primary key,"
				+ "nombre VARCHAR(100))");
		ConexionSQL.createTable("piezasproveedores", "Suministra", "("
				+ "codigo_pieza INT,"
				+ "id_proveedor VARCHAR(4),"
				+ "precio INT,"
				+ "foreign key (codigo_pieza) REFERENCES Piezas(codigo)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "foreign key (id_proveedor) REFERENCES Proveedores(id)"
				+ "ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "primary key(codigo_pieza, id_proveedor))");
		ConexionSQL.insertData("piezasproveedores", "Piezas", "(codigo, nombre) values (187, 'tornillo'),"
				+ "(287, 'alicates'), (387, 'destornillador'), (487, 'clavos'), (587, 'brocas');");
		ConexionSQL.insertData("piezasproveedores", "Proveedores", "(id, nombre) values "
				+ "('L234', 'bosch'),('L235',  'ridex'), ('L236', 'mapco'),"
				+ " ('L237', 'vaico'), ('L238', 'brembo');");
		ConexionSQL.insertData("piezasproveedores", "Suministra", "(codigo_pieza, id_proveedor, precio) values (187, 'L234', 300),"
				+ "(287, 'L238', 500), (387, 'L235', 200), (487, 'L236', 800), (587, 'L237', 600);");
		ConexionSQL.closeConnection();

	}

}
