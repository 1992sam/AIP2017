package com.demo.dao;

import java.util.List;

import com.demo.model.Event;
import com.demo.model.Order;


public interface OrderDao {

	/**
	 * Create an Order.
	 * @param order Order details
	 */
	public void createOrder(Order order);
	
	/**
	 * Reduce number of tickets on events table. 
	 * @param numberOfTickets
	 * @param eventId
	 */
	public void bookTickets(int numberOfTickets, String eventId);
	
	/**
	 * Retrieve orders associated with account.
	 * @param order orderId
	 * @return order details
	 */
	public List<Order> getMyEvents(Order order);
	
}
