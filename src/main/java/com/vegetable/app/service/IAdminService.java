package com.vegetable.app.service;

import com.vegetable.app.vo.Admin;

public interface IAdminService
{
	
	public Admin addAdmin(Admin admin);
	 
	 void deleteAdmin(Integer adminId);
	
	public  Admin updateAdminDetails( Integer adminId,Admin admin);
	
	 public Admin getAdmin(Integer adminId);
	
	
}
