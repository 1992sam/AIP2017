<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Bookings</title>
</head>
<body>
	<h1 align = "center"> Your Bookings </h1>
	<table>
		<tr>
			
				<c:forEach var = "listvalues" items = "${myEventList}">
					<td><c:out value="${listvalues.orderId}" /></td>
					<td><c:out value="${listvalues.eventName}" /></td>
					<td><c:out value="${listvalues.venue}" /></td>
					<td><c:out value="${listvalues.eventDate}" /></td>
					<td><c:out value="${listvalues.numberOfSeats}" /></td>
				</c:forEach><br><br>
				
				<p align = "center"><a href = "cancelOrder.html">Cancel Order</a></p>
				
			
		</tr>
	</table>
</body>
</html>