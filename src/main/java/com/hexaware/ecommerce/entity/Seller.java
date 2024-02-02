package com.hexaware.ecommerce.entity;

import java.util.ArrayList;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Seller {
	@Id
	 private int sellerId;        // Primary Key
	@NotBlank
	 private String businessName;
	 @Pattern(regexp = "[0-9]{10}")
	 private String phoneNumber;
	 @Email(message = "Invalid email address")
	 @NotBlank(message = "Email cannot be blank")
	 private String email;
	 @NotBlank(message = "Address cannot be blank")
	 private String address;
	 @NotBlank(message = "Selling domain cannot be blank")
	 private String sellingDomain;
	 
	 @OneToMany(cascade=CascadeType.ALL,mappedBy="seller")
	 private List<Product> product=new ArrayList<Product>();
	 
	 @OneToOne(mappedBy="seller",cascade=CascadeType.ALL)
	 private User user;
}
