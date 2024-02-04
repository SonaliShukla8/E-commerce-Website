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

import com.hexaware.ecommerce.dto.CategoryDTO;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.service.ICategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
	
	@Autowired
	ICategoryService service;
	
	 @PostMapping("/add")
	 public Category addCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
		 return service.addCategory(categoryDTO);
		 
	 }
	 @PutMapping("/update")
     public Category updateCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
    	 return service.updateCategory(categoryDTO);
    	 
     }
	 @DeleteMapping("/delete/{categoryId}")
     public String deleteCategoryById(@PathVariable int categoryId) {
    	 return service.deleteCategoryById(categoryId);
    	 
     }
	 @GetMapping("/getbyId/{categoryId}")
     public CategoryDTO getCategoryById(@PathVariable int categoryId) {
    	 return service.getCategoryById(categoryId);
    	 
     }
	 @GetMapping("/getall")
     public List<Category> getAllCategory(){
    	 return service.getAllCategory();
    	 
     }

}