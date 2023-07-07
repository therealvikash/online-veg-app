package com.vegetable.app.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedbackId;
	@Column
	private Integer vegetableId;
	@Column
	private Integer customerId;
	@Column
	private Integer rating;
	@Column
	private String comments;

	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	public Feedback(Integer feedbackId, Integer vegetableId, Integer customerId, Integer rating, String comments,
			Customer customer) {
		super();
		this.feedbackId = feedbackId;
		this.vegetableId = vegetableId;
		this.customerId = customerId;
		this.rating = rating;
		this.comments = comments;
		this.customer = customer;
	}

	public Feedback() {
		super();
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Integer getVegetableId() {
		return vegetableId;
	}

	public void setVegetableId(Integer vegetableId) {
		this.vegetableId = vegetableId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", vegetableId=" + vegetableId + ", customerId=" + customerId
				+ ", rating=" + rating + ", comments=" + comments + ", customer=" + customer + "]";
	}

}
