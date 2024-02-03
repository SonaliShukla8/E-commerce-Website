package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entity.Seller;

public interface ISellerService {
	public Seller addSeller(SellerDTO sellerDTO);
    public Seller updateSeller(SellerDTO sellerDTO);
    public String deleteSellerById(int sellerId);
    public SellerDTO getSelleeById(int sellerId);
    public List<Seller> getAllSeller();
}
