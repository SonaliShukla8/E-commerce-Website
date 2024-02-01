package com.hexaware.ecommerce.entity;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
	   @Id
	 private int addressId;        // Primary Key
	    private String addressLine1;
	    private String addressLine2;
	    private String postalCode;
	    private String city;
	    private String state;
	    private String country;
	    @ManyToMany(mappedBy = "addresses", fetch=FetchType.LAZY)
	    private List<Customer> customers = new ArrayList<Customer>();
	    
	    
	    
	    
	    
	    
}
