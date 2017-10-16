package com.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.Event;

public class EventMapper implements RowMapper<Event>{

	public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		if(rs != null && rs.next()) {
			Event event = new Event();
			event.setId(rs.getString("Id"));
			event.setEventName(rs.getString("eventName"));
			event.setVenue(rs.getString("venue"));
			event.setEventDate(rs.getDate("eventDate").toString());
			event.setAbout(rs.getString("about"));
			event.setTickets(rs.getInt("tickets"));
			return event;
		}
		return null;
	}

}
