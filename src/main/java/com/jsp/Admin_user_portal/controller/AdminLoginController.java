package com.jsp.Admin_user_portal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.Admin_user_portal.dto.Admin;
import com.jsp.Admin_user_portal.service.AdminService;

@WebServlet(value = "/adminLogin")
public class AdminLoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminService adminService = new AdminService();
		
		HttpSession httpSession = req.getSession();
		
		String user = req.getParameter("adminName");
		String pass = req.getParameter("adminPassword");
		
		Admin admin=adminService.loginAdmin(user);
		
		if(admin!=null) {
			
			if((admin.getAdminName().equals(user))&&(admin.getAdminPassword().equals(pass))) {
				
				httpSession.setAttribute("username", admin.getAdminName());
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("user-home.jsp");
				dispatcher.forward(req, resp);
			}else {
				
				req.setAttribute("invalid", "invalid username or password");
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("admin-login.jsp");
				dispatcher.forward(req, resp);
			}
		}else {
			req.setAttribute("invalid", "invalid username");
			RequestDispatcher dispatcher = req.getRequestDispatcher("admin-login.jsp");
			dispatcher.forward(req, resp);
			
		}
	}
}
