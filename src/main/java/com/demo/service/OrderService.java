package com.demo.service;

import java.util.List;

import com.demo.model.Event;
import com.demo.model.Order;
import com.demo.model.UserEvents;

public interface OrderService {

	public void createOrder(Order order);
	
	public void cancelOrder(Order order);
	
	public void bookTickets(int numberOfSeats, String eventId);
	
	public int cancelTickets(int numberOfTickets, String eventId);

	public List<UserEvents> getMyEvents(Order order);
	
}
