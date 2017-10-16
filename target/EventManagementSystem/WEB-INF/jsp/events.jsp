<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Event Details</title>
	</head>
	<body>
		<form:form commandName = "bookTicket"> 
		<h1 align="center">Event Details</h1>
		
				<table>
					<tr><td>Event name:</td><td>${eventName}</td></tr>
					<tr><td>Venue:</td><td>${venue}</td></tr>
					<tr><td>Date:</td><td>${eventDate}</td></tr>
					<tr><td>Description:</td><td>${about}</td></tr>
				</table>
		
		<h2 align="center"> Number of tickets:</h2>
		
			<form:input path = "tickets" /><form: path = "tickets" /><br/>
			<input type = "submit" value = "Book Tickets">
		</form:form>
	</body>
</html>