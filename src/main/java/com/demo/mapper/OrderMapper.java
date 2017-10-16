package com.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.Order;

public class OrderMapper implements RowMapper<Order> {

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		if (rs != null && rs.next()) {
			Order order = new Order();
			order.setEventId(rs.getString("eventId"));
			order.setOrderId(rs.getInt("orderId"));
			order.setID(rs.getString("userId"));
			order.setTickets(rs.getInt("numberOfSeats"));
			return order;
		}
		return null;
	}

}
