<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Event</title>
</head>
<body>
	<form:form commandName = "deleteEvent">
			<table>
				<tr><td>Event Name:</td><td><form:input path = "eventName"  />
				<tr> <td></td><td><input type="submit" value = "Delete"></td></tr>
			</table>
	</form:form>
	<p align = "center"><a href = "admin.html">Go Back</a></p><br>
	<p align = "center"><a href = "userHome.html">Home</a></p>
</body>
</html>