package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entity.Customer;

public interface ICustomerService {
	public Customer addCustomer(CustomerDTO customerDTO);
    public Customer updateCustomer(CustomerDTO customerDTO);
    public String deleteCustomerById(int customerId);
    public CustomerDTO getCustomerById(int customerId);
    public List<Customer> getAllCustomer();
}
