package com.hexaware.ecommerce.dto;

import java.time.LocalDate;

import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.entity.Payment;
import com.hexaware.ecommerce.entity.Seller;

public class OrderDTO {
	
	private int orderId; 
	 private Customer customer;
	    private LocalDate orderDate;
	    private double totalAmount;
	    private String status;
	    private String statusDescription;
	    private Payment payment;
	    private LocalDate deliveryDate;
	    private Seller seller;
		public OrderDTO() {
			super();
			
		}
		public OrderDTO(int orderId, Customer customer, LocalDate orderDate, double totalAmount, String status,
				String statusDescription, Payment payment, LocalDate deliveryDate, Seller seller) {
			super();
			this.orderId = orderId;
			this.customer = customer;
			this.orderDate = orderDate;
			this.totalAmount = totalAmount;
			this.status = status;
			this.statusDescription = statusDescription;
			this.payment = payment;
			this.deliveryDate = deliveryDate;
			this.seller = seller;
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
		public Payment getPayment() {
			return payment;
		}
		public void setPayment(Payment payment) {
			this.payment = payment;
		}
		public LocalDate getDeliveryDate() {
			return deliveryDate;
		}
		public void setDeliveryDate(LocalDate deliveryDate) {
			this.deliveryDate = deliveryDate;
		}
		public Seller getSeller() {
			return seller;
		}
		public void setSeller(Seller seller) {
			this.seller = seller;
		}
		@Override
		public String toString() {
			return "OrderDTO [orderId=" + orderId + ", customer=" + customer + ", orderDate=" + orderDate
					+ ", totalAmount=" + totalAmount + ", status=" + status + ", statusDescription=" + statusDescription
					+ ", payment=" + payment + ", deliveryDate=" + deliveryDate + ", seller=" + seller + "]";
		}
		
	    
}
