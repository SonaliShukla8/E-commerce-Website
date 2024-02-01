package com.hexaware.ecommerce.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
	@Id
	 private int paymentId;        // Primary Key
	
	@OneToOne(mappedBy="payment",cascade=CascadeType.ALL)
    private Order order;
	
	private LocalDateTime paymentDate;
	private double amount;
	private String paymentMethod;
	private String paymentStatus;
}
