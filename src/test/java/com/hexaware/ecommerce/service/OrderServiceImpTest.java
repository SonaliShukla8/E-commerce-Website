//package com.hexaware.ecommerce.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.hexaware.ecommerce.dto.OrderDTO;
//import com.hexaware.ecommerce.entity.Order;
//import com.hexaware.ecommerce.exception.OrderNotFoundException;
//
//import jakarta.transaction.Transactional;
//@SpringBootTest
//@Transactional
//class OrderServiceImpTest {
//
//	@Autowired
//	IOrderService service;
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//		
//	}
//
//	@Test
//	@DisplayName("InsertOrder")
//	void testAddOrder() {
//		
//		OrderDTO orderDTO = new OrderDTO(1,null,LocalDate.now(),500.00,"Pending","Yet to be placed",null,LocalDate.now().plusDays(7),null);
//		Order order = service.addOrder(orderDTO);
//		assertEquals("Pending",order.getStatus());
//		
//       
//	}
//
//
//	@Test
//	void testDeleteOrderById() throws OrderNotFoundException {
//		
//		OrderDTO orderDTO = new OrderDTO(2,null,LocalDate.now(),500.00,"Pending","Yet to be placed",null,LocalDate.now().plusDays(7),null);
//		Order order = service.addOrder(orderDTO);
//		String delete = service.deleteOrderById(order.getOrderId());
//		assertNotEquals("",delete);
//
//	}
//
//	@Test
//	void testGetOrderById() throws OrderNotFoundException {
//		OrderDTO orderDTO = new OrderDTO(1,null,LocalDate.now(),500.00,"Pending","Yet to be placed",null,LocalDate.now().plusDays(7),null);
//		Order order = service.addOrder(orderDTO);
//		OrderDTO orderDTO2 = service.getOrderById(order.getOrderId());
//		
//		assertEquals(500.00,orderDTO2.getTotalAmount());
//	}
//
//	@Test
//	void testGetAllOrder() {
//		List list = service.getAllOrder();
//		int size = list.size();
//
//		assertNotEquals(1,size);
//	
//	}
//
//}
