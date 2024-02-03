package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.dto.OrderDTO;
import com.hexaware.ecommerce.entity.Order;

public interface IOrderService {
	public Order addOrder(OrderDTO orderDTO);
    public Order updateOrder(OrderDTO orderDTO);
    public String deleteOrderById(int orderId);
    public OrderDTO getOrderById(int orderId);
    public List<Order> getAllOrder();
}
