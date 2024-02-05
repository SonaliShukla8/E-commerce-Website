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
	    Product product = new Product();
	    product.setProductId(productDTO.getProductId());
	    product.setBrand(productDTO.getBrand());
	    product.setCart(productDTO.getCart());
	    product.setCategory(productDTO.getCategory());
	    product.setCreatedAt(productDTO.getCreatedAt());
	    product.setDescription(productDTO.getDescription());
	    product.setModifiedAt(productDTO.getModifiedAt());
	    product.setPrice(productDTO.getPrice());
	    product.setProductImageURL(productDTO.getProductImageURL());
	    product.setProductName(productDTO.getProductName());
	    product.setSeller(productDTO.getSeller());
	    product.setStockQuantity(productDTO.getStockQuantity());
	    product.setSubCategory(productDTO.getSubCategory());
		return repo.save(product);
	}

	@Override
	public Product updateProduct(ProductDTO productDTO) {
		 Product product = new Product();
		    product.setProductId(productDTO.getProductId());
		    product.setBrand(productDTO.getBrand());
		    product.setCart(productDTO.getCart());
		    product.setCategory(productDTO.getCategory());
		    product.setCreatedAt(productDTO.getCreatedAt());
		    product.setDescription(productDTO.getDescription());
		    product.setModifiedAt(productDTO.getModifiedAt());
		    product.setPrice(productDTO.getPrice());
		    product.setProductImageURL(productDTO.getProductImageURL());
		    product.setProductName(productDTO.getProductName());
		    product.setSeller(productDTO.getSeller());
		    product.setStockQuantity(productDTO.getStockQuantity());
		    product.setSubCategory(productDTO.getSubCategory());
			return repo.save(product);
		
	}

	@Override
	public String deleteProductById(int productId) {
		repo.deleteById(productId);
		return "Product with productId "+productId+" deleted.";
	}

	@Override
	public ProductDTO getProductById(int productId) {
		Product product=repo.findById(productId).orElse(null);
		ProductDTO dto=new ProductDTO();
		dto.setProductId(product.getProductId());
	    dto.setBrand(product.getBrand());
	    dto.setCart(product.getCart());
	    dto.setCategory(product.getCategory());
	    dto.setCreatedAt(product.getCreatedAt());
	   dto.setDescription(product.getDescription());
	    dto.setModifiedAt(product.getModifiedAt());
	    dto.setPrice(product.getPrice());
	    dto.setProductImageURL(product.getProductImageURL());
	   dto.setProductName(product.getProductName());
	    dto.setSeller(product.getSeller());
	    dto.setStockQuantity(product.getStockQuantity());
	    dto.setSubCategory(product.getSubCategory());
		return dto;
	}

	@Override
	public List<Product> getAllProduct() {

		return repo.findAll();
	}

}
