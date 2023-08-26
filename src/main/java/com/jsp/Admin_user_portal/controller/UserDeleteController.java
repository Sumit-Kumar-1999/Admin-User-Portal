package com.jsp.Admin_user_portal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.Admin_user_portal.dao.UserDao;

@WebServlet(value = "/delete")
public class UserDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		int id  = Integer.parseInt(req.getParameter("id"));
		
		UserDao dao = new UserDao();
		
		if(httpSession.getAttribute("username")!=null) {
			
		    dao.deleteUserById(id);
			
		    RequestDispatcher dispatcher = req.getRequestDispatcher("user-display.jsp");
		    
		    dispatcher.forward(req, resp);
		}else {
			
			   RequestDispatcher dispatcher = req.getRequestDispatcher("admin-login.jsp");
			    
			    dispatcher.forward(req, resp);
		}
	
		
		
	}
}
