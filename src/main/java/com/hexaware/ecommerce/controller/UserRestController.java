package com.hexaware.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexaware.ecommerce.dto.UserDTO;
import com.hexaware.ecommerce.entity.User;
import com.hexaware.ecommerce.service.IUserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserRestController {
	@Autowired
	IUserService service;
	
	@PostMapping("/add")
	public User addUser(@RequestBody @Valid UserDTO userDTO) {
		return service.addUser(userDTO);
	}
	
	@PutMapping("/update")
    public User updateUser(@RequestBody @Valid  UserDTO userDTO) {
		return service.updateUser(userDTO);
	}
	
	@DeleteMapping("/delete/{userId}")
    public String deleteUserById(@PathVariable int userId) {
		return service.deleteUserById(userId);
	}
     
	@GetMapping("/getbyId/{userId}")
	public UserDTO getUserById(@PathVariable int userId) {
		return service.getUserById(userId);
	}
	
	@GetMapping("/getall")
    public List<User> getAllUser(){
		return service.getAllUser();
	}


}
