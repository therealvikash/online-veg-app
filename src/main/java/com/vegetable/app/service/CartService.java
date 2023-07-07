package com.vegetable.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.app.dao.CartRepository;
import com.vegetable.app.vo.Cart;

@Service
public class CartService implements ICartService 
{
	@Autowired 
	private CartRepository cartRepo;

	@Override
	public Cart addToCart(Cart veg) 
	{
		Cart  savedveg = cartRepo.save(veg);
		return savedveg;
	}

	@Override
	public void removeVegetable(int id) 
	{
		cartRepo.deleteById(id);
	}

	@Override
	public void removeAllVegetables() 
	{
		cartRepo.deleteAll();
	}

	@Override
	public List<Cart> viewAllItems() 
	{
		List<Cart> allVegs = cartRepo.findAll();
		return allVegs;
	}
	
}
