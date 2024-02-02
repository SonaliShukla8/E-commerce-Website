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
    @OneToOne(mappedBy="admin",cascade=CascadeType.ALL)
    private User user;
    
}
