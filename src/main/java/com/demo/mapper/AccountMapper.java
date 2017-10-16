package com.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.model.Account;

public class AccountMapper implements RowMapper<Account>{

	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		//if (rs != null && rs.next()) {
			Account account = new Account();
			account.setId(rs.getString("ID"));
			account.setFirstName(rs.getString("firstName"));
			account.setLastName(rs.getString("lastName"));
			account.setAddress(rs.getString("address"));
			account.setAge(rs.getInt("age"));
			account.setEmail(rs.getString("email"));
			account.setPassword(rs.getString("password"));
			account.setAdmin(rs.getBoolean("admin"));
			System.out.println(account.toString());
			return account;
		//}
		//return null;
	}

}
