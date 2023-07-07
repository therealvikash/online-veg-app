package com.vegetable.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.app.service.ICartService;
import com.vegetable.app.vo.Cart;

@RestController
@RequestMapping("/cart")

public class CartController {
	@Autowired
	private ICartService cartService;

	@PostMapping(value = "/save")
	public ResponseEntity<Cart> saveVeg(@RequestBody Cart veg) {
		Cart saveCart = cartService.addToCart(veg);
		return new ResponseEntity<Cart>(saveCart, HttpStatus.CREATED);
	}

	@GetMapping(value = "/viewall")
	public ResponseEntity<List<Cart>> viewAllItems() {
		List<Cart> allItems = cartService.viewAllItems();
		return new ResponseEntity<List<Cart>>(allItems, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{vegId}")
	public ResponseEntity<String> deleteVeg(@PathVariable Integer vegId) {
		cartService.removeVegetable(vegId);
		String msg = "Veg With ID:" + vegId + " Deleted Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteAll")
	public ResponseEntity<String> deleteAllVeg() {
		cartService.removeAllVegetables();
		String msg = "All  Vegetables Deleted Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
