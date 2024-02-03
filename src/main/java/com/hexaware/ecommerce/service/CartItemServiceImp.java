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
		CartItem cartItem = new CartItem();
		cartItem.setCart(cartItemDTO.getCart());
		cartItem.setCartitemId(cartItemDTO.getCartitemId());
		cartItem.setItemQuantity(cartItemDTO.getItemQuantity());
		cartItem.setProduct(cartItemDTO.getProduct());
	
		return repo.save(cartItem);
	}

	@Override
	public CartItem updateCartItem(CartItemDTO cartItemDTO) {
		
		CartItem cartItem = new CartItem();
		cartItem.setCart(cartItemDTO.getCart());
		cartItem.setCartitemId(cartItemDTO.getCartitemId());
		cartItem.setItemQuantity(cartItemDTO.getItemQuantity());
		cartItem.setProduct(cartItemDTO.getProduct());
	
		return repo.save(cartItem);
	}

	@Override
	public String deleteCartItemById(int cartitemId) {
		
		repo.deleteById(cartitemId);
		return "Cart Item with cartitemId "+cartitemId+ "deleted.";
	}

	@Override
	public CartItemDTO getCartItemById(int cartitemId) {
		CartItem cartItem = repo.findById(cartitemId).orElse(null);
		CartItemDTO dto = new CartItemDTO();
		dto.setCart(cartItem.getCart());
		dto.setCartitemId(cartItem.getCartitemId());
		dto.setItemQuantity(cartItem.getItemQuantity());
		dto.setProduct(cartItem.getProduct());
		
		
		return dto;
	}

	@Override
	public List<CartItem> getAllCartItem() {
		return repo.findAll();
	}

}
