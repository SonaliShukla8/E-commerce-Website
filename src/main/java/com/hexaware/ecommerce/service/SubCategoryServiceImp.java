package com.hexaware.ecommerce.service;

import java.util.List;

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
	
	@Override
	public SubCategory addSubCategory(SubCategoryDTO subCategoryDTO) {
        	SubCategory subcategory=new SubCategory();
        	subcategory.setSubCategoryId(subCategoryDTO.getSubCategoryId());
        	subcategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());
        	subcategory.setCategory(subCategoryDTO.getCategory());
        	subcategory.setProducts(subCategoryDTO.getProducts());
		return repo.save(subcategory);
	}

	@Override
	public SubCategory updateSubCategory(SubCategoryDTO subCategoryDTO) {
		SubCategory subcategory=new SubCategory();
    	subcategory.setSubCategoryId(subCategoryDTO.getSubCategoryId());
    	subcategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());
    	subcategory.setCategory(subCategoryDTO.getCategory());
    	subcategory.setProducts(subCategoryDTO.getProducts());
	    return repo.save(subcategory);
	}

	@Override
	public String deleteSubCategoryById(int subCategoryId) {
			repo.deleteById(subCategoryId);
		return "Subcategory  with subcategoryID "+subCategoryId+" deleted.";
	}

	@Override
	public SubCategoryDTO getSubCategoryById(int subCategoryId) {
		SubCategory subCategory=repo.findById(subCategoryId).orElse(null);
		SubCategoryDTO dto=new SubCategoryDTO();
		dto.setSubCategoryId(subCategory.getSubCategoryId());
    	dto.setSubCategoryName(subCategory.getSubCategoryName());
    	dto.setCategory(subCategory.getCategory());
    	dto.setProducts(subCategory.getProducts());
		
		return dto;
	}

	@Override
	public List<SubCategory> getAllSubCategory() {
		
		return repo.findAll();
	}

}
