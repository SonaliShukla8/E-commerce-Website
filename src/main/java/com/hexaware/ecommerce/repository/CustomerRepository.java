package com.hexaware.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.entity.Admin;
import com.hexaware.ecommerce.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
//	 Customer findByUserName(String username);
}
