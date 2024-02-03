package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.PaymentDTO;
import com.hexaware.ecommerce.entity.Payment;
import com.hexaware.ecommerce.repository.PaymentRepository;
@Service
public class PaymentServiceImp implements IPaymentService {
    @Autowired
	PaymentRepository repo;
	
	
	@Override
	public Payment addPayment(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment updatePayment(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePaymentById(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentDTO getPaymentById(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> getAllPayment() {
		// TODO Auto-generated method stub
		return null;
	}

}
