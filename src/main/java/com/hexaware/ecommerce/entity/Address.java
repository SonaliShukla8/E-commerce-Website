package com.hexaware.ecommerce.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	    private int addressId;        // Primary Key
	    private String houseNo;
	    private String addressLine1;
	    private String addressLine2;
	    private String postalCode;
	    private String city;
	    private String state;
	    private String country;
		
	    public Address(int addressId, String houseNo, String addressLine1, String addressLine2, String postalCode,
				String city, String state, String country) {
			super();
			this.addressId = addressId;
			this.houseNo = houseNo;
			this.addressLine1 = addressLine1;
			this.addressLine2 = addressLine2;
			this.postalCode = postalCode;
			this.city = city;
			this.state = state;
			this.country = country;
		}

		public int getAddressId() {
			return addressId;
		}

		public void setAddressId(int addressId) {
			this.addressId = addressId;
		}

		public String getHouseNo() {
			return houseNo;
		}

		public void setHouseNo(String houseNo) {
			this.houseNo = houseNo;
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

		@Override
		public String toString() {
			return "Address [addressId=" + addressId + ", houseNo=" + houseNo + ", addressLine1=" + addressLine1
					+ ", addressLine2=" + addressLine2 + ", postalCode=" + postalCode + ", city=" + city + ", state="
					+ state + ", country=" + country + "]";
		}
	    
	    
	    
	    
}
