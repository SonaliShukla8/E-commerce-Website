package com.hexaware.ecommerce.dto;

import java.util.List;

import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Product;

public class SubCategoryDTO {
	
	 private int subCategoryId;        // Primary Key
	    private String subCategoryName;
	    private Category category;
	    private List<Product> products;

}
