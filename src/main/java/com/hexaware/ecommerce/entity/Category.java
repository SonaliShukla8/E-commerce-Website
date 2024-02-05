package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Category {
    @Id
	private int categoryId;        // Primary Key
    @NotBlank
    private String categoryName;
    
    public Category(int categoryId, @NotBlank String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
    
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy="category", fetch = FetchType.LAZY)
   private List<SubCategory> subCategories =new ArrayList<SubCategory>();
    
	/*
	 * @OneToMany(mappedBy = "category", cascade = CascadeType.ALL) private
	 * List<Product> products =new ArrayList<Product>();
	 */

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryId, @NotBlank String categoryName, List<SubCategory> subCategories) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.subCategories = subCategories;
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

	
	  public List<SubCategory> getSubCategories() { return subCategories; }
	  
	  public void setSubCategories(List<SubCategory> subCategories) {
	  this.subCategories = subCategories; }

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", subCategories="
				+ subCategories + "]";
	}
	 

	
    
    
}
