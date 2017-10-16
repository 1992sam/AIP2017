package com.demo.dao;

import com.demo.model.Account;

public interface AccountDao {

	
	public Account getAccount(Account account);
	
	public void registerAccount(Account account);
	
	public void updateAccount(Account account);
	
	public void deleteAccount(Account account);
	
	
}
