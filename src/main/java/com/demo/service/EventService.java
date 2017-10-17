package com.demo.service;

import java.util.List;

import com.demo.model.Event;

public interface EventService {
	
	/**
	 * Gets a list of All Events.
	 * @return Returns List of All Events.
	 */
	public List<Event> getAllEvents();
	
	/**
	 * Gets Event associated with the event Id. 
	 * @param id
	 * @return Event associated to Id.
	 */
	public Event getEvent(String id);
	
	/**
	 * Create Event Administrator Access Only.
	 * @param event
	 */
	public void createEvent(Event event);
	
	/**
	 * Delete Event Administrator Access Only.
	 */
	public void deleteEvent(Event event);
	
}
