package com.hexaware.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.exception.SellerNotFoundException;
@SpringBootTest
class SellerServiceImpTest {
	
	@Autowired
	ISellerService service;

	@Test
	void testAddSeller() {
		//fail("Not yet implemented");
		SellerDTO sellerDTO = new SellerDTO(101,"Raymond","9848283421","raymond@gmail.com","Mumbai","Clothing",null,null);
		Seller seller = service.addSeller(sellerDTO);
		assertEquals(101,seller.getSellerId());
	}

	@Test
	void testUpdateSeller() throws SellerNotFoundException {
	//	fail("Not yet implemented");
		SellerDTO sellerDTO = new SellerDTO(102,"LOUIS PHILIPPE","8074537575","louisphilippe@gmail.com","Hyderabad","Clothing",null,null);
		Seller seller = service.addSeller(sellerDTO);
		SellerDTO sellerDTO2 = new SellerDTO(102,"LOUIS PHILIPPE","9392029482","louisphilippe@gmail.com","Hyderabad","Clothing",null,null);
		Seller seller2 = service.updateSeller(sellerDTO2);
		assertEquals("9392029482",seller2.getPhoneNumber());
	}

	@Test
	void testDeleteSellerById() throws SellerNotFoundException {
		//fail("Not yet implemented");
		SellerDTO sellerDTO = new SellerDTO(104,"ASUS","7124932415","asus@gmail.com","Chennai","Electronics",null,null);
		Seller seller = service.addSeller(sellerDTO);
		String delete = service.deleteSellerById(seller.getSellerId());
		assertNotEquals(null,delete);
		
	}

	@Test
	void testGetSellerById() throws SellerNotFoundException {
		//fail("Not yet implemented");
		SellerDTO sellerDTO = new SellerDTO(103,"SAMSUNG","8435242468","samsung@gmail.com","Kochi","Electronics",null,null);
		Seller seller = service.addSeller(sellerDTO);
		SellerDTO sellerDTO2 = service.getSellerById(seller.getSellerId());
		assertEquals(103,sellerDTO2.getSellerId());
	}

	@Test
	void testGetAllSeller() {
		//fail("Not yet implemented");
		List list = service.getAllSeller();
		boolean flag = list.isEmpty();
		assertFalse(flag);
	}

}
