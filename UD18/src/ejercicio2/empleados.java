package ejercicio2;

import conexion.ConexionSQL;

public class empleados {

		public static void main(String[] args) {
			ConexionSQL.mySQLConnection("root", "primero", "");
			ConexionSQL.createDB("empleados");
			ConexionSQL.createTable("empleados", "Departamentos", "("
					+ "codigo INT primary key auto_increment,"
					+ "nombre VARCHAR(100),"
					+ "presupuesto INT);");
			ConexionSQL.createTable("empleados", "Empleados", "("
					+ "dni VARCHAR(8) primary key,"
					+ "nombre VARCHAR(100),"
					+ "apellidos VARCHAR(255), "
					+ "departamento INT,"
					+ "foreign key (departamento) REFERENCES Departamentos(codigo)"
					+ "ON DELETE CASCADE ON UPDATE CASCADE);");
			ConexionSQL.insertData("empleados", "Departamentos", "(nombre, presupuesto)"
					+ " values ('financiero', 12300), ('recursos humanos', 5600), "
					+ "('marketing', 18500), ('logística y operaciones', 10900), ('compras', 32900);");
			ConexionSQL.insertData("empleados", "Empleados", "(dni, nombre, apellidos, departamento) "
					+ "values ('1653821T', 'Jaime', 'Martínez de la Rosa', 1),"
					+ "('3211873R', 'Úrsula', 'Naoi Mendéz', 2), "
					+ "('1239063L', 'Jimena', 'Gómez Miramar', 3),"
					+ "('8684321S', 'Carlos', 'Fernández Boniato', 4), "
					+ "('4532116U', 'Manolo', 'Ganijo Fresno', 5);");
			ConexionSQL.closeConnection();

		}

	}


