package com.hexaware.ecommerce.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	private int orderId;        // Primary Key
	
	 @ManyToMany(mappedBy="order" ,fetch = FetchType.LAZY)
	    private List<Customer> customer  = new ArrayList<Customer>();
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

	    @ManyToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="sellerId")
	    private Seller seller;

		public Order() {
			super();

		}

		public Order(int orderId, List<Customer> customer, @NotNull LocalDate orderDate, @Positive double totalAmount,
				@NotBlank String status, @NotBlank String statusDescription, @FutureOrPresent LocalDate deliveryDate,
				Payment payment, Seller seller) {
			super();
			this.orderId = orderId;
			this.customer = customer;
			this.orderDate = orderDate;
			this.totalAmount = totalAmount;
			this.status = status;
			this.statusDescription = statusDescription;
			this.deliveryDate = deliveryDate;
			this.payment = payment;
			this.seller = seller;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public List<Customer> getCustomer() {
			return customer;
		}

		public void setCustomer(List<Customer> customer) {
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

		public Seller getSeller() {
			return seller;
		}

		public void setSeller(Seller seller) {
			this.seller = seller;
		}

		@Override
		public String toString() {
			return "Order [orderId=" + orderId + ", customer=" + customer + ", orderDate=" + orderDate
					+ ", totalAmount=" + totalAmount + ", status=" + status + ", statusDescription=" + statusDescription
					+ ", deliveryDate=" + deliveryDate + ", payment=" + payment + ", seller=" + seller + "]";
		}

		
}
