package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.ProductDTO;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.repository.ProductRepository;
@Service
public class ProductServiceImp implements IProductService {
    
	@Autowired
	ProductRepository repo;
	
	@Override
	public Product addProduct(ProductDTO productDTO) {
	
		return null;
	}

	@Override
	public Product updateProduct(ProductDTO productDTO) {
		
		return null;
	}

	@Override
	public String deleteProductById(int productId) {
		
		return null;
	}

	@Override
	public ProductDTO getProductById(int productId) {
		
		return null;
	}

	@Override
	public List<Product> getAllProduct() {

		return null;
	}

}
