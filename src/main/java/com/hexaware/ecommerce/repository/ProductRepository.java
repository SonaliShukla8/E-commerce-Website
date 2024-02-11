package com.hexaware.ecommerce.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>  {
	Optional<Product> findByProductName(String name);
	List<Product> findBybrand(String brand);
	List<Product> findBypriceBetween(double min,double max);
}
