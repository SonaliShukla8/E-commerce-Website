package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.SubCategoryDTO;
import com.hexaware.ecommerce.entity.SubCategory;
import com.hexaware.ecommerce.repository.SubCategoryRepository;
@Service
public class SubCategoryServiceImp implements ISubCategoryService {
    @Autowired 
	SubCategoryRepository repo;
	
	@Override
	public SubCategory addSubCategory(SubCategoryDTO subCategoryDTO) {

		return null;
	}

	@Override
	public SubCategory updateCategory(SubCategoryDTO subCategoryDTO) {

		return null;
	}

	@Override
	public String deleteSubCategoryById(int subCategoryId) {

		return null;
	}

	@Override
	public SubCategoryDTO getSubCategoryById(int subCategoryId) {
		
		return null;
	}

	@Override
	public List<SubCategory> getAllSubCategory() {
		
		return null;
	}

}
