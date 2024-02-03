package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.CartItemDTO;
import com.hexaware.ecommerce.entity.CartItem;
import com.hexaware.ecommerce.repository.CartItemRepository;
@Service
public class CartItemServiceImp implements ICartItemService {
    @Autowired
	CartItemRepository repo;
	
	@Override
	public CartItem addCartItem(CartItemDTO cartItemDTO) {
	
		return null;
	}

	@Override
	public CartItem updateCartItem(CartItemDTO cartItemDTO) {
		
		return null;
	}

	@Override
	public String deleteCartItemById(int cartitemId) {
		
		return null;
	}

	@Override
	public CartItemDTO getCartItemById(int cartitemId) {
		
		return null;
	}

	@Override
	public List<CartItem> getAllCartItem() {
		return null;
	}

}
