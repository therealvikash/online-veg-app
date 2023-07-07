package com.vegetable.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.app.dao.IBillingRepository;
import com.vegetable.app.exception.BillNotFoundException;
import com.vegetable.app.exception.NoSuchBillException;
import com.vegetable.app.vo.BillingDetails;

@Service
public class BillingService implements IBillingService {
	
	@Autowired
	private IBillingRepository billrepo;

	@Override
	public BillingDetails addBill(BillingDetails bill)  {
		// TODO Auto-generated method stub
	
		BillingDetails saveBill = billrepo.save(bill);
		return saveBill;
	}

	@Override
	public BillingDetails updateBill(Integer billingId, BillingDetails bill) throws BillNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<BillingDetails> opt = billrepo.findById(billingId);
		if (opt.isPresent()) 
		{
			
			BillingDetails bill1 = opt.get();
			bill1.setBillingId(bill.getBillingId());
			bill1.setOrderId(bill.getOrderId());
			bill1.setTransactionMode(bill.getTransactionMode());
			bill1.setTransactionDate(bill.getTransactionDate());
			bill1.setTransactionDate(bill.getTransactionDate());
			bill1.setBillingAddress(bill.getBillingAddress());
			return billrepo.save(bill);
			
		}
		else 
		{
			throw new BillNotFoundException("This bill does not exist");
		}
	}

	@Override
	public BillingDetails viewBill(Integer bilInteger) throws NoSuchBillException {
		// TODO Auto-generated method stub
		
		Optional<BillingDetails> opt = billrepo.findById(bilInteger);
		if(opt.isPresent())	
		{
		BillingDetails bill = opt.get();
		return bill;
		}
		else 
		{
			throw new NoSuchBillException("Bill with given id doesn't exist");
		}
		
		
		//return null;
	}

}
