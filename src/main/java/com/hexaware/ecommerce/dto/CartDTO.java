package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.CartItem;
import com.hexaware.ecommerce.entity.Customer;

public class CartDTO {

	 private int cartId;
	 private Customer customer;
	 private List<CartItem> cartItems= new ArrayList<CartItem>();
	 private double totalPrice;
	public CartDTO() {
		super();
	
	}
	public CartDTO(int cartId, Customer customer, List<CartItem> cartItems, double totalPrice) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", customer=" + customer + ", cartItems=" + cartItems + ", totalPrice="
				+ totalPrice + "]";
	}
	
}
