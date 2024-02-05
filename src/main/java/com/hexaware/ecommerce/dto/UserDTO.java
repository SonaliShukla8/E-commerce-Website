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






	public UserDTO(int userId, String username, String email, String password, String userType) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.userType = userType;
	
	}



	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", userType=" + userType + "]";
	}



   
    
}
