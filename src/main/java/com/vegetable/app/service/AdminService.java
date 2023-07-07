package com.vegetable.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.app.dao.AdminRepository;
import com.vegetable.app.exception.AdminNotFoundException;
import com.vegetable.app.vo.Admin;


@Service
public class AdminService implements IAdminService {
	
	@Autowired
	private AdminRepository adRepo;

	@Override
	public Admin addAdmin(Admin admin) {
		Admin saveAdmin = adRepo.save(admin);
		return saveAdmin;
		
	}

	
	@Override
	public void deleteAdmin(Integer adminId) {
		adRepo.deleteById(adminId);
	}
	
	@Override
	public Admin getAdmin(Integer adminId) throws AdminNotFoundException{
		Optional <Admin> opt=adRepo.findById(adminId);
		if(opt.isPresent())
		{
			Admin admin = opt.get();
			return admin;
		}
		else
		{
			throw new  AdminNotFoundException("Admin with Given ID:"+adminId+ "Not Available");
		}
	}

	

	@Override
	public Admin updateAdminDetails(Integer adminId, Admin admin) throws AdminNotFoundException
	{
		Optional<Admin> opt=adRepo.findById(adminId);
		if(opt.isPresent())
		{
			Admin admin1=opt.get();
			admin1.setName(admin.getName());
			admin1.setContactNumber(admin.getContactNumber());
			return adRepo.save(admin1);
			
		
		}
	else
	{
		throw new  AdminNotFoundException("Admin with Given ID:"+adminId+ "Not Available");
	}
			
			
			
	}

	

}