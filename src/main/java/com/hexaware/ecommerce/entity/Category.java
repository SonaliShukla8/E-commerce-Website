package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Category {
    @Id
	private int categoryId;        // Primary Key
    private String categoryName;
    private int subCategoryId;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy="category")
    private List<SubCategory> subCategories =new ArrayList<SubCategory>();
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products =new ArrayList<Product>();
}
