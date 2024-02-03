package com.hexaware.ecommerce.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="OrderTable")
public class Order {
	@Id
	private int orderId;        // Primary Key
	
	   @OneToOne(cascade=CascadeType.ALL,mappedBy="order")
	    private Customer customer;
	   @NotNull
	    private LocalDate orderDate;
	   @Positive
	    private double totalAmount;
	   @NotBlank
	    private String status;
	   @NotBlank
	    private String statusDescription;
	    @FutureOrPresent
	    private LocalDate deliveryDate;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="payment_id")
	    private Payment payment;
}
