package com.TF.Model.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBasePostgre {
	private static final String url = "jdbc:postgresql://localhost:5432/dbpatronestf";
	private static final String user = "postgres";
	private static final String password = "root";
	
	private Connection con;

	public Connection connectDb() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
		}
		return con;
	}

	public void desconnectDb() {
		try {
			con.close();
		} catch (Exception e) {
		}
	}
}
