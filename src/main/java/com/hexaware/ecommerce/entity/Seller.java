package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Seller {
	@Id
	 private int sellerId;        // Primary Key
	 private String businessName;
	 private String phoneNumber;
	 private String email;
	 private String address;
	 private String sellingDomain;
	 
	 @OneToMany(cascade=CascadeType.ALL,mappedBy="seller")
	 private List<Product> product=new ArrayList<Product>();
	 
	 @OneToOne(mappedBy="seller",cascade=CascadeType.ALL)
	 private User user;
}
