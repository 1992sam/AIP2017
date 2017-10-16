package com.demo.service;

import com.demo.model.Account;

public interface AccountService {
	
	/**
	 * This method creates an Account.
	 * @param account account details  
	 */
	public void createAccount(Account account);
	
	/**
	 * Checks whether account is an Administrator account.
	 * @param account checks admin
	 * @return 
	 */	
	public boolean checkAdmin(Account account);
	
	public Account loginAccount(Account account);
	
	public void updateAccount(Account account); 
	
	public void deleteAccount(Account account);
	
	public Account getAccount(Account account);
	
	
	
}
