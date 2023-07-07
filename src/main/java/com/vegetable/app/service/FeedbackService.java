package com.vegetable.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.app.dao.FeedbackRepository;
import com.vegetable.app.exception.CustomerNotFoundException;
import com.vegetable.app.exception.VegetableNotFoundException;
import com.vegetable.app.vo.Feedback;

@Service
public class FeedbackService implements IFeedbackService {
	@Autowired
	private FeedbackRepository fbRepo;

	@Override
	public Feedback addFeedback(Feedback fdbk) {
		Feedback saveFeedback = fbRepo.save(fdbk);
		return saveFeedback;
	}

	@Override
	public Feedback viewAllFeedbacks(Integer vegetableId) {
		Optional<Feedback> opt = fbRepo.findByVegetableId(vegetableId);
		if (opt.isPresent()) {
			Feedback feedback = opt.get();
			return feedback;
		} else {
			throw new VegetableNotFoundException("Vegetable with Given ID:" + vegetableId + "Not Available");
		}

	}

	@Override
	public Feedback viewFeedback(Integer customerId) {

		Optional<Feedback> opt = fbRepo.findByCustomerId(customerId);
		if (opt.isPresent()) {
			Feedback feedback = opt.get();
			return feedback;
		} else {
			throw new CustomerNotFoundException("Customer with Given ID:" + customerId + "Not Available");
		}
	}
}
