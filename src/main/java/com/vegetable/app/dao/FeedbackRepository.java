package com.vegetable.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vegetable.app.vo.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{
	
	Optional<Feedback> findByCustomerId(Integer customerId);

	Optional<Feedback> findByVegetableId(Integer vegetableId);
	
	

}
