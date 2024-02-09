package com.hexaware.ecommerce.dto;

import java.time.LocalDate;

public class AdminDTO {

	 private int adminID;
	    private String adminName;
	    private String email;
	    private String phoneNumber;
	    private String password;
	    private LocalDate joiningDate;
	    

		public AdminDTO() {
			super();
		}


		public int getAdminID() {
			return adminID;
		}


		public void setAdminID(int adminID) {
			this.adminID = adminID;
		}


		public String getAdminName() {
			return adminName;
		}


		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPhoneNumber() {
			return phoneNumber;
		}


		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public LocalDate getJoiningDate() {
			return joiningDate;
		}


		public void setJoiningDate(LocalDate joiningDate) {
			this.joiningDate = joiningDate;
		}


		@Override
		public String toString() {
			return "AdminDTO [adminID=" + adminID + ", adminName=" + adminName + ", email=" + email + ", phoneNumber="
					+ phoneNumber + ", password=" + password + ", joiningDate=" + joiningDate + "]";
		}

		
		
}
