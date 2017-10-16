package com.demo.model;

public class Event {
	
		private String Id;

		private String eventName;
		
		private String venue;
		
		private String eventDate;
		
		private String about;
		
		private int tickets = 0;

		public String getEventName() {
			return eventName;
		}

		public void setEventName(String eventName) {
			this.eventName = eventName;
		}

		public String getVenue() {
			return venue;
		}

		public void setVenue(String venue) {
			this.venue = venue;
		}

		public String getEventDate() {
			return eventDate;
		}

		public void setEventDate(String eventDate) {
			this.eventDate = eventDate;
		}

		public String getAbout() {
			return about;
		}

		public void setAbout(String about) {
			this.about = about;
		}

		public int getTickets() {
			return tickets;
		}

		public void setTickets(int tickets) {
			this.tickets = tickets;
		}

		public String getId() {
			return Id;
		}

		public void setId(String id) {
			Id = id;
		}
		
		
}
