package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hexaware.ecommerce.entity.Address;
import com.hexaware.ecommerce.entity.Cart;
import com.hexaware.ecommerce.entity.Order;



public class CustomerDTO {
	
	private int customerId;        // Primary Key
    private String fullName;
    private String gender;
    private String contactNumber;
    private String email;
    private String password;
    @JsonIgnore
    private Address address;
    @JsonIgnore
    private Cart cart;
    @JsonIgnore
    private List<Order> order= new ArrayList<Order>();
	
    public CustomerDTO() {
		super();
		
	}

	

	public CustomerDTO(int customerId, String fullName, String gender, String contactNumber, String email,
			String password, Address address, Cart cart, List<Order> order) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.cart = cart;
		this.order = order;
	}



	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", fullName=" + fullName + ", gender=" + gender
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", password=" + password + ", address="
				+ address + ", cart=" + cart + ", order=" + order + "]";
	}



	public CustomerDTO(int customerId, String fullName, String gender, String contactNumber, String email,
			String password) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
	}

	
}
