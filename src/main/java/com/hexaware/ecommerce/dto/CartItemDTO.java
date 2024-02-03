package com.hexaware.ecommerce.dto;

import java.util.List;

import com.hexaware.ecommerce.entity.Cart;
import com.hexaware.ecommerce.entity.Product;

public class CartItemDTO {
	
	 private int cartitemId;
	 private int itemQuantity;
	 private CartDTO cart;
	 private List<ProductDTO> product;

}
