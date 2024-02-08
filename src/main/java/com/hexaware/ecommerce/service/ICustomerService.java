package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.exception.CustomerNotFoundException;

public interface ICustomerService {
	public Customer addCustomer(CustomerDTO customerDTO);
    public Customer updateCustomer(CustomerDTO customerDTO) throws CustomerNotFoundException ;
    public String deleteCustomerById(int customerId) throws CustomerNotFoundException ;
    public CustomerDTO getCustomerById(int customerId)throws CustomerNotFoundException ;
    public List<Customer> getAllCustomer();
}
