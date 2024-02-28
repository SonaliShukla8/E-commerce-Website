package com.hexaware.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.Payment;
import com.hexaware.ecommerce.entity.Seller;


@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer>  {
	
	Seller findByEmail(String email);
	Optional<Seller> findBySellerName(String name);
	 Optional<Seller> findByUsername(String username);
	 @Query(value = "SELECT os.order_id FROM order_table o JOIN order_seller os ON o.order_id = os.order_id WHERE os.seller_id = :sellerId", nativeQuery = true)
	    List<Integer> getOrdersBySellerId( int sellerId);
	 
	 @Query(value ="select payment.payment_id from payment where payment_id IN (SELECT payment.payment_id FROM payment JOIN order_table ON payment.payment_id = order_table.payment_id JOIN order_seller ON order_table.order_id = order_seller.order_id WHERE order_seller.seller_id = :sellerId);", nativeQuery = true)
	 List<Integer> getPaymentsOfSeller(int sellerId);
	 
	 
}
