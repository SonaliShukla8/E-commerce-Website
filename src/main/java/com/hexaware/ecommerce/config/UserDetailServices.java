//package com.hexaware.ecommerce.config;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.hexaware.ecommerce.entity.Admin;
//import com.hexaware.ecommerce.entity.Customer;
//import com.hexaware.ecommerce.repository.AdminRepository;
//import com.hexaware.ecommerce.repository.CustomerRepository;
//@Component
//public class UserDetailServices implements UserDetailsService , UserDetails{
//	@Autowired
//	private AdminRepository adminRepo;
//    private CustomerRepository customerRepo;
//    
//   
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Customer customer = customerRepo.findByUserName(username);
//		if (customer != null) {
//			return new User(customer.getFullName(), customer.getPassword(),
//					Collections.singletonList(new SimpleGrantedAuthority("customer")));
//		}
//		
//		Admin admin = adminRepo.findByUserName(username);
//		if (admin != null) {
//			return new User(admin.getAdminName(), admin.getPassword(),
//					Collections.singletonList(new SimpleGrantedAuthority("admin")));
//		}
//		throw new UsernameNotFoundException("User not found: " + username);
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		
//		return null;
//	}
//
//	@Override
//	public String getPassword() {
//		return null;
//	}
//
////	@Override
////	public String getUsername() {
////
////		return userName;
////	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//	
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return false;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	
//
//}
