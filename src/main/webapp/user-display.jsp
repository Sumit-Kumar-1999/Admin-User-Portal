<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@page import="com.jsp.Admin_user_portal.dto.User"%>
<%@page import="java.util.List"%>
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

		<%
			UserDao userDao = new UserDao();
		
			List<User> users=userDao.getAllUser();
		%>
	
		<h3>display</h3>
		
		<table border="2px">
			<tr>
				<th>UserId</th>
				<th>UserName</th>
				<th>UserEmail</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
			<%for(User user:users){ %>
			<tr>
				<td><%=user.getUserId()%></td>
				<td><%=user.getUserName()%></td>
				<td><%=user.getUserEmail()%></td>
				<td><a href="delete?id=<%=user.getUserId()%>"><button>Delete</button></a></td>
				<td><a href="user-update.jsp?id=<%=user.getUserId()%>"><button>Update</button></a></td>
			</tr>
			<%}%>
		</table>
</body>
</html>