package br.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	
	public static void main(String args[]) {
		try {
			if(getConnectionMySQL() !=null)
				System.out.println("CONECTADO!!!!");
			else
				System.out.println("NÃO CONECTADO!!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnectionMySQL() throws ClassNotFoundException, SQLException {
		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/engsoftiii?useSSL=false&useTimezone=true&serverTimezone=UTC";
		user = "root";
		password = "admin";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
}
