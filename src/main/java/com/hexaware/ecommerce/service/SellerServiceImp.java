package com.hexaware.ecommerce.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.ProductDTO;
import com.hexaware.ecommerce.dto.SellerDTO;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.entity.SubCategory;
import com.hexaware.ecommerce.repository.SellerRepository;
@Service
public class SellerServiceImp implements ISellerService {
    @Autowired
	SellerRepository repo;
    @Autowired
    IOrderService orderService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    ISubCategoryService subCategoryService;
    @Autowired
    IProductService productService;
    
    private static final Logger logger = LoggerFactory.getLogger(SellerServiceImp.class);
	
	@Override
	public Seller addSeller(SellerDTO sellerDTO) {
		logger.info("Adding a seller..");
		Seller seller=new Seller();
		seller.setAddress(sellerDTO.getAddress());
		seller.setSellerName(sellerDTO.getSellerName());
		seller.setBusinessName(sellerDTO.getBusinessName());
		seller.setEmail(sellerDTO.getEmail());
		seller.setOrder(sellerDTO.getOrder());
		seller.setPhoneNumber(sellerDTO.getPhoneNumber());
		seller.setProduct(sellerDTO.getProduct());
		seller.setSellerId(sellerDTO.getSellerId());
		seller.setSellingDomain(sellerDTO.getSellingDomain());
		seller.setPassword(sellerDTO.getPassword());
		return repo.save(seller);
		
	}

	@Override
	public Seller updateSeller(SellerDTO sellerDTO) {
		logger.info("Updating the seller record...");
		Seller seller=new Seller();
		seller.setAddress(sellerDTO.getAddress());
		seller.setSellerName(sellerDTO.getSellerName());
		seller.setBusinessName(sellerDTO.getBusinessName());
		seller.setEmail(sellerDTO.getEmail());
		seller.setOrder(sellerDTO.getOrder());
		seller.setPhoneNumber(sellerDTO.getPhoneNumber());
		seller.setProduct(sellerDTO.getProduct());
		seller.setSellerId(sellerDTO.getSellerId());
		seller.setSellingDomain(sellerDTO.getSellingDomain());
		seller.setPassword(sellerDTO.getPassword());
		return repo.save(seller);
	}

	@Override
	public String deleteSellerById(int sellerId) {
		logger.info("Deleting the seller with sellerId: "+sellerId);
		repo.deleteById(sellerId);
		return "Seller with sellerID "+ sellerId+" deleted.";
	}

	@Override
	public SellerDTO getSellerById(int sellerId) {
        Seller seller=repo.findById(sellerId).orElse(null);
        if(seller == null) {
        	logger.warn("Seller with sellerId: "+sellerId+" not found.");
        	return null;}
        SellerDTO dto=new SellerDTO();
        dto.setAddress(seller.getAddress());
        dto.setSellerName(seller.getSellerName());
		dto.setBusinessName(seller.getBusinessName());
		dto.setEmail(seller.getEmail());
		dto.setOrder(seller.getOrder());
		dto.setPhoneNumber(seller.getPhoneNumber());
		dto.setProduct(seller.getProduct());
		dto.setSellerId(seller.getSellerId());
		dto.setSellingDomain(seller.getSellingDomain());
		dto.setPassword(seller.getPassword());
		return dto;
	}

	@Override
	public List<Seller> getAllSeller() {
		logger.info("Fetching all Sellers..");
		return repo.findAll();
	}

	@Override
	public List<Order> getAllOrder() {
		return orderService.getAllOrder();
	}

	@Override
	public List<Product> getAllProduct() {

		return productService.getAllProduct();
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}

	@Override
	public List<SubCategory> getAllSubCategory() {
		return subCategoryService.getAllSubCategory();
	}

	@Override
	public Product addProduct(ProductDTO productdto) {
		return productService.addProduct(productdto);
	}

	@Override
	public Product updateProduct(ProductDTO productdto) {
		return productService.updateProduct(productdto);
	}

	@Override
	public String deleteProduct(int id) {

		return productService.deleteProductById(id);
	}

	@Override
	public Product getProductbyName(String name) {
		return productService.getByName(name);
	}

	@Override
	public ProductDTO getProductById(int id) {
		return productService.getProductById(id);
	}

}
