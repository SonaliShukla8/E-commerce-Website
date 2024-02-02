package com.hexaware.ecommerce.dto;

import java.time.LocalDateTime;

import com.hexaware.ecommerce.entity.Order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class PaymentDTO {
	
	 private int paymentId;  
	 private Order order;
	
	private LocalDateTime paymentDate;
	private double amount;
	private String paymentMethod;
	private String paymentStatus;

}
