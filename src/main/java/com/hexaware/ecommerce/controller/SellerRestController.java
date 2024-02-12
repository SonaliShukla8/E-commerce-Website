package com.hexaware.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexaware.ecommerce.dto.AuthRequest;
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
import com.hexaware.ecommerce.service.JwtService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/seller")
public class SellerRestController {
	
	 private static final Logger log = LoggerFactory.getLogger(AdminRestController.class);
	@Autowired
	ISellerService service;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/login/authenticate")
	public String  authenticateAndGetTokent(@RequestBody  AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		String token = null;
		if(authentication.isAuthenticated()) {
				  // call generate token method from jwtService class	
			     token=jwtService.generateToken(authRequest.getUsername());		
			
			log.info("Tokent : "+token);
			  }
				else{
					
					log.info("invalid");
			
					 throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");	
				}
				return token;	 
	 }
	
	@PostMapping("/register")
	public String registerSeller(@RequestBody @Valid SellerDTO sellerDTO) {
		return service.registerSeller(sellerDTO);
	}
	

	@PutMapping("/update")
	@PreAuthorize("hasAuthority('seller')")
    public Seller updateSeller(@RequestBody @Valid  SellerDTO sellerDTO) throws SellerNotFoundException{

		return service.updateSeller(sellerDTO);
	}

	@GetMapping("/getAllOrder")
	@PreAuthorize("hasAuthority('seller')")
	public List<Order> getAllOrder(){
		return service.getAllOrder();
	}
	
	@GetMapping("/getAllProduct")
	@PreAuthorize("hasAuthority('seller')")
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	
	@GetMapping("/getAllCategory")
	@PreAuthorize("hasAuthority('seller')")
	public List<Category> getAllCategory(){
		return service.getAllCategory();
	}
	
	@GetMapping("/getAllSubCategory")
	@PreAuthorize("hasAuthority('seller')")
	public List<SubCategory> getAllSubCategory(){
		return service.getAllSubCategory();
	}
	
	@PostMapping("/addProduct")
	@PreAuthorize("hasAuthority('seller')")
	public Product addProduct(@RequestBody ProductDTO productdto) {
		return service.addProduct(productdto);
	}
	
	@PostMapping("/updateProduct")
	@PreAuthorize("hasAuthority('seller')")
	public Product updateProduct(@RequestBody ProductDTO productdto) throws ProductNotFoundException {
		return service.updateProduct(productdto);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	@PreAuthorize("hasAuthority('seller')")
	public String deleteProduct(@PathVariable int id) throws ProductNotFoundException {
		return service.deleteProduct(id);
	}
	
	@GetMapping("/getProductByName/{name}")
	@PreAuthorize("hasAuthority('seller')")
	public Product getProductbyName(@PathVariable String name) throws ProductNotFoundException {
		return service.getProductbyName(name);
	}
	
	@GetMapping("/getProductByID/{id}")
	@PreAuthorize("hasAuthority('seller')")
	public ProductDTO getProductById(@PathVariable int id) throws ProductNotFoundException {
		return service.getProductById(id);
	}
	@GetMapping("/markProductOutOfStock/{sellerId}/{productId}")
	public ProductDTO markProductOutOfStock(@PathVariable int sellerId,@PathVariable int productId) throws ProductNotFoundException{
		return service.markProductOutOfStock(sellerId, productId);
	}


}
