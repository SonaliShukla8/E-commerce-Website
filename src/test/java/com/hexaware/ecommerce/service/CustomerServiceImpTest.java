package com.hexaware.ecommerce.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entity.Address;
import com.hexaware.ecommerce.entity.Cart;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.exception.CustomerNotFoundException;

import jakarta.transaction.Transactional;
@SpringBootTest
@Transactional
class CustomerServiceImpTest {
	@Autowired
    ICustomerService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testRegisterCustomer() {
		Cart cart = new Cart(1,100);
		Address address = new Address(2," D.NO- 3-16B-63, ABC COLONY","XYZ NAGAR, GACHIBOWLI","533003","Hyderabad","Telangana","India");
		
		CustomerDTO customerDto = new CustomerDTO(101, "Ram", "Male", "9244387561", "ram@example.com", "ram123","ram@123", "customer", address, cart, null);
		String customer = service.registerCustomer(customerDto);
		assertNotEquals("",customer);
	}


	@Test
	void testUpdateCustomer() throws CustomerNotFoundException {
	   
	    CustomerDTO customerDto = new CustomerDTO(101, "Ram", "Male", "9244387561", "ram@example.com", "ram123", "ram@123", "customer", null, null, null);
	    String customer = service.registerCustomer(customerDto);
	    Address updatedAddress = new Address(3," D.NO- 432,SDF COLONY","JHG NAGAR, LB NAGAR","532104","Hyderabad","Telangana","India");

	    CustomerDTO updatedCustomerDto = new CustomerDTO(101,"Ram", "Male", "9244387561", "ram@example.com", "ram123", "ram@123", "customer", updatedAddress, null, null);
	    Customer result = service.updateCustomer(updatedCustomerDto);

	    assertEquals(updatedAddress.getAddressId(), result.getAddress().getAddressId());
	}


	@Test
	void testDeleteCustomerById() throws CustomerNotFoundException {
		CustomerDTO customerDto = new CustomerDTO(101, "Ram", "Male", "9244387561", "ram@example.com", "ram123", "ram@123", "customer", null, null, null);
	    String customer = service.registerCustomer(customerDto);
	    String delete = service.deleteCustomerById(101);
	    assertEquals("Customer with customerId 101 deleted.",delete);
	}

	@Test
	void testGetCustomerById() throws CustomerNotFoundException {
		CustomerDTO customerDto = new CustomerDTO(101, "Ram", "Male", "9244387561", "ram@example.com", "ram123", "ram@123", "customer", null, null, null);
	    String customer = service.registerCustomer(customerDto);
	    CustomerDTO customerDto2 = service.getCustomerById(101);
	    assertEquals("Ram",customerDto2.getCustomerName());
	}

	@Test
	void testGetAllCustomer() {
		List<Customer> list=service.getAllCustomer();
		assertNotNull(list);
	}

}
