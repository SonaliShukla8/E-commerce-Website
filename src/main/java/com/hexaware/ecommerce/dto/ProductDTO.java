package com.hexaware.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.hexaware.ecommerce.entity.CartItem;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.entity.SubCategory;

public class ProductDTO {
	
	
	
	private Seller seller;
	 
    private String productName;
    
    private String productImageURL;
    
    private String description;
    
    private double price;
    
    private int stockQuantity;
    
    private String brand;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime modifiedAt;
    private Category category;
    private SubCategory subCategory;
    private List<CartItem> cartitem;

}
