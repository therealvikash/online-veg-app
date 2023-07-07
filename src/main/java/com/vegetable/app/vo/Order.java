package com.vegetable.app.vo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ordertable")
public class Order {
	@Id
	@GeneratedValue
	@Column(name="orderno")
	private Integer orderNo;
	@Column
	private Integer customerid;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private List<VegetableDTO> vegetable;
	

	@Column
	private  Integer totalAmount;
	@Column
	private String status;
	
	@OneToOne(mappedBy = "orderdetails")
	private Customer customerorder;
	
	public Order(Integer orderNo, Integer customerid, List<VegetableDTO> vegetable, Integer totalAmount, String status,
			Customer customerorder) {
		super();
		this.orderNo = orderNo;
		this.customerid = customerid;
		this.vegetable = vegetable;
		this.totalAmount = totalAmount;
		this.status = status;
		this.customerorder = customerorder;
	}

	public Order() {
		super();
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public List<VegetableDTO> getVegetable() {
		return vegetable;
	}

	public void setVegetable(List<VegetableDTO> vegetable) {
		this.vegetable = vegetable;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomerorder() {
		return customerorder;
	}

	public void setCustomerorder(Customer customerorder) {
		this.customerorder = customerorder;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", customerid=" + customerid + ", vegetable=" + vegetable
				+ ", totalAmount=" + totalAmount + ", status=" + status + ", customerorder=" + customerorder + "]";
	}
	

}
