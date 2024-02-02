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
	
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="cartId")
	 private Cart cart;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="product_cart_detail", joinColumns= {@JoinColumn(name="cartitemId")},
	inverseJoinColumns= {@JoinColumn(name="productId")})
    private List<Product> product=new ArrayList<Product>();


	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CartItem(@NotNull int cartitemId, @Positive int itemQuantity, Cart cart, List<Product> product) {
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
		return "CartItem [cartitemId=" + cartitemId + ", itemQuantity=" + itemQuantity + ", cart=" + cart + ", product="
				+ product + "]";
	}
	
	
 
    
}
