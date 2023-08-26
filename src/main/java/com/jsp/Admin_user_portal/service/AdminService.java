package com.jsp.Admin_user_portal.service;

import com.jsp.Admin_user_portal.dao.AdminDao;
import com.jsp.Admin_user_portal.dto.Admin;

public class AdminService {

	AdminDao adminDao = new AdminDao();
	
	/*
	 * saveAdminMethod
	 */
	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}
	

	/*
	 * login method
	 */
	public Admin loginAdmin(String adminName) {
		return adminDao.loginAdmin(adminName);
	}
}
