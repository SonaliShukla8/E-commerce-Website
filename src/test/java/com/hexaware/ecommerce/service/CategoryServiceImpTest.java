package com.hexaware.ecommerce.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.ecommerce.dto.CategoryDTO;
import com.hexaware.ecommerce.entity.Category;
@SpringBootTest
class CategoryServiceImpTest {
	
	@Autowired
	ICategoryService service;

	@Test
	void testAddCategory() {
		
		CategoryDTO categorydto =new CategoryDTO(101,"Clothing");
		Category category = service.addCategory(categorydto);
		assertEquals(101,category.getCategoryId());
		//fail("Not yet implemented");
	}

	@Test
	void testUpdateCategory() {
		//fail("Not yet implemented");
		CategoryDTO categorydto =new CategoryDTO(102,"Furniture");
		Category category = service.addCategory(categorydto);
		CategoryDTO categorydto2 =new CategoryDTO(102,"Home Appliances");
		Category category2 = service.updateCategory(categorydto2);
		assertEquals("Home Appliances",category2.getCategoryName());
	}

	@Test
	void testDeleteCategoryById() {
		//fail("Not yet implemented");
		CategoryDTO categorydto =new CategoryDTO(103,"Furniture");
		Category category = service.addCategory(categorydto);
		String delete = service.deleteCategoryById(category.getCategoryId());
		assertNotEquals(null,delete);
		
	}

	@Test
	void testGetCategoryById() {
		//fail("Not yet implemented");
		CategoryDTO categorydto =new CategoryDTO(104,"Stationery");
		Category category = service.addCategory(categorydto);
		CategoryDTO categorydto2 = service.getCategoryById(category.getCategoryId());
		assertEquals(104,categorydto2.getCategoryId());
		
	}

	@Test
	void testGetAllCategory() {
		//fail("Not yet implemented");
		List list = service.getAllCategory();
		boolean flag = list.isEmpty();
		assertFalse(flag);
	}

}
