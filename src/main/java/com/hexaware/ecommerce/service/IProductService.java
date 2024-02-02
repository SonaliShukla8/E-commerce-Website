package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.entity.Product;

public interface IProductService {
	public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public String deleteProductById(int productId);
    public Product getProductById(int productId);
    public List<Product> getAllProduct();
}
