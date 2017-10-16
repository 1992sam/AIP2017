package com.demo.service;

import java.util.List;

import com.demo.model.Event;

public interface EventService {

	public List<Event> getAllEvents();
	
	public Event getEvent(String id);
	
	public void createEvent(Event event);
	
	public void deleteEvent(Event event);
	
}
