package com.vegetable.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.app.dao.UserRepository;
import com.vegetable.app.vo.User;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		Optional<User> opt = userRepo.findByUsernameAndPassword(username, password);
		if (opt.isPresent()) {
			return true;
		}
		return false;
	}

}
