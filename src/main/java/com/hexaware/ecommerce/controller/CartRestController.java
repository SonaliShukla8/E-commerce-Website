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

import com.hexaware.ecommerce.dto.CartDTO;
import com.hexaware.ecommerce.entity.Cart;
import com.hexaware.ecommerce.service.ICartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {
	
	@Autowired
	ICartService service;
	
	@PostMapping("/add")
	public Cart addCart(@RequestBody @Valid CartDTO cartDTO) {
		
		return service.addCart(cartDTO);
	}
	
	@PutMapping("/update")
    public Cart updateCart(@RequestBody @Valid CartDTO cartDTO) {
    	return service.updateCart(cartDTO);
    	
    }
	
	@DeleteMapping("/delete/{cartId}")
    public String deleteCartById(@PathVariable int cartId) {
    	return service.deleteCartById(cartId);
    	
    	
    }
	
	@GetMapping("/getbyId/{cartId}")
    public CartDTO getCartbyId(@PathVariable int cartId) {
    	return service.getCartbyId(cartId);
    	
    	
    }
	
	@GetMapping("/getall")
    public List<Cart> getAllCart(){
    	return service.getAllCart();
    	
    	
    }

}
