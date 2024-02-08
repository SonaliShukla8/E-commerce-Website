package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.exception.SellerNotFoundException;

public interface ISellerService {
	public Seller addSeller(SellerDTO sellerDTO);
    public Seller updateSeller(SellerDTO sellerDTO) throws SellerNotFoundException;
    public String deleteSellerById(int sellerId) throws SellerNotFoundException;
   
    public List<Seller> getAllSeller();
	SellerDTO getSellerById(int sellerId) throws SellerNotFoundException;
}
