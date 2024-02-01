package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Cart {
	  @Id
	    private String cartId;
	  
	  @OneToOne(cascade=CascadeType.ALL, mappedBy="cart")
	  private Customer customer;

	    @OneToMany( cascade = CascadeType.ALL, mappedBy="cart")
	    private List<CartItem> cartItems= new ArrayList<CartItem>();

	    
	    @Column(name="cart_total_price")
	    private double totalPrice;
	    
	    
	    
	    
}
