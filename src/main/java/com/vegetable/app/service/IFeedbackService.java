package com.vegetable.app.service;

import com.vegetable.app.vo.Feedback;

public interface IFeedbackService {
	Feedback addFeedback(Feedback fdbk);

	Feedback viewAllFeedbacks(Integer vegetableId);

	Feedback viewFeedback(Integer customerId);

}
