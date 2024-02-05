package com.hexaware.ecommerce.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.intThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.ecommerce.dto.UserDTO;
import com.hexaware.ecommerce.entity.User;
@SpringBootTest
class UserServiceImpTest {
	@Autowired
    IUserService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testAddUser() {
		UserDTO userdto = new UserDTO(3, "User 3", "user3@gmail.com", "User3@", "seller");
		User dtoUser=service.addUser(userdto);
		assertNotNull(dtoUser);
		
	}

	@Test
	void testUpdateUser() {
		UserDTO userdto = new UserDTO(2, "User 2", "user2@gmail.com", "User2@", "customer");
		User dtoUser=service.updateUser(userdto);
		assertNotNull(dtoUser);
	}

	@Test
	void testDeleteUserById() {
//		int id=2;
//		String s=service.deleteUserById(id);
//		assertNotNull(s);
	}

	@Test
	void testGetUserById() {
        int id = 2;
        UserDTO dto=service.getUserById(id);
        assertNotNull(dto);
        assertEquals("customer",dto.getUserType());
	}

	@Test
	void testGetAllUser() {
		List<User> list1=service.getAllUser();
		assertNotNull(list1);
	}

}
