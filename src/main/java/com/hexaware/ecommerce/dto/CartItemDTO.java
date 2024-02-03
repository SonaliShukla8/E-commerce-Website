package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.Cart;
import com.hexaware.ecommerce.entity.Product;

public class CartItemDTO {
	
	 private int cartitemId;
	 private int itemQuantity;
	 private CartDTO cart;

	 private List<ProductDTO> product=new ArrayList<ProductDTO>();
	
	 public CartItemDTO() {
		super();
		
	}

	public CartItemDTO(int cartitemId, int itemQuantity, CartDTO cart, List<ProductDTO> product) {
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



	public CartDTO getCart() {
		return cart;
	}

	public void setCart(CartDTO cart) {
		this.cart = cart;
	}

	public List<ProductDTO> getProduct() {
		return product;
	}

	public void setProduct(List<ProductDTO> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CartItemDTO [cartitemId=" + cartitemId + ", itemQuantity=" + itemQuantity + ", cart=" + cart
				+ ", product=" + product + "]";
	}
	 
	
}
