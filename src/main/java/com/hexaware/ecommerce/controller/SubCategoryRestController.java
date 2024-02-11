package com.hexaware.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.SubCategoryDTO;
import com.hexaware.ecommerce.entity.SubCategory;
import com.hexaware.ecommerce.exception.SubCategoryNotFoundException;
import com.hexaware.ecommerce.service.ISubCategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/subCategory")
public class SubCategoryRestController {
	@Autowired
	ISubCategoryService service;
	
	@PostMapping("/add")
	public SubCategory addSubCategory(@RequestBody SubCategoryDTO subCategoryDTO) {
		return service.addSubCategory(subCategoryDTO);
	}
	
	@PutMapping("/update")
    public SubCategory updateSubCategory(@RequestBody @Valid  SubCategoryDTO subCategoryDTO) throws SubCategoryNotFoundException {
		return service.updateSubCategory(subCategoryDTO);
	}
	
	@DeleteMapping("/delete/{subCategoryId}")
    public String deleteSubCategoryById(@PathVariable int subCategoryId) throws SubCategoryNotFoundException  {
		return service.deleteSubCategoryById(subCategoryId);
	}
     
	@GetMapping("/getbyId/{subCategoryId}")
	public SubCategoryDTO getSubCategoryById(@PathVariable int subCategoryId) throws SubCategoryNotFoundException  {
		return service.getSubCategoryById(subCategoryId);
	}
	
	@GetMapping("/getall")
    public List<SubCategory> getAllSubCategory(){
		return service.getAllSubCategory();
	}


}
