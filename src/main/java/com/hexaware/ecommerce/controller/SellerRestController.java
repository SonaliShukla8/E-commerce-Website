package com.hexaware.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.service.ISellerService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/seller")
public class SellerRestController {
	@Autowired
	ISellerService service;
	
	@PostMapping("/add")
	public Seller addSeller(@RequestBody @Valid SellerDTO sellerDTO) {
		return service.addSeller(sellerDTO);
	}
	
	@PutMapping("/update")
    public Seller updateSeller(@RequestBody @Valid  SellerDTO sellerDTO) {
		return service.updateSeller(sellerDTO);
	}
	
	@DeleteMapping("/delete/{sellerId}")
    public String deleteSellerById(@PathVariable int sellerId) {
		
		return service.deleteSellerById(sellerId);
		}
	
     
	@GetMapping("/getbyId/{sellerId}")
	public SellerDTO getSellerById(@PathVariable int sellerId) {
		try {
		return service.getSellerById(sellerId);
	}
	catch(NullPointerException exc) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Sorry, seller does not exist",exc);
	}
	}
	
	@GetMapping("/getall")
    public List<Seller> getAllSeller(){
		return service.getAllSeller();
	}


}
