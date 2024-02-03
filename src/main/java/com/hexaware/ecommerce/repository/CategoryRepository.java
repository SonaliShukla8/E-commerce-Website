package com.hexaware.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
