<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Update your Details</title>
	</head>
	<body>
	
		<table>
			<tr><td>Account Id:</td><td> ${accountId}</td></tr>
			<tr><td>First Name:</td><td>${firstName}</td></tr>
			<tr><td>Last Name:</td><td>${lastName}</td></tr>
			<tr><td>Email:</td><td>${email}</td></tr>
		</table>
		
		<form:form commandName = "updateAccount">
			<table>
				<tr><td>First Name:</td><td><form:input path = "firstName"  />
				<form: path = "firstName" /></td></tr>
				<tr><td>Last Name: </td><td><form:input path = "lastName"  />
				<form: path = "lastName" /></td></tr>
				<tr><td>Last Name: </td><td><form:input path = "address"  />
				<form: path = "address" /></td></tr>
				<tr><td>Last Name: </td><td><form:input path = "age"  />
				<form: path = "age" /></td></tr>
				<tr><td>Email: </td><td><form:input path = "email"  />
				<form: path = "email" /></td></tr>
				<tr> <td></td><td><input type="submit" value = "Submit"></td></tr>
			</table>
		</form:form>
		
	</body>
</html>