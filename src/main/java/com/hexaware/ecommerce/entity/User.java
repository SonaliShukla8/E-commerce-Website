package com.hexaware.ecommerce.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	@Id
	 private int userId;        // Primary Key
	    private String username;
	    private String email;
	    private String password;
	    private String userType;
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="sellerId")
	    private Seller seller;
	    @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="customerId")
	    private Customer customer;
	    @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="adminId")
	    private Admin admin;
}
