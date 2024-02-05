package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Entity
public class Cart {
	  	@Id
	  	@NotNull
	    private int cartId;
	  
	  

	    @OneToMany( cascade = CascadeType.ALL, mappedBy="cart")
	    private List<CartItem> cartItems= new ArrayList<CartItem>();

	    @Positive
	    @Column(name="cart_total_price")
	    private double totalPrice;


		@ManyToMany(cascade=CascadeType.ALL)
		@JoinTable(name="product_cart_detail", joinColumns= {@JoinColumn(name="cartId")},
		inverseJoinColumns= {@JoinColumn(name="productId")})
	    private List<Product> product=new ArrayList<Product>();
		
		public Cart() {
			super();
			// TODO Auto-generated constructor stub
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

		@Override
		public String toString() {
			return "Cart [cartId=" + cartId + ", cartItems=" + cartItems + ", totalPrice=" + totalPrice + ", product="
					+ product + "]";
		}

		public Cart(@NotNull int cartId, List<CartItem> cartItems, @Positive double totalPrice, List<Product> product) {
			super();
			this.cartId = cartId;
			this.cartItems = cartItems;
			this.totalPrice = totalPrice;
			this.product = product;
		}
		public Cart(@NotNull int cartId,  @Positive double totalPrice) {
			super();
			this.cartId = cartId;
//			this.cartItems = cartItems;
			this.totalPrice = totalPrice;
//			this.product = product;
		}

	    
}
