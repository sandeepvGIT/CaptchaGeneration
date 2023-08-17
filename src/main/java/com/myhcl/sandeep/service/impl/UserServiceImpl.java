package com.myhcl.sandeep.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhcl.sandeep.entity.User;
import com.myhcl.sandeep.repository.UserRepository;
import com.myhcl.sandeep.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository usrRepo;

	@Override
	public Integer createUser(User user) {
		return usrRepo.save(user).getUserId();
	}

	@Override
	public List<User> getAllUser() {
		return usrRepo.findAll();
	}

	@Override
	public User getOneUser(Integer id) {
		return usrRepo.findById(id).get();
	}

}
