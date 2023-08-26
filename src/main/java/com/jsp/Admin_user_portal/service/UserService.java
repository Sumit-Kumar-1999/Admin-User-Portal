package com.jsp.Admin_user_portal.service;

import com.jsp.Admin_user_portal.dao.UserDao;
import com.jsp.Admin_user_portal.dto.User;

public class UserService {

	UserDao userDao = new UserDao();
	
	/*
	 * save User method
	 */
	public User saveUser(User user) {
		
		return userDao.saveUser(user);
	}
	
	/*
	 * update User
	 */
	public int userUpdate(User user) {
		return userDao.userUpdate(user);
	}
}
