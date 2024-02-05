package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.Cart;
import com.hexaware.ecommerce.entity.Product;

public class CartItemDTO {
	
	 private int cartitemId;
	 private int itemQuantity;
	 private Product productId;
	 private Cart cart;

	
	 public CartItemDTO() {
		super();
		
	}

	public CartItemDTO(int cartitemId, int itemQuantity, Product productId, Cart cart, List<Product> product) {
		super();
		this.cartitemId = cartitemId;
		this.itemQuantity = itemQuantity;
		this.productId = productId;
		this.cart = cart;
		
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

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CartItemDTO [cartitemId=" + cartitemId + ", itemQuantity=" + itemQuantity + ", productId=" + productId
				+ ", cart=" + cart + "]";
	}


	

}
