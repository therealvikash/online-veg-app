package com.vegetable.app.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class VegetableDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vegId;
	@Column
	private String category;
	@Column
	private String name;
	@Column
	private String type;
	@Column
	private double price;
	@Column
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "cartno")
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "orderno")
	private Order order;

}
