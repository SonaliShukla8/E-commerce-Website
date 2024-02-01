package com.hexaware.ecommerce.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


public class Order {
	@Id
	private int orderId;        // Primary Key
	
	   @ManyToOne(cascade=CascadeType.ALL)
        @JoinColumn(name = "customerId")
	    private Customer customer;
	    private LocalDate orderDate;
	    private double totalAmount;
	    private String status;
	    private String statusDescription;

	    private LocalDate deliveryDate;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="payment_id")
	    private Payment payment;
}
