package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.CategoryDTO;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.repository.CategoryRepository;
@Service
public class CategoryServiceImp implements ICategoryService {
     @Autowired
	CategoryRepository repo;
	
	@Override
	public Category addCategory(CategoryDTO categoryDTO) {
		
		return null;
	}

	@Override
	public Category updateCategory(CategoryDTO categoryDTO) {
		
		return null;
	}

	@Override
	public String deleteCategoryById(int cartegoryId) {
		
		return null;
	}

	@Override
	public CategoryDTO getCategoryById(int categoryId) {
	
		return null;
	}

	@Override
	public List<Category> getAllCategory() {

		return null;
	}

}
