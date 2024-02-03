package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.UserDTO;
import com.hexaware.ecommerce.entity.User;
import com.hexaware.ecommerce.repository.UserRepository;
@Service
public class UserServiceImp implements IUserService {
    @Autowired
	UserRepository repo;
	
	@Override
	public User addUser(UserDTO userDTO) {

		return null;
	}

	@Override
	public User updateUser(UserDTO userDTO) {
	
		return null;
	}

	@Override
	public String deleteUserById(int userId) {
		
		return null;
	}

	@Override
	public UserDTO getUserById(int userId) {
	
		return null;
	}

	@Override
	public List<User> getAllUser() {
	
		return null;
	}

}
