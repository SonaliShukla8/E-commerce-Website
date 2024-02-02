package com.hexaware.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.ecommerce.entity.Customer;

public class AddressDTO {
		
	    private int addressId;        // Primary Key
	    private String addressLine1;
	    private String addressLine2;
	    private String postalCode;
	    private String city;
	    private String state;
	    private String country;
	    private List<Customer> customers = new ArrayList<Customer>();
		
	    public AddressDTO() {
			super();
			
		}

		public AddressDTO(int addressId, String addressLine1, String addressLine2, String postalCode, String city,
				String state, String country, List<Customer> customers) {
			super();
			this.addressId = addressId;
			this.addressLine1 = addressLine1;
			this.addressLine2 = addressLine2;
			this.postalCode = postalCode;
			this.city = city;
			this.state = state;
			this.country = country;
			this.customers = customers;
		}

		public int getAddressId() {
			return addressId;
		}

		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}

		public String getAddressLine1() {
			return addressLine1;
		}

		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}

		public String getAddressLine2() {
			return addressLine2;
		}

		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public List<Customer> getCustomers() {
			return customers;
		}

		public void setCustomers(List<Customer> customers) {
			this.customers = customers;
		}

		@Override
		public String toString() {
			return "AddressDTO [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2="
					+ addressLine2 + ", postalCode=" + postalCode + ", city=" + city + ", state=" + state + ", country="
					+ country + ", customers=" + customers + "]";
		}

		
        
	    
	    
}
