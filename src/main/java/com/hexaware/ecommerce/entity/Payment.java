package com.hexaware.ecommerce.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

@Entity
public class Payment {
	@Id
	 private int paymentId;        // Primary Key
	
	@OneToOne(mappedBy="payment",cascade=CascadeType.ALL)
    private Order order;
	 @PastOrPresent
	private LocalDateTime paymentDate;
	 @Positive
	private double amount;
	@NotBlank
	private String paymentMethod;
	@NotBlank
	private String paymentStatus;
}
