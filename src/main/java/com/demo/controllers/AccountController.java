package com.demo.controllers;



import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Account;
import com.demo.model.Login;
import com.demo.service.AccountService;
import com.demo.service.EventService;


@Controller
@Scope("session")
public class AccountController {

	AccountService accountService;
	EventService eventService;
	
	// Maps "index.html"
	@RequestMapping(value="/index")
	//Method to display Index Page.
	public String displayIndexPage(){
		return "index";
	}
	
	//Maps "signUp.html".
	@RequestMapping(value="/signup")
	//Method to create a new account.
	public ModelAndView createAccount(@ModelAttribute ("aNewAccount") @Valid Account aNewAccount, BindingResult result){
		ModelAndView mav = new ModelAndView();
		String[] er = {"First Name cannot be null","Last Name cannot be empty","Address cannot be Empty",
				"Age cannot be less than 18","Email address cannot be Empty","Email format is wrong",
				"Password field cannot be empty","Password length cannot be less than six characters",
				"Please enter Proper Age"};
		mav.setViewName("signup");
		//Form Validation.
		if(aNewAccount.getFirstName() == null || aNewAccount.getFirstName().isEmpty()){
			if(aNewAccount.getFirstName() == null) {
				mav.setViewName("signup");
				return mav;
			}
			mav.addObject("firstNameError", er[0]);
			mav.setViewName("signup");
			return mav;
		}
		else if(aNewAccount.getLastName() == null || aNewAccount.getLastName().isEmpty()){
			if(aNewAccount.getLastName() == null) {
				mav.setViewName("signup");
				return mav;
			}
			mav.addObject("lastNameError", er[1]);
			mav.setViewName("signup");
			return mav;
		}
		else if(aNewAccount.getLastName() == null || aNewAccount.getLastName().isEmpty()){
			if(aNewAccount.getLastName() == null) {
				mav.setViewName("signup");
				return mav;
			}
			mav.addObject("lastNameError", er[1]);
			mav.setViewName("signup");
			return mav;
		}
		else if(aNewAccount.getAddress() == null || aNewAccount.getAddress().isEmpty()){
			if(aNewAccount.getAddress() == null) {
				mav.setViewName("signup");
				return mav;
			}
			mav.addObject("AddressError", er[2]);
			mav.setViewName("signup");
			return mav;
		}
		else if(aNewAccount.getAge() < 18){
			if(aNewAccount.getAge() == 0) {
				mav.addObject("AgeEmptyError", er[8]);
				mav.setViewName("signup");
				return mav;
			}
			mav.addObject("AgeError", er[3]);
			mav.setViewName("signup");
			return mav;
		}
		else if(aNewAccount.getEmail() == null || aNewAccount.getEmail().isEmpty()){
			if(aNewAccount.getEmail() == null) {
				mav.setViewName("signup");
				return mav;
			}
			mav.addObject("EmailError", er[4]);
			mav.setViewName("signup");
			return mav;
		}
		else if(aNewAccount.getPassword() == null || aNewAccount.getPassword().isEmpty()){
			if(aNewAccount.getPassword() == null) {
				mav.setViewName("signup");
				return mav;
			}
			mav.addObject("PasswordError", er[6]);			
			mav.setViewName("signup");
			return mav;
		}
		
		else {
			accountService.createAccount(aNewAccount);
			mav.setViewName("index");
		}
		
		
		return mav;
	}
	
	//Map "login.html"
	@RequestMapping(value="/login")
	//Method to verify User identity.
	public ModelAndView loginAccount(HttpServletRequest request, @ModelAttribute ("loginAccount") Login login, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(request.getSession().getAttribute("userId") != null) {
			Account acc = new Account();
			acc.setEmail((String)request.getSession().getAttribute("email"));
			Account loggedAccount = accountService.getAccount(acc);
			mav.addObject("userName", loggedAccount.getFirstName());
			return new ModelAndView("redirect:/userHome.html");
		}
		if(login.getEmail() == null || login.getEmail().isEmpty()){
			if(login.getEmail() == null) {
				mav.setViewName("login");
				return mav;
			}
			mav.addObject("emailError", "Please enter email");
			mav.setViewName("login");
			return mav;
		}
		else if(login.getPassword() == null || login.getPassword().isEmpty()){
			if(login.getPassword() == null) {
				mav.setViewName("login");
				return mav;
			}
			mav.addObject("passwordError", "Please enter password");
			mav.setViewName("login");
			return mav;
		}
		Account account = new Account();
		account.setEmail(login.getEmail());
		account.setPassword(login.getPassword());
		
		Account loginAccount = accountService.loginAccount(account);
		if(loginAccount == null){
			mav.addObject("loginError", "Wrong email or password");
			mav.setViewName("login");
			return mav;
		}
		
		System.out.println(loginAccount.toString());
		request.getSession().setAttribute("userName", loginAccount.getFirstName());
		request.getSession().setAttribute("userId", loginAccount.getId());
		request.getSession().setAttribute("email", loginAccount.getEmail());
		request.getSession().setAttribute("admin", loginAccount.isAdmin());
		//mav.setViewName("userHome");
		return new ModelAndView("redirect:/userHome.html");
		
	}
	
	//Maps "editAccount.html".
	@RequestMapping(value="/editAccount")
	//Method to update account details.
	public ModelAndView updateAccount(@ModelAttribute("updateAccount") Account updateAccount, BindingResult Result){
		
		ModelAndView mav = new ModelAndView();	
		accountService.updateAccount(updateAccount);
		mav.setViewName("editAccount");		
		return mav;
	}
	
	//Maps "deleteAccount.html"
	@RequestMapping(value = "/deleteAccount")
	//Method to delete account.
	public ModelAndView deleteAccount(@ModelAttribute("deleteAnAccount") Account deleteAnAccount, BindingResult Result, HttpServletRequest request){
		
		if(!(boolean)request.getSession().getAttribute("admin")){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("userHome");
			mav.addObject("message", "Not an Admin");
			return mav;
		}
		
		ModelAndView mav = new ModelAndView();
		accountService.deleteAccount(deleteAnAccount);
		mav.setViewName("deleteAccount");
		return mav;
	}
	
	//Maps "logout.html"
	@RequestMapping("/logout")
	//Method to Log user out.
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		request.getSession().setAttribute("userId", null);
		request.getSession().setAttribute("email", null);
		mav.setViewName("index");
		return mav;
		
	}

	
	// Spring setters
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	
}
