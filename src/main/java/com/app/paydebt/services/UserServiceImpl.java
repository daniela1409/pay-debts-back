package com.app.paydebt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.paydebt.DAO.IUserDAO;
import com.app.paydebt.model.User;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDAO iUserDao;

	@Override
	public User findUserById(String userId) {
		return iUserDao.findById(userId).orElse(null);
	}

}
