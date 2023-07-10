package com.vegetable.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.vegetable.app.vo.Customer;

@Repository
@EnableJpaRepositories
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	
//	public List<Customer> findByAddress(String address);
	
	
}
