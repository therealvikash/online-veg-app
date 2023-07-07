package com.vegetable.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.app.service.IFeedbackService;
import com.vegetable.app.vo.Feedback;

@RestController
@RequestMapping(value = "/feedback")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {
	@Autowired
	private IFeedbackService fbService;

	@PostMapping(value = "/add")
	public ResponseEntity<Feedback> saveProduct(@RequestBody Feedback feedback) {
		Feedback saveFeedback = fbService.addFeedback(feedback);
		return new ResponseEntity<Feedback>(saveFeedback, HttpStatus.CREATED);
	}

	@GetMapping(value = "/vegetableId/{vegetableId}")
	public ResponseEntity<Feedback> viewAllFeedbacks(@PathVariable Integer vegetableId) {
		Feedback allproductByVegetableId = fbService.viewAllFeedbacks(vegetableId);
		return new ResponseEntity<Feedback>(allproductByVegetableId, HttpStatus.OK);
	}

	@GetMapping(value = "/customerId/{customerId}")
	public ResponseEntity<Feedback> viewFeedback(@PathVariable Integer customerId) {
		Feedback allproductBycustomerId = fbService.viewFeedback(customerId);
		return new ResponseEntity<Feedback>(allproductBycustomerId, HttpStatus.OK);
	}

}
