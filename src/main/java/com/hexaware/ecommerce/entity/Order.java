package com.hexaware.ecommerce.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Order {
	@Id
	private int orderId;        // Primary Key
	
	   @OneToOne(cascade=CascadeType.ALL,mappedBy="order")
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
