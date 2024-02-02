package com.hexaware.ecommerce.service;

import java.util.List;

import com.hexaware.ecommerce.entity.Order;

public interface IOrderService {
	public Order addOrder(Order order);
    public Order updateOrder(Order order);
    public String deleteOrderById(int orderId);
    public Order getOrderById(int orderId);
    public List<Order> getAllOrder();
}
