package com.vegetable.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.app.service.IContactService;
import com.vegetable.app.vo.Contact;

@RestController
@RequestMapping(value = "/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

	@Autowired
	private IContactService conservice;

	@PostMapping(value = "/save")
	public ResponseEntity<String> savebook(@RequestBody Contact con) {
		Contact savedcon = conservice.saveContact(con);
		String msg = "Dear," + savedcon.getFirstName() + "Thank you for contacting us";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

}
