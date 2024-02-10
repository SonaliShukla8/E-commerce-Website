package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Seller {
	@Id
	 private int sellerId;        // Primary Key
	@NotBlank
	private String sellerName;
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
	 	 private String password;

	@JsonIgnore
	 @OneToMany(cascade=CascadeType.ALL,mappedBy="seller")
	 private List<Product> product=new ArrayList<Product>();
	 
	 
	 
	@ManyToMany(mappedBy = "sellers")
    private List<Order> orders = new ArrayList<>();

	public Seller() {
		super();
	
	}

	public Seller(int sellerId, @NotBlank String sellerName, @NotBlank String businessName,
			@Pattern(regexp = "[0-9]{10}") String phoneNumber,
			@Email(message = "Invalid email address") @NotBlank(message = "Email cannot be blank") String email,
			@NotBlank(message = "Address cannot be blank") String address,
			@NotBlank(message = "Selling domain cannot be blank") String sellingDomain, String password,
			List<Product> product, List<Order> orders) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.businessName = businessName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.sellingDomain = sellingDomain;
		this.password = password;
		this.product = product;
		this.orders = orders;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public List<Order> getOrder() {
		return orders;
	}

	public void setOrder(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", businessName=" + businessName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address + ", sellingDomain="
				+ sellingDomain + ", password=" + password + ", product=" + product + ", orders=" + orders + "]";
	}
    
	
}
