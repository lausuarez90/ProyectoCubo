package com.proyecto.cubo.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class UtilidadBaseDatos {
	
	public  Connection obtenerConexion(){

		Connection connection = null;

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");



		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://baasu.db.elephantsql.com:5432/tcoaoips", "tcoaoips",
					"AW7ZvjLRn8eDlu-sL4T95mbl2TdOJ5LL");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}



		return connection;

	}

}
