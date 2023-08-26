<%@page import="com.jsp.Admin_user_portal.dto.User"%>
<%@page import="com.jsp.Admin_user_portal.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>Welcome to user update Form</h3>
	
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		UserDao userDao = new UserDao();
	
		User user=userDao.getUserById(id);
	%>
	
	<div>
		
		<form action="userUpdate" method="post">
			<label for="userId">userId</label>
			<input type="number" name="userId" id="userId" placeholder="enter user Id" value="<%=user.getUserId()%>"><br>
			
			<label for="userName">userName</label>
			<input type="text" name="userName" id="userName" placeholder="enter user Name" value="<%=user.getUserName()%>"><br>
			
			<label for="userEmail">userEmail</label>
			<input type="text" name="userEmail" id="userEmail" placeholder="enter user Email" value="<%=user.getUserEmail()%>" ><br>
			
			<input type="submit" value="update">
		</form>
		<a href="logout">logout</a>
	</div>
</body>
</html>