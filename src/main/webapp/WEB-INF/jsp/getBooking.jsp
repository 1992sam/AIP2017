<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Bookings</title>
</head>
<body>
	<h1 align = "center"> Your Bookings </h1>
	<table align = "center">
		<tr>
			<th>ORDER ID</th>
			<th>EVENT NAME </th>
			<th>VENUE </th>
			<th>DATE</th>
			<th>Number of Seats</th>
		</tr>
		
			<c:forEach var = "listvalues" items = "${myEventList}">
				<tr><td><c:out value="${listvalues.orderId}" /></td>
					<td><c:out value="${listvalues.eventName}" /></td>
					<td><c:out value="${listvalues.venue}" /></td>
					<td><c:out value="${listvalues.eventDate}" /></td>
					<td align = "center"><c:out value="${listvalues.numberOfSeats}" /></td></tr>
			</c:forEach><br><br>
				
				
				
			
		
	</table>
	<p align = "center"><a href = "userHome.html">Home Page</a></p>
</body>
</html>