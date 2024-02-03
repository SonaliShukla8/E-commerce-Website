package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.CartItem;
import com.hexaware.ecommerce.entity.Customer;

public class CartDTO {

	 private int cartId;
	 private CustomerDTO customer;
	 private List<CartItemDTO> cartItems= new ArrayList<CartItemDTO>();
	 private double totalPrice;
	public CartDTO() {
		super();
	
	}
	public CartDTO(int cartId, CustomerDTO customer, List<CartItemDTO> cartItems, double totalPrice) {
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
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public List<CartItemDTO> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItemDTO> cartItems) {
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
