package com.hexaware.ecommerce.dto;

import java.util.List;

import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.SubCategory;

public class CategoryDTO {
	
	private int categoryId;        // Primary Key
    private String categoryName;
    private List<SubCategory> subCategories;
    private List<Product> products;
    

}
