package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.repository.CustomerRepository;
@Service
public class CustomerServiceImp implements ICustomerService {
    @Autowired
	CustomerRepository repo;
	
	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setEmail(customerDTO.getEmail());
		customer.setFullName(customerDTO.getFullName());
		customer.setGender(customerDTO.getGender());
		customer.setContactNumber(customerDTO.getContactNumber());
		customer.setAddresses(customerDTO.getAddresses());
		customer.setUser(customerDTO.getUser());
		customer.setOrder(customerDTO.getOrder());
		customer.setCart(customerDTO.getCart());
		return repo.save(customer);
	}

	@Override
	public Customer updateCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setEmail(customerDTO.getEmail());
		customer.setFullName(customerDTO.getFullName());
		customer.setGender(customerDTO.getGender());
		customer.setContactNumber(customerDTO.getContactNumber());
		customer.setAddresses(customerDTO.getAddresses());
		customer.setUser(customerDTO.getUser());
		customer.setOrder(customerDTO.getOrder());
		customer.setCart(customerDTO.getCart());
		return repo.save(customer);
	}

	@Override
	public String deleteCustomerById(int customerId) {
		
		repo.deleteById(customerId);
		return "Customer with customerId "+customerId+" deleted.";
	}

	@Override
	public CustomerDTO getCustomerById(int customerId) {
		
		Customer customer = repo.findById(customerId).orElse(null);
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerId(customer.getCustomerId());
		dto.setEmail(customer.getEmail());
		dto.setFullName(customer.getFullName());
		dto.setGender(customer.getGender());
		dto.setContactNumber(customer.getContactNumber());
		dto.setAddresses(customer.getAddresses());
		dto.setUser(customer.getUser());
		dto.setOrder(customer.getOrder());
		dto.setCart(customer.getCart());
		
		return dto;
	}

	@Override
	public List<Customer> getAllCustomer() {

		return repo.findAll();
	}

}
