package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.ProductDTO;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.exception.ProductNotFoundException;

public interface IProductService {
	public Product addProduct(ProductDTO productDTO);
    public Product updateProduct(ProductDTO productDTO) throws ProductNotFoundException;
    public String deleteProductById(int productId) throws ProductNotFoundException;
    public ProductDTO getProductById(int productId) throws ProductNotFoundException;
    public List<Product> getAllProduct();
}
