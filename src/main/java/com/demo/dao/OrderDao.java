package com.demo.dao;

import java.util.List;

import com.demo.model.Event;
import com.demo.model.Order;


public interface OrderDao {

	public void createOrder(Order order);
	
	public int cancelOrder(Order order);
	
	public void bookTickets(int numberOfTickets, String eventId);
	
	public int cancelTickets(int numberOfTickets, String eventId);

	public List<Order> getMyEvents(Order order);
	
}
