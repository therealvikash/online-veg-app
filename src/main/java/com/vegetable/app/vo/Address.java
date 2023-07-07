package com.vegetable.app.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Address {
	@Id
	@GeneratedValue
	@Column(name = "addressno")
	private Integer addressId;
	@Column
	private String flatNo;
	@Column
	private String buildingName;
	@Column
	private String area;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String pincode;

	public Address(Integer addressId, String flatNo, String buildingName, String area, String city, String state,
			String pincode) {
		super();
		this.addressId = addressId;
		this.flatNo = flatNo;
		this.buildingName = buildingName;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Address() {
		super();
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatNo=" + flatNo + ", buildingName=" + buildingName + ", area="
				+ area + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
}
