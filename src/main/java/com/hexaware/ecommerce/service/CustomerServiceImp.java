package com.hexaware.ecommerce.service;

import java.util.Collections;
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

import com.hexaware.ecommerce.exception.CustomerNotFoundException;
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
		customer.setPassword(customerDTO.getPassword());
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
		customer.setPassword(customerDTO.getPassword());
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
		dto.setPassword(customer.getPassword());
		
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
     @Override
     public SubCategory getSubCategoryByName(String name) {
             return subcategoryService.getSubCategoryByName(name);
     }
     
     public String addProductToCustomerCart(int customerId, int productId, int quantity) throws ProductNotFoundException {
      
    	 Customer customer = repo.findById(customerId).orElse(null);
          
             Cart cart = customer.getCart();
             if (cart == null) {
        
                 cart = new Cart();
                 cart.setCustomer(customer);
                 customer.setCart(cart);
             }
             
             
             ProductDTO productDTO = productService.getProductById(productId);
                 Product product = productService.updateProduct(productDTO);
        
                 if (product.getStockQuantity() >= quantity) {
                     CartItem existingCartItem = cart.getCartItems().stream()
                                                 .filter(item -> item.getProductId().equals(product))
                                                 .findFirst().orElse(null);
                     if (existingCartItem != null) {
                         existingCartItem.setItemQuantity(existingCartItem.getItemQuantity() + quantity);
                     } else {
                         // Create a new cart item
                         CartItem cartItem = new CartItem();
                         cartItem.setCart(cart);
                         cartItem.setProductId(product);
                         cartItem.setItemQuantity(quantity);
                         cart.getCartItems().add(cartItem);
                     }
                     
//                     int updatedStockQuantity = productDTO.getStockQuantity() - quantity;
//                     productDTO.setStockQuantity(updatedStockQuantity);
//                     productService.updateProduct(productDTO);
                     
                     double totalPrice = cart.getCartItems().stream()
                                             .mapToDouble(item -> item.getItemQuantity() * item.getProductId().getPrice())
                                             .sum();
                     cart.setTotalPrice(totalPrice);
                     repo.save(customer);
                 } 
             
		return "Added to the cart."; 
          
     }
             
    
         
     @Override
     public List<CartItem> viewCartitems(int customerId) {
    	 
    	 Customer customer = repo.findById(customerId).orElse(null);
    	 Cart cart = customer.getCart();
         if (cart != null) {
             return cart.getCartItems();
         }
             return Collections.emptyList();
     }
     @Override
     public String placeOrder(Order order) {
             // TODO Auto-generated method stub
             return null;
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

	@Override
	public SubCategory getSubCategoryByName(String name) {
		return subcategoryService.getSubCategoryByName(name);
	}

	@Override
	public String addToCart(Product product) {
		
		return null;
	}


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

}
