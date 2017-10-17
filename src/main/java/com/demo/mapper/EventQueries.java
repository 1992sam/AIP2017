package com.demo.mapper;

public class EventQueries {
	
	public static String createEvent = "insert into events(eventName, venue, eventDate, about, tickets) values(?,?,?,?,?);";

	public static String getAllEvents = "select * from events;";
	
	public static String getEventByName = "select * from events where eventName = ?;";
	
	public static String getEventById = "select * from events where eventId = ?;";
	
	public static String deleteEvent = "delete from events where eventName = ?;";
	
	
}
