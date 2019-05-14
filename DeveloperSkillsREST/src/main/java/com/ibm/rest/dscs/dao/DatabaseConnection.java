package com.ibm.rest.dscs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public Connection getConnection() throws SQLException {
		Connection connection = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver"); //load driver in the program
			DriverManager.setLoginTimeout(10); //optional
			                                         //constant                //port//database //username //password
			connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/dscs","root","root");
		    System.out.println("CONNECTION: " + connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}

}
