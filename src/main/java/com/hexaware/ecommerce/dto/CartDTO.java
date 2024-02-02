package com.hexaware.ecommerce.dto;

import java.util.List;

import com.hexaware.ecommerce.entity.CartItem;
import com.hexaware.ecommerce.entity.Customer;

public class CartDTO {

	 private int cartId;
	 private Customer customer;
	 private List<CartItem> cartItems;
	 private double totalPrice;
}
