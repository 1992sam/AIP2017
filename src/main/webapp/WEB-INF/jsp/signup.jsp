<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>SIGN UP for a new Account</title>
	</head>
	<body>
	
		<form:form  commandName = "aNewAccount" method = "POST">
	
			<table>
				<tr>
					<td>First Name:</td>
					<td><form:input path = "firstName"  />	</td> 
					<td><form:errors path = "firstName" /></td>
				</tr>
				
				<tr><td>Last Name: </td><td><form:input path = "lastName"  /></td></tr>
				
				<tr><td>Address: </td><td><form:input path = "address" /></td></tr>
				
				<tr><td>Age: </td><td><form:input path = "age"  /></td></tr>
				
				<tr><td>Email: </td><td><form:input path = "email"  /></td></tr>
				
				<tr><td>Password: </td><td><form:password path = "password" /></td></tr>
				
				<tr><td><input type="submit" value = "Submit"></td></tr>
			</table>
		</form:form>
		<p><a href = "index.html">Back to Home</a></p>
		<p> ${firstNameError}</p><p> ${lastNameError}</p><p> ${AddressError}</p>
		<p> ${AgeError}</p><p> ${AgeEmptyError}</p><p> ${EmailError}</p><p> ${PasswordError}</p>		
	</body>
</html>