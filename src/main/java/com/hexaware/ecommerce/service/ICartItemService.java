package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.entity.CartItem;

public interface ICartItemService {
      public CartItem addCartItem(CartItem cartItem);
      public CartItem updateCartItem(CartItem cartItem);
      public String deleteCartItemById(int cartitemId);
      public CartItem getCartItemById(int cartitemId);
      public List<CartItem> getAllCartItem();
}
