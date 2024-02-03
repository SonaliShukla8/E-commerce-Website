package com.hexaware.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.entity.SubCategory;
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {

}