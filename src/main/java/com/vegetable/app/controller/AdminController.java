package com.vegetable.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.app.service.IAdminService;
import com.vegetable.app.vo.Admin;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private IAdminService adRepo;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin)
	{
		Admin saveAdmin = adRepo.addAdmin(admin);
		return new ResponseEntity<>(saveAdmin,HttpStatus.CREATED);
	}
	
	//Requires Enhancement
	@GetMapping(value="/allAdmins")
	public ResponseEntity<Admin> getAllAdmins(@PathVariable Integer adminId)
	{
		Admin allBooks = adRepo.getAdmin(adminId);
		return new ResponseEntity<Admin>(allBooks, HttpStatus.OK);
	}
	
	@GetMapping(value="/{adminId}")
	public ResponseEntity<Admin> getBook(@PathVariable Integer adminId)
	{
		Admin admin = adRepo.getAdmin(adminId);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{adminId}")
	public ResponseEntity<String> deleteAdmin(@PathVariable Integer adminId)
	{
		adRepo.deleteAdmin(adminId);
		String msg = "Admin With ID:"+adminId+" Deleted Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@PutMapping(value="/{adminId}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable Integer adminId, @RequestBody Admin admin)
	{
		Admin updatedAdmin = adRepo.updateAdminDetails(adminId, admin);
		return new ResponseEntity<Admin>(updatedAdmin, HttpStatus.CREATED);
	}
}