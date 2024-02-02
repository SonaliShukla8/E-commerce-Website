package com.hexaware.ecommerce.service;

import java.util.List;
import com.hexaware.ecommerce.entity.User;

public interface IUserService {
	public User addUser(User user);
    public  User updateUser(User user);
    public String deleteUserById(int userId);
    public User getUserById(int userId);
    public List<User> getAllUser();
}
