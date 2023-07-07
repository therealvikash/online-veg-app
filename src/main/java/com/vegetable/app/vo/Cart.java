package com.vegetable.app.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	@Column(name = "cartno")
	private Integer cartId;
	@Column
	private Integer customerId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	private List<VegetableDTO> vegetable;

	@OneToOne(mappedBy = "cartdetails")
	private Customer customer;

	public Cart(Integer cartId, Integer customerId, List<VegetableDTO> vegetable, Customer customer) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.vegetable = vegetable;
		this.customer = customer;
	}

	public Cart() {
		super();
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public List<VegetableDTO> getVegetable() {
		return vegetable;
	}

	public void setVegetable(List<VegetableDTO> vegetable) {
		this.vegetable = vegetable;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customerId=" + customerId + ", vegetable=" + vegetable + ", customer="
				+ customer + "]";
	}

}
