package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.entity.Cart;


public interface ICartService {
	 public Cart addCart(Cart cart);
     public Cart updateCart(Cart cart);
     public String deleteCartById(int cartId);
     public Cart getCartbyId(int cartId);
     public List<Cart> getAllCart();
}
