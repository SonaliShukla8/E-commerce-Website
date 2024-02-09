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
import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.exception.ProductNotFoundException;
import com.hexaware.ecommerce.exception.SellerNotFoundException;
import com.hexaware.ecommerce.entity.SubCategory;
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
    public Seller updateSeller(@RequestBody @Valid  SellerDTO sellerDTO) throws SellerNotFoundException{
		return service.updateSeller(sellerDTO);
	}
//	
//	@DeleteMapping("/delete/{sellerId}")
//    public String deleteSellerById(@PathVariable int sellerId) throws SellerNotFoundException{
//		
//		return service.deleteSellerById(sellerId);
//		}
//	
//     
//	@GetMapping("/getbyId/{sellerId}")
//	public SellerDTO getSellerById(@PathVariable int sellerId) throws SellerNotFoundException{
//		try {
//		return service.getSellerById(sellerId);
//	}
//	catch(NullPointerException exc) {
//		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Sorry, seller does not exist",exc);
//	}
//	}
//	
//	@GetMapping("/getall")
//    public List<Seller> getAllSeller(){
//		return service.getAllSeller();
//	}
	
	
	
	@GetMapping("/getAllOrder")
	public List<Order> getAllOrder(){
		return service.getAllOrder();
	}
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory(){
		return service.getAllCategory();
	}
	
	@GetMapping("/getAllSubCategory")
	public List<SubCategory> getAllSubCategory(){
		return service.getAllSubCategory();
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody ProductDTO productdto) {
		return service.addProduct(productdto);
	}
	
	@PostMapping("/updateProduct")
	public Product updateProduct(@RequestBody ProductDTO productdto) throws ProductNotFoundException {
		return service.updateProduct(productdto);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) throws ProductNotFoundException {
		return service.deleteProduct(id);
	}
	
	@GetMapping("/getProductByName/{name}")
	public Product getProductbyName(@PathVariable String name) throws ProductNotFoundException {
		return service.getProductbyName(name);
	}
	
	@GetMapping("/getProductByID/{id}")
	public ProductDTO getProductById(@PathVariable int id) throws ProductNotFoundException {
		return service.getProductById(id);
	}


}
