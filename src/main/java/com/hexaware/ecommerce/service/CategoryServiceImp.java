package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.CategoryDTO;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.SubCategory;
import com.hexaware.ecommerce.repository.CategoryRepository;
@Service
public class CategoryServiceImp implements ICategoryService {
     @Autowired
	CategoryRepository repo;
	
	@Override
	public Category addCategory(CategoryDTO categoryDTO) {
		
		Category category = new Category();
		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());
		//category.setSubCategories(categoryDTO.getSubCategories());
		
		return repo.save(category);
	}

	@Override
	public Category updateCategory(CategoryDTO categoryDTO) {
		

		Category category = new Category();
		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());
		//category.setSubCategories(categoryDTO.getSubCategories());
		
		return repo.save(category);
	}

	@Override
	public String deleteCategoryById(int categoryId) {
		
		repo.deleteById(categoryId);
		
		
		return "Category Id with categoryId "+categoryId +" deleted.";
	}

	@Override
	public CategoryDTO getCategoryById(int categoryId) {
		
		Category category = repo.findById(categoryId).orElse(null);
		CategoryDTO dto = new CategoryDTO();
		dto.setCategoryId(category.getCategoryId());
		dto.setCategoryName(category.getCategoryName());
	//	dto.setSubCategories(category.getSubCategories());
	
		return dto;
	}

	@Override
	public List<Category> getAllCategory() {

		return repo.findAll();
	}

	@Override
	public List<SubCategory> getSubCategoryIdByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return repo.getSubCategoryIdByCategoryId(categoryId);
	}

}
