package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Customer {
	@Id
	private int customerId;        // Primary Key
	@NotBlank
    private String fullName;
	@NotBlank
    private String gender;
	@NotBlank
	@Pattern(regexp = "\\d{10}")
    private String contactNumber;
    @NotBlank
    @Email
    private String email;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "customer_address",joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private List<Address> addresses =new ArrayList<Address>();
    
    @OneToOne(cascade=CascadeType.ALL, mappedBy="customer")
    private User user;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cartId")
    private Cart cart;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Order order;
}

