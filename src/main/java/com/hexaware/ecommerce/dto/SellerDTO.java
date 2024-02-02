package com.hexaware.ecommerce.dto;

import java.util.List;

import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.User;

public class SellerDTO {
	
	 private int sellerId;        // Primary Key
	 
	 private String businessName;
	
	 private String phoneNumber;
	 
	 private String email;
	 
	 private String address;
	 
	 private String sellingDomain;
	 private List<Product> product;
	 private User user;
	 
	 

}
