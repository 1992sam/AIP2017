<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home Page</title>
	</head>

	<body>
		
		<h1 align="center">Home page</h1><br><br>
		<form:form commandName = "displayEvents" >
			<table>
				<tr><td><form:select path="allEvents">
					<form:options items = "${allEventList}" />
				</form:select></td>
				<td><input type="submit" value = "Select Event" /></td></tr>
			</table>
		</form:form>	
			<br><br><a href = "/getBooking.html">View your Bookings</a>
			
			<br><br><a href = "/editAccount.html">Update Account Details</a>
			
			<br><br><a href = "/logout.html">Logout</a>
			
			<br><br><a href = "/admin.html">Administrator Settings</a>
		
	</body>
</html>