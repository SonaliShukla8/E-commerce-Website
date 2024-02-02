package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.entity.Category;
import com.hexaware.ecommerce.entity.Payment;

public interface IPaymentService {
	public Payment addPayment(Payment payment);
    public Payment updatePayment(Payment payment);
    public String deletePaymentById(int paymentId);
    public Payment getPaymentById(int paymentId);
    public List<Payment> getAllPayment();
}
