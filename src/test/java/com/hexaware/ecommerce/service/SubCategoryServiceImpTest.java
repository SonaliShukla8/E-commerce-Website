package com.hexaware.ecommerce.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.hexaware.ecommerce.dto.CategoryDTO;
import com.hexaware.ecommerce.dto.SubCategoryDTO;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.SubCategory;
import com.hexaware.ecommerce.exception.CategoryNotFoundException;
import com.hexaware.ecommerce.exception.SubCategoryNotFoundException;

import ch.qos.logback.classic.Logger;
import jakarta.transaction.Transactional;
@SpringBootTest
@Transactional
class SubCategoryServiceImpTest {
	
	@Autowired
	ISubCategoryService service;
	@Autowired
	ICategoryService service2;

	@Test
	void testAddSubCategory() throws CategoryNotFoundException {
		//fail("Not yet implemented");
		CategoryDTO categorydto = new CategoryDTO(1,"Electronics");
		Category category = service2.updateCategory(categorydto);
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO(201,"Mobiles",category);
		SubCategory subCategory = service.addSubCategory(subCategoryDTO);
		assertEquals("Mobiles",subCategory.getSubCategoryName());
	}

	@Test
	void testUpdateSubCategory() throws CategoryNotFoundException, SubCategoryNotFoundException {
		//fail("Not yet implemented");
		CategoryDTO categorydto = new CategoryDTO(1,"Electronics");
		Category category = service2.updateCategory(categorydto);
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO(202,"PC",category);
		SubCategory subCategory = service.addSubCategory(subCategoryDTO);
		SubCategoryDTO subCategoryDTO2 = new SubCategoryDTO(202,"Laptop",category);
		SubCategory subCategory2 = service.updateSubCategory(subCategoryDTO2);
		assertEquals("Laptop",subCategory2.getSubCategoryName());
	}

	@Test
	void testDeleteSubCategoryById() throws CategoryNotFoundException, SubCategoryNotFoundException {
		//fail("Not yet implemented");
		CategoryDTO categorydto = new CategoryDTO(1,"Electronics");
		Category category = service2.updateCategory(categorydto);
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO(203,"Power Bank",category);
		SubCategory subCategory = service.addSubCategory(subCategoryDTO);
		String delete = service.deleteSubCategoryById(subCategory.getSubCategoryId());
		assertNotEquals(null,delete);
	}

	@Test
	void testGetSubCategoryById() throws CategoryNotFoundException, SubCategoryNotFoundException {
		//fail("Not yet implemented");
		CategoryDTO categorydto = new CategoryDTO(1,"Electronics");
		Category category = service2.updateCategory(categorydto);
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO(203,"TV",category);
		SubCategory subCategory = service.addSubCategory(subCategoryDTO);
		SubCategoryDTO subCategoryDTO2 = service.getSubCategoryById(subCategory.getSubCategoryId());
		assertEquals(203,subCategoryDTO2.getSubCategoryId());
		
	}

	@Test
	void testGetAllSubCategory() {
		//fail("Not yet implemented");
		List list = service.getAllSubCategory();
		int size = list.size();

		assertNotEquals(0,size);
	}

}
