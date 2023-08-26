package com.jsp.Admin_user_portal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.Admin_user_portal.dto.Admin;
import com.jsp.Admin_user_portal.service.AdminService;

@WebServlet("/adminRegister")
public class AdminRegisterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		int id = Integer.parseInt(req.getParameter("adminId"));
		String user = req.getParameter("adminName");
		String pass = req.getParameter("adminPassword");
		
		Admin admin = new Admin();
		
		AdminService adminService = new AdminService();
		
		admin.setAdminId(id);
		admin.setAdminName(user);
		admin.setAdminPassword(pass);
		
		Admin admin2=adminService.saveAdmin(admin);
		
		if(admin2!=null) {
			
			req.setAttribute("message", "register-successfully");
			RequestDispatcher dispatcher = req.getRequestDispatcher("admin-login.jsp");
			dispatcher.forward(req, resp);
		}else {
			req.setAttribute("errormessage", "register-failed");
			RequestDispatcher dispatcher = req.getRequestDispatcher("admin-register.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
