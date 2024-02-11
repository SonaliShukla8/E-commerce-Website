package com.hexaware.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.entity.CartItem;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.SubCategory;
import com.hexaware.ecommerce.exception.ProductNotFoundException;
import com.hexaware.ecommerce.repository.CustomerRepository;
@Service
public class CustomerServiceImp implements ICustomerService {
    @Autowired
	CustomerRepository repo;
    @Autowired
    IProductService productService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    ISubCategoryService subcategoryService;
    @Autowired
    ICartItemService cartitemService;
    
    
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);
	
	@Override
	public String registerCustomer(CustomerDTO customerDTO) {
		logger.info("Adding new Customer");
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setEmail(customerDTO.getEmail());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setGender(customerDTO.getGender());
		customer.setContactNumber(customerDTO.getContactNumber());
		customer.setAddresses(customerDTO.getAddresses());
		customer.setOrder(customerDTO.getOrder());
		customer.setCart(customerDTO.getCart());
		customer.setPassword(customerDTO.getPassword());
		customer.setRole(customerDTO.getRole());
		customer.setUsername(customerDTO.getUsername());
		 repo.save(customer);
		 return "New customer Registered";
	}

	@Override
	public Customer updateCustomer(CustomerDTO customerDTO) {
		logger.info("Updating the customer");
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setEmail(customerDTO.getEmail());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setGender(customerDTO.getGender());
		customer.setContactNumber(customerDTO.getContactNumber());
		customer.setAddresses(customerDTO.getAddresses());
		customer.setOrder(customerDTO.getOrder());
		customer.setCart(customerDTO.getCart());
		customer.setPassword(customerDTO.getPassword());
		customer.setRole(customerDTO.getRole());
		customer.setUsername(customerDTO.getUsername());
		return repo.save(customer);
	}

	@Override
	public String deleteCustomerById(int customerId) {
		logger.info("Deleting the customer with customerId "+customerId);
		repo.deleteById(customerId);
		return "Customer with customerId "+customerId+" deleted.";
	}

	@Override
	public CustomerDTO getCustomerById(int customerId) {
		
		Customer customer = repo.findById(customerId).orElse(null);
		if(customer == null) {
			logger.warn("Customer with ID " +customerId+ "not found.");
		}
		
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerId(customer.getCustomerId());
		dto.setEmail(customer.getEmail());
		dto.setUsername(customer.getUsername());
		dto.setGender(customer.getGender());
		dto.setContactNumber(customer.getContactNumber());
		dto.setAddresses(customer.getAddresses());
		dto.setOrder(customer.getOrder());
		dto.setCart(customer.getCart());
		dto.setPassword(customer.getPassword());
		dto.setRole(customer.getRole());
		dto.setCustomerName(customer.getCustomerName());
		return dto;
	}

	@Override
	public List<Customer> getAllCustomer() {
		logger.info("Fetching all Customers...");

		return repo.findAll();
	}

	@Override
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}

	@Override
	public List<SubCategory> getAllSubCategory() {
		return subcategoryService.getAllSubCategory();
	}

	@Override
	public Product getProductByName(String name) {
		return productService.getByName(name);
	}

	@Override
	public Category getCategorybyName(String name) {
		return categoryService.getbyName(name);
	}

//	@Override
//	public SubCategory getSubCategoryByName(String name) {
//		return subcategoryService.getSubCategoryByName(name);
//	}
//
//	@Override
//	public String addToCart(Product product) {
//		
//		return null;
//	}


	@Override
	public List<CartItem> viewCartitems(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String placeOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addProductToCustomerCart(int customerId, int productId, int quantity)
			throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategory getSubCategoryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
