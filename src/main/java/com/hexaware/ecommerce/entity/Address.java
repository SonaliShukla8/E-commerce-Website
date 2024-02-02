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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Address {
	
		@Id
		@NotNull
	   	private int addressId;        // Primary Key
		@NotBlank
	    @Size(max = 255)
	    private String addressLine1;
		@Size(max = 255)
	    private String addressLine2;
		@NotBlank
	    @Pattern(regexp = "\\d{6}")
	    private String postalCode;
		@NotBlank
	    private String city;
		@NotBlank
	    private String state;
		@NotBlank
	    private String country;
	    @ManyToMany(mappedBy = "addresses", fetch=FetchType.LAZY)
	    private List<Customer> customers = new ArrayList<Customer>();
	    
	    
	    
	    
	    
	    
}
