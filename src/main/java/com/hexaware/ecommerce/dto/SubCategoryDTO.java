package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Product;

public class SubCategoryDTO {
	
	 private int subCategoryId;        // Primary Key
	    private String subCategoryName;
	    private CategoryDTO category;

	    private List<ProductDTO> products= new ArrayList<ProductDTO>();
		
	    public SubCategoryDTO() {
			super();
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

		public CategoryDTO getCategory() {
			return category;
		}

		public void setCategory(CategoryDTO category) {
			this.category = category;
		}

		public List<ProductDTO> getProducts() {
			return products;
		}

		public void setProducts(List<ProductDTO> products) {
			this.products = products;
		}

		public SubCategoryDTO(int subCategoryId, String subCategoryName, CategoryDTO category,
				List<ProductDTO> products) {
			super();
			this.subCategoryId = subCategoryId;
			this.subCategoryName = subCategoryName;
			this.category = category;
			this.products = products;
		}

		@Override
		public String toString() {
			return "SubCategoryDTO [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName
					+ ", category=" + category + ", products=" + products + "]";
		}

		



}
