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
		Seller seller=new Seller();
		seller.setAddress(sellerDTO.getAddress());
		seller.setBusinessName(sellerDTO.getBusinessName());
		seller.setEmail(sellerDTO.getEmail());
		seller.setOrder(sellerDTO.getOrder());
		seller.setPhoneNumber(sellerDTO.getPhoneNumber());
		seller.setProduct(sellerDTO.getProduct());
		seller.setSellerId(sellerDTO.getSellerId());
		seller.setSellingDomain(sellerDTO.getSellingDomain());
		seller.setUser(sellerDTO.getUser());
		return repo.save(seller);
		
	}

	@Override
	public Seller updateSeller(SellerDTO sellerDTO) {
		Seller seller=new Seller();
		seller.setAddress(sellerDTO.getAddress());
		seller.setBusinessName(sellerDTO.getBusinessName());
		seller.setEmail(sellerDTO.getEmail());
		seller.setOrder(sellerDTO.getOrder());
		seller.setPhoneNumber(sellerDTO.getPhoneNumber());
		seller.setProduct(sellerDTO.getProduct());
		seller.setSellerId(sellerDTO.getSellerId());
		seller.setSellingDomain(sellerDTO.getSellingDomain());
		seller.setUser(sellerDTO.getUser());
		return repo.save(seller);
	}

	@Override
	public String deleteSellerById(int sellerId) {
		repo.deleteById(sellerId);
		return "Seller with sellerID "+ sellerId+" deleted.";
	}

	@Override
	public SellerDTO getSellerById(int sellerId) {
        Seller seller=repo.findById(sellerId).orElse(null);
        SellerDTO dto=new SellerDTO();
        dto.setAddress(seller.getAddress());
		dto.setBusinessName(seller.getBusinessName());
		dto.setEmail(seller.getEmail());
		dto.setOrder(seller.getOrder());
		dto.setPhoneNumber(seller.getPhoneNumber());
		dto.setProduct(seller.getProduct());
		dto.setSellerId(seller.getSellerId());
		dto.setSellingDomain(seller.getSellingDomain());
		dto.setUser(seller.getUser());
		return dto;
	}

	@Override
	public List<Seller> getAllSeller() {
		
		return repo.findAll();
	}

}
