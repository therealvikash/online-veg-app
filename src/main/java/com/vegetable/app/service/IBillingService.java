package com.vegetable.app.service;

import com.vegetable.app.exception.BillNotFoundException;
import com.vegetable.app.exception.NoSuchBillException;
import com.vegetable.app.vo.BillingDetails;

public interface IBillingService {
	
	public BillingDetails addBill(BillingDetails bill);
	public BillingDetails updateBill(Integer billingDetails, BillingDetails bill) throws BillNotFoundException;
	public BillingDetails viewBill(Integer bilInteger) throws NoSuchBillException;

}
