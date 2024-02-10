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

import com.hexaware.ecommerce.dto.OrderDTO;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.exception.OrderNotFoundException;
import com.hexaware.ecommerce.service.IOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/order")
public class OrderRestController {
	@Autowired
	IOrderService service;
	
	@PostMapping("/add")
	public Order addOrder(@RequestBody @Valid OrderDTO orderDTO) {
		return service.addOrder(orderDTO);
	}
	
	@PutMapping("/update")
    public Order updateOrder(@RequestBody @Valid  OrderDTO orderDTO) throws OrderNotFoundException {
		return service.updateOrder(orderDTO);
	}
	
	@DeleteMapping("/delete/{orderId}")
    public String deleteOrderById(@PathVariable int orderId) throws OrderNotFoundException{
		return service.deleteOrderById(orderId);
	}
     
	@GetMapping("/getbyId/{orderId}")
	public OrderDTO getOrderById(@PathVariable int orderId) throws OrderNotFoundException{
		return service.getOrderById(orderId);
	}
	
	@GetMapping("/getall")
    public List<Order> getAllOrder(){
		return service.getAllOrder();
	}

}
