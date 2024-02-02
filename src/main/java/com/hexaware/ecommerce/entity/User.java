package com.hexaware.ecommerce.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="sellerId")
	    private Seller seller;
	    @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="customerId")
	    private Customer customer;
	    @OneToOne(cascade=CascadeType.ALL)
	    @JoinColumn(name="adminId")
	    private Admin admin;
}
