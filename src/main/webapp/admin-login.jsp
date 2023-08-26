<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
			<%
				String msg=(String)request.getAttribute("message");
				String invalid = (String)request.getAttribute("invalid");
				String logout = (String) request.getAttribute("logoutMessage");
			%>
		
			
			<form action="adminLogin" method="get">
				<%if(msg!=null) {%>
					<h3 style="color: green;"><%=msg%></h3>
				<%} %>
				<%if(invalid!=null) {%>
					<h3 style="color: red;"><%=invalid%></h3>
				<%} %>
				<%if(logout!=null) {%>
					<h3 style="color: green;"><%=logout%></h3>
				<%} %>
				
				<label for="adminName">AdminName</label>
				<input type="text" name="adminName" id="adminName" placeholder="enter admin name"><br>
				<label for="adminPassword">AdminPassword</label>
				<input type="password" name="adminPassword" id="adminPassword" placeholder="enter admin name"><br>
				<input type="submit" value="login">
				
			</form><br>
			<p>if not register then register first</p>
			<a href="admin-register.jsp">register</a>
		</div>
</body>
</html>