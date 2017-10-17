package com.demo.service;

import com.demo.model.Account;

public interface AccountService {
	
	/**
	 * This method creates an Account.
	 * @param account Account Details  
	 */
	public void createAccount(Account account);
	
	/**
	 * Checks whether account is an Administrator account.
	 * @param account Checks Admin
	 * @return returns whether user is administrator
	 */	
	public boolean checkAdmin(Account account);
	
	/**
	 * Verifies Login details and Logs user.
	 * @param account Login Details
	 * @return
	 */
	public Account loginAccount(Account account);
	
	/**
	 * Updates acccount with new information
	 * @param account Account Details
	 */
	public void updateAccount(Account account); 
	
	/**
	 * Deletes account (Administrative Function)
	 * @param account
	 */
	public void deleteAccount(Account account);
	
	/**
	 * Gets all account details
	 * @param account UserId
	 * @return Account Details
	 */
	public Account getAccount(Account account);
	
	
	
}
