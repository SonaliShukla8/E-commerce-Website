package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Customer {
	@Id
	private int customerId;        // Primary Key
	@NotBlank
    private String fullName;
	@NotBlank
    private String gender;
	@NotBlank
	@Pattern(regexp = "\\d{10}")
    private String contactNumber;
    @NotBlank
    @Email
    private String email;
    
    private String password;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="cartId")
    private Cart cart;
   
    public Customer(int customerId, @NotBlank String fullName, @NotBlank String gender,
			@NotBlank @Pattern(regexp = "\\d{10}") String contactNumber, @NotBlank @Email String email,
			String password) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
	}
    @JsonIgnore
	@OneToMany( mappedBy="customer")
    private List<Order> order= new ArrayList<Order>();

	public Customer() {
		super();
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


	public Customer(int customerId, @NotBlank String fullName, @NotBlank String gender,
			@NotBlank @Pattern(regexp = "\\d{10}") String contactNumber, @NotBlank @Email String email, String password,
			Address address, Cart cart, List<Order> order) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.cart = new Cart();
		this.order = order;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", gender=" + gender
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", password=" + password + ", address="
				+ address + ", cart=" + cart + ", order=" + order + "]";
	}

	

	
	
	
    
}

