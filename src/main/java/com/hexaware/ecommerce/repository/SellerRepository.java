package com.hexaware.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.entity.Seller;


@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer>  {
	
	Seller findByEmail(String email);
	Optional<Seller> findBySellerName(String name);
}
