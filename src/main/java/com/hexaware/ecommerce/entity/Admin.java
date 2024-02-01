package com.hexaware.ecommerce.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Admin {
	@Id
    private int adminID;
    private String adminName;
    private String email;
    private int phoneNumber;
    private String password;
    private LocalDate joiningDate;
    @OneToOne(mappedBy="admin",cascade=CascadeType.ALL)
    private User user;
    
}
