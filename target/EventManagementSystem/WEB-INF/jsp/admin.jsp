<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	
	<h1 align = "center">Adminstrator</h1>
	<table><tr><td>
		<h2> Add Event</h2></td><td><h2 align = "center">Delete Event</h2></td></tr>
		<tr><td><form:form commandName = "addEvent">
			<table>
				<tr><td>Event Name:</td><td><form:input path = "eventName"  />
				<form: path = "eventName" /></td></tr>
				<tr><td>Venue:</td><td><form:input path = "venue"  />
				<form: path = "venue" /></td></tr>
				<tr><td>Date:</td><td><form:input path = "eventDate"  />
				<form: path = "eventDate" /></td></tr>
				<tr><td>Number of Tickets:</td><td><form:input path = "tickets"  />
				<form: path = "tickets" /></td></tr>
				<tr><td>Description:</td><td><form:input path = "about"  />
				<form: path = "about" /></td></tr>
				<tr><td><input type="submit" value = "Add"></td></tr>
			</table>
		</form:form></td></tr>	
		</table>
		<a href="/deleteEvent.html"><p align="center">Delete an Event</p></a>
		
		
</body>
</html>