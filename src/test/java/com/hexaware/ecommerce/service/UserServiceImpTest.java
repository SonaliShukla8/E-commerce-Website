package com.hexaware.ecommerce.service;

import static org.junit.jupiter.api.Assertions.*;

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
		UserDTO userdto = new UserDTO(2, "User 2", "user2@gmail.com", "User1@", "customer");
		User dtoUser=service.addUser(userdto);
		assertNotNull(dtoUser);
		
	}

	@Test
	void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteUserById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUserById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllUser() {
		fail("Not yet implemented");
	}

}
