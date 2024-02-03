package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.User;

public class SellerDTO {
	
	 private int sellerId;        // Primary Key
	 
	 private String businessName;
	
	 private String phoneNumber;
	 
	 private String email;
	 
	 private String address;
	 
	 private String sellingDomain;
	 private List<Product> product=new ArrayList<Product>();
	 private User user;
	 private List<Order> order=new ArrayList<Order>();
	
	 public SellerDTO() {
		super();
	
	}

	public SellerDTO(int sellerId, String businessName, String phoneNumber, String email, String address,
			String sellingDomain, List<Product> product, User user, List<Order> order) {
		super();
		this.sellerId = sellerId;
		this.businessName = businessName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.sellingDomain = sellingDomain;
		this.product = product;
		this.user = user;
		this.order = order;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSellingDomain() {
		return sellingDomain;
	}

	public void setSellingDomain(String sellingDomain) {
		this.sellingDomain = sellingDomain;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "SellerDTO [sellerId=" + sellerId + ", businessName=" + businessName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", address=" + address + ", sellingDomain=" + sellingDomain + ", product="
				+ product + ", user=" + user + ", order=" + order + "]";
	}
    

}
