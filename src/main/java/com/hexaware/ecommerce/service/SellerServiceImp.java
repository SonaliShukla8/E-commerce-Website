package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.repository.SellerRepository;
@Service
public class SellerServiceImp implements ISellerService {
    @Autowired
	SellerRepository repo;
	
	@Override
	public Seller addSeller(SellerDTO sellerDTO) {
		
		return null;
	}

	@Override
	public Seller updateSeller(SellerDTO sellerDTO) {
		
		return null;
	}

	@Override
	public String deleteSellerById(int sellerId) {
		
		return null;
	}

	@Override
	public SellerDTO getSelleeById(int sellerId) {

		return null;
	}

	@Override
	public List<Seller> getAllSeller() {
		
		return null;
	}

}
