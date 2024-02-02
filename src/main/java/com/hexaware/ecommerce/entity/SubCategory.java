package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="categoryID")
    private Category category;
    
    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<Product>();
    
	/*
	 * @OneToMany(cascade=CascadeType.ALL,mappedBy="subCategory") private
	 * List<Product> product=new ArrayList<Product>();
	 */
    
    
}
