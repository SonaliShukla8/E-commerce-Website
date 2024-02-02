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

}
