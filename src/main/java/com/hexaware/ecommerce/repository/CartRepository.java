package com.hexaware.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

}
