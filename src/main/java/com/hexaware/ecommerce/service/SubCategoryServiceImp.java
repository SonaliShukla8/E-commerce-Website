package com.hexaware.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.SubCategoryDTO;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.SubCategory;
import com.hexaware.ecommerce.repository.SubCategoryRepository;
@Service
public class SubCategoryServiceImp implements ISubCategoryService {
    @Autowired 
	SubCategoryRepository repo;
    
    private static final Logger logger = LoggerFactory.getLogger(SubCategoryServiceImp.class);
	
	@Override
	public SubCategory addSubCategory(SubCategoryDTO subCategoryDTO) {
		logger.info("Adding new Sub Category...");
        	SubCategory subcategory=new SubCategory();
        	subcategory.setSubCategoryId(subCategoryDTO.getSubCategoryId());
        	subcategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());
        	subcategory.setCategory(subCategoryDTO.getCategory());
        	subcategory.setProducts(subCategoryDTO.getProducts());
		return repo.save(subcategory);
	}

	@Override
	public SubCategory updateSubCategory(SubCategoryDTO subCategoryDTO) {
		logger.info("Updating Sub Category...");
		SubCategory subcategory=new SubCategory();
    	subcategory.setSubCategoryId(subCategoryDTO.getSubCategoryId());
    	subcategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());
    	subcategory.setCategory(subCategoryDTO.getCategory());
    	subcategory.setProducts(subCategoryDTO.getProducts());
	    return repo.save(subcategory);
	}

	@Override
	public String deleteSubCategoryById(int subCategoryId) {
		logger.info("Deleting Sub Category with subCategoryId "+subCategoryId);
			repo.deleteById(subCategoryId);
		return "Subcategory  with subcategoryID "+subCategoryId+" deleted.";
	}

	@Override
	public SubCategoryDTO getSubCategoryById(int subCategoryId) {
		SubCategory subCategory=repo.findById(subCategoryId).orElse(null);
		if(subCategory == null) {
			logger.warn("Sub Category with subCategoryId: "+subCategoryId+" not found.");
			return null;}
		SubCategoryDTO dto=new SubCategoryDTO();
		dto.setSubCategoryId(subCategory.getSubCategoryId());
    	dto.setSubCategoryName(subCategory.getSubCategoryName());
    	dto.setCategory(subCategory.getCategory());
    	dto.setProducts(subCategory.getProducts());
		
		return dto;
	}

	@Override
	public List<SubCategory> getAllSubCategory() {
		logger.info("Fetching all Sub Categories...");
		
		return repo.findAll();
	}

	@Override
	public SubCategory getSubCategoryByName(String name) {
		return repo.findBySubCategoryName(name).orElse(null);
				
	}

}
