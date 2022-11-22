package com.app.paydebt.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.paydebt.model.Bank;


public interface IBankDAO extends CrudRepository<Bank, Integer>{

	 public List<Bank> findBanksByUsersId(String userId);
}
