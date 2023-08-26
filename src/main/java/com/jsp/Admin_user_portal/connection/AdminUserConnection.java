package com.jsp.Admin_user_portal.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdminUserConnection {

	public static Connection getAdminUserConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url  = "jdbc:mysql://localhost:3306/jdbc-njja12";
			String user = "root";
			String pass = "root";
			
			return DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
