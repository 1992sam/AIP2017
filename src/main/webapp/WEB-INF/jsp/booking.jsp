<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Booking</title>
</head>
<body>
	<h1 align = "center">Your Booking is:</h1><br>
	<table>
			<tr><td>Order Id::</td><td>${orderId}</td></tr>
			<tr><td>Event Name:</td><td>${eventName}</td></tr>
			<tr><td>Venue:</td><td>${venue}</td></tr>
			<tr><td>Date:</td><td>${eventDate}</td></tr>
			<tr><td>Tickets Booked:</td><td>${numberOfSeats}</td></tr>
	</table>
	<h2 align = "center"><a href="/userHome.html">Go to Home Page</a></h2>

</body>
</html>