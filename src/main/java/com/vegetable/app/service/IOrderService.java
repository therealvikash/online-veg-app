package com.vegetable.app.service;

import java.util.List;

import com.vegetable.app.vo.Order;

public interface IOrderService {

	Order addOrder(Order order);

	Order updateOrderDetails(Order order, Integer orderNo);

	Order viewAllOrders(int custid);

	List<Order> viewOrderList();

	void cancelOrder(int orderid);

}
