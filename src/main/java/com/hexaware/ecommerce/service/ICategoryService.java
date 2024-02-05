package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.hexaware.ecommerce.dto.CategoryDTO;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.SubCategory;

public interface ICategoryService {
	 public Category addCategory(CategoryDTO categoryDTO);
     public Category updateCategory(CategoryDTO categoryDTO);
     public String deleteCategoryById(int categoryId);
     public CategoryDTO getCategoryById(int categoryId);
     public List<Category> getAllCategory();
    public List<SubCategory> getSubCategoryIdByCategoryId(int categoryId);
}
