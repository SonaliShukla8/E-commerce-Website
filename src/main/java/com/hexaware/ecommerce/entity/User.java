package com.hexaware.ecommerce.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	@Id
	 private int userId;        // Primary Key
	    @Size(min=5,max=15)
	    @NotBlank
	    private String username;
	    @Email
	    @NotBlank
	    private String email;
	    @NotBlank
	    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain at least one number, uppercase letter, lowercase letter, and a special character.")
	    private String password;
	    @NotBlank
	    private String userType;
	    
		
	    
	    public User() {
			super();
			// TODO Auto-generated constructor stub
		}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
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


		public String getUserType() {
			return userType;
		}


		public void setUserType(String userType) {
			this.userType = userType;
		}


		

		public User(int userId, @Size(min = 5, max = 15) @NotBlank String username, @Email @NotBlank String email,
				@NotBlank @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain at least one number, uppercase letter, lowercase letter, and a special character.") String password,
				@NotBlank String userType) {
			super();
			this.userId = userId;
			this.username = username;
			this.email = email;
			this.password = password;
			this.userType = userType;
			
		}


		@Override
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
					+ ", userType=" + userType + "]";
		}




		
}
