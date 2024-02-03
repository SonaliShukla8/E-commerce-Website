package com.hexaware.ecommerce.dto;

import java.time.LocalDate;

import com.hexaware.ecommerce.entity.User;

public class AdminDTO {

	 private int adminID;
	    private String adminName;
	    private String email;
	    private String phoneNumber;
	    private String password;
	    private LocalDate joiningDate;
	    private UserDTO user;
}
