package com.vegetable.app.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.app.dao.ICustomerRepository;
import com.vegetable.app.exception.NoSuchCustomerException;
import com.vegetable.app.vo.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepository cusRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer addCus = cusRepo.save(customer);
		return addCus;
	}

	@Override
	public List<Customer> getAllcus() {
		List<Customer> allcus = cusRepo.findAll();
		return allcus;
	}

	@Override
	public Customer updateCustomer(Integer cid, Customer cus) {
		Optional<Customer> opt = cusRepo.findById(cid);
		if (opt.isPresent()) {
			Customer opt1 = opt.get();
			opt1.setCustomerName(null);
			opt1.setCustomerMobileNumber(cus.getCustomerMobileNumber());
			opt1.setCustomerEmailId(cus.getCustomerEmailId());
			opt1.setCustomerAddress(cus.getCustomerAddress());
			return cusRepo.save(opt1);

		} else {
			return cusRepo.save(cus);
		}
	}

	@Override
	public void removeCustomer(Integer cid) {
		Optional<Customer> cus = cusRepo.findById(cid);
		if (cus.isPresent()) {
			cusRepo.deleteById(cid);
		} else {
			throw new NoSuchCustomerException("customeer with Given ID:" + cid + "Not Available");
		}

	}

	@Override
	public Customer viewCustomer(Integer cid) throws NoSuchCustomerException {
		Optional<Customer> cust = cusRepo.findById(cid);
		if (cust.isPresent()) {
			Customer customer = cust.get();
			return customer;
		} else {
			throw new NoSuchCustomerException("customer with given id:" + cid + "not available");
		}

	}

}