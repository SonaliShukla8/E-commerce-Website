package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.ProductDTO;
import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.entity.SubCategory;

public interface ISellerService {
	public Seller addSeller(SellerDTO sellerDTO);
    public Seller updateSeller(SellerDTO sellerDTO);
    public String deleteSellerById(int sellerId);
   
    public List<Seller> getAllSeller();
	SellerDTO getSellerById(int sellerId);
	
	public List<Order> getAllOrder();
	public List<Product> getAllProduct();
	public List<Category> getAllCategory();
	public List<SubCategory> getAllSubCategory();
	public Product addProduct(ProductDTO productdto);
	public Product updateProduct(ProductDTO productdto);
	public String deleteProduct(int id);
	public Product getProductbyName(String name);
	public ProductDTO getProductById(int id);
}
