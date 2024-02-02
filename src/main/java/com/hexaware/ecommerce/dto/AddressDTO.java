package com.hexaware.ecommerce.dto;

import java.util.List;

import com.hexaware.ecommerce.entity.Customer;

public class AddressDTO {
		
	    private int addressId;        // Primary Key
	    private String addressLine1;
	    private String addressLine2;
	    private String postalCode;
	    private String city;
	    private String state;
	    private String country;
	    private List<Customer> customers;

}
