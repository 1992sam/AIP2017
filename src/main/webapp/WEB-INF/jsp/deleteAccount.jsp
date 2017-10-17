<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Delete your Account</title>
	</head>
	
	<body>
		
		<form:form commandName = "deleteAnAccount">
			<table>
				<tr><td>First Name:</td><td><form:input path = "firstName"  />
				<form:errors path = "firstName" /></td></tr>
				<tr><td>Last Name: </td><td><form:input path = "lastName"  />
				<form:errors path = "lastName" /></td></tr>
				<tr><td>Email: </td><td><form:input path = "email"  />
				<</td></tr>
				<tr> <td></td><td><input type="submit" value = "Delete"></td></tr>
			</table>
		</form:form>
			<p><a href="admin.html">Go Back</a></p>
	</body>
</html>