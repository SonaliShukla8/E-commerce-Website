package com.hexaware.ecommerce.service;

import java.util.List;
import com.hexaware.ecommerce.entity.Category;

public interface ICategoryService {
	 public Category addCategory(Category category);
     public Category updateCategory(Category category);
     public String deleteCategoryById(int cartegoryId);
     public Category getCategoryById(int categoryId);
     public List<Category> getAllCategory();
}
