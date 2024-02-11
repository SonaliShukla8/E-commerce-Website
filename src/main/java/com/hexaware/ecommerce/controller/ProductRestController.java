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

import com.hexaware.ecommerce.dto.ProductDTO;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.exception.ProductNotFoundException;
import com.hexaware.ecommerce.service.IProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/product")
public class ProductRestController {
	@Autowired
	IProductService service;
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody @Valid ProductDTO productDTO) {
		return service.addProduct(productDTO);
	}
	
	@PutMapping("/update")
    public Product updateProduct(@RequestBody @Valid  ProductDTO productDTO) throws ProductNotFoundException{
		return service.updateProduct(productDTO);
	}
	
	@DeleteMapping("/delete/{productId}")
    public String deleteProductById(@PathVariable int productId) throws ProductNotFoundException {
		
		return service.deleteProductById(productId);
	
	}
     
	@GetMapping("/getbyId/{productId}")
	public ProductDTO getProductById(@PathVariable int productId)throws ProductNotFoundException {
		try {
		return service.getProductById(productId);
	}
	catch(NullPointerException exc) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Sorry,product does not exist",exc);
	}
	}
	
	@GetMapping("/getall")
    public List<Product> getAllProduct(){
		return service.getAllProduct();
	}

}
