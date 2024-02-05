package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.CartItem;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.entity.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartDTO {

	 private int cartId;
	
	 private List<CartItem> cartItems= new ArrayList<CartItem>();
	 
	 private double totalPrice;
	 
	 private List<Product> product=new ArrayList<Product>();
	
	 public CartDTO() {
		super();
	
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public CartDTO(int cartId, List<CartItem> cartItems, double totalPrice, List<Product> product) {
		super();
		this.cartId = cartId;
		this.cartItems = cartItems;
		this.totalPrice = totalPrice;
		this.product = product;
	}
	public CartDTO(int cartId, double totalPrice) {
		super();
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		
	}

	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", cartItems=" + cartItems + ", totalPrice=" + totalPrice + ", product="
				+ product + "]";
	}
	
	
}
