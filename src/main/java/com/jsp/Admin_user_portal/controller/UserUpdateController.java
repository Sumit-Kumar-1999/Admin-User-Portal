package com.jsp.Admin_user_portal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.Admin_user_portal.dto.User;
import com.jsp.Admin_user_portal.service.UserService;

@WebServlet("/userUpdate")
public class UserUpdateController  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    HttpSession httpSession = req.getSession();
		
		int id  = Integer.parseInt(req.getParameter("userId"));
		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		
		UserService service = new UserService();
		
		User user = new User();
		
		user.setUserId(id);
		user.setUserName(name);
		user.setUserEmail(email);
		
		if(httpSession.getAttribute("username")!=null) {
			
			int tableId=service.userUpdate(user);
			 
			if(tableId!=0) {
				
				req.setAttribute("usermessage", "updated-successfully");
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("user-display.jsp");
				dispatcher.forward(req, resp);
				
			}else {
				
				req.setAttribute("usermessage", "not updated ....please check your data");
				RequestDispatcher dispatcher = req.getRequestDispatcher("user-insert.jsp");
				dispatcher.forward(req, resp);
			}
		}else {
			 req.setAttribute("usermessage", "please logged in with admin and then update");
			RequestDispatcher dispatcher = req.getRequestDispatcher("admin-login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
