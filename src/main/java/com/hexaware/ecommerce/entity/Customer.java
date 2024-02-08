package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
    private String fullName;
	@NotBlank
    private String gender;
	@NotBlank
	@Pattern(regexp = "\\d{10}")
    private String contactNumber;
    @NotBlank
    @Email
    private String email;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "customer_address",joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private List<Address> addresses =new ArrayList<Address>();
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cartId", nullable =false)
    private Cart cart;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
    private List<Order> order= new ArrayList<Order>();

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", gender=" + gender
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", addresses=" + addresses + ", cart="
				+ cart + ", order=" + order + "]";
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

	
	
    
}

