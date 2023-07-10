package com.vegetable.app.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Cart {
	@Id
	private int cartId;

	private int orderId;

	private int customerId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	private List<VegetableDTO> vegetable;

	@OneToOne(mappedBy = "cartdetails")
	private Customer customer;
}
