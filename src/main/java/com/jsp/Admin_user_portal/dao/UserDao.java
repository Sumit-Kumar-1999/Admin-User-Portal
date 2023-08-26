package com.jsp.Admin_user_portal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.Admin_user_portal.connection.AdminUserConnection;
import com.jsp.Admin_user_portal.dto.User;

public class UserDao {

	Connection connection = AdminUserConnection.getAdminUserConnection();

	/*
	 * save User method
	 */
	public User saveUser(User user) {

		String insertUser = "insert into user values(?,?,?)";

		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connection.prepareStatement(insertUser);
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getUserEmail());

			preparedStatement.execute();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getAllUser() {

		String selectQuery = "Select * from user";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

			ResultSet resultSet = preparedStatement.executeQuery();

			List<User> users = new ArrayList<User>();
			while (resultSet.next()) {
				User user = new User();

				user.setUserId(resultSet.getInt("id"));
				user.setUserName(resultSet.getString("name"));
				user.setUserEmail(resultSet.getString("email"));

				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * deleteUser
	 */
	public int deleteUserById(int userId) {

		String deleteQuery = "delete from user where id = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, userId);

			int tableId = preparedStatement.executeUpdate();

			return tableId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * getUserById
	 */
	public User getUserById(int userId) {

		String selectQuery = "SELECT * FROM  user where id = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				User user = new User();

				user.setUserId(resultSet.getInt("id"));
				user.setUserName(resultSet.getString("name"));
				user.setUserEmail(resultSet.getString("email"));

				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * update User
	 */
	public int userUpdate(User user) {
		
		String updateQuery = "update user set name=?,email=? where id = ?";
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getUserEmail());
			preparedStatement.setInt(3, user.getUserId());

			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
