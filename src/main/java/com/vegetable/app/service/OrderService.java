package com.vegetable.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.app.dao.IOrderRepository;
import com.vegetable.app.exception.OrderNotFoundException;
import com.vegetable.app.vo.Order;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepository orderRepo;

	@Override
	public Order addOrder(Order order) {
		Order saveOrder = orderRepo.save(order);
		return saveOrder;
	}

	@Override
	public Order updateOrderDetails(Order order, Integer orderno) {

		Optional<Order> opt = orderRepo.findById(orderno);
		if (opt.isPresent()) {
			Order order1 = opt.get();
			order1.setOrderNo(order.getOrderNo());
			order1.setCustomerid(order.getCustomerid());
			order1.setVegetable(order.getVegetable());
			order1.setTotalAmount(order.getTotalAmount());
			order1.setStatus(order.getStatus());
			return orderRepo.save(order1);
		} else {
			return orderRepo.save(order);
		}

	}

	@Override
	public Order viewAllOrders(int custid) {

		Optional<Order> opt = orderRepo.findById(custid);
		if (opt.isPresent()) {
			Order order1 = opt.get();
			return order1;
		} else {
			throw new OrderNotFoundException("Order Not Available");
		}

	}

	@Override
	public List<Order> viewOrderList() {
		return orderRepo.findAll();
	}

	@Override

	public void cancelOrder(int orderid) {

		orderRepo.deleteById(orderid);
		;

	}

}
