<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place your Order</title>
</head>
<body>
		<h1> Place Order</h1>
		<form:form commandName = "placeOrder">
			<table>
				<tr><td>Enter Event Name:</td><td><form:input path = "eventName"  />
				</td></tr>
				<tr><td>Enter number of Seats</td><td><form:input path = "tickets"  />
				</td></tr>
				<tr> <td></td><td><input type="submit" value = "Place Order"></td></tr>
			</table>
		</form:form>
		<p align = "center"><a href = "userHome.html">Go Back</a></p>

</body>
</html>