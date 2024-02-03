package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.UserDTO;
import com.hexaware.ecommerce.entity.User;

public interface IUserService {
	public User addUser(UserDTO userDTO);
    public  User updateUser(UserDTO userDTO);
    public String deleteUserById(int userId);
    public UserDTO getUserById(int userId);
    public List<User> getAllUser();
}
