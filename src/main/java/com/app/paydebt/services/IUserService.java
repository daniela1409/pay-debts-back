package com.app.paydebt.services;

import org.springframework.stereotype.Repository;

import com.app.paydebt.model.User;

@Repository
public interface IUserService {
	
	public User findUserById(String userId);

}
