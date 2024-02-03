package com.hexaware.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.ecommerce.dto.OrderDTO;
import com.hexaware.ecommerce.entity.Order;
import com.hexaware.ecommerce.repository.OrderRepository;
@Service
public class OrderServiceImp implements IOrderService {
    @Autowired
	OrderRepository repo;
	
	@Override
	public Order addOrder(OrderDTO orderDTO) {
		Order order=new Order();
		order.setOrderId(orderDTO.getOrderId());
		order.setOrderDate(orderDTO.getOrderDate());
		order.setDeliveryDate(order.getDeliveryDate());
		order.setStatus(orderDTO.getStatus());
		order.setStatusDescription(orderDTO.getStatusDescription());
		order.setTotalAmount(orderDTO.getTotalAmount());
		order.setPayment(orderDTO.getPayment());
		order.setCustomer(orderDTO.getCustomer());
		order.setSeller(orderDTO.getSeller());
		
		return repo.save(order);
	}

	@Override
	public Order updateOrder(OrderDTO orderDTO) {
		Order order=new Order();
		order.setOrderId(orderDTO.getOrderId());
		order.setOrderDate(orderDTO.getOrderDate());
		order.setDeliveryDate(order.getDeliveryDate());
		order.setStatus(orderDTO.getStatus());
		order.setStatusDescription(orderDTO.getStatusDescription());
		order.setTotalAmount(orderDTO.getTotalAmount());
		order.setPayment(orderDTO.getPayment());
		order.setCustomer(orderDTO.getCustomer());
		order.setSeller(orderDTO.getSeller());
	
		return repo.save(order);
	}

	@Override
	public String deleteOrderById(int orderId) {
		repo.deleteById(orderId);
		return "Order with orderId "+orderId+" deleted.";
	}

	@Override
	public OrderDTO getOrderById(int orderId) {
		Order order =repo.findById(orderId).orElse(null);
		OrderDTO dto=new OrderDTO();
		dto.setOrderId(order.getOrderId());
		dto.setOrderDate(order.getOrderDate());
		dto.setDeliveryDate(order.getDeliveryDate());
		dto.setStatus(order.getStatus());
		dto.setStatusDescription(order.getStatusDescription());
		dto.setTotalAmount(order.getTotalAmount());
		dto.setPayment(order.getPayment());
		dto.setCustomer(order.getCustomer());
		dto.setSeller(order.getSeller());
		
		return dto;
	}

	@Override
	public List<Order> getAllOrder() {
		
		return repo.findAll();
	}

}
