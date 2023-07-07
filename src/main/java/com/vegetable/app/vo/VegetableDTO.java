package com.vegetable.app.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	public VegetableDTO(Integer vegId, String category, String name, String type, double price, Integer quantity,
			Cart cart, Order order) {
		super();
		this.vegId = vegId;
		this.category = category;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.cart = cart;
		this.order = order;
	}

	public VegetableDTO() {
		super();
	}

	public Integer getVegId() {
		return vegId;
	}

	public void setVegId(Integer vegId) {
		this.vegId = vegId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "VegetableDTO [vegId=" + vegId + ", category=" + category + ", name=" + name + ", type=" + type
				+ ", price=" + price + ", quantity=" + quantity + ", cart=" + cart + ", order=" + order + "]";
	}

}
