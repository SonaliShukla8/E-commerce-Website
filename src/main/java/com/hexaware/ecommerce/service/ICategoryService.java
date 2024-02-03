package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.CategoryDTO;
import com.hexaware.ecommerce.entity.Category;

public interface ICategoryService {
	 public Category addCategory(CategoryDTO categoryDTO);
     public Category updateCategory(CategoryDTO categoryDTO);
     public String deleteCategoryById(int cartegoryId);
     public CategoryDTO getCategoryById(int categoryId);
     public List<Category> getAllCategory();
}
