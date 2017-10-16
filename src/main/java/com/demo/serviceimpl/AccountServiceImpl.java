package com.demo.serviceimpl;

import com.demo.dao.AccountDao;
import com.demo.dao.EventDao;
import com.demo.model.Account;
import com.demo.service.AccountService;
import com.demo.service.OrderService;

public class AccountServiceImpl implements AccountService{

	AccountDao accountDao;
	EventDao eventDao;
	OrderService orderService;
	
	public void createAccount(Account account) {
		
			accountDao.registerAccount(account);
		
	}
	
	
	
	
	public Account getAccount(Account account) {
		return accountDao.getAccount(account);
	}
	
	public Account loginAccount(Account account) {
		Account userAccount = getAccount(account);
	//	System.out.println(userAccount.getEmail() + "  " + userAccount.getPassword());
		if(userAccount != null && !userAccount.getId().isEmpty()) {
			
			if(account.getPassword().equals(userAccount.getPassword())) {
				return userAccount;
			}
				return null;
		}
		return null;
		
	}
	
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
		
	}
	
	

	
	
	//Spring setters
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void deleteAccount(Account account) {
		accountDao.deleteAccount(account);
		
	}




	@Override
	public boolean checkAdmin(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
	
	






	





	
}
