package com.vegetable.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.app.service.IUserService;
import com.vegetable.app.vo.Login;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private IUserService userService;

	@PostMapping(value = "/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody Login login) {
		Boolean isloginSuccess = userService.login(login.getUsername(), login.getPassword());
		Map<String, String> m = new HashMap<>();
		String msg = "";
		if (isloginSuccess) {
			msg = "Welcome." + login.getUsername();
			m.put("msg", msg);
			return new ResponseEntity<Map<String, String>>(m, HttpStatus.OK);

		} else {
			msg = "Invalid credentials, try again!";
			m.put("msg", msg);
			return new ResponseEntity<Map<String, String>>(m, HttpStatus.OK);

		}
	}

}
