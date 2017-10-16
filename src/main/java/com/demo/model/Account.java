package com.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Email;

public class Account {
	
	
	private String Id;
	
	@NotNull
	@NotEmpty
    @Size(min=1, max=15, message = "First name")
	private String firstName;
	
	@NotNull(message = "Last name cannot be null") 
	@NotBlank
	@Size(min=1, max=15)
	private String lastName;
	
	@NotNull(message = "Address cannot be null") 
	@Size(min=1, max=100)
	private String address;
	
	//@NotNull(message = "Age cannot be null")
	//@Min(value = 15, message = "Age should not be less than 15")
	private int age = 15;
	
	//@javax.validation.constraints.Email(message = "Email cannot be null")
	@NotNull @Size(min=1)
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String email = null;
	
	@NotNull(message = "Please enter password") @Size(min=1)
	private String password = null;
	
	private boolean admin;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "Account [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", age="
				+ age + ", email=" + email + ", password=" + password + "]";
	}
	

}
