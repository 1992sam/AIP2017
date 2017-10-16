package com.demo.serviceimpl;

import java.util.List;

import com.demo.dao.AccountDao;
import com.demo.dao.EventDao;
import com.demo.model.Event;
import com.demo.service.EventService;
import com.demo.service.OrderService;

public class EventServiceImpl implements EventService {

	AccountDao accountDao;
	EventDao eventDao;
	OrderService orderService;
	
	
	public List<Event> getAllEvents() {
		return eventDao.getAllEvent();
	}
	
	public Event getEvent(String name) {
		return eventDao.getEvent(name);
		
	}
	
	public void createEvent(Event event) {
		eventDao.createEvent(event);
	}
	
	public void deleteEvent(Event event) {
		eventDao.deleteEvent(event);		
	}
	
	//Spring setters
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	

	
}
