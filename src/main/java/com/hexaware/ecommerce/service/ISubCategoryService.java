package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.entity.SubCategory;

public interface ISubCategoryService {
	public SubCategory addSubCategory(SubCategory subCategory);
    public SubCategory updateCategory(SubCategory subCategory);
    public String deleteSubCategoryById(int subCategoryId);
    public SubCategory getSubCategoryById(int subCategoryId);
    public List<SubCategory> getAllSubCategory();
}
