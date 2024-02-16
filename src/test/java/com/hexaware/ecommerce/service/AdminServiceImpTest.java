package com.hexaware.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.ecommerce.dto.AdminDTO;
import com.hexaware.ecommerce.entity.Admin;

import jakarta.transaction.Transactional;
@SpringBootTest
@Transactional
class AdminServiceImpTest {
	
	@Autowired
	IAdminService service;

	@Test
	void testAddAdmin() {
		//fail("Not yet implemented");
		AdminDTO adminDTO = new AdminDTO(1,"Admin1","admin1@gmail.com","admin","admin@113","7689768907",LocalDate.now(),"admin1");
		String add = service.addAdmin(adminDTO);
		assertEquals("New Admin records added.",add);
	}

}
