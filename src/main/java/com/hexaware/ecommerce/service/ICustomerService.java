package com.hexaware.ecommerce.service;

import java.util.List;


import com.hexaware.ecommerce.entity.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public String deleteCustomerById(int customerId);
    public Customer getCustomerById(int customerId);
    public List<Customer> getAllCustomer();
}
