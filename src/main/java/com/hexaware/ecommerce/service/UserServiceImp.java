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
       User user = new User();
       
      
       user.setEmail(userDTO.getEmail());
       user.setPassword(userDTO.getPassword());
      
       user.setUserId(userDTO.getUserId());
       user.setUsername(userDTO.getUsername());
       user.setUserType(userDTO.getUserType());
		return repo.save(user);
	}

	@Override
	public User updateUser(UserDTO userDTO) {
		 User user = new User();

	      
	       user.setEmail(userDTO.getEmail());
	       user.setPassword(userDTO.getPassword());
	      
	       user.setUserId(userDTO.getUserId());
	       user.setUsername(userDTO.getUsername());
	       user.setUserType(userDTO.getUserType());
			return repo.save(user);
		
	}

	@Override
	public String deleteUserById(int userId) {
		repo.deleteById(userId);
		return "User with userId "+userId+" deleted.";
	}

	@Override
	public UserDTO getUserById(int userId) {
	    User user=repo.findById(userId).orElse(null);
	    UserDTO dto=new UserDTO();
	    
	      
	       dto.setEmail(user.getEmail());
	       dto.setPassword(user.getPassword());
	      
	       dto.setUserId(user.getUserId());
	       dto.setUsername(user.getUsername());
	       dto.setUserType(user.getUserType());
		return dto;
	}

	@Override
	public List<User> getAllUser() {
	
		return repo.findAll();
	}

}
