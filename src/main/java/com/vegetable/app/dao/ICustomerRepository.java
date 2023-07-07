package com.vegetable.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vegetable.app.vo.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	
	public List<Customer> findByAddress(String address);
	
	
}
