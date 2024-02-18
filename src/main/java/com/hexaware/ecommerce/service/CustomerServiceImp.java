package com.hexaware.ecommerce.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hexaware.ecommerce.dto.CustomerDTO;
import com.hexaware.ecommerce.dto.OrderDTO;
import com.hexaware.ecommerce.dto.PaymentDTO;
import com.hexaware.ecommerce.dto.ProductDTO;
import com.hexaware.ecommerce.entity.Cart;

import com.hexaware.ecommerce.entity.CartItem;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.Payment;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.entity.SubCategory;

import com.hexaware.ecommerce.exception.CustomerNotFoundException;
import com.hexaware.ecommerce.exception.OrderNotFoundException;
import com.hexaware.ecommerce.exception.ProductNotFoundException;
import com.hexaware.ecommerce.repository.CartRepository;
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
    IOrderService orderService;
    @Autowired
    IPaymentService paymentService;
    @Autowired
    ICartService cartService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CartRepository cartRepository;
    
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
		customer.setAddress(customerDTO.getAddress());
//		customer.setOrder(customerDTO.getOrder());
//		customer.setCart(customerDTO.getCart());
		customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
		customer.setRole(customerDTO.getRole());
		customer.setUsername(customerDTO.getUsername());
		Cart cart=new Cart();
		cart.setCartId(customerDTO.getCustomerId());
		cart.setTotalPrice(0);
		cartRepository.save(cart);
		customer.setCart(cart);
		
		

		 repo.save(customer);
		 return "New customer Registered";
	}

	@Override
	public Customer updateCustomer(CustomerDTO customerDTO)throws CustomerNotFoundException  {
		logger.info("Updating the customer");
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setEmail(customerDTO.getEmail());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setGender(customerDTO.getGender());
		customer.setContactNumber(customerDTO.getContactNumber());
		customer.setAddress(customerDTO.getAddress());
//		customer.setOrder(customerDTO.getOrder());

		customer.setCart(customerDTO.getCart());
		customer.setPassword(customerDTO.getPassword());
		customer.setRole(customerDTO.getRole());
		customer.setUsername(customerDTO.getUsername());
		return repo.save(customer);
	}

	@Override
	public String deleteCustomerById(int customerId) throws CustomerNotFoundException {
		logger.info("Deleting the customer with customerId "+customerId);
		repo.deleteById(customerId);
		return "Customer with customerId "+customerId+" deleted.";
	}

	@Override
	public CustomerDTO getCustomerById(int customerId) throws CustomerNotFoundException {
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
		dto.setAddress(customer.getAddress());
//		dto.setOrder(customer.getOrder());
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
             return categoryService.getCategorybyName(name);
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
                                                 .filter(item -> item.getProduct().equals(product))
                                                 .findFirst().orElse(null);
                     if (existingCartItem != null) {
                    	 if (quantity < existingCartItem.getItemQuantity()) {
                             existingCartItem.setItemQuantity(quantity);
                         }else {
                         existingCartItem.setItemQuantity(existingCartItem.getItemQuantity() + quantity);}
                     } else {
                         // Create a new cart item
                         CartItem cartItem = new CartItem();
                         cartItem.setCart(cart);
                         cartItem.setProduct(product);
                         cartItem.setItemQuantity(quantity);
                         cart.getCartItems().add(cartItem);
                     }
                     double totalPrice = cart.getCartItems().stream()
                                             .mapToDouble(item -> item.getItemQuantity() * item.getProduct().getPrice())
                                             .sum();
                     cart.setTotalPrice(totalPrice);
                     repo.save(customer);
                     return "Added to the cart."; 
                 } 
             
		return "Maximum "+product.getStockQuantity()+"products can be added"; 
          
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
	public List<Product> getProductsByBrand(String brand){
		return productService.getByBrand(brand);
	}

	@Override
	public List<Product> getProductsByPriceRange(double min, double max) {
		
		return productService.getByPriceRange(min, max);
	}

	@Override
	public String placeOrder(int customerId,String paymentMethod) throws OrderNotFoundException, ProductNotFoundException {
		
		 Customer customer = repo.findById(customerId).orElse(null);
		 if (customer == null) {
	            return "Customer not found";
	        }
		 Cart cart = customer.getCart();
	        if (cart == null || cart.getCartItems().isEmpty()) {
	            return "Cart is empty";
	        }
	        Order order = new Order();
	        order.setCustomer(customer);
	        order.setOrderDate(LocalDate.now());
	        order.setDeliveryDate(LocalDate.now().plusDays(7));
	        double totalAmount = cart.getTotalPrice();
	        order.setTotalAmount(totalAmount);
	        order.setStatus("Pending");
	        order.setStatusDescription("Payment Not Yet Processed...");
	        
	        
	        Payment payment = new Payment();
	        payment.setAmount(totalAmount);
	        payment.setPaymentDate(LocalDateTime.now());
	        payment.setPaymentMethod(paymentMethod);
	        payment.setPaymentStatus("Paid"); 
	       // order.setPayment(payment);
	        payment.setOrder(order);
	        PaymentDTO paymentDTO = new PaymentDTO();
	        paymentDTO.setPaymentId(payment.getPaymentId());
	        paymentDTO.setAmount(payment.getAmount());
	        
	        paymentDTO.setOrder(order);
	        paymentDTO.setPaymentDate(payment.getPaymentDate());
	        paymentDTO.setPaymentMethod(payment.getPaymentMethod());
	        paymentDTO.setPaymentStatus(payment.getPaymentStatus());
	        paymentService.updatePayment(paymentDTO);
	        
	        
	        for (CartItem cartItem : cart.getCartItems()) {
	            Product product = cartItem.getProduct();
	            int productID = cartItem.getProduct().getProductId();
	            int orderedQuantity = cartItem.getItemQuantity();
	            int currentStock = product.getStockQuantity();
	            if (currentStock >= orderedQuantity) {
	                product.setStockQuantity(currentStock - orderedQuantity);
	            } else {
	                return "Insufficient stock for product: " + product.getProductName();
	            }
	            ProductDTO productDTO = new ProductDTO();
	            productDTO = productService.getProductById(productID);
	            productService.updateProduct(productDTO);
	        }
	        List<Seller> sellers = new ArrayList<>();
	        for (CartItem cartItem : cart.getCartItems()) {
	            Seller seller = cartItem.getProduct().getSeller();
	            if (!sellers.contains(seller)) {
	                sellers.add(seller);
	            }
	        }
	        order.setSellers(sellers);
	        if(order.getPayment() == null) {
			    order.setPayment(payment);
			}
	        
	        OrderDTO orderDTO=new OrderDTO();
			orderDTO.setOrderId(order.getOrderId());
			orderDTO.setSellers(order.getSellers());
			orderDTO.setTotalAmount(order.getTotalAmount());
			orderDTO.setCustomer(order.getCustomer());
			orderDTO.setOrderDate(order.getOrderDate());
			orderDTO.setDeliveryDate(order.getDeliveryDate());
			
			orderDTO.setPayment(order.getPayment());
	        orderDTO.setStatus("Payment Done.");
	        orderDTO.setStatusDescription("Payment done via "+payment.getPaymentMethod()+" is successful.");
	        orderService.updateOrder(orderDTO);
	        int cartdelete = customer.getCart().getCartId();
	        customer.setCart(null);
	        repo.save(customer);
	        
	        for (CartItem cartItem : cart.getCartItems()) {
	        	
	        	cartitemService.deleteCartItemById(cartItem.getCartitemId());
	        }
	        cartService.deleteCartById(cartdelete);

	        cart.getCartItems().clear();
	        return "Order placed successfully";
		
		
	}


}
