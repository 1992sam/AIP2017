package com.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Account;
import com.demo.model.Event;
import com.demo.model.Order;
import com.demo.model.UserEvents;
import com.demo.service.AccountService;
import com.demo.service.EventService;
import com.demo.service.OrderService;

@Controller
public class EventController {
	
	EventService eventService;
	AccountService accountService;
	OrderService orderService;

	
	
	@RequestMapping("/cancelOrder")
	public ModelAndView cancelOrder(@ModelAttribute("cancelOrder") String orderId){
		
		ModelAndView mav = new ModelAndView();
		Order order = new Order();
		order.setOrderId(Integer.parseInt(orderId));
		orderService.cancelOrder(order);
		orderService.cancelTickets(order.getTickets(), order.getEventId());
		mav.setViewName("cancelOrder");
		return mav;
	}
	
	@RequestMapping("/userHome")
//	public ModelAndView userHome(@ModelAttribute("displayEvents") Event event, BindingResult Result){
	public ModelAndView userHome(){
		ModelAndView mav = new ModelAndView();
//		List<Event> events = eventService.getAllEvents();
//		mav.addObject("allEvents", events);
		mav.setViewName("userHome");
		return mav;
	}
	
	@RequestMapping("/events")
	public ModelAndView booktickets(@ModelAttribute("bookTicket") Order order){
		ModelAndView mav = new ModelAndView();	
		Event event= new Event();
		orderService.createOrder(order);
		orderService.bookTickets(order.getTickets(), order.getEventId());
		mav.addObject("orderId", order.getOrderId());
		mav.addObject("eventName", event.getEventName());
		mav.addObject("venue", event.getVenue());
		mav.addObject("eventDate", event.getEventDate());
		mav.addObject("numberOfSeats", order.getTickets());
		if(order.getOrderId() == null){
			mav.setViewName("booking");
		}
		mav.setViewName("events");
		return mav;
	}
	
	@RequestMapping("/getBooking")
	public ModelAndView getBooking(@ModelAttribute("getBooking") Order order, BindingResult Result, HttpSession session){
		
		String userId = (String) session.getAttribute("userId");
		
		ModelAndView mav = new ModelAndView();
		//Account account = new Account();
		order.setID(userId);
		System.out.println(userId);
		List<UserEvents> userEvents = orderService.getMyEvents(order);
		
		mav.addObject("myEventList", userEvents);
		return mav;
	}
	
	@RequestMapping("/admin")
	public ModelAndView createEvent(@ModelAttribute("addEvent") @Valid Event addEvent, BindingResult Result){
		
		ModelAndView mav = new ModelAndView();
		String[] er = {"Event Name Field Cannot be Empty","Venue Field cannot be Empty",
				"Date Field cannot be Empty","Date should be in yyyy-mm-dd format only",
				"Tickets should be more than Zero","success" };
		if(addEvent.getEventName() == null || addEvent.getEventName().isEmpty()){
			if(addEvent.getEventName() == null) {
				mav.setViewName("admin");
				return mav;
			}
			mav.addObject("eventName", er[0]);
			mav.setViewName("admin");
			return mav;
		}
		else if(addEvent.getVenue() == null || addEvent.getVenue().isEmpty()){
			if(addEvent.getVenue() == null) {
				mav.setViewName("admin");
				return mav;
			}
			mav.addObject("venue", er[1]);
			mav.setViewName("admin");
			return mav;
		}
		else if(addEvent.getEventDate() == null || addEvent.getEventDate().isEmpty()){
			if(addEvent.getEventDate() == null) {
				mav.setViewName("admin");
				return mav;
			}
			mav.addObject("date", er[2]);
			mav.setViewName("admin");
			return mav;
		}
		else if(addEvent.getTickets() == 0){
			mav.addObject("tickets", er[4]);
			mav.setViewName("admin");
			return mav;
		}
		else{
		eventService.createEvent(addEvent);
		mav.addObject("success", er[5] );
		mav.setViewName("admin");
		}
		return mav;
	}
	
	@RequestMapping("/deleteEvent")
	public ModelAndView deleteEvent(@ModelAttribute("deleteEvent") Event event){
		
		ModelAndView mav = new ModelAndView();
		eventService.deleteEvent(event);
		mav.setViewName("deleteEvent");
		return mav;
	}
	
	//Spring setters
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	

}
