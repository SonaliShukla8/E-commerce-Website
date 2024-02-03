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
		
		Cart cart = new Cart();
		cart.setCartId(cartDTO.getCartId());
		cart.setCartItems(cartDTO.getCartItems());
		cart.setCustomer(cartDTO.getCustomer());
		cart.setTotalPrice(cartDTO.getTotalPrice());
		
		return repo.save(cart);
	}

	@Override
	public Cart updateCart(CartDTO cartDTO) {
	
		Cart cart = new Cart();
		cart.setCartId(cartDTO.getCartId());
		cart.setCartItems(cartDTO.getCartItems());
		cart.setCustomer(cartDTO.getCustomer());
		cart.setTotalPrice(cartDTO.getTotalPrice());
		
		return repo.save(cart);
	}

	@Override
	public String deleteCartById(int cartId) {
		
		repo.deleteById(cartId);

		return "Cart with cartId "+cartId+" deleted.";
	}

	@Override
	public CartDTO getCartbyId(int cartId) {
		
		Cart cart = repo.findById(cartId).orElse(null);
		CartDTO dto = new CartDTO();
		dto.setCartId(cart.getCartId());
		dto.setCartItems(cart.getCartItems());
		dto.setCustomer(cart.getCustomer());
		dto.setTotalPrice(cart.getTotalPrice());

		return dto;
	}

	@Override
	public List<Cart> getAllCart() {
	
		return repo.findAll();
	}

}
