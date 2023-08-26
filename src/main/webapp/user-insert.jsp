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
		String usermsg = (String)request.getAttribute("usermessage");
	%>
	<h3>Welcome to user Registration Form</h3>
	<div>
		<%if(usermsg!=null){%>
				<%=usermsg%>
		<%}%>
		
		<form action="userRegister" method="post">
			<label for="userId">userId</label>
			<input type="number" name="userId" id="userId" placeholder="enter user Id" ><br>
			
			<label for="userName">userName</label>
			<input type="text" name="userName" id="userName" placeholder="enter user Name" ><br>
			
			<label for="userEmail">userEmail</label>
			<input type="text" name="userEmail" id="userEmail" placeholder="enter user Email" ><br>
			
			<input type="submit" value="register">
		</form>
		<a href="logout">logout</a>
	</div>
</body>
</html>