package com.vegetable.app.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BillingDetails {
	@Id
	@GeneratedValue
	@Column(name = "bill")
	private Integer billingId;
	@Column
	private Integer orderId;
	@Column
	private String transactionMode;
	@Column
	private String transactionDate;
	@Column
	private String billingAddress;

	@OneToOne(mappedBy = "billingdetails")
	// @JsonIgnore
	private Customer customer;

	public BillingDetails(Integer billingId, Integer orderId, String transactionMode, String transactionDate,
			String billingAddress, Customer customer) {
		super();
		this.billingId = billingId;
		this.orderId = orderId;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.billingAddress = billingAddress;
		this.customer = customer;
	}

	public BillingDetails() {
		super();
	}

	public Integer getBillingId() {
		return billingId;
	}

	public void setBillingId(Integer billingId) {
		this.billingId = billingId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "BillingDetails [billingId=" + billingId + ", orderId=" + orderId + ", transactionMode="
				+ transactionMode + ", transactionDate=" + transactionDate + ", billingAddress=" + billingAddress
				+ ", customer=" + customer + "]";
	}

}
