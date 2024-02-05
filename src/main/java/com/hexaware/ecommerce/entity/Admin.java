package com.hexaware.ecommerce.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Entity
public class Admin {
	@Id
	@NotNull
    private int adminID;
	@NotBlank
    private String adminName;
	@NotBlank
	@Email
    private String email;
	@Pattern(regexp = "\\d{10}")
    private String phoneNumber;
    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain at least one number, uppercase letter, lowercase letter, and a special character.")
    private String password;
    @NotNull
    private LocalDate joiningDate;
    @OneToOne(cascade=CascadeType.ALL)
    private User user;
	
    public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(@NotNull int adminID, @NotBlank String adminName, @NotBlank @Email String email,
			@Pattern(regexp = "\\d{10}") String phoneNumber,
			@NotBlank @Size(min = 8) @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Password must contain at least one number, uppercase letter, lowercase letter, and a special character.") String password,
			@NotNull LocalDate joiningDate, User user) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.joiningDate = joiningDate;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", adminName=" + adminName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", joiningDate=" + joiningDate + ", user=" + user + "]";
	}
    
    
}
