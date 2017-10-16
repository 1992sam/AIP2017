package com.demo.mapper;

public class OrderQueries {

	public static String bookTickets = "update Events set tickets = tickets - ? where eventID = ?;";
	
	public static String cancelTickets =  "update Events set tickets = tickets + ? where eventName = ?;";
	
	public static String placeOrder = "insert into Orders(eventId,Id,tickets) values(?,?,?);";
	
	public static String cancelOrder = "delete from Orders where orderId =?;";
	
	public static String getOrders = "select * from Orders where Id = ?;";
	
}
