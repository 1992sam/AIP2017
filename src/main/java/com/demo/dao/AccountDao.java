package com.demo.dao;

import com.demo.model.Account;

public interface AccountDao {

	/**
	 * Gets Account Details.
	 * @param account userId.
	 * @return account details.
	 */
	public Account getAccount(Account account);
	
	/**
	 * Creates account.
	 * @param account account details.
	 */
	public void registerAccount(Account account);
	
	/**
	 * Update account details.
	 * @param account account details.
	 */
	public void updateAccount(Account account);
	
	/**
	 * Deletes account Administrator access only.
	 * @param account account details.
	 */
	public void deleteAccount(Account account);
	
	
}
