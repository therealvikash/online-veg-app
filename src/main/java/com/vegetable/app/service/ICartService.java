package com.vegetable.app.service;

import java.util.List;

import com.vegetable.app.vo.Cart;

public interface ICartService {
	
	Cart addToCart(Cart veg);
	
	void removeVegetable(int id);
	void removeAllVegetables();
	List<Cart> viewAllItems();
	

}
