package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.Address;
import com.hexaware.ecommerce.entity.Cart;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.User;

public class CustomerDTO {
	
	private int customerId;        // Primary Key
    private String fullName;
    private String gender;
    private String contactNumber;
    private String email;
    private List<AddressDTO> addresses = new ArrayList<AddressDTO>();
    private UserDTO user;
    private CartDTO cart;
    private OrderDTO order;
	
    public CustomerDTO() {
		super();
		
	}

	public CustomerDTO(int customerId, String fullName, String gender, String contactNumber, String email,
			List<AddressDTO> addresses, UserDTO user, CartDTO cart, OrderDTO order) {
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

	public List<AddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public CartDTO getCart() {
		return cart;
	}

	public void setCart(CartDTO cart) {
		this.cart = cart;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", fullName=" + fullName + ", gender=" + gender
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", addresses=" + addresses + ", user="
				+ user + ", cart=" + cart + ", order=" + order + "]";
	}

	

}
