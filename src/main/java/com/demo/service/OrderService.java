package com.demo.service;

import java.util.List;

import com.demo.model.Order;
import com.demo.model.UserEvents;

public interface OrderService {
	/**
	 * Create an Order
	 * @param order
	 */
	public void createOrder(Order order);
	
	/**
	 * 
	 * @param numberOfSeats
	 * @param eventId
	 */
	public void bookTickets(int numberOfSeats, String eventId);
	

	public List<UserEvents> getMyEvents(Order order);
	
}
