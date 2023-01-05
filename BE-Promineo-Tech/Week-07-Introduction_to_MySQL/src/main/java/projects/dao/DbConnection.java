package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import projects.exception.DbException;

public class DbConnection {
	private static String Host = "localhost";
	private static String Password = "projects";
	private static int PORT = 3306;
	private static String Schema = "projects";
	private static String USER = "projects";
	
	public static Connection getConnection(){
		String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s", Host, PORT, Schema, USER, Password);
		try {
			Connection conn = DriverManager.getConnection(uri);
			System.out.println("Connection to schema " + Schema + " is successful.");
			return conn;
		} catch (SQLException e) {
			System.out.println("Unable to get connection at " + uri);
			throw new DbException("Unable to get connection at " + uri);
		}		
	}
}
