package com.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    // Maps "userHome.html"
	@RequestMapping("/userHome")
	//Method to display User Home Page.
	public ModelAndView userHome(){
		ModelAndView mav = new ModelAndView();
		System.out.println("here in userHome");
		List<Event> events = eventService.getAllEvents();
		mav.addObject("allEvents", events);
		mav.setViewName("userHome");
		return mav;
	}
	
	//Maps "placeOrder.html"
	@RequestMapping("/placeOrder")
	//Method to create an order.
	public ModelAndView placeOrder(@ModelAttribute("placeOrder") Event event, HttpServletRequest request){
		String userId = null;
		if(request.getSession().getAttribute("userId") != null) {
			
			userId = (String) request.getSession().getAttribute("userId");
		}
		System.out.println(event.getEventName());
		System.out.println(event.getTickets());
		System.out.println(userId);
		ModelAndView mav = new ModelAndView();
		Event bookingEvent = eventService.getEvent(event.getEventName());
		System.out.println(bookingEvent.toString());
		
		Order order =new Order();
		
		order.setEventId(bookingEvent.getId());
		order.setID(userId);
		order.setTickets(event.getTickets());
		if(bookingEvent.getId() != null){
			orderService.createOrder(order);
			orderService.bookTickets(event.getTickets(), event.getId());
		}
		
		mav.addObject("OrderSuccess", "Order Successful");
		mav.setViewName("placeOrder");
		return mav;
	}
	
	
	//Maps "getBooking.html"
	@RequestMapping("/getBooking")
	//Method to display bookings associated with an account. 
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
	
	
	//Maps "admin.html"
	@RequestMapping("/admin")
	//Method to create an Event 
	public ModelAndView createEvent(@ModelAttribute("addEvent") @Valid Event addEvent, BindingResult Result, HttpServletRequest request){
		if(!(boolean)request.getSession().getAttribute("admin")){
			return new ModelAndView("redirect:/userHome.html");
		}
		ModelAndView mav = new ModelAndView();
		//Form Validation.
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
	
	//Maps "deleteEvent.html"
	@RequestMapping("/deleteEvent")
	// Method to delete Event.
	public ModelAndView deleteEvent(@ModelAttribute("deleteEvent") Event event, HttpServletRequest request){
		
		if(!(boolean)request.getSession().getAttribute("admin")){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("userHome");
			mav.addObject("message", "Not an Admin");
			return mav;
		}
		
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
