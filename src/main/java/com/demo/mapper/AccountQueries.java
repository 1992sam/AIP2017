package com.demo.mapper;

public class AccountQueries {


		public static String insertAccount = "insert into user_accounts(firstName, lastName, address, age, email, password) values(?,?,?,?,?,?);";
		
		public static String deleteAccount = "delete from user_accounts where email = ? and password = ?;";
		
		public static String getAccount	= "Select * from user_accounts where email like ?;";
		
		//Change this Query
		public static String updateAccount = "Update user_accounts set firstName =?,lastName = ?, address = ?, age = ? where email = ?";
		
		
}
