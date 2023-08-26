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
			String msg=(String)request.getAttribute("errormessage");
		%>
		<div>
			<%if(msg!=null) {%>
					<h3 style="color: red;"><%=msg%></h3>
				<%} %>
			<form action="adminRegister" method="post">
				
				<label for="adminId">AdminId</label>
				<input type="number" name="adminId" id="adminId" placeholder="enter admin id"><br>
				<label for="adminName">AdminName</label>
				<input type="text" name="adminName" id="adminName" placeholder="enter admin name"><br>
				<label for="adminPassword">AdminPassword</label>
				<input type="password" name="adminPassword" id="adminPassword" placeholder="enter admin name"><br>
				<input type="submit" value="register">
				
			</form><br>
			<p>if already register then login</p>
			<a href="admin-login.jsp">login</a>
		</div>
</body>
</html>