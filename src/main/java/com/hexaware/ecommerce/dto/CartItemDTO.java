package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.Cart;
import com.hexaware.ecommerce.entity.Product;

public class CartItemDTO {
	
	 private int cartitemId;
	 private int itemQuantity;
	 private Cart cart;

	 private List<Product> product=new ArrayList<Product>();
	
	 public CartItemDTO() {
		super();
		
	}

	public CartItemDTO(int cartitemId, int itemQuantity, Cart cart, List<Product> product) {
		super();
		this.cartitemId = cartitemId;
		this.itemQuantity = itemQuantity;
		this.cart = cart;
		this.product = product;
	}

	public int getCartitemId() {
		return cartitemId;
	}

	public void setCartitemId(int cartitemId) {
		this.cartitemId = cartitemId;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartItemDTO [cartitemId=" + cartitemId + ", itemQuantity=" + itemQuantity + ", cart=" + cart
				+ ", product=" + product + "]";
	}

	
	
}
