package com.vegetable.app.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Integer customerId;

	private String customerName;

	private String customerMobileNumber;

	private String customerEmailId;

	private String customerAddress;

	private String password;

	private String confirmPassword;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bill")
	private BillingDetails billingdetails;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderno")
	private Order orderdetails;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartno")
	private Cart cartdetails;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Feedback> feedbacks;
}
