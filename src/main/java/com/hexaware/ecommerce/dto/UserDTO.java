package com.hexaware.ecommerce.dto;

import com.hexaware.ecommerce.entity.Admin;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.entity.Seller;

public class UserDTO {
	
	private int userId;        // Primary Key
    private String username;
    private String email;
    private String password;
    private String userType;
    private Seller seller;
    private Customer customer;
    private Admin admin;

	
    
    public UserDTO() {
		super();
		
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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



	public String getUserType() {
		return userType;
	}



	public void setUserType(String userType) {
		this.userType = userType;
	}



	public Seller getSeller() {
		return seller;
	}



	public void setSeller(Seller seller) {
		this.seller = seller;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Admin getAdmin() {
		return admin;
	}



	public void setAdmin(Admin admin) {
		this.admin = admin;
	}



	public UserDTO(int userId, String username, String email, String password, String userType, Seller seller,
			Customer customer, Admin admin) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.seller = seller;
		this.customer = customer;
		this.admin = admin;
	}



	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", userType=" + userType + ", seller=" + seller + ", customer=" + customer + ", admin=" + admin + "]";
	}



   
    
}
