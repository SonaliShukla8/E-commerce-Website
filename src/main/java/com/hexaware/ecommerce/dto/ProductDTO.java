package com.hexaware.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private List<CartItem> cartitem=new ArrayList<CartItem>();
	
    public ProductDTO() {
		super();
		
	}

	public ProductDTO(Seller seller, String productName, String productImageURL, String description, double price,
			int stockQuantity, String brand, LocalDateTime createdAt, LocalDateTime modifiedAt, Category category,
			SubCategory subCategory, List<CartItem> cartitem) {
		super();
		this.seller = seller;
		this.productName = productName;
		this.productImageURL = productImageURL;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.brand = brand;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.category = category;
		this.subCategory = subCategory;
		this.cartitem = cartitem;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImageURL() {
		return productImageURL;
	}

	public void setProductImageURL(String productImageURL) {
		this.productImageURL = productImageURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public List<CartItem> getCartitem() {
		return cartitem;
	}

	public void setCartitem(List<CartItem> cartitem) {
		this.cartitem = cartitem;
	}

	@Override
	public String toString() {
		return "ProductDTO [seller=" + seller + ", productName=" + productName + ", productImageURL=" + productImageURL
				+ ", description=" + description + ", price=" + price + ", stockQuantity=" + stockQuantity + ", brand="
				+ brand + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", category=" + category
				+ ", subCategory=" + subCategory + ", cartitem=" + cartitem + "]";
	}
    
    
    
    

}