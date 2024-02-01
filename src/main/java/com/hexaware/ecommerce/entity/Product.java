package com.hexaware.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Product {
	@Id
	 private int productId;        // Primary Key
	
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name = "seller_Id")
	 private Seller seller;
	 
	    private String productName;
	    
	    private String productImageURL;
	    
	    private String description;
	    
	    private double price;
	    
	    private int stockQuantity;
	    
	    private String brand;
	    
	    private LocalDateTime createdAt;
	    
	    private LocalDateTime modifiedAt;
	    
	    
	    @ManyToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name = "categoryId")
	    private Category category;
	    
	    @ManyToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="subcategory_Id")
	    private SubCategory subCategory;
	    
	    @ManyToMany(mappedBy="products" ,fetch = FetchType.LAZY)
	    private List<Cart> carts=new ArrayList<Cart>();
	    
	    
}
