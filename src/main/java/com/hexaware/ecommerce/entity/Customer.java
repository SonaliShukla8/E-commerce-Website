package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    private String customerName;
	@NotBlank
    private String gender;
	@NotBlank
	@Pattern(regexp = "\\d{10}")
    private String contactNumber;
    @NotBlank
    @Email
    private String email;
    
    @NotBlank(message = "Username is required")
	@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username should contain only alphanumeric characters and underscores")
	private String username;
    
    private String password;
    
    private String role;
    
    
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "customer_address",joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private List<Address> addresses =new ArrayList<Address>();
    
    
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="cartId", nullable =false)
    private Cart cart;
   
   
	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
    private List<Order> order= new ArrayList<Order>();


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", username=" + username + ", password="
				+ password + ", role=" + role + ", addresses=" + addresses + ", cart=" + cart + ", order=" + order
				+ "]";
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public List<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
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


	public Customer(int customerId, @NotBlank String customerName, @NotBlank String gender,
			@NotBlank @Pattern(regexp = "\\d{10}") String contactNumber, @NotBlank @Email String email,
			@NotBlank(message = "Username is required") @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username should contain only alphanumeric characters and underscores") String username,
			String password, String role, List<Address> addresses, Cart cart, List<Order> order) {
		super();
		this.customerId = customerId;
		this.customerName=customerName;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.addresses = addresses;
		this.cart = cart;
		this.order = order;
	}


	
	
    
}

