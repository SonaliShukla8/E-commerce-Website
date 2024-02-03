package com.hexaware.ecommerce.dto;

import java.time.LocalDate;

import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.entity.Payment;

public class OrderDTO {
	
	private int orderId; 
	 private CustomerDTO customer;
	    private LocalDate orderDate;
	    private double totalAmount;
	    private String status;
	    private String statusDescription;
	    private PaymentDTO payment;
	    private LocalDate deliveryDate;

}
