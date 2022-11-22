package com.app.paydebt.DAO;

import java.util.List;
import java.util.UUID;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.paydebt.model.Bank;
import com.app.paydebt.model.User;

@Repository
public interface IUserDAO extends CrudRepository<User, UUID>{
	
	 public List<User> findUsersBybanksId(String userId);
}
