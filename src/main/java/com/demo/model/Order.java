package com.demo.model;

public class Order {

	private Integer orderId;
	
	private String eventId;
	
	private String ID;
	
	private Integer tickets;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Integer getTickets() {
		return tickets;
	}

	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", eventId=" + eventId + ", ID=" + ID + ", tickets=" + tickets + "]";
	}

	

	
	
	
}
