<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home Page</title>
	</head>

	<body>
		
		<p align = "center">Welcome ${userName}</p> 
	<h1 align="center">Home page</h1><br><br>
	<table align= "center">
		<tr> 	
				<th>EVENT NAME </th>
				<th>VENUE </th>
				<th>DATE</th>
				</tr>
				<tr>
			<c:forEach var = "listvalues" items = "${allEvents}">
				<tr><td><c:out value="${listvalues.eventName}" /></td>
				<td><c:out value="${listvalues.venue}" /></td>
				<td><c:out value="${listvalues.eventDate}" /></td></tr>
			</c:forEach>
		</tr>	
	</table>
	
		
	
	
	<p align="center"> 
			<br><br><a href = "placeOrder.html">Place an Order</a>
			
 			<br><br><a href = "getBooking.html">View your Bookings</a>
			
			<br><br><a href = "editAccount.html">Update Account Details</a>
			
			<br><br><a href = "logout.html">Logout</a>
			
			<br><br><a href = "admin.html">Administrator Settings</a>
	</p>		
	</body>
</html>