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

import com.hexaware.ecommerce.dto.CartItemDTO;
import com.hexaware.ecommerce.entity.CartItem;
import com.hexaware.ecommerce.service.ICartItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cartItem")
public class CartItemRestController {
	
	
	@Autowired
	ICartItemService service;
	
	@PostMapping("/add")
	 public CartItem addCartItem(@RequestBody @Valid CartItemDTO cartItemDTO) {
		 
		 return service.addCartItem(cartItemDTO);
	 }
	
	@PutMapping("/update")
     public CartItem updateCartItem(@RequestBody @Valid CartItemDTO cartItemDTO) {
    	 
    	 return service.updateCartItem(cartItemDTO);
     }
	
	@DeleteMapping("/delete/{catitemId}")
     public String deleteCartItemById(@PathVariable int cartitemId) {
    	 
    	 return service.deleteCartItemById(cartitemId);
     }
	
	@GetMapping("/getbyId/{cartitemId}")
     public CartItemDTO getCartItemById(@PathVariable int cartitemId) {
    	 
    	 return service.getCartItemById(cartitemId);
     }
	
	@GetMapping("/getall")
     public List<CartItem> getAllCartItem(){
    	 
    	 return service.getAllCartItem();
     }

}
