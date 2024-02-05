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

import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
	
	@Autowired
	ICustomerService service;
	
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		return service.addCustomer(customerDTO);
	}
	
	@PutMapping("/update")
    public Customer updateCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
    	return service.updateCustomer(customerDTO);
    }
    
	@DeleteMapping("/delete/{customerId}")
    public String deleteCustomerById(@PathVariable int customerId) {	
	
			
    	return service.deleteCustomerById(customerId);

    }
    
	@GetMapping("/getbyId/{customerId}")
    public CustomerDTO getCustomerById(@PathVariable int customerId) {
		try {
    	return service.getCustomerById(customerId);
	}
	catch(NullPointerException exc) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Sorry, customer does not exist",exc);
	}
    }
    
	@GetMapping("/getall")
    public List<Customer> getAllCustomer(){
    	return service.getAllCustomer();
    }

}
