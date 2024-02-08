package com.hexaware.ecommerce.entity;

import java.util.ArrayList;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Seller {
	@Id
	 private int sellerId;        // Primary Key
	@NotBlank
	 private String businessName;
	 @Pattern(regexp = "[0-9]{10}")
	 private String phoneNumber;
	 @Email(message = "Invalid email address")
	 @NotBlank(message = "Email cannot be blank")
	 private String email;
	 @NotBlank(message = "Address cannot be blank")
	 private String address;
	 @NotBlank(message = "Selling domain cannot be blank")
	 private String sellingDomain;
	 
	 @OneToMany(cascade=CascadeType.ALL,mappedBy="seller")
	 private List<Product> product=new ArrayList<Product>();
	 
	 
	 
	 @OneToMany(cascade=CascadeType.ALL, mappedBy="seller")
	 private List<Order> order=new ArrayList<Order>();

	public Seller() {
		super();
	
	}

	public Seller(int sellerId, @NotBlank String businessName, @Pattern(regexp = "[0-9]{10}") String phoneNumber,
			@Email(message = "Invalid email address") @NotBlank(message = "Email cannot be blank") String email,
			@NotBlank(message = "Address cannot be blank") String address,
			@NotBlank(message = "Selling domain cannot be blank") String sellingDomain, List<Product> product,
			List<Order> order) {
		super();
		this.sellerId = sellerId;
		this.businessName = businessName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.sellingDomain = sellingDomain;
		this.product = product;
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

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", businessName=" + businessName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", address=" + address + ", sellingDomain=" + sellingDomain + ", product="
				+ product + ", order=" + order + "]";
	}

	
	
}
