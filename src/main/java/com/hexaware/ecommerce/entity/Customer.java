package com.hexaware.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(nullable=false , name="userId")
    private User user;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cartId", nullable =false)
    private Cart cart;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Order order;

	public Customer() {
		super();
	}

	public Customer(int customerId, @NotBlank String fullName, @NotBlank String gender,
			@NotBlank @Pattern(regexp = "\\d{10}") String contactNumber, @NotBlank @Email String email,
			List<Address> addresses, User user, Cart cart, Order order) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.email = email;
		this.addresses = addresses;
		this.user = user;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", gender=" + gender
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", addresses=" + addresses + ", user="
				+ user + ", cart=" + cart + ", order=" + order + "]";
	}
    
    
}

