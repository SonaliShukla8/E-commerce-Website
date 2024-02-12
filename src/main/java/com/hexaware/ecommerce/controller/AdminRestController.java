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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.AdminDTO;
import com.hexaware.ecommerce.dto.AuthRequest;
import com.hexaware.ecommerce.dto.CategoryDTO;
import com.hexaware.ecommerce.dto.PaymentDTO;
import com.hexaware.ecommerce.dto.SubCategoryDTO;
import com.hexaware.ecommerce.entity.Admin;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.Payment;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.entity.SubCategory;
import com.hexaware.ecommerce.exception.CategoryNotFoundException;
import com.hexaware.ecommerce.exception.CustomerNotFoundException;
import com.hexaware.ecommerce.exception.ProductNotFoundException;
import com.hexaware.ecommerce.exception.SellerNotFoundException;
import com.hexaware.ecommerce.exception.SubCategoryNotFoundException;
import com.hexaware.ecommerce.service.IAdminService;
import com.hexaware.ecommerce.service.JwtService;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	 private static final Logger log = LoggerFactory.getLogger(AdminRestController.class);
	
	@Autowired
	IAdminService service;
	
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
	@PostMapping("/addAdmin")
	@PreAuthorize("hasAuthority('admin')")
	public String addAdmin(@RequestBody AdminDTO admindto) {
		return service.addAdmin(admindto);
	}
	
	
	@GetMapping("/viewAllProduct")
	@PreAuthorize("hasAuthority('admin')")
	public List<Product> viewAllProducts() {
		return service.viewAllProducts();
	}
	
	@GetMapping("/viewAllCategory")
	@PreAuthorize("hasAuthority('admin')")
	public List<Category> viewAllCategory(){
		return service.viewAllCategory();
	}

	@GetMapping("/viewAllSubCategory")
	@PreAuthorize("hasAuthority('admin')")
	public List<SubCategory> viewAllSubCategory(){
		return service.viewAllSubCategory();
	}
	
	@GetMapping("/viewAllSeller")
	@PreAuthorize("hasAuthority('admin')")
	public List<Seller> viewAllSeller(){
		return service.viewAllSeller();
	}
	
	@GetMapping("/viewAllCustomer")
	@PreAuthorize("hasAuthority('admin')")
	public List<Customer> viewAllCustomer(){
		return service.viewAllCustomer();
	}
	
	@GetMapping("/viewAllPayment")
	@PreAuthorize("hasAuthority('admin')")
	public List<Payment> viewAllPayment(){
		return service.viewAllPayment();
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	@PreAuthorize("hasAuthority('admin')")
	public String deleteProduct(@PathVariable int id) throws ProductNotFoundException {
		return service.deleteProduct(id);
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	@PreAuthorize("hasAuthority('admin')")
	public String deleteCategory(@PathVariable int id) throws CategoryNotFoundException {
		return service.deleteCategory(id);
	}
	
	@DeleteMapping("/deleteSubCategory/{id}")
	@PreAuthorize("hasAuthority('admin')")
	public String deleteSubCategory(@PathVariable int id) throws SubCategoryNotFoundException {
		return service.deleteSubCategory(id);
	}
	

	 @DeleteMapping("/deleteSeller/{id}")
	 @PreAuthorize("hasAuthority('admin')")
	    public  String deleteSeller(@PathVariable int id) throws SellerNotFoundException {
	                return service.deleteSeller(id);
	        }
	    
	        @DeleteMapping("/deleteCustomer/{id}")
	    public String deleteCustomer(@PathVariable int id) throws CustomerNotFoundException {
	                return service.deleteCustomer(id);
	            
	    }

	
	@GetMapping("/viewAllOrder")
	@PreAuthorize("hasAuthority('admin')")
	public List<Order> viewAllOrders() {
		return service.viewAllOrder();
	}
	
	@PostMapping("/addCategory")
	@PreAuthorize("hasAuthority('admin')")
	public Category addCategory(@RequestBody CategoryDTO categorydto) {
		return service.addCategory(categorydto);
	}
	
	
	@PostMapping("/addSubCategory")
	@PreAuthorize("hasAuthority('admin')")
	public SubCategory addSubCategory(@RequestBody SubCategoryDTO subcategorydto) {
		return service.addSubCategory(subcategorydto);
	}
	
	
	
}