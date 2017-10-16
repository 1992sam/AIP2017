package com.demo.dao;

import java.util.List;

import com.demo.model.Event;

public interface EventDao {
	
	
	
	public void createEvent(Event event);
	
	public Event getEvent(String eventName);
	
	public Event getEvent(int ID);
	
	public List<Event> getAllEvent();
	
	public void updateEvent();

	public void deleteEvent(Event event);
	
}
