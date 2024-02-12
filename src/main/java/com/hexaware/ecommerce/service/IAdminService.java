package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.AdminDTO;
import com.hexaware.ecommerce.dto.CategoryDTO;
import com.hexaware.ecommerce.dto.PaymentDTO;
import com.hexaware.ecommerce.dto.SubCategoryDTO;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.Payment;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.entity.SubCategory;
import com.hexaware.ecommerce.exception.CategoryNotFoundException;
import com.hexaware.ecommerce.exception.CustomerNotFoundException;
import com.hexaware.ecommerce.exception.ProductNotFoundException;
import com.hexaware.ecommerce.exception.SellerNotFoundException;
import com.hexaware.ecommerce.exception.SubCategoryNotFoundException;

public interface IAdminService {
    
    public String addAdmin(AdminDTO admindto);
    
    public List<Product> viewAllProducts();
    
    public String deleteProduct(int id) throws ProductNotFoundException;
    
    public String deleteCategory(int id) throws CategoryNotFoundException;
   
    public String deleteSubCategory(int id) throws SubCategoryNotFoundException;
    
    public List<Customer> viewAllCustomer();
    
    public List<Seller> viewAllSeller();
    
    public List<Order> viewAllOrder();
    
    public List<Payment> viewAllPayment();
    
    public  String deleteSeller(int id) throws SellerNotFoundException;
    
    public String deleteCustomer(int id) throws CustomerNotFoundException;
    


    
    
    public List<Category> viewAllCategory();
    
    public List<SubCategory> viewAllSubCategory();
    
    public Payment addPayment(PaymentDTO payment);
    
    public Category addCategory(CategoryDTO categorydto);
    
    public SubCategory addSubCategory(SubCategoryDTO subcategorydto); 
    
      
}
