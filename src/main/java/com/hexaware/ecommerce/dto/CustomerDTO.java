package com.hexaware.ecommerce.dto;

import java.util.List;

import com.hexaware.ecommerce.entity.Address;
import com.hexaware.ecommerce.entity.Cart;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.User;

public class CustomerDTO {
	
	private int customerId;        // Primary Key
    private String fullName;
    private String gender;
    private String contactNumber;
    private String email;
    private List<Address> addresses;
    private User user;
    private Cart cart;
    private Order order;
    

}
