package com.vegetable.app.service;

import java.util.List;

import com.vegetable.app.exception.NoSuchCustomerException;
import com.vegetable.app.vo.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Integer bid, Customer cus);

	public void removeCustomer(Integer cid);

	public Customer viewCustomer(Integer cid) throws NoSuchCustomerException;

	public List<Customer> getAllcus();

}
