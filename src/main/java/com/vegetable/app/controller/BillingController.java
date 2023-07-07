package com.vegetable.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.app.service.IBillingService;
import com.vegetable.app.vo.BillingDetails;

@Service
@RestController
@RequestMapping(value = "/bill")
@CrossOrigin(origins = "http://localhost:3000")

public class BillingController {
	// Injecting dependencies from IBillingService Interface.

	@Autowired
	private IBillingService billserv;

	// HTTP method to add the data into the database.

	@PostMapping(value = "/add")

	public ResponseEntity<BillingDetails> addBill(@RequestBody BillingDetails billingdetails) {
		BillingDetails bill = billserv.addBill(billingdetails);
		return new ResponseEntity<BillingDetails>(bill, HttpStatus.CREATED);
	}

	// HTTP method to update the existing data in the database.

	@PutMapping(value = "/{billingId}")
	public ResponseEntity<BillingDetails> updateBill(@PathVariable Integer billingId,
			@RequestBody BillingDetails billingdetails) {
		BillingDetails billdtls = billserv.updateBill(billingId, billingdetails);
		return new ResponseEntity<BillingDetails>(billdtls, HttpStatus.CREATED);
	}

	// HTTP method to view the existing data from the database.

	@GetMapping(value = "/viewBill/{billingId}")
	public ResponseEntity<BillingDetails> viewBill(@PathVariable Integer billingId) {
		BillingDetails billingdetails = billserv.viewBill(billingId);
		return new ResponseEntity<BillingDetails>(billingdetails, HttpStatus.OK);
	}
}
