package com.hexaware.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
     
     private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImp.class);
	
	@Override
	public Category addCategory(CategoryDTO categoryDTO) {
		logger.info("Adding new Category");
		Category category = new Category();
		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());
		//category.setSubCategories(categoryDTO.getSubCategories());
		
		return repo.save(category);
	}

	@Override
	public Category updateCategory(CategoryDTO categoryDTO) {
		logger.info("Updating the Category");

		Category category = new Category();
		category.setCategoryId(categoryDTO.getCategoryId());
		category.setCategoryName(categoryDTO.getCategoryName());
		//category.setSubCategories(categoryDTO.getSubCategories());
		
		return repo.save(category);
	}

	@Override
	public String deleteCategoryById(int categoryId) {
		
		logger.info("Deleting the category with category Id: "+categoryId);
		
		repo.deleteById(categoryId);
		
		
		return "Category Id with categoryId "+categoryId +" deleted.";
	}

	@Override
	public CategoryDTO getCategoryById(int categoryId) {
		
		Category category = repo.findById(categoryId).orElse(null);
		if(category == null) {
			logger.warn("Category with ID " +categoryId+ "not found.");
		}
		CategoryDTO dto = new CategoryDTO();
		dto.setCategoryId(category.getCategoryId());
		dto.setCategoryName(category.getCategoryName());
	//	dto.setSubCategories(category.getSubCategories());
	
		return dto;
	}

	@Override
	public List<Category> getAllCategory() {
		logger.info("Fetching all categories ...");
		return repo.findAll();
	}

	@Override
	public List<SubCategory> getSubCategoryIdByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		logger.info("Displaying sub categories with categoryId "+ categoryId);
		return repo.getSubCategoryIdByCategoryId(categoryId);
	}

}
