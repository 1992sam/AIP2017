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

import com.demo.dao.EventDao;
import com.demo.mapper.EventMapper;
import com.demo.mapper.EventQueries;
import com.demo.model.Event;

public class EventDaoImpl implements EventDao{

	DataSource dataSource;
	
	
	public Connection getConnection() {
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
	
	
	public void createEvent(Event event) {
		
		Connection conn = getConnection();
		
		
			try {
				PreparedStatement stmt = conn.prepareStatement(EventQueries.createEvent);
				stmt.setString(1, event.getEventName());
				stmt.setString(2, event.getVenue());
				stmt.setString(3, event.getEventDate());
				stmt.setString(4, event.getAbout());
				stmt.setInt(5, event.getTickets());
				stmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
	


	
	public Event getEvent(String eventName) {
		Connection conn = getConnection();
		Event event =  new Event();
		try {
			PreparedStatement stmt = conn.prepareStatement(EventQueries.getEventByName);
			stmt.setString(1, eventName);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				 
				event.setId(rs.getString("eventId"));
				event.setEventName(rs.getString("eventName"));
				event.setVenue(rs.getString("venue"));
				event.setEventDate(rs.getDate("eventDate").toString());
				event.setAbout(rs.getString("about"));
				event.setTickets(rs.getInt("tickets"));
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;
	}

	public Event getEvent(int ID) {
		Connection conn = getConnection();
		Event event =  new Event();
		try {
			PreparedStatement stmt = conn.prepareStatement(EventQueries.getEventById);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				 
				event.setId(rs.getString("eventId"));
				event.setEventName(rs.getString("eventName"));
				event.setVenue(rs.getString("venue"));
				event.setEventDate(rs.getDate("eventDate").toString());
				event.setAbout(rs.getString("about"));
				event.setTickets(rs.getInt("tickets"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;
	}

	
	public List<Event> getAllEvent() {
		Connection conn = getConnection();
		List<Event> allEvents = new ArrayList<Event>();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(EventQueries.getAllEvents);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Event event =  new Event();
				event.setId(rs.getString("eventId"));
				event.setEventName(rs.getString("eventName"));
				event.setVenue(rs.getString("venue"));
				event.setEventDate(rs.getDate("eventDate").toString());
				event.setAbout(rs.getString("about"));
				event.setTickets(rs.getInt("tickets"));
				event.toString();
				allEvents.add(event);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allEvents;
	}

	public void updateEvent() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void deleteEvent(Event event) {
		Connection conn = getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(EventQueries.deleteEvent);
			stmt.setString(1, event.getEventName());
			 stmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	//Spring setters
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	
	






	
}
