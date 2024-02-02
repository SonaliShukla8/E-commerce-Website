package com.hexaware.ecommerce.service;

import java.util.List;


import com.hexaware.ecommerce.entity.Seller;

public interface ISellerService {
	public Seller addSeller(Seller seller);
    public Seller updateSeller(Seller seller);
    public String deleteSellerById(int sellerId);
    public Seller getSelleeById(int sellerId);
    public List<Seller> getAllSeller();
}
