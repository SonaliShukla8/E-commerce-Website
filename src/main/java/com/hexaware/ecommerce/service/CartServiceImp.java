package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.CartDTO;
import com.hexaware.ecommerce.entity.Cart;
import com.hexaware.ecommerce.repository.CartRepository;
@Service
public class CartServiceImp implements ICartService {
    @Autowired
	CartRepository repo;
	
	
	@Override
	public Cart addCart(CartDTO cartDTO) {
		
		return null;
	}

	@Override
	public Cart updateCart(CartDTO cartDTO) {
	
		return null;
	}

	@Override
	public String deleteCartById(int cartId) {

		return null;
	}

	@Override
	public CartDTO getCartbyId(int cartId) {

		return null;
	}

	@Override
	public List<Cart> getAllCart() {
	
		return null;
	}

}
