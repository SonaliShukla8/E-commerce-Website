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
import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entity.CartItem;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.SubCategory;
import com.hexaware.ecommerce.exception.CustomerNotFoundException;
import com.hexaware.ecommerce.exception.OrderNotFoundException;
import com.hexaware.ecommerce.exception.ProductNotFoundException;
import com.hexaware.ecommerce.service.ICustomerService;
import com.hexaware.ecommerce.service.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
	private static final Logger log = LoggerFactory.getLogger(CustomerRestController.class);
	@Autowired
	ICustomerService service;
	
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
	public String registerCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		return service.registerCustomer(customerDTO);
	}
	
	@PostMapping("/addProductToCustomerCart/{customerId}/{productId}/{quantity}")
	@PreAuthorize("hasAuthority('customer')")
	public String addProductToCustomerCart(@PathVariable int customerId,@PathVariable int productId,@PathVariable int quantity) throws ProductNotFoundException{
		return service.addProductToCustomerCart(customerId, productId, quantity);
	}
	
	@PostMapping("/ placeOrder/{customerId}")
	@PreAuthorize("hasAuthority('customer')")
	public String placeOrder(@PathVariable int customerId) throws OrderNotFoundException, ProductNotFoundException{
		return service.placeOrder(customerId);
	}
	
    @GetMapping("/viewAllProduct")
    @PreAuthorize("hasAuthority('customer')")
    public List<Product> getAllProduct(){
    	return service.getAllProduct();
    }
    
    @GetMapping("/viewAllCategory")
    @PreAuthorize("hasAuthority('customer')")
    public List<Category> getAllCategory(){
    	return service.getAllCategory();
    }
    
    @GetMapping("/viewAllSubCategory")
    @PreAuthorize("hasAuthority('customer')")
    public List<SubCategory> getAllSubCategory(){
    	return service.getAllSubCategory();
    }
    
    @GetMapping("/viewProductByName/{name}")
    @PreAuthorize("hasAuthority('customer')")
    public Product getProductByName(@PathVariable String name) {
    	return service.getProductByName(name);
    }
    
    
    @GetMapping("/viewCategoryByName/{name}")
    @PreAuthorize("hasAuthority('customer')")
    public Category getCategorybyName(@PathVariable String name) {
    	return service.getCategorybyName(name);
    }
    
    @GetMapping("/viewSubCategoryByName/{name}")
    @PreAuthorize("hasAuthority('customer')")
    public SubCategory getSubCategoryByName(@PathVariable String name) {
    	return service.getSubCategoryByName(name);
    }
    @GetMapping("/viewCartitems/{customerId}")
    @PreAuthorize("hasAuthority('customer')")
    public List<CartItem> viewCartitems(@PathVariable int customerId){
    	return service.viewCartitems(customerId);
    }

    @GetMapping("/viewProductByBrand/{brand}")
    @PreAuthorize("hasAuthority('customer')")
    public List<Product> getProductsByBrand(@PathVariable String brand){
    	return service.getProductsByBrand(brand);
    }
    
    @GetMapping("/viewProductByPriceRange/{min}/{max}")
    @PreAuthorize("hasAuthority('customer')")
    public List<Product> getProductsByPriceRange(@PathVariable double min,@PathVariable double max){
    	return service.getProductsByPriceRange(min, max);
    }

}
