package com.myhcl.sandeep.service;

import java.util.List;

import com.myhcl.sandeep.entity.User;

public interface IUserService {
	Integer createUser(User user);
	List<User> getAllUser();
	User getOneUser(Integer id);

}
