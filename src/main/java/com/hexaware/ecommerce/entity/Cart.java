package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;



public class Cart {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private String cartId;

	    @OneToMany(targetEntity = CartItem.class, cascade = CascadeType.ALL)
	    @JoinColumn(name="cart_item_foreign_key")
	    private List<CartItem> cartItems= new ArrayList<CartItem>();

	    
	    @Column(name="cart_total_price")
	    private double totalPrice;
	    
	    private int cart_quantity;
}
