package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.CategoryDTO;
import com.hexaware.ecommerce.dto.PaymentDTO;
import com.hexaware.ecommerce.dto.SubCategoryDTO;
import com.hexaware.ecommerce.entity.Admin;
import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Customer;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.entity.Payment;
import com.hexaware.ecommerce.entity.Product;
import com.hexaware.ecommerce.entity.Seller;
import com.hexaware.ecommerce.entity.SubCategory;

public interface IAdminService {
    public Admin login(String username, String password);
    
    public Admin registerAdmin(Admin admin);
    
    public List<Product> viewAllProducts();
    
    public String deleteProduct(int id);
    
    public String deleteCategory(int id);
   
    public String deleteSubCategory(int id);
    
    public List<Customer> viewAllCustomer();
    
    public List<Seller> viewAllSeller();
    
    public List<Order> viewAllOrder();
    
    public List<Payment> viewAllPayment();
    
    public  String deleteSeller(int id);
    
    public List<Category> viewAllCategory();
    
    public List<SubCategory> viewAllSubCategory();
    
    public Payment addPayment(PaymentDTO payment);
    
    public Category addCategory(CategoryDTO categorydto);
    
    public SubCategory addSubCategory(SubCategoryDTO subcategorydto); 
    
      
}
