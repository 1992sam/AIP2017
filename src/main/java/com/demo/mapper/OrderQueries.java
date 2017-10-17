package com.demo.mapper;

public class OrderQueries {

	public static String bookTickets = "update Events set tickets = tickets - ? where eventID = ?;";
	
	public static String placeOrder = "insert into orders(eventId,Id,tickets) values(?,?,?);";
	
	public static String getOrders = "select * from Orders where Id = ?;";
	
}
