<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>LOGIN to your account</title>
	</head>
	<body>
		
		<form:form commandName = "loginAccount">
		
			<table>
				<tr><td>Email: </td><td><form:input path = "email"  />
				<form:errors path = "email" /></td></tr>
				<tr><td>Password: </td><td><form:password path = "password" />
				<form:errors path = "password" /></td></tr>
				<tr> <td></td><td><input type="submit" value = "Log In"></td></tr>
			</table>
		
		</form:form>
		<p>${emailError}</p><p>${passwordError}</p><p>${loginError}</p>
		<br><br> Do not have an account??<br>
		<a href = "signup.html">Sign up for a new account</a>
	</body>
</html>