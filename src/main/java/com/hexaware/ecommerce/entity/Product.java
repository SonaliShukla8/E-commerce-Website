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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;


@Entity
public class Product {
	@Id
	 private int productId;        // Primary Key
	
	 @ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name = "seller_Id")
	 private Seller seller;
	 @NotBlank
	    private String productName;
	    @NotBlank
	    private String productImageURL;
	    @NotBlank
	    private String description;
	    @Positive
	    private double price;
	    @Min(1)
	    private int stockQuantity;
	    @NotBlank
	    private String brand;
	    @PastOrPresent
	    private LocalDateTime createdAt;
	    @PastOrPresent
	    private LocalDateTime modifiedAt;
	    
	    
	    @ManyToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name = "categoryId")
	    private Category category;
	    
	    @ManyToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="subcategory_Id")
	    private SubCategory subCategory;
	    
	    @ManyToMany(mappedBy="product" ,fetch = FetchType.LAZY)
	    private List<CartItem> cartitem=new ArrayList<CartItem>();
	    
	    
}
