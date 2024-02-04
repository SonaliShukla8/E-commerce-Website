package com.hexaware.ecommerce.entity;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Address {
	
		@Id
		@NotNull
	   	private int addressId;        // Primary Key
		@NotBlank
	    @Size(max = 255)
	    private String addressLine1;
		@NotBlank
		@Size(max = 255)
	    private String addressLine2;
		@NotBlank
	    @Pattern(regexp = "\\d{6}")
	    private String postalCode;
		@NotBlank
	    private String city;
		@NotBlank
	    private String state;
		@NotBlank
	    private String country;
	    @ManyToMany(mappedBy = "addresses", fetch=FetchType.LAZY)
	    private List<Customer> customers = new ArrayList<Customer>();
		
	    public Address() {
			super();
			// TODO Auto-generated constructor stub
		}
	    

		public Address(@NotNull int addressId, @NotBlank @Size(max = 255) String addressLine1,
				@NotBlank @Size(max = 255) String addressLine2, @NotBlank @Pattern(regexp = "\\d{6}") String postalCode,
				@NotBlank String city, @NotBlank String state, @NotBlank String country) {
			super();
			this.addressId = addressId;
			this.addressLine1 = addressLine1;
			this.addressLine2 = addressLine2;
			this.postalCode = postalCode;
			this.city = city;
			this.state = state;
			this.country = country;
		}


		public Address(@NotNull int addressId, @NotBlank @Size(max = 255) String addressLine1,
				@NotBlank @Size(max = 255) String addressLine2, @NotBlank @Pattern(regexp = "\\d{6}") String postalCode,
				@NotBlank String city, @NotBlank String state, @NotBlank String country, List<Customer> customers) {
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
			return "Address [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2="
					+ addressLine2 + ", postalCode=" + postalCode + ", city=" + city + ", state=" + state + ", country="
					+ country + ", customers=" + customers + "]";
		}
	    
	    
	    
	    
	    
	    
	    
	    
}
