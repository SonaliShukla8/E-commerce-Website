package com.hexaware.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hexaware.ecommerce.dto.PaymentDTO;
import com.hexaware.ecommerce.entity.Payment;
import com.hexaware.ecommerce.service.IPaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/payment")
public class PaymentRestController {
	@Autowired
	IPaymentService service;
	
	@PostMapping("/add")
	public Payment addPayment(@RequestBody @Valid PaymentDTO paymentDTO) {
		return service.addPayment(paymentDTO);
	}
	
	@PutMapping("/update")
    public Payment updatePayment(@RequestBody @Valid  PaymentDTO paymentDTO) {
		return service.updatePayment(paymentDTO);
	}
	
	@DeleteMapping("/delete/{paymentId}")
    public String deletePaymentById(@PathVariable int paymentId) {
		return service.deletePaymentById(paymentId);
	}
     
	@GetMapping("/getbyId/{paymentId}")
	public PaymentDTO getPaymentById(@PathVariable int paymentId) {
		return service.getPaymentById(paymentId);
	}
	
	@GetMapping("/getall")
    public List<Payment> getAllPayment(){
		return service.getAllPayment();
	}

}
