package com.TF.Model.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseMysql {
	private static final String url = "jdbc:mysql://localhost:3306/patronessoftware?verifyServerCertificate=false&useSSL=true";
	private static final String user = "root";
	private static final String password = "root";
	
	private Connection con;

	public Connection connectDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
