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
	
 
    
}
