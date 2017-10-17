package com.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.EventDao;
import com.demo.dao.OrderDao;
import com.demo.model.Event;
import com.demo.model.Order;
import com.demo.model.UserEvents;
import com.demo.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	OrderDao orderDao;
	EventDao eventDao;
	
	public void createOrder(Order order) {
		
		//if(order.getTickets() > 4) 
		//TODO display that max of 4 tickets can be bought at one one by a user 
		//do not place order
		orderDao.createOrder(order);
		
	}

	public void bookTickets(int numberOfTickets, String eventId) {
		orderDao.bookTickets(numberOfTickets, eventId);
		
	}

	
	
	public List<UserEvents> getMyEvents(Order order) {
		List<Order> myOrders = orderDao.getMyEvents(order);
		System.out.println(myOrders.toString());
		List<UserEvents> userEvents = new ArrayList<UserEvents>();
		
		for(Order myOrder:myOrders){
			System.out.println(myOrder.getID());
			UserEvents userEvent = new UserEvents();
			Event event = eventDao.getEvent(Integer.parseInt(myOrder.getEventId()));
			userEvent.setEventName(event.getEventName());
			userEvent.setEventDate(event.getEventDate());
			userEvent.setVenue(event.getVenue());
			userEvent.setOrderId(myOrder.getOrderId());
			userEvent.setNumberOfSeats(myOrder.getTickets());
			userEvents.add(userEvent);
		}
		return userEvents;
	}

	
	
	//Spring Setters
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
}
