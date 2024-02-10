package com.hexaware.ecommerce.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity

@Table(name="orderTable")

public class Order {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;        // Primary Key
	
	@ManyToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="customerId")
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
	    
	    @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="payment_id")
	    private Payment payment;

	    @ManyToMany
	    @JoinTable(
	        name = "order_seller",
	        joinColumns = @JoinColumn(name = "order_id"),
	        inverseJoinColumns = @JoinColumn(name = "seller_id")
	    )
	    private List<Seller> sellers = new ArrayList<>();

		public Order() {
			super();

		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public LocalDate getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getStatusDescription() {
			return statusDescription;
		}

		public void setStatusDescription(String statusDescription) {
			this.statusDescription = statusDescription;
		}

		public LocalDate getDeliveryDate() {
			return deliveryDate;
		}

		public void setDeliveryDate(LocalDate deliveryDate) {
			this.deliveryDate = deliveryDate;
		}

		public Payment getPayment() {
			return payment;
		}

		public void setPayment(Payment payment) {
			this.payment = payment;
		}

		public List<Seller> getSellers() {
			return sellers;
		}

		public void setSellers(List<Seller> sellers) {
			this.sellers = sellers;
		}

		@Override
		public String toString() {
			return "Order [orderId=" + orderId + ", customer=" + customer + ", orderDate=" + orderDate
					+ ", totalAmount=" + totalAmount + ", status=" + status + ", statusDescription=" + statusDescription
					+ ", deliveryDate=" + deliveryDate + ", payment=" + payment + ", sellers=" + sellers + "]";
		}

		public Order(int orderId, Customer customer, @NotNull LocalDate orderDate, @Positive double totalAmount,
				@NotBlank String status, @NotBlank String statusDescription, @FutureOrPresent LocalDate deliveryDate,
				Payment payment, List<Seller> sellers) {
			super();
			this.orderId = orderId;
			this.customer = customer;
			this.orderDate = orderDate;
			this.totalAmount = totalAmount;
			this.status = status;
			this.statusDescription = statusDescription;
			this.deliveryDate = deliveryDate;
			this.payment = payment;
			this.sellers = sellers;
		}

		


		
}
