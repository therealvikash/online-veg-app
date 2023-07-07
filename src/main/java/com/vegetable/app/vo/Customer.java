package com.vegetable.app.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="cust_id")
	private Integer customerId;
	@Column
	private String name;
	@Column
	private String mobileNumber;
	@Column
	private String emailId;
	
	@Column
	private String address;
	@Column
	private String password;
	@Column
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

	public Customer(Integer customerId, String name, String mobileNumber, String emailId, String address,
			String password, String confirmPassword, BillingDetails billingdetails, Order orderdetails,
			Cart cartdetails, List<Feedback> feedbacks) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.billingdetails = billingdetails;
		this.orderdetails = orderdetails;
		this.cartdetails = cartdetails;
		this.feedbacks = feedbacks;
	}

	public Customer() {
		super();
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public BillingDetails getBillingdetails() {
		return billingdetails;
	}

	public void setBillingdetails(BillingDetails billingdetails) {
		this.billingdetails = billingdetails;
	}

	public Order getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(Order orderdetails) {
		this.orderdetails = orderdetails;
	}

	public Cart getCartdetails() {
		return cartdetails;
	}

	public void setCartdetails(Cart cartdetails) {
		this.cartdetails = cartdetails;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", emailId="
				+ emailId + ", address=" + address + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", billingdetails=" + billingdetails + ", orderdetails=" + orderdetails + ", cartdetails="
				+ cartdetails + ", feedbacks=" + feedbacks + "]";
	}
	

	
	

}
