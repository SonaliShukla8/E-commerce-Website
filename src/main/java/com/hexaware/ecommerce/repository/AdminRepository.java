package com.hexaware.ecommerce.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
	Optional<Admin> findByUsername(String username);
    
	@Query(value="select * from admin where adminid=:adminId", nativeQuery=true)
	Admin findByAdminId(int adminId);
   
   
}
