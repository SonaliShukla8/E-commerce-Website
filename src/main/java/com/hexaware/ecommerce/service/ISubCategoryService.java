package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.SubCategoryDTO;
import com.hexaware.ecommerce.entity.SubCategory;

public interface ISubCategoryService {
	public SubCategory addSubCategory(SubCategoryDTO subCategoryDTO);
    public SubCategory updateSubCategory(SubCategoryDTO subCategoryDTO);
    public String deleteSubCategoryById(int subCategoryId);
    public SubCategoryDTO getSubCategoryById(int subCategoryId);
    public List<SubCategory> getAllSubCategory();
    public SubCategory getSubCategoryByName(String name);
}
