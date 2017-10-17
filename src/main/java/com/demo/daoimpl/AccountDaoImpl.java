package com.demo.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import com.demo.dao.AccountDao;

import com.demo.model.Account;
import com.demo.mapper.AccountMapper;
import com.demo.mapper.AccountQueries;

public class AccountDaoImpl implements AccountDao {


	
	/**
	 * Open connection to database.
	 * @return connection
	 */
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aip","root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	/**
	 * Gets account details from database
	 */
	public Account getAccount(Account account) {
		Connection conn = getConnection();
		Account retrievedAccount = new Account();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(AccountQueries.getAccount);
			stmt.setString(1, account.getEmail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				
				retrievedAccount.setId(rs.getString("ID"));
				retrievedAccount.setFirstName(rs.getString("firstName"));
				retrievedAccount.setLastName(rs.getString("lastName"));
				retrievedAccount.setAddress(rs.getString("address"));
				retrievedAccount.setAge(rs.getInt("age"));
				retrievedAccount.setEmail(rs.getString("email"));
				retrievedAccount.setPassword(rs.getString("password"));
				retrievedAccount.setAdmin(rs.getBoolean("admin"));
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO 
			
			e.printStackTrace();
		}
		
		
		return retrievedAccount;
	}

	/**
	 * Creates new user account in database table
	 */
	public void registerAccount(Account account) {
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(AccountQueries.insertAccount);
			stmt.setString(1, account.getFirstName());
			stmt.setString(2, account.getLastName());
			stmt.setString(3, account.getAddress());
			stmt.setInt(4, account.getAge());
			stmt.setString(5, account.getEmail());
			stmt.setString(6, account.getPassword());
			stmt.setBoolean(7, false);
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO 
			e.printStackTrace();
		}
		
	}
	

	/**
	 * Deletes user account in database table
	 */
	public void deleteAccount(Account account) {
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(AccountQueries.deleteAccount);
			stmt.setString(1, account.getEmail() );
			stmt.setString(2, account.getPassword());
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO 
			e.printStackTrace();
		}
		
		
	}

	
	
	/**
	 * Updates columns in user accounts table.
	 */
	public void updateAccount(Account account) {
		Connection conn = getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(AccountQueries.updateAccount);
			stmt.setString(1, account.getFirstName());
			stmt.setString(2, account.getLastName());
			stmt.setString(3, account.getAddress());
			stmt.setInt(4, account.getAge());
			stmt.setString(5, account.getEmail());
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	

	
}
