package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.SubCategory;

public class CategoryDTO {
	
	private int categoryId;        // Primary Key
    private String categoryName;
    private List<SubCategoryDTO> subCategories = new ArrayList<SubCategoryDTO>();
    private List<ProductDTO> products=new ArrayList<ProductDTO>();
	
    public CategoryDTO() {
		super();
	}

	public CategoryDTO(int categoryId, String categoryName, List<SubCategoryDTO> subCategories,
			List<ProductDTO> products) {
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

	public List<SubCategoryDTO> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategoryDTO> subCategories) {
		this.subCategories = subCategories;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryId=" + categoryId + ", categoryName=" + categoryName + ", subCategories="
				+ subCategories + ", products=" + products + "]";
	}


    
	

}
