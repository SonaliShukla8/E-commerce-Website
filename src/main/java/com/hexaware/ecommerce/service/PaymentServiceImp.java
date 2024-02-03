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
		Payment payment = new Payment();
		payment.setPaymentId(paymentDTO.getPaymentId());
		payment.setAmount(paymentDTO.getAmount());
		payment.setOrder(paymentDTO.getOrder());
		payment.setPaymentDate(paymentDTO.getPaymentDate());
		payment.setPaymentStatus(paymentDTO.getPaymentStatus());
		payment.setPaymentMethod(paymentDTO.getPaymentMethod());
		return repo.save(payment);
	}

	@Override
	public Payment updatePayment(PaymentDTO paymentDTO) {
		Payment payment = new Payment();
		payment.setPaymentId(paymentDTO.getPaymentId());
		payment.setAmount(paymentDTO.getAmount());
		payment.setOrder(paymentDTO.getOrder());
		payment.setPaymentDate(paymentDTO.getPaymentDate());
		payment.setPaymentStatus(paymentDTO.getPaymentStatus());
		payment.setPaymentMethod(paymentDTO.getPaymentMethod());
		return repo.save(payment);
	}

	@Override
	public String deletePaymentById(int paymentId) {
		repo.deleteById(paymentId);
		return "Payment with paymentId "+ paymentId+ " deleted";
	}

	@Override
	public PaymentDTO getPaymentById(int paymentId) {
		Payment payment=repo.findById(paymentId).orElse(null);
		PaymentDTO dto=new PaymentDTO();
		dto.setPaymentId(payment.getPaymentId());
		dto.setAmount(payment.getAmount());
		dto.setOrder(payment.getOrder());
		dto.setPaymentDate(payment.getPaymentDate());
		dto.setPaymentStatus(payment.getPaymentStatus());
		dto.setPaymentMethod(payment.getPaymentMethod());
		
		return dto;
	}

	@Override
	public List<Payment> getAllPayment() {
		
		return repo.findAll();
	}

}
