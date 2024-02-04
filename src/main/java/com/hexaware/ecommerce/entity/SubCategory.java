package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class SubCategory {
	@Id
    private int subCategoryId;        // Primary Key
	@NotBlank(message = "Subcategory name cannot be blank")
    private String subCategoryName;
    
	@ManyToOne
    @JoinColumn(name = "categoryID", nullable = false)
	private Category category;

    
    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<Product>();

	public SubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public SubCategory(int subCategoryId,
			@NotBlank(message = "Subcategory name cannot be blank") String subCategoryName,  Category category) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.category = category;
	}


	public SubCategory(int subCategoryId,
			@NotBlank(message = "Subcategory name cannot be blank") String subCategoryName,  Category category,
			List<Product> products) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.category = category;
		this.products = products;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", category="
				+ category + ", products=" + products + "]";
	}
    
    
    
}
