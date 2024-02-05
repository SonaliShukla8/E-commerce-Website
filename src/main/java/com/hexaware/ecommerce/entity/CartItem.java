package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
@Entity
public class CartItem {
	@Id
	@NotNull
    private int cartitemId;
	
	@Positive
	private int itemQuantity;
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity = Product.class)
    @JoinColumn(name="productId", nullable = false)
	private Product productId;
	
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="cartId")
	 private Cart cart;
	
	


	public CartItem() {
		super();
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




	public CartItem(@NotNull int cartitemId, @Positive int itemQuantity, Product productId, Cart cart) {
		super();
		this.cartitemId = cartitemId;
		this.itemQuantity = itemQuantity;
		this.productId = productId;
		this.cart = cart;
	}




	@Override
	public String toString() {
		return "CartItem [cartitemId=" + cartitemId + ", itemQuantity=" + itemQuantity + ", productId=" + productId
				+ ", cart=" + cart + "]";
	}


    
	
}
