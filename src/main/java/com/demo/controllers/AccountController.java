package com.demo.controllers;



import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
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
	
	@RequestMapping(value="/index")
	public String displayIndexPage(){
		return "index";
	}
	
	
	@RequestMapping(value="/signup")
	public ModelAndView createAccount(@ModelAttribute ("aNewAccount") @Valid Account aNewAccount, BindingResult result){
		ModelAndView mav = new ModelAndView();
		String[] er = {"First Name cannot be null","Last Name cannot be empty","Address cannot be Empty",
				"Age cannot be less than 18","Email address cannot be Empty","Email format is wrong",
				"Password field cannot be empty","Password length cannot be less than six characters",
				"Please enter Proper Age"};
		System.out.println(result.toString());
		System.out.println(aNewAccount.toString());
		mav.setViewName("signup");
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
	
	@RequestMapping(value="/login")
	public ModelAndView loginAccount(HttpServletRequest request, @ModelAttribute ("loginAccount") Login login, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(request.getSession().getAttribute("userId") != null) {
			Account acc = new Account();
			acc.setEmail((String)request.getSession().getAttribute("email"));
			Account loggedAccount = accountService.getAccount(acc);
			mav.addObject("userName", loggedAccount.getFirstName());
			mav.setViewName("userHome");
			return mav;
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
		mav.addObject("userName", loginAccount.getFirstName());
		request.getSession().setAttribute("userId", loginAccount.getId());
		request.getSession().setAttribute("email", loginAccount.getEmail());
		mav.setViewName("userHome");
		return mav;
	}
	
	@RequestMapping(value="/editAccount")
	public ModelAndView updateAccount(@ModelAttribute("updateAccount") Account updateAccount, BindingResult Result){
		
		ModelAndView mav = new ModelAndView();
	
	
		accountService.updateAccount(updateAccount);
		mav.setViewName("editAccount");
		
		return mav;
	}
	
	@RequestMapping(value = "/deleteAccount")
	public ModelAndView deleteAccount(@ModelAttribute("deleteAnAccount") Account deleteAnAccount, BindingResult Result){
		ModelAndView mav = new ModelAndView();
		accountService.deleteAccount(deleteAnAccount);
		mav.setViewName("deleteAccount");
		return mav;
	}
	
	@RequestMapping("/logout")
	public String logout(){

		return "index";
	}

	
	// Spring setters
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}
	
	
}
