package com.vegetable.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vegetable.app.vo.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
	
	
	
	
	

}
