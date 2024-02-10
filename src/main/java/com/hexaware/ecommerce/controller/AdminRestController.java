package com.hexaware.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.ecommerce.dto.PaymentDTO;
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

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	@Autowired
	IAdminService service;
	@GetMapping("/viewAllProduct")
	public List<Product> viewAllProducts() {
		return service.viewAllProducts();
	}
	
	@GetMapping("/viewAllCategory")
	public List<Category> viewAllCategory(){
		return service.viewAllCategory();
	}

	@GetMapping("/viewAllSubCategory")
	public List<SubCategory> viewAllSubCategory(){
		return service.viewAllSubCategory();
	}
	
	@GetMapping("/viewAllSeller")
	public List<Seller> viewAllSeller(){
		return service.viewAllSeller();
	}
	
	@GetMapping("/viewAllCustomer")
	public List<Customer> viewAllCustomer(){
		return service.viewAllCustomer();
	}
	
	@GetMapping("/viewAllPayment")
	public List<Payment> viewAllPayment(){
		return service.viewAllPayment();
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) throws ProductNotFoundException {
		return service.deleteProduct(id);
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id) throws CategoryNotFoundException {
		return service.deleteCategory(id);
	}
	
	@DeleteMapping("/deleteSubCategory/{id}")
	public String deleteSubCategory(@PathVariable int id) throws SubCategoryNotFoundException {
		return service.deleteSubCategory(id);
	}
	

	 @DeleteMapping("/deleteSeller/{id}")
	    public  String deleteSeller(@PathVariable int id) throws SellerNotFoundException {
	                return service.deleteSeller(id);
	        }
	    
	        @DeleteMapping("/deleteCustomer/{id}")
	    public String deleteCustomer(@PathVariable int id) throws CustomerNotFoundException {
	                return service.deleteCustomer(id);
	            
	    }

	
	@GetMapping("/viewAllOrder")
	public List<Order> viewAllOrders() {
		return service.viewAllOrder();
	}
	
	@PostMapping("/addAdmin")
	public Admin registerNewqAdmin(Admin admin) {
		return service.registerAdmin(admin);
	}
	
	
     @PostMapping("/addPayment")
      public Payment addPayment(@RequestBody PaymentDTO payment) {
	   return service.addPayment(payment);
}
}