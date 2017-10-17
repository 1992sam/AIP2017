package com.demo.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.dao.OrderDao;
import com.demo.mapper.OrderQueries;
import com.demo.model.Event;
import com.demo.model.Order;
import com.demo.model.UserEvents;

public class OrderDaoImpl implements OrderDao{

	DataSource dataSource;
	
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aip","root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/*public void createOrder(Order order) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(OrderQueries.placeOrder, order.getEventId(),
				order.getID(),
				order.getTickets());
		
	}*/
	public void createOrder(Order order) {
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(OrderQueries.placeOrder);
			stmt.setInt(1, Integer.parseInt(order.getEventId()));
			stmt.setInt(2, Integer.parseInt(order.getID()));
			stmt.setInt(3, order.getTickets());
			int rs = stmt.executeUpdate();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	/*public void bookTickets(int numberOfTickets, String eventId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
		jdbcTemplate.update(OrderQueries.bookTickets, numberOfTickets, eventId);
	}(Spring Implementation)*/
	
	//Reduce number of tickets from Events table.
	public void bookTickets(int numberOfTickets, String eventId) {
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(OrderQueries.bookTickets);
			stmt.setInt(1, numberOfTickets);
			stmt.setString(2, eventId);
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	/*public List<Order> getMyEvents(Order order) {
		System.out.println(order.getID());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Order> myOrders = new ArrayList<Order>();
		//List<Map> rows = jdbcTemplate.queryForList(OrderQueries.getOrders);
	List<Map<String, Object>> rows =  jdbcTemplate.queryForList(OrderQueries.getOrders, new Object[] {Integer.parseInt(order.getID())});
		
		
		 for(Map row: rows) {
			 Order retrievedOrder =  new Order();
			 retrievedOrder.setOrderId((Integer)row.get("orderId"));
			 retrievedOrder.setEventId(row.get("eventId").toString());
			 retrievedOrder.setID(row.get("ID").toString());
			 retrievedOrder.setTickets((Integer) row.get("orderId"));
			 
			 retrievedOrder.toString();
		 }
		return myOrders;
		
	}(Spring Implementation)*/
	
	//Get a List of orders associated with the account.
	public List<Order> getMyEvents(Order order){
		List<Order> myOrders = new ArrayList<Order>();
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(OrderQueries.getOrders);
			stmt.setString(1, order.getID());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Order retrievedOrder = new Order();
				retrievedOrder.setEventId(rs.getString("eventId"));
				retrievedOrder.setID(rs.getString("ID"));
				retrievedOrder.setOrderId(rs.getInt("orderId"));
				retrievedOrder.setTickets(rs.getInt("tickets"));
				System.out.println(retrievedOrder.toString());
				myOrders.add(retrievedOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return myOrders;
		
		
		
	}

	
	
	//Spring Setters
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	

}
