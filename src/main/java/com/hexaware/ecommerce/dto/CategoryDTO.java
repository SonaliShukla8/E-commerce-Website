package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.SubCategory;

public class CategoryDTO {
	
	private int categoryId;        // Primary Key
    private String categoryName;
    private List<SubCategory> subCategories = new ArrayList<SubCategory>();
    private List<Product> products=new ArrayList<Product>();
	
    public CategoryDTO() {
		super();
	}
    
	public CategoryDTO(int categoryId, String categoryName, List<SubCategory> subCategories, List<Product> products) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.subCategories = subCategories;
		this.products = products;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "CategoryDTO [categoryId=" + categoryId + ", categoryName=" + categoryName + ", subCategories="
				+ subCategories + ", products=" + products + "]";
	}
    
    
    

}
