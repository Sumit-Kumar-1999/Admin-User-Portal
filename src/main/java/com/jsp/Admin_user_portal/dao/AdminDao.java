package com.jsp.Admin_user_portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.Admin_user_portal.connection.AdminUserConnection;
import com.jsp.Admin_user_portal.dto.Admin;

public class AdminDao {

	Connection connection = AdminUserConnection.getAdminUserConnection();
	
	/*
	 * saveAdminMethod
	 */
	public Admin saveAdmin(Admin admin) {
		
		String insertAdmin = "insert into admin values(?,?,?)";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(insertAdmin);
			preparedStatement.setInt(1, admin.getAdminId());
			preparedStatement.setString(2, admin.getAdminName());
			preparedStatement.setString(3, admin.getAdminPassword());
			
			preparedStatement.execute();
			
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * login method
	 */
	public Admin loginAdmin(String adminName) {
		
		
		String loginQuery = "SELECT * FROM admin WHERE name=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			
			preparedStatement.setString(1, adminName);
			ResultSet resultSet=preparedStatement.executeQuery();
			
		
			if(resultSet.next()) {
				Admin admin = new Admin();
				admin.setAdminId(resultSet.getInt("id"));
				admin.setAdminName(resultSet.getString("name"));
				admin.setAdminPassword(resultSet.getString("password"));
				return admin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
