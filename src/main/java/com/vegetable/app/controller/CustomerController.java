package com.vegetable.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.app.exception.NoSuchCustomerException;
import com.vegetable.app.service.ICustomerService;
import com.vegetable.app.vo.Customer;

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin(origins = "http://localhost:3000")

public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	/*
	 * { "customerId": 1, "name": "theju", "mobileNumber": "123.4", "address":
	 * "teju", "emailid": "theju@gmail.com" }
	 */
	@PostMapping(value = "/save")
	public ResponseEntity<Customer> savebook(@RequestBody Customer cus) {
		Customer savedcus = customerService.addCustomer(cus);
		return new ResponseEntity<Customer>(savedcus, HttpStatus.CREATED);
	}

	@GetMapping(value = "/allcus")
	public ResponseEntity<List<Customer>> getAllcus() {
		List<Customer> allcus = customerService.getAllcus();
		return new ResponseEntity<List<Customer>>(allcus, HttpStatus.OK);
	}

//	@GetMapping(value = "/view/{address}")
//	public ResponseEntity<List<Customer>> viewCustomerList(@PathVariable String address) {
//		try {
//			List<Customer> allcus = customerService.viewCustomerList(address);
//			return new ResponseEntity<List<Customer>>(allcus, HttpStatus.OK);
//		} catch (NoSuchCustomerException e) {
//			return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
//		}
//	}

	@GetMapping(value = "/cid/{cid}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable Integer cid) {
		Customer findcus = customerService.viewCustomer(cid);
		return new ResponseEntity<Customer>(findcus, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{cid}")
	public ResponseEntity<String> removeCustomer(@PathVariable Integer cid) {
		customerService.removeCustomer(cid);
		String msg = "customer with id" + cid + "deleted successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@PutMapping(value = "/update/{cid}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer cid, @RequestBody Customer cus) {

		Customer cus1 = customerService.updateCustomer(cid, cus);
		return new ResponseEntity<Customer>(cus1, HttpStatus.CREATED);

	}

}
