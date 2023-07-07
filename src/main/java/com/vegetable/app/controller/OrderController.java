package com.vegetable.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.app.service.IOrderService;
import com.vegetable.app.vo.Order;

@RestController
@RequestMapping(value = "/Order")
public class OrderController {
	@Autowired
	private IOrderService orderService;

	@PostMapping(value = "/add")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		Order saveOrder = orderService.addOrder(order);
		return new ResponseEntity<Order>(saveOrder, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{orderNo}")
	public ResponseEntity<Order> updateVegetable(@PathVariable Integer orderNo, @RequestBody Order order) {

		Order order1 = orderService.updateOrderDetails(order, orderNo);
		return new ResponseEntity<Order>(order1, HttpStatus.CREATED);

	}

	@GetMapping(value = "/vieworder")
	public ResponseEntity<List<Order>> viewOrderList() {

		List<Order> viewVegetable = orderService.viewOrderList();
		return new ResponseEntity<List<Order>>(viewVegetable, HttpStatus.OK);
	}

	@GetMapping(value = "/vieworder/{customerId}")
	public ResponseEntity<Order> viewAllOrder(@PathVariable Integer customerId) {

		Order vieworder = orderService.viewAllOrders(customerId);
		return new ResponseEntity<Order>(vieworder, HttpStatus.OK);
	}

	@DeleteMapping(value = "/customerId{customerId}")
	public ResponseEntity<String> removeVegetable(@PathVariable Integer orderId) {
		orderService.cancelOrder(orderId);
		String msg = "order deleted successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
