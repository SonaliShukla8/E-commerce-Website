package com.hexaware.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.exception.CustomerNotFoundException;
import com.hexaware.ecommerce.repository.CustomerRepository;
@Service
public class CustomerServiceImp implements ICustomerService {
    @Autowired
	CustomerRepository repo;
    
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);
	
	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		logger.info("Adding new Customer");
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setEmail(customerDTO.getEmail());
		customer.setFullName(customerDTO.getFullName());
		customer.setGender(customerDTO.getGender());
		customer.setContactNumber(customerDTO.getContactNumber());
		customer.setAddresses(customerDTO.getAddresses());
		customer.setOrder(customerDTO.getOrder());
		customer.setCart(customerDTO.getCart());
		return repo.save(customer);
	}

	@Override
	public Customer updateCustomer(CustomerDTO customerDTO) throws CustomerNotFoundException {
		Customer customer = repo.findById(customerDTO.getCustomerId()).orElse(null);
		if(customer == null) {
			throw new CustomerNotFoundException ("Customer with ID " +customerDTO.getCustomerId()+ "not found.");
		}
		
		logger.info("Updating the customer");
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setEmail(customerDTO.getEmail());
		customer.setFullName(customerDTO.getFullName());
		customer.setGender(customerDTO.getGender());
		customer.setContactNumber(customerDTO.getContactNumber());
		customer.setAddresses(customerDTO.getAddresses());
		customer.setOrder(customerDTO.getOrder());
		customer.setCart(customerDTO.getCart());
		return repo.save(customer);
	}

	@Override
	public String deleteCustomerById(int customerId) throws CustomerNotFoundException {
		Customer customer = repo.findById(customerId).orElse(null);
		if(customer == null) {
			throw new CustomerNotFoundException ("Customer with ID " +customerId+ "not found.");
		}
		
		logger.info("Deleting the customer with customerId "+customerId);
		repo.deleteById(customerId);
		return "Customer with customerId "+customerId+" deleted.";
	}

	@Override
	public CustomerDTO getCustomerById(int customerId) throws CustomerNotFoundException {
		
		Customer customer = repo.findById(customerId).orElse(null);
		if(customer == null) {
			throw new CustomerNotFoundException ("Customer with ID " +customerId+ "not found.");
		}
		
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerId(customer.getCustomerId());
		dto.setEmail(customer.getEmail());
		dto.setFullName(customer.getFullName());
		dto.setGender(customer.getGender());
		dto.setContactNumber(customer.getContactNumber());
		dto.setAddresses(customer.getAddresses());
		dto.setOrder(customer.getOrder());
		dto.setCart(customer.getCart());
		
		return dto;
	}

	@Override
	public List<Customer> getAllCustomer() {
		logger.info("Fetching all Customers...");

		return repo.findAll();
	}

}
