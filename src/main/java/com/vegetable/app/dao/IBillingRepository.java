package com.vegetable.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.vegetable.app.vo.BillingDetails;

@Repository
@EnableJpaRepositories
public interface IBillingRepository extends JpaRepository<BillingDetails, Integer> {
	
	
}
