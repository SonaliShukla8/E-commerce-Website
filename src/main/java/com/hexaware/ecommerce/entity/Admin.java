package com.hexaware.ecommerce.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Admin {
	@Id
    private int adminID;
    private String adminName;
    private String email;
    private int phoneNumber;
    private String password;
    private LocalDate joiningDate;
    
}
