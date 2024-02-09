package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.ProductDTO;
import com.hexaware.ecommerce.entity.Product;

public interface IProductService {
	public Product addProduct(ProductDTO productDTO);
    public Product updateProduct(ProductDTO productDTO);
    public String deleteProductById(int productId);
    public ProductDTO getProductById(int productId);
    public List<Product> getAllProduct();
    public Product getByName(String name);
}
