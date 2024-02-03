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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order updateOrder(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrderById(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
